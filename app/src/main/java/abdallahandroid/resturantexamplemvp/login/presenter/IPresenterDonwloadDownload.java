package abdallahandroid.resturantexamplemvp.login.presenter;

public interface IPresenterDonwloadDownload {

    void checkAuthenticationToCanStartDownloadData(String enteryEmail , String enteryPass);
    void startDownload();
    void completeDownload(boolean AuthenticationOk, String mess);
}
