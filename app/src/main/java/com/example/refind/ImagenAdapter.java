package com.example.refind;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

public class ImagenAdapter extends BaseAdapter {

    private Context mContext;

    public int[] imagenArray = {
        R.drawable.ima_grid1,R.drawable.ima_grid2,R.drawable.ima_grid3,R.drawable.ima_grid4,R.drawable.ima_grid5,R.drawable.ima_grid6,R.drawable.ima_grid7,
        R.drawable.ima_grid8,R.drawable.ima_grid9,R.drawable.ima_grid10,R.drawable.ima_grid11,R.drawable.ima_grid12,R.drawable.ima_grid13
    };

    public ImagenAdapter(Context mContext) {
        this.mContext = mContext;
    }

    //https://developer.android.com/training/multiscreen/screendensities?hl=es

    @Override
    public int getCount() {
        return imagenArray.length;
    }

    @Override
    public Object getItem(int position) {
        return imagenArray[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imagenView = new ImageView(mContext);
        imagenView.setImageResource(imagenArray[position]);
        imagenView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imagenView.setLayoutParams(new GridView.LayoutParams(350, 350));
        return imagenView;
    }
}
