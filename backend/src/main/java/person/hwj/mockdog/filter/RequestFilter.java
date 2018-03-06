package person.hwj.mockdog.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import person.hwj.mockdog.dao.MockDao;
import person.hwj.mockdog.dto.ResponseDTO;
import person.hwj.mockdog.dto.ResponseDTO.ResponseInfo;
import person.hwj.mockdog.entity.MockEntity;
import person.hwj.mockdog.entity.Param;
import person.hwj.mockdog.utils.SpringContextUtil;

import com.alibaba.fastjson.JSON;

public class RequestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String uri = httpRequest.getRequestURI();
        MockDao mockDao = (MockDao) SpringContextUtil.getBean(MockDao.class);
        List<MockEntity> mockEntities = mockDao.selectByUri(uri);
        if (CollectionUtils.isEmpty(mockEntities)) {
            chain.doFilter(httpRequest, httpResponse);
            return;
        }

        for (MockEntity tempMock : mockEntities) {
            if (!uri.equals(tempMock.getUri())) {
                continue;
            }
            String param = tempMock.getParams();
            if (!StringUtils.isEmpty(param)) {
                List<Param> params = JSON.parseObject(param, List.class);
                for (Param tempParam : params) {
                    String reqValue = httpRequest.getParameter(tempParam.getParamName());
                }
            }
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setHeader("Content-Type", "application/json");
            PrintWriter out = httpResponse.getWriter();

            if (!httpRequest.getMethod().equals(tempMock.getReqMethod())) {
                out.write(JSON.toJSONString(ResponseDTO.create(ResponseInfo.FAIL, "请求方式错误，应为"
                        + tempMock.getReqMethod())));
                out.flush();
                return;
            }
            httpResponse.setStatus(tempMock.getHttpCode());
            try {
                Thread.sleep(tempMock.getTimeout());
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            out.write(tempMock.getResponse());
            out.flush();
            return;
        }
        // if (uri.indexOf("/mock/") == 0) {
        // chain.doFilter(httpRequest, httpResponse);
        // return;
        // }
        // JSONObject jsonObject = new JSONObject();
        // if (!StringUtils.isEmpty(uri) && uri.equals("/message/send/verificationCode")) {
        // jsonObject.put("resultCode", "0");
        // jsonObject.put("message", "发送成功");
        // } else {
        // jsonObject.put("message", "不存在uri:" + uri);
        // }
        // out.write(jsonObject.toJSONString());
        // out.flush();
        chain.doFilter(httpRequest, httpResponse);
        return;
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

}
