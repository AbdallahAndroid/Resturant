package abdallahandroid.resturantexamplemvp.login.model;

import abdallahandroid.resturantexamplemvp.login.presenter.IPresenterDonwloadDownload;

public interface IAuthenticaitonData {

    boolean checkAuthentication(final IPresenterDonwloadDownload IPresent, String enteredEmail, String enteredPass );
}
