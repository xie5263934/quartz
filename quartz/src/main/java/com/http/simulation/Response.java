package com.http.simulation;

/**
 * author 45208
 * date 2017/6/4
 **/
public class Response {
    //响应类型
    private byte encode;
    //响应内容
    private String response;
    //响应内容长度
    private int responseLength;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getResponseLength() {
        return responseLength;
    }

    public void setResponseLength(int responseLength) {
        this.responseLength = responseLength;
    }
}
