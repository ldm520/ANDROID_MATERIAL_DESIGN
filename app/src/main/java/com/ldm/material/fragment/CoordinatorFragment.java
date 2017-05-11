package com.ldm.material.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ldm.material.R;

public class CoordinatorFragment extends Fragment {
    private View view;
    private FloatingActionButton coor_float_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_coodinator, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        coor_float_button = (FloatingActionButton) view.findViewById(R.id.coor_float_button);
        //CoordinatorLayout是加强版本的FrameLayout，可以监听所有子控件的监听事件并做出对应响应
        //比如当前页面的FloatActionBar位于屏幕底部当弹出SnackBar时，FloatingActionButton会往上移动
        //悬浮在屏幕上的一个图标，可以进行点击操作
        coor_float_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "测试添加数据", Snackbar.LENGTH_LONG).setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //TODO 这里做操作
                        Toast.makeText(getActivity(), "操作成功", Toast.LENGTH_SHORT).show();
                    }
                }).show();
            }
        });

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
