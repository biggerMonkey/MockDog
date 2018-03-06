package person.hwj.mockdog.entity;

public class Param {
    private String paramName;
    private String paramValue;

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    @Override
    public String toString() {
        return "Param [paramName=" + paramName + ", paramValue=" + paramValue + "]";
    }
}
