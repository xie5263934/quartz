package com.http.simulation;

import java.io.*;

/**
 * author 45208
 * date 2017/6/4
 **/
public class ProtocalUtil {
    public static void writeRequest(OutputStream outputStream,Request request) throws IOException {
        outputStream.write(request.getEncode());
        outputStream.write(ByteUtil.int2Byte(request.getCommandLength()));
        if(request.getEncode()==HttpEncode.UTF8.getValue()){
            outputStream.write(request.getCommand().getBytes("utf8"));
        }else{
            outputStream.write(request.getCommand().getBytes("gbk"));
        }
    }
    public static Response readResponse(InputStream inputStream) throws IOException, ClassNotFoundException {
        byte [] encodeBytes = new byte[1];
        inputStream.read(encodeBytes);
        byte encodeByte = encodeBytes[0];
        byte [] commandLengthByte = new byte[4];
        inputStream.read(commandLengthByte);
        int lenght = ByteUtil.byte2Int(commandLengthByte);
        byte [] commandByte = new byte[lenght];
        inputStream.read(commandByte);
        String command = "";
        if(HttpEncode.UTF8.getValue()==encodeByte){
            command = new String(commandByte,"utf8");
        }else{
            command = new String(commandByte,"gbk");
        }
        Response response = new Response();
        response.setEncode(encodeByte);
        response.setResponseLength(lenght);
        response.setResponse(command);
        return response;
    }

    public static Request readRequest(InputStream inputstream) throws IOException, ClassNotFoundException {
        byte [] encodeBytes = new byte[1];
        inputstream.read(encodeBytes);
        byte encodeByte = encodeBytes[0];
        byte [] commandLengthByte = new byte[4];
        inputstream.read(commandLengthByte);
        int lenght = ByteUtil.byte2Int(commandLengthByte);
        byte [] commandByte = new byte[lenght];
        inputstream.read(commandByte);
        String command = "";
        if(HttpEncode.UTF8.getValue()==encodeByte){
            command = new String(commandByte,"utf8");
        }else{
            command = new String(commandByte,"gbk");
        }
        Request request = new Request();
        request.setEncode(encodeByte);
        request.setCommandLength(lenght);
        request.setCommand(command);
        return request;
    }

    public static void writeResponse(OutputStream outputStream,Response response) throws IOException {
        outputStream.write(response.getEncode());
        outputStream.write(ByteUtil.int2Byte(response.getResponseLength()));
        if(response.getEncode()==HttpEncode.UTF8.getValue()){
            outputStream.write(response.getResponse().getBytes("utf8"));
        }else{
            outputStream.write(response.getResponse().getBytes("gbk"));
        }
    }
}
