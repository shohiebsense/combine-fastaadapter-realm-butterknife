package com.shohiebsense.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Shohieb on 5/13/2017.
 */

public class ViewWrapper<V extends View> extends RecyclerView.ViewHolder{
    public final V view;


    public ViewWrapper(View itemView) {
        super(itemView);
        view = (V) itemView;
    }
}
