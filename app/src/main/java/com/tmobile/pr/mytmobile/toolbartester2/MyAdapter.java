package com.tmobile.pr.mytmobile.toolbartester2;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jonegalado on 10/4/17, Gimmyo Project.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<Model> mDataSet;
    private int viewWidth;
    private int viewHeight;
    String TAG = "ToolbarTester2";

    public MyAdapter(List<Model> mDataSet) {
        this.mDataSet = mDataSet;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);

        ViewTreeObserver viewTreeObserver = itemView.getViewTreeObserver();
        if(viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                @Override
                public void onGlobalLayout() {
                    itemView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    viewWidth = itemView.getWidth();
                    viewHeight = itemView.getMeasuredHeight();
//                    Log.i(TAG, "onGlobalLayout: " + viewHeight);
                }
            });
        }

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Model model = mDataSet.get(position);
        holder.titlemessage.setText(model.getTitle());
        holder.body.setText(model.getBody());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titlemessage, body;

        public ViewHolder(View itemView) {
            super(itemView);

            titlemessage = itemView.findViewById(R.id.card_title);
            body = itemView.findViewById(R.id.card_body);
        }
    }

    public int getViewHeight() {
        return viewHeight;
    }
}
