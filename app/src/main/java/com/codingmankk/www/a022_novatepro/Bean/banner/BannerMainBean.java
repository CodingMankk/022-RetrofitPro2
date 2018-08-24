/**
 * Copyright 2018 bejson.com
 */
package com.codingmankk.www.a022_novatepro.Bean.banner;

import java.util.List;

/**
 * Auto-generated: 2018-08-24 15:21:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BannerMainBean {

    private List<BannerData> data;
    private int errorCode;
    private String errorMsg;

    public void setData(List<BannerData> data) {
        this.data = data;
    }

    public List<BannerData> getData() {
        return data;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }


    @Override
    public String toString() {
        return "BannerMainBean{" +
                "data=" + data +
                ", errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}