package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

public interface IPresenterShowCase {


    void afterTransitionSlideHaveBeenEnded(final boolean inBackgroudnNow);
    void waitForFinishTransationAnimationThenDoShowCase();
    void afterDismisShowCase0(boolean inBackgroudnNow, final int uniqueId);
    void afterDismisShowCase1(boolean inBackgroudnNow, final int uniqueId);
    void afterDismisShowCase2(boolean inBackgroudnNow, int uniqueId);

}
