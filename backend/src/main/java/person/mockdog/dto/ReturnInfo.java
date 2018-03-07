package person.mockdog.dto;

import java.util.List;

import com.github.pagehelper.Page;

import person.mockdog.constant.CodeEnum;

public class ReturnInfo {
    // code 码
    private int code;
    // 返回信息
    private String msg;
    // 返回数据
    private Object data;

    private Paginnation paginNation;

    public static ReturnInfo create(int code, String msg, Object data, Paginnation paginNation) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.code = code;
        returnInfo.msg = msg;
        returnInfo.data = data;
        returnInfo.paginNation = paginNation;
        return returnInfo;
    }

    public static ReturnInfo create(CodeEnum codeEnum) {
        return create(codeEnum.getCode(), codeEnum.getMsg());
    }

    public static ReturnInfo create(int code, String msg) {
        return create(code, msg, "", new Paginnation());
    }

    public static ReturnInfo createReturnSucces(List<?> data) {
        ReturnInfo returnInfo = new ReturnInfo();
        returnInfo.setCode(CodeEnum.SUCCESS.getCode());
        returnInfo.setMsg(CodeEnum.SUCCESS.getMsg());
        returnInfo.setData(data);
        Paginnation paginnation = create(data);
        returnInfo.setPaginNation(paginnation);
        return returnInfo;
    }

    public static ReturnInfo createReturnSuccessOne(Object data) {
        ReturnInfo returnInfo = create(CodeEnum.SUCCESS);
        returnInfo.setData(data);
        return returnInfo;
    }

    public static Paginnation create(List<?> result) {
        Paginnation paginnation = new Paginnation();
        paginnation.setTotal(new Long(((Page<?>) result).getTotal()).intValue());
        paginnation.setPageNo(((Page<?>) result).getPageNum());
        paginnation.setPages(((Page<?>) result).getPages());
        paginnation.setPageSize(((Page<?>) result).getPageSize());
        return paginnation;
    }

    public ReturnInfo() {

    }

    public ReturnInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Paginnation getPaginNation() {
        return paginNation;
    }

    public void setPaginNation(Paginnation paginNation) {
        this.paginNation = paginNation;
    }



    public static class Paginnation {
        // 总数
        private int total;
        // 当前页
        private int pageNo;
        // 每页条数
        private int pageSize;
        // 总页数
        private int pages;

        public Paginnation() {

        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }
    }
}
