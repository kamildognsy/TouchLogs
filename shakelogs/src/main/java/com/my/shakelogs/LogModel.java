package com.my.shakelogs;

import java.io.Serializable;
import java.util.Date;

public class LogModel implements Serializable {
    private int id;
    private String message;
    private String request;
    private String response;
    private String userId;
    private String createDate;

    public LogModel() {
    }

    public LogModel(String message, String request, String response, String userId) {
        this.message = message;
        this.request = request;
        this.response = response;
        this.userId = userId;
        this.createDate = new Date().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
