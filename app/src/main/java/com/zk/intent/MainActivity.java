package com.zk.intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.zk.intent.Attribute.IntentAttribute;
import com.zk.intent.Instance.IntentInstance;
import com.zk.mylibrary.CustomUtil;

public class MainActivity extends AppCompatActivity {

    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        String name = CustomUtil.getName();
        Log.i("TAG_lib", "onCreate: " + name);
    }

    public void Click(View view){
        switch (view.getId()){
            case R.id.btn1:
                startActivity(new Intent(mContext, IntentAttribute.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(mContext, IntentInstance.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(mContext, com.zk.intent.StartupMode.standard.FirstActivity.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(mContext, com.zk.intent.StartupMode.singleTop.FirstActivity.class));
                break;
            case R.id.btn5:
                startActivity(new Intent(mContext, com.zk.intent.StartupMode.singleTask.FirstActivity.class));
                break;
            case R.id.btn6:
                startActivity(new Intent(mContext, com.zk.intent.StartupMode.singleInstance.FirstActivity.class));
                break;
        }
    }
}
