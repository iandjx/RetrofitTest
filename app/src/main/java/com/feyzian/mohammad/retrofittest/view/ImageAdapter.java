package com.feyzian.mohammad.retrofittest.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.feyzian.mohammad.retrofittest.R;
import com.feyzian.mohammad.retrofittest.model.Image;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Mohammad on 11/22/2016.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageHolder> {

        ArrayList<Image> images = new ArrayList<>();

        LayoutInflater inflater;

public ImageAdapter(Context context) {
        inflater = LayoutInflater.from(context);
        }

@Override
public ImageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImageHolder(inflater.inflate(R.layout.item_image, parent, false));
        }

@Override
public void onBindViewHolder(ImageHolder holder, int position) {
        Picasso.with(holder.imageView.getContext())
        .load(images.get(position).link)
        .into(holder.imageView);
        }

@Override
public int getItemCount() {
        return images.size();
        }

public void swap(ArrayList<Image> list) {
        if (list != null) {
        images = list;
        notifyDataSetChanged();
        }
        }

public class ImageHolder extends RecyclerView.ViewHolder {
    ImageView imageView;

    public ImageHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView;
    }
}
}
