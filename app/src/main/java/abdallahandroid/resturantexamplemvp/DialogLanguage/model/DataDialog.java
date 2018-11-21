package abdallahandroid.resturantexamplemvp.DialogLanguage.model;

import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;

public class DataDialog extends GeneralData {

    //langauge setter and getter
    public static String selectedDialogLanuage ;
    public static String getSelectedDialogLanuage() {
        return selectedDialogLanuage;
    }
    public static void setSelectedDialogLanuage(String selectedDialogLanuage) {
        DataDialog.selectedDialogLanuage = selectedDialogLanuage;
    }



    //array of item
    public static String [] normalArray = {"English", "Arabic", "Egypt", "Saudi"};

}
