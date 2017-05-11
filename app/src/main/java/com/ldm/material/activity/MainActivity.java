package com.ldm.material.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.ldm.material.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar main_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置ToolBar
        main_toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);
        //绑定控件及监听事件
        findViewById(R.id.bar_btn).setOnClickListener(this);
        findViewById(R.id.drawer_btn).setOnClickListener(this);
    }

    /**
     * @description 给Toolbar添加菜单
     * @author ldm
     * @time 2017/5/10 13:46
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * R.menu.toolbar_menu.xml中每个item相应参数说明：
         * android:id用于指定菜单项的id
         * android:icon用于指定菜单项的图标
         * android:title用于指定菜单标题
         * app:showAsAction用于指定显示方式，取值可以有：
         * always：一直显示在ToolBar上
         * never：不显示
         * ifRoom:表示ToolBar空间足够时显示出来,空间中够时会以三个点样式提示下拉显示，显示在ToolBar上的只会是图标，显示在下拉菜单中的只有文字标题
         */
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        //return true或return super.onCreateOptionsMenu(menu)才会显示出菜单项
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * @description 菜单项目点击监听
     * @author ldm
     * @time 2017/5/10 13:58
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_one:
                Toast.makeText(this, "点击了" + item.getTitle(), Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bar_btn:
                Toast.makeText(this, "本页面使用了ToolBar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.drawer_btn:
                startActivity(new Intent(this, DrawerActivity.class));
                break;
            default:
                break;
        }
    }
}
