package abdallahandroid.resturantexamplemvp.login.model;

import android.content.Context;
import android.os.Handler;

import abdallahandroid.resturantexamplemvp.login.presenter.IPresenterDonwloadDownload;


public class waitingForDownload implements IWaiting {




    Context mContext;
    IPresenterDonwloadDownload IPresent;
    FirebaseDownloadTools fire = new FirebaseDownloadTools();

    public waitingForDownload(Context mContext, IPresenterDonwloadDownload IPresent){
        this.mContext = mContext;
        this.IPresent = IPresent;
    }


    @Override
    public void startDownloadAllData_nameAndImage( ) {
        downloadNameArray();
        downloadImageArray();
        downloadNameArabic();
        downloadDescriptionEnglish();
    }

    @Override
    public void downloadNameArray() {
        String key0 = "imagename";
        for (int i = 0 ; i < 11 ; i++ ){
            String key1 = "" + i;
            fire.getData_thenSaveItTo_listName(key0, key1, i);
        }
    }


    @Override
    public void downloadImageArray() {
        String key0 = "imageUrl";
        for (int i = 0 ; i < 11 ; i++ ){
            String key1 = "" + i;
            fire.getData_thenSaveItTo_listImageUrl(key0, key1,i);
        }
    }

    @Override
    public void downloadNameArabic() {
        String key0 = "imageArabic";
        for (int i = 0 ; i < 11 ; i++ ){
            String key1 = "" + i;
            fire.getData_thenSaveItTo_listNameArabic(key0, key1,i);
        }
    }

    @Override
    public void downloadDescriptionEnglish() {
        String key0 = "descriptionEnglish";
        for (int i = 0 ; i < 11 ; i++ ){
            String key1 = "" + i;
            fire.getData_thenSaveItTo_listDescriptionEnglish(key0, key1,i);
        }
    }


    @Override
    public void waitingForDownloadComplete() {
        final Handler handler = new Handler();
        final Runnable runAble = new Runnable() {
            @Override
            public void run() {

                boolean checkDownloadOk = checkArraylistIntitlizeComplete();
                if (checkDownloadOk ){
                    boolean authenticationOk = true;
                    String message = "Authentication ok ";
                    IPresent.completeDownload(authenticationOk, message);

                    //infinity invoke code there stop when complete download
                } else{
                    handler.postDelayed(this, 100);
                }
                System.out.println("handler   " );
            }
        };
        handler.post(runAble);
    }

    @Override
    public boolean checkArraylistIntitlizeComplete() {
        //check name list
        for (int i = 0; i < DataDownloaded.nameEnglish_list.size(); i++ ) {
            String singleData = DataDownloaded.nameEnglish_list.get(i);
            if (singleData == null ){
                return  false;
            }
        }
        //check name list
        for (int i = 0; i < DataDownloaded.imageUrl_list.size(); i++ ) {
            String singleData = DataDownloaded.imageUrl_list.get(i);
            if (singleData == null ){
                return  false;
            }
        }
        //check description downloaded
        for (int i = 0; i < DataDownloaded.description_list.size(); i++ ) {
            String singleData = DataDownloaded.description_list.get(i);
            if (singleData == null ){
                return  false;
            }
        }
        //check arabic name of list downloaded complete
        for (int i = 0; i < DataDownloaded.nameArabic_list.size(); i++ ) {
            String singleData = DataDownloaded.nameArabic_list.get(i);
            if (singleData == null ){
                return  false;
            }
        }

        //if arrive to this line thats means than all list image and name list complete download
        return true;
    }




}
