package com.example.today_study.MainLog;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.today_study.R;

import java.util.ArrayList;

public class MainLogAdapter extends BaseAdapter {

    Context mContext = null;
    ArrayList<MainLogItem> dataList;

    public MainLogAdapter(Context context, ArrayList<MainLogItem> data) {
        mContext = context;
        dataList = data;
    }

    @Override
    public int getCount() { // Item Size 반환
        return dataList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public MainLogItem getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.layout_listview_main, parent, false);
        }

        MainLogItem currentItem = getItem(position);
        TextView mainLogText = (TextView) convertView.findViewById(R.id.mainLogText);

        mainLogText.setText(currentItem.GetMainLogText());

        return convertView;
    }
}
