package com.codingmankk.www.a022_novatepro;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingmankk.www.a022_novatepro.Bean.JsonRootBean2;
import com.codingmankk.www.a022_novatepro.Bean.banner.BannerData;
import com.codingmankk.www.a022_novatepro.Bean.banner.BannerMainBean;
import com.orhanobut.logger.Logger;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxResultCallback;
import com.tamic.novate.callback.RxStringCallback;

import java.net.Proxy;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private TextView mTV;
    private Button mBtn;
    private ImageView mIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initView();
//        NovateSimple2ReturnString();
//        NovateSimple3ReturnBean();

        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                performGet();
//                NovateSimple3ReturnBean();
//                NovateRequestBean();

                NovateRequstBean();


          }
        });

    }

    private void initView() {
        mTV = (TextView) findViewById(R.id.id_tv);
        mBtn = (Button) findViewById(R.id.btn_get);
        mIV = (ImageView) findViewById(R.id.id_iv);

    }


    /**
     * [1]novate  的初始化方法
     *
     * @param url
     */
    private void NovateInitSimple1(String url) {

        /**
         * 基础使用
         */
        Novate novate = new Novate.Builder(this)
                .baseUrl(url)
                .build();


        Map<String, String> headers = new HashMap<>();
        headers.put("com", "com");
        headers.put("www", "www");

        HashMap<String, String> params = new HashMap<>();
        params.put("com", "com");
        params.put("www", "www");

        Cache cache = new Cache(Environment.getExternalStorageDirectory().getAbsoluteFile(), 300);

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
    private void NovateSimple2ReturnString() {

        Map<String, Object> parameters0 = new HashMap<>();
        parameters0.put("ip", "21.22.11.33");

        String baseUrl = "http://ip.taobao.com/";
        String url = "service/getIpInfo.php";

        String SecondURL = "http://www.wanandroid.com/article/list/1/json1";

        new Novate.Builder(this)
                .baseUrl(baseUrl)
                .build()
                .rxGet(url, parameters0, new RxStringCallback() {
                    @Override
                    public void onNext(Object tag, String response) {
                        if (response != null) {
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
     * [3] Bean请求失败！！！！
     */
    private void NovateSimple3ReturnBean() {

        String BaseUrl = "http://www.wanandroid.com/";
        String url = "article/list/1/json1";

        Map<String, Object> parameters = new HashMap<>();
//        parameters.put("ip", "21.22.11.33");

        new Novate.Builder(this)
                .baseUrl(BaseUrl)
//                .addConverterFactory(GsonConverterFactory.create())
                .addLog(true)
                .build()
                .rxGet(url, parameters, new RxResultCallback<JsonRootBean2>() {
                    @Override
                    public void onError(Object tag, Throwable e) {

                    }

                    @Override
                    public void onCancel(Object tag, Throwable e) {

                    }

                    @Override
                    public void onNext(Object tag, int code, String message, JsonRootBean2 response) {

                    }
                });


    }


    /**
     * [4]retrofit 原生请求Bean
     */
    private void NovateRequestBean() {

        String URL = "http://www.wanandroid.com/bannder/json";
        String BaseUrl = "http://www.wanandroid.com/";
        String url = "banner/json";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Service service = retrofit.create(Service.class);
        Call<BannerMainBean> call = service.GetBean(url);

        call.enqueue(new Callback<BannerMainBean>() {
            @Override
            public void onResponse(Call<BannerMainBean> call, Response<BannerMainBean> response) {
                if (response.isSuccessful()){
                    BannerMainBean bean = response.body();
                    StringBuilder result = new StringBuilder();
                    int size = bean.getData().size();
                    for (int i=0; i<size; i++){
                        result.append(bean.getData().get(i).toString());
                        BannerData bannerData = bean.getData().get(i);
                        if (i == 3){
                            //ToDo :请求图片加载到ImageView中
                            bannerData.getImagePath();
                        }
                        Logger.i(
                                "id:"+bannerData.getId()+"\n"+
                                "Url:"+bannerData.getUrl()+"\n"+
                                "Desc:"+bannerData.getDesc()+"\n"+
                                "ImagePath:"+bannerData.getImagePath()+"\n"+
                                "Type:"+bannerData.getOrder()+"\n"+
                                "Title:"+bannerData.getTitle()+"\n");

                    }
                    mTV.setText(result);
                    Logger.i(result+"");
                }
            }

            @Override
            public void onFailure(Call<BannerMainBean> call, java.lang.Throwable t) {

            }
        });
    }

    /**
     * [5]请求Novate
     */
    
    private void NovateRequstBean(){

        String URL = "http://www.wanandroid.com/bannder/json";
        String BaseUrl = "http://www.wanandroid.com/";
        String url = "banner/json";


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("banner","banner");


        new Novate.Builder(this)
                .baseUrl(BaseUrl)
//                .addConverterFactory(new GsonConverterFactory.create())
                .build()
                .rxGet(url, parameters, new RxResultCallback<BannerMainBean>() {
                    @Override
                    public void onError(Object tag, Throwable e) {

                    }

                    @Override
                    public void onCancel(Object tag, Throwable e) {

                    }

                    @Override
                    public void onNext(Object tag, int code, String message, BannerMainBean response) {
                        BannerData bannerData = response.getData().get(1);
                        String imagePath = bannerData.getImagePath();
                        Logger.i(imagePath);
                    }
                });

    }
}