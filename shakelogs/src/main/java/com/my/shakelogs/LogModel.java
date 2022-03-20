package com.my.shakelogs;

import com.google.gson.Gson;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LogModel implements Serializable {
    private int id;
    private String message;
    private String request;
    private String response;
    private String userId;
    private String createDate;
    private Object requestObj;
    private Object responseObj;

    public LogModel() {

    }

    public LogModel(String message, Object request, Object response, String userId) {
        this.message = message;
        this.requestObj = request;
        this.responseObj = response;
        this.userId = userId;
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = dateFormat.format(date);
        this.createDate = strDate;
        Gson gson = new Gson();
        String requestJson = gson.toJson(request);
        String responseJson = gson.toJson(response);
        this.request = requestJson;
        this.response = responseJson;
    }

    public Object getRequestObj() {
        return requestObj;
    }

    public void setRequestObj(Object requestObj) {
        this.requestObj = requestObj;
    }

    public Object getResponseObj() {
        return responseObj;
    }

    public void setResponseObj(Object responseObj) {
        this.responseObj = responseObj;
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
