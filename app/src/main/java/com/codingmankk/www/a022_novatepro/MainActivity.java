package com.codingmankk.www.a022_novatepro;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxResultCallback;
import com.tamic.novate.callback.RxStringCallback;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {


    private TextView mTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        NovateSimple2ReturnString();


    }

    private void initView() {
        mTV = (TextView) findViewById(R.id.id_tv);

    }


    /**
     * [1]novate  的初始化方法
     * @param url
     */
    private void NovateInitSimple1(String url){

        /**
         * 基础使用
         */
        Novate novate = new Novate.Builder(this)
                .baseUrl(url)
                .build();


        Map<String, String> headers = new HashMap<>();
        headers.put("com","com");
        headers.put("www","www");

        HashMap<String, String> params = new HashMap<>();
        params.put("com","com");
        params.put("www","www");

        Cache cache = new Cache(Environment.getExternalStorageDirectory().getAbsoluteFile(),300);

        /**
         * 更多功能的novate
         */
        Novate novate1 = new Novate.Builder(this)
                .addHeader(headers) //添加公共请求头
                .addParameters(params) //公共参数
                .connectTimeout(10)//连接时间 可以忽略
                .addCookie(false) //是否同步cooike 默认不同步
                .addCache(true) //是否缓存 默认缓存
                .addCache(cache) //自定义缓存
                .baseUrl(url) //base URL
                .addLog(true) //是否开启log
//                .cookieManager(new NovateCookieManager()) // 自定义cooike，可以忽略
//                .addInterceptor() // 自定义Interceptor
//                .addNetworkInterceptor() // 自定义NetworkInterceptor
                .proxy(Proxy.NO_PROXY) //代理
                .client(new OkHttpClient()) //clent 默认不需要
                .build();

    }


    /**
     * [2] String字符串的请求：
     */
    private void NovateSimple2ReturnString(){

        Map<String, Object> parameters0 = new HashMap<>();
        parameters0.put("ip", "21.22.11.33");

        String baseUrl = "http://ip.taobao.com/";
        String url = "service/getIpInfo.php";

        String SecondURL = "http://www.wanandroid.com/article/list/1/json";

        new Novate.Builder(this)
                .baseUrl(baseUrl)
                .build()
                .rxGet(url,parameters0,new RxStringCallback() {
                    @Override
                    public void onNext(Object tag, String response) {
                        if (response != null){
                            mTV.setText(response);
                        }
                    }

                    @Override
                    public void onError(Object tag, Throwable e) {

                    }

                    @Override
                    public void onCancel(Object tag, Throwable e) {

                    }
                });

    }

    /**
     * [3] Bean请求
     *
     */
    private void NovateSimple3ReturnBean() {

        String BaseUrl = "http://www.wanandroid.com/";
        String url = "article/list/1/json";

        new Novate.Builder(this)
                .baseUrl(BaseUrl)
                .build()
                .rxGet(url, , new RxResultCallback<>() {
                });
    }

}
