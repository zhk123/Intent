package com.zk.intent.StartupMode.singleInstance;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.zk.intent.R;

// 总是在新的任务中开启，并且这个新的任务中有且只有这一个实例，也就是说被该实例启动的其他activity会自动运行于另一个任务中。当再次启动该activity的实例时，会重新调用已存在的任务和实例。并且会调用这个实例的onNewIntent()方法，将Intent实例传递到该实例中。和singleTask相同，同一时刻在系统中只会存在一个这样的Activity实例。(singleInstance即单实例)

// 注：前面三种模式中，每个应用程序都有自己的返回栈，同一个活动在不同的返回栈中入栈时，必然是创建了新的实例。而使用singleInstance模式可以解决这个问题，在这种模式下会有一个单独的返回栈来管理这个活动，不管是哪一个应用程序来访问这个活动，都公用同一个返回栈，也就解决了共享活动实例的问题。（此时可以实现任务之间的切换，而不是单独某个栈中的实例切换）

public class FirstActivity extends AppCompatActivity {

    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Activity_singleInstance_1", String.valueOf(getTaskId()));
        setContentView(R.layout.singleinstance_1);
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
