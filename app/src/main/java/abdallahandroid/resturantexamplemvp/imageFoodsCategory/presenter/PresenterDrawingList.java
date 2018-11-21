package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import java.util.List;

import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDrawing;

public class PresenterDrawingList implements IPresenterDownload{


    IDrawing IRecyler;

    public PresenterDrawingList(IDrawing IRecyler){
        this.IRecyler = IRecyler;


        drawThisLanguage("English");  //default language english
    }



    @Override
    public void drawThisLanguage(String lang) {
        //name  of resturant
        setNameOfResturant( GeneralData.resturantName);
        //now draw with language
        if (lang.equals("English")) {
            drawView(GeneralData.nameEnglish_list, GeneralData.imageUrl_list);
            System.out.println("dialog - inisde PresenterDrawingList - english");
        } else{
            drawView(GeneralData.nameArabic_list, GeneralData.imageUrl_list);
            System.out.println("dialog - inisde PresenterDrawingList - arabic");
        }

    }

    @Override
    public void drawView(List<String> nameList, List<String> imageList) {
        //convert List to Array
        String [] name = new String [ nameList.size() ]  ;
        String [] image = new String [ imageList.size() ]  ;
        name = nameList.toArray(name);
        image = imageList.toArray(image);
        //draw now
        IRecyler.drawNow(name, image);
    }

    @Override
    public void setNameOfResturant(String nameOfResturant) {
        System.out.println("mvp - presenter - nameOfResturant " + nameOfResturant);
        IRecyler.setNameOfResturant(nameOfResturant);
    }



}
