package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnSave;
    private Button mBtnLoad;
    private TextView mTv;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSave = findViewById(R.id.btn_save);
        mBtnSave.setOnClickListener(this);
        mBtnLoad = findViewById(R.id.btn_load);
        mBtnLoad.setOnClickListener(this);
        mTv = findViewById(R.id.tv_textView);
        mTv.setOnClickListener(this);
        sharedPreferences = getSharedPreferences("abc", MODE_PRIVATE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_save: {
                save();
                break;
            }
            case R.id.btn_load: {
                load();
                break;
            }
        }
    }

    private void save() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name","abc");
        editor.putInt("age",18);
        editor.commit();
    }

    private void load() {
        String name = sharedPreferences.getString("name","");
        int age=sharedPreferences.getInt("age",0);
        mTv.setText("名字:"+name+"\n年龄:"+age);

    }

}