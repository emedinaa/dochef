package info.androidhive.slidingmenu;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class MensajeRespuesta {

    private boolean success;
    private String mensaje = "";
    private boolean showAsAlert;
    private boolean showAsConfirm;

    public MensajeRespuesta() {
    }

    public MensajeRespuesta(boolean success, String mensaje) {
        super();
        this.success = success;
        this.mensaje = mensaje;
    }

    public MensajeRespuesta(boolean success, String mensaje, boolean showAsAlert) {
        this(success, mensaje);
        this.showAsAlert = showAsAlert;
    }

    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMensaje() {
        return mensaje;
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public boolean isShowAsAlert() {
        return showAsAlert;
    }

    public void setShowAsAlert(boolean showAsAlert) {
        this.showAsAlert = showAsAlert;
    }
    public void setShowAsConfirm(boolean b) {
        this.showAsConfirm = b;
    }

    public boolean isShowAsConfirm() {
        return showAsConfirm;
    }


}
