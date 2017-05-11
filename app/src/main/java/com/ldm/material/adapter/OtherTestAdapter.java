package com.ldm.material.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ldm.material.R;
import com.ldm.material.bean.TestBean;

import java.util.ArrayList;
import java.util.List;


public class OtherTestAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<TestBean> datas;
    private Context context;
    private List<Integer> lists;

    public OtherTestAdapter(Context context, List<TestBean> datas) {
        this.datas = datas;
        this.context = context;
        constructRandomHeights(datas);
    }

    private void constructRandomHeights(List<TestBean> datas) {
        lists = new ArrayList<>();
        for (int i = 0; i < datas.size(); i++) {
            lists.add((int) (200 + Math.random() * 366));
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.collapse_item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        //随机高度赋予item布局
        params.height = lists.get(position);
        holder.itemView.setLayoutParams(params);
        holder.item_tv.setText(datas.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView item_tv;

    public MyViewHolder(View itemView) {
        super(itemView);
        item_tv = (TextView) itemView.findViewById(R.id.item_tv);
    }
}
