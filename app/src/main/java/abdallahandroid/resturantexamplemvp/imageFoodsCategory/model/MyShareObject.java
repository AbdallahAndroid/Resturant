package abdallahandroid.resturantexamplemvp.imageFoodsCategory.model;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by abdo on 05/04/2017.
 */

public class MyShareObject {


    /////////////////////////////////////////////////////////////////////////// setter

    public void setDataBySharedObject(Context c, String key, int data){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(key, data);
            editor.apply(); // Apply the edits!
        } catch (Exception e) {
        } catch (Error er){

        }
    }


    public void setDataBySharedObject(Context c, String key, String data){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(key, data); //putString or putInt
            editor.apply(); // Apply the edits!
        } catch (Exception e){
        } catch (Error er){

        }
    }


    public void setDataBySharedObject(Context c, String key, boolean data){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(key, data);
            editor.apply(); // Apply the edits!
        } catch (Exception e){
        } catch (Error er){

        }
    }

    /////////////////////////////////////////////////////////////////////////// getter

    public int getDataBySharedObject_int(Context c, String getKey){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            int homeScore = settings.getInt(getKey, 0); // Get from the SharedPreferences
            return homeScore;
        } catch (Exception e){
            return 0;
        } catch (Error er){
            return 0;
        }
    } //end metdhod


    public String getDataBySharedObject_string(Context c, String getKey){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            String homeScore = settings.getString(getKey, null);  //j غير متأكد هل كده صح ام لا
            return homeScore;
        } catch (Exception e){
            return null;
        } catch (Error er){
            return null;
        }
    }


    public boolean getDataBySharedObject_boolean(Context c, String getKey){
        try {
            SharedPreferences settings = c.getSharedPreferences("PREFS_NAME", Context.MODE_PRIVATE);
            //System.out.println("objectShared - getKey " + getKey );
            boolean homeScore = settings.getBoolean(getKey, false);  //j غير متأكد هل كده صح ام لا
            return homeScore;
        } catch (Exception e){
            return false;
        } catch (Error er){
            return false;
        }
    }



}
