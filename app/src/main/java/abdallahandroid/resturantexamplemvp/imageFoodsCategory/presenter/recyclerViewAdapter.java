package abdallahandroid.resturantexamplemvp.imageFoodsCategory.presenter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.HashMap;
import java.util.Map;

import abdallahandroid.resturantexamplemvp.R;

public class recyclerViewAdapter {

    Context mContext;
    Activity mActivity;
    String [] nameArray;
    String [] imageArray;


    public static Map<Integer, Boolean > CheckDownloadImage_map ;
    public static Map<Integer, Drawable > drawableData_map;

    public recyclerViewAdapter(Activity mActivity, Context mContext,
                               String [] nameList, String [] imageList){
        this.mActivity = mActivity;
        this.mContext  = mContext;
        this.nameArray = nameList;
        this.imageArray = imageList;


        CheckDownloadImage_map = new HashMap<>();
        drawableData_map = new HashMap<>();


        //recylerview code
        recylerviewMethod();
    }

    private void recylerviewMethod() {
        // set a GridLayoutManager with 2 number of columns
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL); // set Horizontal Orientation
        // get the reference of RecyclerView
        RecyclerView recyclerView = (RecyclerView) mActivity.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        // call the constructor of CustomAdapter to send the reference and data to Adapter
        AbdoRecyler customAdapter = new AbdoRecyler(mContext,mActivity);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
        System.out.println("dialog inside recylerview adapter ");
    }


    // inner class
    private class AbdoRecyler extends RecyclerView.Adapter<AbdoRecyler.MyViewHolder> {


        //varialbe
        private LayoutInflater mInflater;    private Context mContext;    private Activity mActivity;
        // data is passed into the constructor
        public AbdoRecyler(Context mContext, Activity mActivity) {
            this.mInflater = LayoutInflater.from(mContext);        this.mContext = mContext;        this.mActivity = mActivity;
        }
        // inflates the row layout from xml when needed
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.item_recycler_homepage, parent, false);
            MyViewHolder viewHolder = new MyViewHolder(view);
            return viewHolder;
        }
        // binds the data to the textview in each row
        @Override
        public void onBindViewHolder(final MyViewHolder holder, final int position) {
            //set name
            holder.nameTextView.setText(  nameArray[position]  );

            //get image url
            String imageUrl =    imageArray[position];

            /////////// set image url

            //prevent when scrolling up and down rePutting imageview agin
            boolean checkDownloadedBefore = CheckDownloadImage_map.containsKey(position);
            //System.out.println("gridview - inflate positon:  " + position + "  /containDrawableBefore: " + checkDownloadedBefore);
            if ( ! checkDownloadedBefore ){                         //check not downloaded before
                CheckDownloadImage_map.put(position, true);  //prenvet again by putting this key
                glidDownload(imageUrl, holder.imageImageVIew, position);   // now can start download
            }
            //every time inflate set old image
            Drawable getDrawableFromMap = drawableData_map.get(position);
            if ( (getDrawableFromMap != null)   )holder.imageImageVIew.setBackground(  getDrawableFromMap );


            //set alpha
            holder.allItemLayout.getBackground().setAlpha(60);

            //on item selected
            holder.allItemLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new PresenterOnItemSelected().setDataSelectedToClassData(position);
                }
            });
        }


        void glidDownload(String imageUrl, final ImageView image, final int position){
            //volley.main(mContext,imageUrl , holder.imageImageVIew, getItemCount() );
            Glide.with(mActivity).load(imageUrl).into(new SimpleTarget() {
                @Override
                public void onResourceReady(Object resource, GlideAnimation glideAnimation) {
                    try {
                        Drawable drawableFromGlide = (Drawable) resource;
                        image.setBackground(drawableFromGlide);
                        //set data downloaded of image to map
                        drawableData_map.put(position, drawableFromGlide );
                    } catch (Exception e) {
                        //System.out.println("glide - cast   exception: " + e);
                    }
                }
            });
        }



        // total number of rows
        @Override
        public int getItemCount() {
            return nameArray.length;
        }
        //function: اكتب  findviewById here
        public class MyViewHolder extends RecyclerView.ViewHolder {
            public TextView nameTextView;
            public ImageView imageImageVIew;
            public LinearLayout allItemLayout;

            public MyViewHolder(View itemView) {
                super(itemView);
                // get the reference of item view's
                nameTextView = (TextView) itemView.findViewById(R.id.name);
                imageImageVIew = (ImageView) itemView.findViewById(R.id.image);
                allItemLayout = (LinearLayout) itemView.findViewById(R.id.allItemLayout);
            }
        }
    }//end inner class


}
