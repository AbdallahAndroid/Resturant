package abdallahandroid.resturantexamplemvp.AccountActivity.view;

import android.graphics.drawable.Drawable;

public interface IWriteProfiel {

    void animation();
    void fonts();
    void alpha();
    void setImageAccount(Drawable drawable);
    void setTextviewOfDialog(String name, String email, String phone, String id,  String resturantName,
                             String themeColor, String themeAccentColor);
    void buttonCancel();
    void buttonCamera();

}
