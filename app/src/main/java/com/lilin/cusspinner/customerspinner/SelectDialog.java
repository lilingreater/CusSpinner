package com.lilin.cusspinner.customerspinner;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by lilin on 2016/11/29.
 * func : 自定义dialog
 */
public class SelectDialog extends Dialog {
    public SelectDialog(Context context, int theme) {
        super(context, theme);
    }

    public SelectDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.slt_cnt_type);
    }
}
