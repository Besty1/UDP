package com.wang.net.test1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * 网络通信中的IP和端口。
 * 
 * IP：标识网络中某台机器。
 * Post：标识某台机器上某个程序。
 * 
 */
public class Demo1 {
	
	/**
	 * InetAddress类。
	 * 
	 * Java中封装IP地址的类。
	 * 
	 */
	public void test1(){
		
		try {
			//本机地址
			InetAddress localAddress = InetAddress.getLocalHost();
			//网络主机地址
			InetAddress remoteAddress = InetAddress.getByName("www.baidu.com");
			
			// 字符串形式IP地址
			String ip1 = localAddress.getHostAddress();
			String ip2 = remoteAddress.getHostAddress();
			System.out.println("local IP:" + ip1);
			System.out.println("remote IP:" + ip2);
			
			//主机名字
			String hostName = remoteAddress.getHostName();
			System.out.println("remote host name:" + hostName);
			
			//是否可达
			boolean localReachable = localAddress.isReachable(3*1000);
			boolean remoteReachable = remoteAddress.isReachable(3*1000);
			
			System.out.println("local reachable:" + localReachable);
			System.out.println("remote reachable:" + remoteReachable);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}












