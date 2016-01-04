package com.carlos.mylistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/12/30.
 */
public class MainAdapter extends BaseAdapter {
    private Context context;
    private View.OnClickListener onClickListener;
    private LayoutInflater layoutInflater;

    public MainAdapter(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.item_main, parent, false);
        TextView top = (TextView) convertView.findViewById(R.id.top);
        TextView middle = (TextView) convertView.findViewById(R.id.middle);
        TextView bottom = (TextView) convertView.findViewById(R.id.bottom);
        top.setText("这里是顶部" + position);
        middle.setText("这里是中间" + position);
        bottom.setText("这里是底部" + position + "   假设这是评论按钮");
        bottom.setTag(position);
        bottom.setOnClickListener(onClickListener);
        return convertView;
    }
}
