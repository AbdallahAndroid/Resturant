package abdallahandroid.resturantexamplemvp.OnBoard.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import abdallahandroid.resturantexamplemvp.R;

public class MyPagerAdapter extends FragmentPagerAdapter {


    public static Context mContext;
    public static Activity mActivity;
    public static boolean smallScreenSize_toSmallerImageBoard = false;

    public MyPagerAdapter(Activity mActivity, Context ctx, FragmentManager fm) {
        super(fm);
        mContext = ctx;

        DisplayMetrics metrics = new DisplayMetrics();
        mActivity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int wid = metrics.widthPixels;
        System.out.println("width is " +  wid);
         if (wid < 900 ) smallScreenSize_toSmallerImageBoard = true;
    }


    @Override
    public Fragment getItem(int pos) {
        switch (pos) {
            case 0:
                return customItemFragment.newInstance(R.drawable.board1, 0);
            case 1:
                return customItemFragment.newInstance(R.drawable.board2, 1);
            case 2:
                return customItemFragment.newInstance(R.drawable.board3, 2);
            case 3:
                return customItemFragment.newInstance(R.drawable.board4, 3);
            case 4:
                return customItemFragment.newInstance(R.drawable.board5, 4);
            default:
                return customItemFragment.newInstance(R.drawable.board5, 5);
        }
    }

    @Override
    public int getCount() {
        return 5;
    }


    //inner class
    public static class customItemFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.board_viewpager_itemfragment, container, false);
            final ImageView imageBoard = view.findViewById(R.id.imageBoard);
            final int position = getArguments().getInt("position");


            //image board when small screen size then smaller size of image
            if ( smallScreenSize_toSmallerImageBoard ) {
                imageBoard.getLayoutParams().width = 650;
                imageBoard.getLayoutParams().height = 215;
            }




            //image board putting
            int idImage = getArguments().getInt("msg");
            imageBoard.setImageResource(idImage);

            //image board aniamtion
            animation(imageBoard);

            return view;
        }

        void animation (ImageView iv){
             //image aniamtion
            try {
                Animation hyperspaceJump = AnimationUtils.loadAnimation(mContext, R.anim.translate);
                iv.startAnimation(hyperspaceJump);
            } catch (Exception e) {
                System.out.println("animate - exception animateTransalate_thenReturnToOrginalPosition " + e);
            }
        }

        //this method pass inside it the argument you want
        public static customItemFragment newInstance(int idOfImageDrawable, int position) {
            customItemFragment f = new customItemFragment();
            Bundle b = new Bundle();
            b.putInt("msg", idOfImageDrawable);
            b.putInt("position", position);
            f.setArguments(b);
            return f;
        }
    } //end innerClass


}


