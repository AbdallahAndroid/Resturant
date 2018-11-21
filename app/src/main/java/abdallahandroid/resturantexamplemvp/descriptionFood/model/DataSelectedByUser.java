package abdallahandroid.resturantexamplemvp.descriptionFood.model;

import abdallahandroid.resturantexamplemvp.DialogLanguage.model.DataDialog;

public class DataSelectedByUser extends DataDialog {


    public static String categeroyName ;
    public static String description ;

    public static String itemCounter ;
    public static String imageUrl;
    public static int position;



    public static String getImageUrl() {
        return imageUrl;
    }
    public static void setImageUrl(String imageUrl) {
        DataSelectedByUser.imageUrl = imageUrl;
    }



    public static int getPosition() {
        return position;
    }
    public static void setPosition(int position) {
        position = position;
    }

    public static String getCategeroyName() {
        return categeroyName;
    }

    public static void setCategeroyName(String categeroyName) {
        DataSelectedByUser.categeroyName = categeroyName;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        DataSelectedByUser.description = description;
    }


    public static String getItemCounter() {
        return itemCounter;
    }

    public static void setItemCounter(String itemCounter) {
        DataSelectedByUser.itemCounter = itemCounter;
    }



}
