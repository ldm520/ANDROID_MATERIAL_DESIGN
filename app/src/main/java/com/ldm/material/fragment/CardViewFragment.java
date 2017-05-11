package com.ldm.material.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ldm.material.R;
import com.ldm.material.adapter.TestAdapter;
import com.ldm.material.bean.TestBean;
import com.ldm.material.view.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class CardViewFragment extends Fragment implements TestAdapter.RecyclerViewItemListener {
    private View view;
    private RecyclerView recycler_view;
    private List<TestBean> testDatas;
    private TestAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_cardview, container, false);
        initTestData();
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);
        //GridView样式展示
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        recycler_view.setLayoutManager(gridLayoutManager);
        mAdapter = new TestAdapter(testDatas, this);
        recycler_view.setAdapter(mAdapter);
//        //这句就是添加分隔线
//        recycler_view.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));
//        recycler_view.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.HORIZONTAL_LIST));
        //设置item间距
        //设置item间距，10dp
        recycler_view.addItemDecoration(new SpaceItemDecoration(10));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    private void initTestData() {
        testDatas = new ArrayList<>();
        TestBean bean;
        for (int i = 0; i < 12; i++) {
            bean = new TestBean();
            bean.setContent("测试_" + i + "_数据");
            testDatas.add(bean);
        }
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(), "点击了" + testDatas.get(position).getContent(), Toast.LENGTH_LONG).show();
    }
}
