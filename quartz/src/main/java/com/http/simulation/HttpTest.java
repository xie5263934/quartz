package com.http.simulation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author 45208
 * date 2017/6/4
 **/
public class HttpTest {
    public static void main(String []  args){
        final HttpTest httpTest = new HttpTest();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    httpTest.server();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        try {
            httpTest.client();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void server() throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(14567);
        while(true){
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            Request request = ProtocalUtil.readRequest(inputStream);
            OutputStream outputStream = socket.getOutputStream();
            Response response = new Response();
            response.setEncode(HttpEncode.GBK.getValue());
            if(request.getCommand().equals("hello")){
                response.setResponse("hello");
            }else{
                response.setResponse("bye bye");
            }
            response.setResponseLength(response.getResponse().length());
            ProtocalUtil.writeResponse(outputStream,response);
        }
    }

    public void client() throws IOException, ClassNotFoundException {
        Request request = new Request();
        request.setEncode(HttpEncode.UTF8.getValue());
        request.setCommand("hello");
        request.setCommandLength("hello".length());
        Socket client =  new Socket("127.0.0.1",14567);
        OutputStream outputStream = client.getOutputStream();
        ProtocalUtil.writeRequest(outputStream,request);
        InputStream in = client.getInputStream();
        Response response = ProtocalUtil.readResponse(in);
        System.out.println(response.getEncode()+"-"+response.getResponseLength()+"-"+response.getResponse());
    }
}
