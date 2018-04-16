package com.zk.intent.Instance;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zk.intent.Attribute.TestActivity;
import com.zk.intent.R;

import java.io.File;

public class IntentInstance extends AppCompatActivity {

    private IntentInstance mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_instance);
        mContext = this;
    }

    public void Click(View view) {
        switch (view.getId()) {
            // 打开指定网页
            case R.id.btn1:
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse("http://www.baidu.com/"));
                startActivity(intent1);
                break;
            // 打开拨号面板
            case R.id.btn2:
                Intent intent2 = new Intent(Intent.ACTION_DIAL);
                intent2.setData(Uri.parse("tel:10086"));
                startActivity(intent2);
                break;
            // 直接拨打指定号码
            case R.id.btn3:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                Intent intent3 = new Intent(Intent.ACTION_CALL);
                intent3.setData(Uri.parse("tel:10086"));
                startActivity(intent3);
                break;
            // 打开发送短信的界面：action+type
            case R.id.btn4:
                Intent intent4 = new Intent(Intent.ACTION_VIEW);
                intent4.setType("vnd.android-dir/mms-sms");
                intent4.putExtra("sms_body", "具体短信内容"); //"sms_body"为固定内容
                startActivity(intent4);
                break;
            // 打开发短信的界面(指定电话号码):action+data
            case R.id.btn5:
                Intent intent5 = new Intent(Intent.ACTION_SENDTO);
                intent5.setData(Uri.parse("smsto:18780260012"));
                intent5.putExtra("sms_body", "具体短信内容"); //"sms_body"为固定内容
                startActivity(intent5);
                break;
            // 播放指定路径音乐
            case R.id.btn6:
                Intent intent6 = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("file:///storage/emulated/0/China.mp4"); // "file:///storage/sdcard0/China.mp4"路径也可以
                intent6.setDataAndType(uri, "audio/mp4"); //方法：Intent android.content.Intent.setDataAndType(Uri data, String type)
                startActivity(intent6);
                break;
            // 卸载某个应用程序，根据包名来识别
            case R.id.btn7:
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("com.zk.xdxm"));
                startActivity(intent);
                break;
            // 安装某个应用程序，根据apk的文件名来识别
            case R.id.btn8:
                Intent intent8 = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.fromFile(new File("/storage/sdcard0/app_hhxm.apk"));    //路径不能写成："file:///storage/sdcard0/···"
                intent8.setDataAndType(data, "application/vnd.android.package-archive");  //Type的字符串为固定内容
                startActivity(intent8);
                break;
        }
    }
}
