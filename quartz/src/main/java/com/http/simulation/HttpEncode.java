package com.http.simulation;

/**
 * Created by 45208 on 2017/6/4.
 */
public enum HttpEncode {
    UTF8("utf-8",(byte)1),
    GBK("gbk",(byte)0);
    private String code;
    private byte value;
    HttpEncode(String code,byte value){
        this.code = code;
        this.value =  value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public byte getValue() {
        return value;
    }

    public void setValue(byte value) {
        this.value = value;
    }
}
