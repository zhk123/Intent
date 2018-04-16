package com.zk.intent.StartupMode.singleTask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zk.intent.R;

// singleTask模式：这种模式下，每次启动一个activity时，系统首先会在返回栈中检查是否存在该活动的实例，如果存在，则直接使用该实例，并把这个活动之上的所有活动统统清除；如果没有发现就会创建一个新的活动实例

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity_singleTask_1", String.valueOf(this));
        setContentView(R.layout.singletask_1);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
