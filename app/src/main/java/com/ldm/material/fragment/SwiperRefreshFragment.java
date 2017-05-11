package com.ldm.material.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
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

public class SwiperRefreshFragment extends Fragment implements TestAdapter.RecyclerViewItemListener {
    private View view;
    private SwipeRefreshLayout swiper_refresh;
    private RecyclerView recycler_view;
    private List<TestBean> testDatas;
    private TestAdapter mAdapter;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    mAdapter.notifyDataSetChanged();
                    swiper_refresh.setRefreshing(false);
                    break;

            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_swiperefresh, container, false);
        testDatas = new ArrayList<>();
        initTestData();
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        recycler_view = (RecyclerView) view.findViewById(R.id.recycler_view);
        swiper_refresh = (SwipeRefreshLayout) view.findViewById(R.id.swiper_refresh);
        //GridView样式展示
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycler_view.setLayoutManager(linearLayoutManager);
        mAdapter = new TestAdapter(testDatas, this);
        recycler_view.setAdapter(mAdapter);
//        //这句就是添加分隔线
//        recycler_view.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.VERTICAL_LIST));
//        recycler_view.addItemDecoration(new MyDecoration(getActivity(), MyDecoration.HORIZONTAL_LIST));
        //设置item间距，5dp
        recycler_view.addItemDecoration(new SpaceItemDecoration(5));
        swiper_refresh.setColorSchemeResources(R.color.colorPrimaryDark);
        swiper_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟刷新数据
                freshData();
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    private void initTestData() {
        TestBean bean;
        for (int i = 0; i < 12; i++) {
            bean = new TestBean();
            bean.setContent("测试_" + i + "_数据");
            testDatas.add(bean);
        }
    }

    private void freshData() {
        testDatas.clear();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1500);
                    TestBean bean;
                    for (int i = 0; i < 12; i++) {
                        bean = new TestBean();
                        bean.setContent("刷新_" + i + "_数据");
                        testDatas.add(bean);
                    }
                    mHandler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(getActivity(), "点击了" + testDatas.get(position).getContent(), Toast.LENGTH_LONG).show();
    }
}
