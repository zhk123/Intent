package com.zk.intent.Attribute;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.zk.intent.R;

import java.io.File;

public class IntentAttribute extends AppCompatActivity {

    private IntentAttribute mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intent_attribute);
        mContext = this;
    }

    public void Click(View view) {
        switch (view.getId()) {

            /* component(组件)：目的组件      注：以下使用显式Intent */
            case R.id.btn1:
                // 方式一：通过组件响应
                Intent intent = new Intent();
                ComponentName name = new ComponentName(mContext, TestActivity.class);
                intent.setComponent(name);
                startActivity(intent);

                // 方式二：通过setClass()方法响应
//                IntentInstance intent = new IntentInstance();
//                intent.setClass(mContext, TestActivity.class);
//                startActivity(intent);

                // 方式三：直接响应
//                IntentInstance intent = new IntentInstance(mContext, TestActivity.class);
//                startActivity(intent);
                break;

            /* Action（动作）：用来表现意图的行动 和 category（类别）：用来表现动作的类别      注：以下使用隐式Intent */
            case R.id.btn2:
                // 方式一：通过setAction()方法响应
                // 重要注意点：如果有多个组件被匹配成功，就会出现以对话框列表的方式让用户进行选择，如何解决这种问题？
                //             答：每个Intent中只能指定一个action，但却能指定多个category；类别越多，动作越具体，意图越明确
                Intent intent1 = new Intent();
                intent1.setAction("test");
                intent1.addCategory("myCategory");
                startActivity(intent1);

                // 方式二：直接响应
//                IntentInstance intent1 = new IntentInstance("test");
//                intent1.addCategory("myCategory");
//                startActivity(intent1);
                break;

            /* data（数据）：表示与动作要操纵的数据 */
            case R.id.btn3:
                Intent intent2 = new Intent();
                intent2.setAction(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("http://www.baidu.com");
                intent2.setData(uri);
                startActivity(intent2);
                break;

            /* type（数据类型）：对于data范例的描写 */
            case R.id.btn4:
                Intent intent3 = new Intent();
                intent3.setAction(Intent.ACTION_VIEW);
                Uri data = Uri.parse("file:///storage/emulated/0/China.mp4"); // "file:///storage/sdcard0/China.mp4"路径也可以
                // 设置data + type属性  注：Type属性用于明确指定Data属性的数据类型或MIME类型（根据文件后缀名获得MIME类型）
                intent3.setDataAndType(data, "audio/mp4");
                startActivity(intent3);
                break;

            /* extras（扩展信息）：扩展信息 */
            case R.id.btn5:
                Intent intent4 = new Intent(Intent.ACTION_SENDTO);
                intent4.setData(Uri.parse("smsto:"));
                startActivity(intent4);
                break;

            /* Flags（标志位）：期望这个意图的运行模式 */
            case R.id.btn6:
                // 一个程序启动后系统会为这个程序分配一个task供其使用，另外同一个task里面可以拥有不同应用程序的activity
                // 那么同一个程序能不能拥有多个task？这就涉及到加载activity的启动模式
                // 注：android中一组逻辑上在一起的activity被叫做task（栈），自己认为可以理解成一个activity堆栈
                Toast.makeText(mContext, "详细用法请看Activity的启动模式", Toast.LENGTH_SHORT).show();

                // 两个方法的区别是setflag是直接给intent设置新的flag，addflag是在已有flag上添加新的flag     注：task（任务）和back stack（返回栈）
                Intent intent6 = new Intent();
                intent6.setAction(Intent.ACTION_VIEW);
                intent6.addCategory(Intent.CATEGORY_DEFAULT);
                intent6.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                File file = new File(Environment.getExternalStorageDirectory() + "/External_storage/abc/test.txt");
                intent6.setDataAndType(Uri.fromFile(file), getMIMEType(file));
                startActivity(intent6);
                break;
        }
    }

    //根据文件后缀名获得MIME类型。
    private String getMIMEType(File file) {
        String type = "*/*";
        String fName = file.getName();
        int dotIndex = fName.lastIndexOf(".");
        if (dotIndex < 0) {
            return type;
        }
        String end = fName.substring(dotIndex, fName.length()).toLowerCase();
        if (end == "") return type;

        for (int i = 0; i < MIME.length; i++) {
            if (end.equals(MIME[i][0]))
                type = MIME[i][1];
        }
        return type;
    }

    // 以下是一些常见文件后缀名及对应的MIME类型
    private final String[][] MIME = {
            //{后缀名，	MIME类型}
            {".bmp", "image/bmp"},
            {".doc", "application/msword"},
            {".docx", "application/vnd.openxmlformats-officedocument.wordprocessingml.document"},
            {".xls", "application/vnd.ms-excel"},
            {".xlsx", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"},
            {".gif", "image/gif"},
            {".htm", "text/html"},
            {".html", "text/html"},
            {".jpeg", "image/jpeg"},
            {".jpg", "image/jpeg"},
            {".mp3", "audio/x-mpeg"},
            {".mp4", "video/mp4"},
            {".pdf", "application/pdf"},
            {".png", "image/png"},
            {".pps", "application/vnd.ms-powerpoint"},
            {".ppt", "application/vnd.ms-powerpoint"},
            {".pptx", "application/vnd.openxmlformats-officedocument.presentationml.presentation"},
            {".txt", "text/plain"},
            {".wps", "application/vnd.ms-works"},
            {".xml", "text/plain"},
            {".zip", "application/x-zip-compressed"},
            {"", "*/*"}
    };
}
