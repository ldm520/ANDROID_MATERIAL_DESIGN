package com.ldm.material.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ldm.material.R;

public class MaterialBarsFragment extends Fragment {
    private View view;
    private FloatingActionButton float_action;
    private Button show_snackbar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_material_bars, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        float_action = (FloatingActionButton) view.findViewById(R.id.float_action);
        show_snackbar = (Button) view.findViewById(R.id.show_snackbar);
        //悬浮在屏幕上的一个图标，可以进行点击操作
        float_action.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "点击了FloatActionBar", Toast.LENGTH_SHORT).show();
            }
        });
        //点击会在屏幕底部显示一个可以操作的窗口
        show_snackbar.setOnClickListener(new View.OnClickListener() {
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
