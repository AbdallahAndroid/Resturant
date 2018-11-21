package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import abdallahandroid.resturantexamplemvp.imageFoodsCategory.model.GeneralData;
import abdallahandroid.resturantexamplemvp.imageFoodsCategory.view.IDialogAccount;

public class PresenterDialogAccount implements IPresenterDialogAccount {

    IDialogAccount iDialog;
    public PresenterDialogAccount(IDialogAccount iDialog){
        this.iDialog = iDialog;
    }

    @Override
    public void checkDownloadDataCompelteToCanOpenDialog() {
        /*  // here in example we must check data downloaded if true then openDialog()  if false then messagePleaze()
        if (GeneralData.dataDownloadComplete ){
            openDialogAccount();
        } else{
            messagePleazeWaitWhileDownloadDataComplete();
        }
         */

        openDialogAccount();
    }

    @Override
    public void openDialogAccount() {
        iDialog.openDialogAccount();
    }

    @Override
    public void messagePleazeWaitWhileDownloadDataComplete() {
        iDialog.messagaPleazeWaitWhileDownloadComplete();
    }
}
