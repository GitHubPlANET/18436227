package com.yychatsever.controller;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.yychat.model.User;

public class StartServer {
	ServerSocket ss;
	public StartServer(){
		try {//捕获异常
			ss= new 	ServerSocket(3456);
			System.out.println("服务器已经启动，监听3456端口");
			Socket s=ss.accept();//接受客户端连接请求
			System.out.println("连接成功"+s);
			
			//接收User对象
			ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
			User user =(User)ois.readObject();
			System.out.println(user.getUserName());
			System.out.println(user.getPassWord());
			
		} catch (IOException   e) {
			e.printStackTrace();//处理异常
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
