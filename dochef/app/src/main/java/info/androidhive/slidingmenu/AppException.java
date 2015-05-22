package info.androidhive.slidingmenu;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class AppException  extends RuntimeException {
    protected String code;

    public AppException(String code) {
        this.code = code;
    }

    public String getMessage() {
        return code;
    }
    public String getCode(){
        return code;
    }

}