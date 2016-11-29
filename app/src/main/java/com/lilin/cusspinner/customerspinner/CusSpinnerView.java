package com.lilin.cusspinner.customerspinner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.List;

/**
 * Created by lilin on 2016/11/29.
 * func : 自定义spinnerview
 */
public class CusSpinnerView extends Spinner implements OnItemClickListener {
    public static SelectDialog dialog = null;
    private List<String> list;
    public static String text;

    public CusSpinnerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //如果视图定义了OnClickListener监听器，调用此方法来执行
    @Override
    public boolean performClick() {
        Context context = getContext();
        final LayoutInflater inflater = LayoutInflater.from(getContext());
        final View view = inflater.inflate(R.layout.formcustomspinner, null);
        final ListView listview = (ListView) view
                .findViewById(R.id.formcustomspinner_list);
        ArrayAdapter<String> adapters = new ArrayAdapter<String>(getContext(),
                R.layout.spinner_checked_text, getList());
        listview.setAdapter(adapters);
        listview.setOnItemClickListener(this);
        dialog = new SelectDialog(context, R.style.dialog);//创建Dialog并设置样式主题
        LayoutParams params = new LayoutParams(DensityUtil.dip2px(context,240), DensityUtil.dip2px(context,300));
        dialog.setCanceledOnTouchOutside(true);// 设置点击Dialog外部任意区域关闭Dialog
        // 设置背景模糊参数
//        WindowManager.LayoutParams winlp = dialog.getWindow()
//                .getAttributes();
//        winlp.alpha = 0.7f; // 0.0-1.0
//        dialog.getWindow().setAttributes(winlp);
        dialog.show();
        dialog.addContentView(view, params);
        return true;
    }

    @Override
    public void onItemClick(AdapterView<?> view, View itemView, int position,
                            long id) {
        setSelection(position);
        setText(list.get(position));
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
