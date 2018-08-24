/**
 * Copyright 2018 bejson.com
 */
package com.codingmankk.www.a022_novatepro.Bean.banner;

/**
 * Auto-generated: 2018-08-24 15:21:50
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BannerData {

    private int id;
    private String url;
    private String imagePath;
    private String title;
    private String desc;
    private int isVisible;
    private int order;
    private int type;


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setIsVisible(int isVisible) {
        this.isVisible = isVisible;
    }

    public int getIsVisible() {
        return isVisible;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "BannerData{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", isVisible=" + isVisible +
                ", order=" + order +
                ", type=" + type +
                '}';
    }
}