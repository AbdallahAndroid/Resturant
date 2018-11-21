package abdallahandroid.resturantexamplemvp.OnBoard.presenter;

import android.app.Activity;
import android.support.v4.view.ViewPager;

import abdallahandroid.resturantexamplemvp.OnBoard.view.IPageChangeTheImagePoint;
import abdallahandroid.resturantexamplemvp.R;

public class PresenterPageChangeImagePoint implements IPresenterImagePoint {

    Activity mActivity;
    IPageChangeTheImagePoint iPageChanger;
    public PresenterPageChangeImagePoint(Activity mActivity, IPageChangeTheImagePoint iPageChanger){
        this.iPageChanger = iPageChanger;
        this.mActivity = mActivity;

        listennerToPageChange();
    }

    @Override
    public void listennerToPageChange() {
        final ViewPager pager = (ViewPager) mActivity.findViewById(R.id.viewPager);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}

            public void onPageSelected(int position) {

                iPageChanger.smallAllPoint_toOrginalSize();  //reInitlzie size agin for all point
                iPageChanger.makeThisImageLarge(position);  // large this point

            }
        });
    }
}
