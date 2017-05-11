package com.ldm.material.bean;

import java.io.Serializable;

/**
 * description：
 * 作者：ldm
 * 时间：20172017/5/11 08:57
 * 邮箱：1786911211@qq.com
 */
public class TestBean implements Serializable {
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //显示的内容，更多字段根据实际情况添加
    String content;
}
