package com.carlos.mylistview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Administrator on 2015/12/30.
 */
public class MyListView extends ListView {
    private OnSizeChangedListener onSizeChangedListener;

    public void setOnSizeChangedListener(OnSizeChangedListener onSizeChangedListener) {
        this.onSizeChangedListener = onSizeChangedListener;
    }

    interface OnSizeChangedListener {
        public void onSizeChanged();
    }

    public MyListView(Context context) {
        super(context);
    }

    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        onSizeChangedListener.onSizeChanged();
    }
}
