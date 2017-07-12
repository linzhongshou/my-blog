package cn.linzs.commons;

/**
 * Created By linzs on 7/12/17 3:16 PM
 */
public class ProcessResult {

    public final static Integer SUCCESS = 1;
    public final static Integer ERROR = 0;
    public final static Integer EXCEPTION = -1;

    public ProcessResult() {}

    public ProcessResult(Integer code, Object resultData) {
        this.code = code;
        this.resultData = resultData;
    }

    private Integer code;
    private Object resultData;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getResultData() {
        return resultData;
    }

    public void setResultData(Object resultData) {
        this.resultData = resultData;
    }
}
