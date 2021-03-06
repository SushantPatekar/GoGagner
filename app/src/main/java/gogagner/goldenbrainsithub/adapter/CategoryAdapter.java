package gogagner.goldenbrainsithub.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import gogagner.goldenbrainsithub.com.GlideApp;
import gogagner.goldenbrainsithub.com.R;
import gogagner.goldenbrainsithub.model.CategoryModel;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private ArrayList<CategoryModel> android;
    private Context context;

    public CategoryAdapter(Context context, ArrayList<CategoryModel> android) {
        this.android = android;
        this.context = context;
    }

    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_category_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(android.get(i).getCategory_name());
        GlideApp.with(context)
                .load(android.get(i).getCategory_image())
                .placeholder(R.mipmap.go_ganer_app_icon)
                .error(R.mipmap.go_ganer_app_icon)
                .centerCrop()
               // .override(170, 170)
                .into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_android;
        private ImageView img_android;
        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView)view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
        }
    }

}