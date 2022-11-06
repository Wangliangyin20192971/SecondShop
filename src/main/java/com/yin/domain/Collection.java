package com.yin.domain;

/**
 * @Classname Collection
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/4/14 21:08
 * @Version 1.0
 **/
public class Collection {
    private Integer collId;
    private Integer UserId;
    private Integer goodsId;
    private String goodsName;
    private String goodsUrl;
    private String goodsMessage;
    private Double goodsPrice;
    private String goodsType;

    public Collection(Integer collId, Integer userId, Integer goodsId, String goodsName, String goodsUrl,String goodsMessage, Double goodsPrice, String goodsType) {
        this.collId = collId;
        UserId = userId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsUrl = goodsUrl;
        this.goodsMessage = goodsMessage;
        this.goodsPrice = goodsPrice;
        this.goodsType = goodsType;
    }

    public Collection() {

    }

    public Integer getCollId() {
        return collId;
    }

    public void setCollId(Integer collId) {
        this.collId = collId;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsUrl() {
        return goodsUrl;
    }

    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    public String getGoodsMessage() {
        return goodsMessage;
    }

    public void setGoodsMessage(String goodsMessage) {
        this.goodsMessage = goodsMessage;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }
}
