package com.my.shakelogs.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.my.shakelogs.Adapters.LogListAdapter;
import com.my.shakelogs.LogModel;
import com.my.shakelogs.R;

import java.util.ArrayList;

public class LogListActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<LogModel> logList;
    LogListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
        init();
    }

    private void init(){
        lv = findViewById(R.id.lv);
        Intent i = getIntent();
        logList = (ArrayList<LogModel>) i.getSerializableExtra("logList");
        adapter = new LogListAdapter(logList , LogListActivity.this);
        lv.setAdapter(adapter);
    }
}