package com.codingmankk.www.a022_novatepro;


import com.codingmankk.www.a022_novatepro.Bean.banner.BannerMainBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * ================================================
 * 版    本：
 * 创建日期：
 * 描    述：
 * 修订历史：
 * ================================================
 */
public interface Service {

    @GET
    Call<BannerMainBean> GetBean(@Url String url);
}
