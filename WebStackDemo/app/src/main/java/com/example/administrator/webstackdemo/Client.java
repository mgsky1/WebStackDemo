package com.example.administrator.webstackdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.administrator.webstackdemo.DS.Stack;

/**
 * Created by Martin Huang on 2017/4/28.
 */

public class Client extends WebViewClient
{
    private Stack<URL> backStack;
    private TextView textView;
    private URL pre;

    public Client(Stack<URL> backStack , TextView textView)
    {
        this.backStack = backStack;
        this.textView = textView;
        pre = null;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        textView.setText(url);
        if(MainActivity.obj == null)
        {
            //System.out.println("NULL");
            URL nurl = new URL(url);
            if(pre != null)
            {
                backStack.pull(pre);
            }
            pre = nurl;
        }
        else
        {
            //System.out.println("1:BACK---"+MainActivity.obj.isBack()+"  FORWARD---"+MainActivity.obj.isForward());
            pre = MainActivity.obj;
            if(MainActivity.obj.isBack())
            {
                MainActivity.obj.setBack(false);
            }

            if(MainActivity.obj.isForward())
            {
                MainActivity.obj.setForward(false);
            }
            //System.out.println("2:BACK---"+MainActivity.obj.isBack()+"  FORWARD---"+MainActivity.obj.isForward());
        }

        MainActivity.obj = null;
    }
}
