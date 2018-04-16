package com.zk.intent.StartupMode.standard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zk.intent.R;

// standard模式：默认的模式，以这种模式加载时，每当启动一个新的活动，必定会构造一个新的Activity实例放到返回栈（目标task）的栈顶，不管这个Activity是否已经存在于返回栈中

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity_standard", String.valueOf(this));
        setContentView(R.layout.standard);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
