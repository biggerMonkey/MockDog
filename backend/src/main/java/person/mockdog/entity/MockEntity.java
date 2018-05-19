package person.mockdog.entity;

import java.util.Date;

public class MockEntity {
    private int id;
    private String name;
    private String uri;
    private String reqMethod;
    private String params;
    private String response;
    private int timeout;
    private int httpCode;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getReqMethod() {
        return reqMethod;
    }

    public void setReqMethod(String reqMethod) {
        this.reqMethod = reqMethod;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MockEntity [id=" + id + ", name=" + name + ", uri=" + uri + ", reqMethod="
                + reqMethod + ", params=" + params + ", response=" + response + ", timeout="
                + timeout + ", httpCode=" + httpCode + ", createTime=" + createTime + "]";
    }
}
