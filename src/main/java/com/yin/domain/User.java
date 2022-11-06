package com.yin.domain;

/**
 * @Classname User
 * @Description TODO
 * @Author Lenovo
 * @Date 2022/3/15 20:06
 * @Version 1.0
 **/
public class User {
    private Integer userId;
    private String userName;
    private String userPassword;
    private String userSex;
    private String userBuilding;
    private String userRoom;

    public User(Integer userId, String userName, String userPassword, String userSex, String userBuilding, String userRoom) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userBuilding = userBuilding;
        this.userRoom = userRoom;
    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBuilding() {
        return userBuilding;
    }

    public void setUserBuilding(String userBuilding) {
        this.userBuilding = userBuilding;
    }

    public String getUserRoom() {
        return userRoom;
    }

    public void setUserRoom(String userRoom) {
        this.userRoom = userRoom;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBuilding='" + userBuilding + '\'' +
                ", userRoom='" + userRoom + '\'' +
                '}';
    }
}
