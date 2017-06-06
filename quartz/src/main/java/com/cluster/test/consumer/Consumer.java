package com.cluster.test.consumer;

import com.cluster.test.SayHelloServiceImpl;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author 45208
 * date 2017/6/4
 **/
public class Consumer {
    public static void main(String [] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, IOException {
        final Consumer c = new Consumer();
        Thread t = new Thread(new Runnable() {
            public void run() {
                try {
                    c.send();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        c.call();
    }
    public void call() throws NoSuchMethodException, IOException, ClassNotFoundException {
        //接口名称
        String interFaceName = SayHelloServiceImpl.class.getName();
        //需要远程执行的方法
        Method method = SayHelloServiceImpl.class.getMethod("syaHello", String.class);
        Object [] arguments = {"sheldon"};
        Socket socket = new Socket("127.0.0.1",1234);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeUTF(interFaceName);
        objectOutputStream.writeUTF(method.getName());
        objectOutputStream.writeObject(method.getParameterTypes());
        objectOutputStream.writeObject(arguments);
        ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
        Object result = inputStream.readObject();
        System.out.println((String)result);
    }

    public void send() throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        ServerSocket serverSocket = new ServerSocket(1234);
        while(true){
            Socket socket = serverSocket.accept();
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            //接口名称
            String interFaceName = inputStream.readUTF();
            //方法名称
            String methodName = inputStream.readUTF();
            //参数类型
            Class<?> [] paramterTypes = (Class<?> [] ) inputStream.readObject();
            //参数值
            Object[] arguments = (Object[])inputStream.readObject();
            Class service = Class.forName(interFaceName);
            Method method = service.getMethod(methodName,paramterTypes);
            Object result = method.invoke(service.newInstance(),arguments);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(result);
        }
    }

}
