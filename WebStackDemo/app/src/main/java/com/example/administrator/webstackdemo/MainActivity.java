package com.example.administrator.webstackdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.webstackdemo.DS.Stack;

import java.net.*;

public class MainActivity extends AppCompatActivity {
    //后退栈
    private Stack<URL> backStack;
    //前进栈
    private Stack<URL> forwardStack;
    //后退按钮
    private Button backButton;
    //前进按钮
    private Button forwardButton;
    //假设这个是显示网页的地方
    private WebView stage;
    //网址输入框
    private EditText editor;
   // private String currentURL;

    private Client client;

    public static URL obj = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化两个栈的数据结构
        backStack = new Stack<URL>();
        forwardStack = new Stack<URL>();
        //获取两个按钮实例
        backButton = (Button)findViewById(R.id.backButton);
        forwardButton = (Button) findViewById(R.id.forwardButton);
        //获取输入框实例
        editor = (EditText) findViewById(R.id.url);
        //获取显示区域实例
        stage = (WebView) findViewById(R.id.content);
        WebSettings settings = stage.getSettings();
        settings.setJavaScriptEnabled(true);
        stage.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        client = new Client(backStack,editor);
        stage.setWebViewClient(client);
        //初始化，设置主页为www.smxy.cn
        stage.loadUrl("http://www.smxy.cn");
       // currentURL = "http://www.smxy.cn";
        //editor.setText(currentURL);


    }

    public void load(View view)
    {
        /*
            获取输入的网址内容
              如果为空，结束
         */
        String url = editor.getText().toString();
        if(url.trim().equals(""))
        {
            Toast.makeText(MainActivity.this,"Not null!",Toast.LENGTH_SHORT).show();
            return;
        }

        if(url.indexOf("http://") == -1)
        {
            url = "http://"+url;
        }

        stage.loadUrl(url);
    }

    public void goBack(View view)
    {
        /*
           回退操作
         */
       if(backStack.empty())
        {
            Toast.makeText(MainActivity.this,"End",Toast.LENGTH_SHORT).show();
            return;
        }

       forwardStack.pull(new URL(editor.getText().toString()));
        URL turl = backStack.pop();
        turl.setBack(true);
        obj = turl;
        stage.loadUrl(turl.getAddress());
    }


    public void goForward(View view)
    {
        /*
           前进操作，与回退操作类似
         */
        if(forwardStack.empty())
        {
            Toast.makeText(MainActivity.this,"End",Toast.LENGTH_SHORT).show();
            return;
        }
        backStack.pull(new URL(editor.getText().toString()));
        URL turl = forwardStack.pop();
        turl.setForward(true);
        obj = turl;
        stage.loadUrl(turl.getAddress());
    }
}
