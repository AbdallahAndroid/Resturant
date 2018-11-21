package abdallahandroid.resturantexamplemvp.OnBoard.presenter;

import abdallahandroid.resturantexamplemvp.OnBoard.view.IDone;

public class PresenterDone implements  IPresenterDone{

    IDone ID;
    public PresenterDone(IDone IDone){
        this.ID = IDone;
    }


    @Override
    public void whenDoneClickedByUser() {
        ID.DoneClicked();
    }
}
