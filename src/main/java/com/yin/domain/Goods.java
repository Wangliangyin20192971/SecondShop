package com.yin.domain;

import java.util.BitSet;

/**
 * @Classname Goods
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/15 20:10
 * @Version 1.0
 **/
public class Goods {
    private Integer goodsId;
    private String goodsName;
    private String goodsMessage;
    private Double goodsPrice;
    private String goodsUrl;
    private String goodsType;
    private String goodsCreateTime;
    private String goodsState;
    private Integer userId;
    private Integer buyId;

    public Goods(Integer goodsId, String goodsName,String goodsUrl, String goodsMessage, Double goodsPrice, String goodsType, String goodsCreateTime, String goodsState, Integer userId, Integer buyId) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsUrl=goodsUrl;
        this.goodsMessage = goodsMessage;
        this.goodsPrice = goodsPrice;
        this.goodsType = goodsType;
        this.goodsCreateTime = goodsCreateTime;
        this.goodsState = goodsState;
        this.userId = userId;
        this.buyId = buyId;
    }

    public Goods() {

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

    public String getGoodsUrl() { return goodsUrl; }

    public void setGoodsUrl(String goodsUrl) { this.goodsUrl = goodsUrl; }

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

    public String getGoodsCreateTime() {
        return goodsCreateTime;
    }

    public void setGoodsCreateTime(String goodsCreateTime) {
        this.goodsCreateTime = goodsCreateTime;
    }

    public String  getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String  goodsState) {
        this.goodsState = goodsState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsUrl='" + goodsUrl + '\'' +
                ", goodsMessage='" + goodsMessage + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCreateTime='" + goodsCreateTime + '\'' +
                ", goodsState=" + goodsState +
                ", userId=" + userId +
                '}';
    }
}
