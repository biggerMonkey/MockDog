package person.mockdog.dto;

public class ResponseDTO<T> {
    private int code;
    private String message;
    private T data;

    public ResponseDTO() {

    }

    public ResponseDTO(int code) {
        this.code = code;
    }

    public ResponseDTO(int code, String message) {
        this(code);
        this.message = message;
    }

    public ResponseDTO(int code, String message, T data) {
        this(code, message);
        this.data = data;
    }

    public static ResponseDTO create(ResponseInfo info) {
        return new ResponseDTO(info.getCode(), info.getMessage());
    }

    public static <T> ResponseDTO<T> create(ResponseInfo info, T t) {
        return new ResponseDTO(info.getCode(), info.getMessage(), t);
    }

    public static ResponseDTO create(int code, String message) {
        return new ResponseDTO(code, message);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public enum ResponseInfo {
            SUCCESS(1000, "成功"), FAIL(900, "失败"), SERVER_ERR(500, "服务器错误"), CLOSE(1001, "接口关闭"),
            API_CONFIGURATION_ERROR(1002, "接口配置错误"), URI_ERROR(1003, "URI 错误"),
            OVERTAKE_MAX_REQUET(1004, "超过接口最大请求数"), PARAM_ERROR(1005, "请求参数错误"),
            VERIFY_SIGN_FAIL(1006, "验证签名失败"), NOT_CONTENT(1007, "内容为空"), API_ERROR(1008, "接口请求错误"),
            TOKEN_NOT_EMPTY(1009, "token不存在");
        private int code;
        private String message;

        private ResponseInfo(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }
}
