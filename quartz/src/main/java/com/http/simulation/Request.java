package com.http.simulation;

/**
 * author 45208
 * date 2017/6/4
 **/
public class Request {
    //编码类型
    private byte encode;
    //命令内容
    private String command;
    //命令长度
    private int commandLength;

    public byte getEncode() {
        return encode;
    }

    public void setEncode(byte encode) {
        this.encode = encode;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public int getCommandLength() {
        return commandLength;
    }

    public void setCommandLength(int commandLength) {
        this.commandLength = commandLength;
    }
}
