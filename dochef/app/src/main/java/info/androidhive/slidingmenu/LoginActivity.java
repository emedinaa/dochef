package info.androidhive.slidingmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.androidhive.slidingmenu.model.UsuarioBean;

/**
 * Created by Celeritech Peru on 18/05/2015.
 */
public class LoginActivity extends AbstractAsyncActivity {

    private MainApplication mainApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainApplication = (MainApplication) getApplication();


        setContentView(R.layout.activity_login);

        showLoginView();
    }

    private void showLoginView() {

        final Button submitButton = (Button) findViewById(R.id.btnLogin);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UsuarioBean usuarioBean = new UsuarioBean();
                if (validaLogin()) {
                    new ValidateLoginTask().execute(usuarioBean);
                }
            }
        });
    }

    private boolean validaLogin() {

        EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
        EditText txtPassword = (EditText) findViewById(R.id.txtPassword);

        if (txtEmail.getText().toString().length() == 0) {
            Toast.makeText(this, "Ud. debe ingresar un e-mail", Toast.LENGTH_LONG).show();
            return false;
        }
        if (txtPassword.getText().toString().length() == 0) {
            Toast.makeText(this, "Ud. debe ingresar su password", Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    private class ValidateLoginTask extends AsyncTask<Object, Void, MensajeRespuesta> {
        @Override
        protected void onPreExecute() {
            showLoadingProgressDialog(getString(R.string.validandoCredenciales));
        }

        @Override
        protected MensajeRespuesta doInBackground(Object... params) {
            UsuarioBean userBean = (UsuarioBean)params[0];
            MensajeRespuesta mensajeRespuesta = new MensajeRespuesta(false, "Login Error");

            try {

                try {
                    userBean.setEmail("jose.diaz@joedayz.pe");
                    userBean.setFirstName("Jose");
                    userBean.setEmail("Diaz");
                    userBean.setPassword("123");
                } catch (LoginException ex) {
                    if (isOnline()) {


                        throw new LoginException("Usuario o password incorrectos");

                    } else {
                        throw ex;
                    }
                }
                mainApplication.setUserInSession(userBean);
                mensajeRespuesta.setSuccess(true);

            } catch (ConnectionException ex) {
                mensajeRespuesta = new MensajeRespuesta(
                        false,
                        "DoChef no responde, disculpe los inconvenientes.",
                        true);
            } catch (LoginException loginException) {
                mensajeRespuesta.setSuccess(false);
                mensajeRespuesta.setMensaje(loginException.getMessage());
            } catch (AppException appException) { // Si hay una exception de sistema, se vuelve a sincronizar
                mensajeRespuesta.setSuccess(false);
                mensajeRespuesta.setMensaje(appException.getMessage());
            } catch (RuntimeException ex) {
                mensajeRespuesta.setSuccess(false);
                mensajeRespuesta.setMensaje(ex.getMessage());
            }
            return mensajeRespuesta;
        }

        @Override
        protected void onPostExecute(MensajeRespuesta result) {
            dismissProgressDialog();
            if (result.isSuccess()) {

                    showWelcomeView();

            }else{

                    displayResponse(result);

            }
        }
    }

    private void showWelcomeView() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    private void displayResponse(MensajeRespuesta response) {
        if (response.isShowAsAlert()) {
            showAlert("Alerta", response.getMensaje());
        } else {
            Toast.makeText(this, response.getMensaje(), Toast.LENGTH_LONG)
                    .show();
        }
    }
    public void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message).setTitle(title).setPositiveButton("Ok", null);
        AlertDialog dialog = builder.create();
        dialog.show();
    }


    public boolean isOnline() {
        if(true){
            return true;
        }
        ConnectivityManager conMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return ( conMgr.getActiveNetworkInfo() != null &&
                conMgr.getActiveNetworkInfo().isAvailable() &&
                conMgr.getActiveNetworkInfo().isConnected() ) ;

    }
}
