package com.my.shakelogs.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.my.shakelogs.Adapters.LogListAdapter;
import com.my.shakelogs.LogModel;
import com.my.shakelogs.R;
import com.my.shakelogs.ThreeFingerDetection;

import java.util.ArrayList;

public class LogListActivity extends AppCompatActivity {
    private ListView lv;
    private EditText et;
    private Button btn_delete;
    private ArrayList<LogModel> logList;
    private ArrayList<LogModel> copyLogList;
    private LogListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_list);
        init();
    }

    private void init(){
        lv = findViewById(R.id.lv);
        et = findViewById(R.id.et);
        btn_delete = findViewById(R.id.btn_delete);
        Intent i = getIntent();
        logList = (ArrayList<LogModel>) i.getSerializableExtra("logList");
        adapter = new LogListAdapter(logList , LogListActivity.this);
        lv.setAdapter(adapter);

        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 1){
                    copyLogList = new ArrayList<>();
                    adapter = new LogListAdapter(logList , LogListActivity.this);
                    lv.setAdapter(adapter);
                }else if(charSequence.length() > 1){
                    copyLogList = new ArrayList<>();
                    for(int index=0;index<logList.size();index++){
                        if(logList.get(index).getCreateDate().contains(charSequence)){
                            copyLogList.add(logList.get(index));
                        }
                    }
                    adapter = new LogListAdapter(copyLogList , LogListActivity.this);
                    lv.setAdapter(adapter);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThreeFingerDetection detection = new ThreeFingerDetection(LogListActivity.this);
                for(int index = 0; index < logList.size();index++){
                    detection.deleteLogs(String.valueOf(logList.get(index).getId()));
                }
                adapter = new LogListAdapter(new ArrayList<>() , LogListActivity.this);
                lv.setAdapter(adapter);
            }
        });

    }
}