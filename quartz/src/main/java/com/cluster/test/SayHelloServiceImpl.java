package com.cluster.test;

/**
 * author 45208
 * date 2017/6/4
 **/
public class SayHelloServiceImpl implements SayHelloService{

    public String syaHello(String helloArg) {
        if("hello".equals(helloArg)){
            return "hello";
        }else{
            return "bye bye";
        }
    }
}
