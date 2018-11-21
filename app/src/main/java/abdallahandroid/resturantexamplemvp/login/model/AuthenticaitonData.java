package abdallahandroid.resturantexamplemvp.login.model;

import abdallahandroid.resturantexamplemvp.login.presenter.IPresenterDonwloadDownload;

public class AuthenticaitonData implements IAuthenticaitonData {

    String email = "test@gmail.com";
    String pass = "123456";


    @Override
    public boolean checkAuthentication(final IPresenterDonwloadDownload IPresent, String enteredEmail, String enteredPass) {
        if (enteredEmail.equals(email) && enteredPass.equals(pass)) {
            IPresent.startDownload();
            return true;
        } else{
            boolean resultFaildAuthenticaiton = false;
            String message = "Sorry, Faild Authenticaiton !";
            IPresent.completeDownload(resultFaildAuthenticaiton, message);
        }
        return false;
    }
}
