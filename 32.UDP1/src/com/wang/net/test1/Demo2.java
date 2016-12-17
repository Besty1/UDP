package com.wang.net.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * UDP通信。
 * 
 * (1)DatagramPacket
 * 
 * (2)DatagramSocket	
 * 
 */
public class Demo2 {
	
	/**
	 * DatagramPacket类。
	 * 
	 * 数据包类，主要用来包装数据和地址。
	 * 
	 */
	public void test1(){
		//数据
		String data = "hello world";
		//转字节
		byte[] buf = data.getBytes();
		
		// 数据包构造
		DatagramPacket packet = new DatagramPacket(buf, buf.length);
		
		// 把数据装到包中
		// 设置数据 
		packet.setData(buf);
		// 设置数据长度
//		packet.setLength(length);
//		// 设置数据地址
//		packet.setAddress(iaddr);
		// 设置端口
//		packet.setPort(iport);
		
		// 从包中取出数据
		// 取出数据
		packet.getData();
		// 数据长度
		packet.getLength();
		// 数据地址
		packet.getAddress();
		// 端口
		packet.getPort();
		
	}
	
	/**
	 * DatagramSocket类。
	 * 
	 * UDP 套接字。
	 * 
	 */
	public void test2(){
		// 套接字
//		int port = 8888;
		// 套接字对象
//		DatagramSocket socket = new DatagramSocket(port);
		
//		// 发送数据包
//		socket.send(packet);
//		
//		// 接收数据包 
//		socket.receive(packet);
//		
//		// 关闭套接字
//		socket.close();
	}
}












