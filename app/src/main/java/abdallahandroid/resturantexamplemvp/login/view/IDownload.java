package abdallahandroid.resturantexamplemvp.login.view;

public interface IDownload {

    void progressbarVisible_whileLoading();
    void progressBarGone_afterFinishDownload();
    void messageNoInterenetConnection();
    void emailEmpty();
    void passEmpty();

}
