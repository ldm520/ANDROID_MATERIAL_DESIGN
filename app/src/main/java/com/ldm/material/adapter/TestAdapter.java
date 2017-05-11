package com.ldm.material.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldm.material.R;
import com.ldm.material.bean.TestBean;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private List<TestBean> mDatas;
    private RecyclerViewItemListener recyclerViewItemListener;

    public TestAdapter(List<TestBean> mDatas, RecyclerViewItemListener recyclerViewItemListener) {
        this.mDatas = mDatas;
        this.recyclerViewItemListener = recyclerViewItemListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.item_tv.setText(mDatas.get(position).getContent());
        holder.item_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != recyclerViewItemListener) {
                    recyclerViewItemListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView item_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            item_tv = (TextView) itemView.findViewById(R.id.item_tv);
        }
    }

    public interface RecyclerViewItemListener {
        void onItemClick(int position);
    }
}