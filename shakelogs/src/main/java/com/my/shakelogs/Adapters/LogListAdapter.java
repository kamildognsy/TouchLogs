package com.my.shakelogs.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.my.shakelogs.LogModel;
import com.my.shakelogs.R;

import java.util.ArrayList;

public class LogListAdapter extends BaseAdapter{
    private ArrayList<LogModel> logList;
    private Context context;
    private LayoutInflater layoutInflater;

    public LogListAdapter(ArrayList<LogModel> logList, Context context) {
        this.logList = logList;
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return logList.size();
    }

    @Override
    public Object getItem(int i) {
        return logList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.item_log_list,null);
        TextView tv_date = v.findViewById(R.id.tv_date);
        tv_date.setText("LOG DATE : " + logList.get(i).getCreateDate());
        return v;
    }
}
