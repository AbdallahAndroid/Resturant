package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import java.util.ArrayList;
import java.util.List;

public interface IPresenterDownload {


    void drawThisLanguage(String lang );
    void drawView(List<String> nameList, List<String > imageList);
    void setNameOfResturant(String nameOfResturant );


}
