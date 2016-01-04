package com.carlos.mylistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyListView.OnSizeChangedListener, View.OnClickListener {
    private ListView listView;
    private EditText editText;

    /**
     * item的高度
     */
    private int viewHeight;
    /**
     * 当前点击的位置
     */
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        listView = (ListView) findViewById(R.id.listView);
        //因为是自定义的ListView,所以在这里设置回调
        ((MyListView) listView).setOnSizeChangedListener(this);
        listView.setAdapter(new MainAdapter(this, this));
    }

    /**
     * ListView尺寸改变后的回调
     */
    @Override
    public void onSizeChanged() {
        listView.setSelectionFromTop(position, listView.getBottom() - viewHeight);
    }

    @Override
    public void onClick(View v) {
        //获取当前点击的位置
        position = (int) v.getTag();
        Toast.makeText(this, "点击了" + position, Toast.LENGTH_LONG).show();
        //获取点击的那个Item的高度
        viewHeight = ((View) v.getParent()).getHeight();
        editText.requestFocus();
        InputMethodManager inputManager =
                (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.showSoftInput(editText, 0);
    }
}
