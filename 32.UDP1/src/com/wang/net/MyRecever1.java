package com.wang.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;

/**
 * 接收端
 *
 */
public class MyRecever1 {
	
	//关闭命令
	public static final String CLOSE_RECEIVER = "bye";

	// 接收端端口
	public static final int PORT = 9000;

	/**
	 * 数据接收端。
	 * 
	 * 只接收一次数据。
	 */
	public void receve1() {

		// 数据缓存
		byte[] buf = new byte[1024];

		// 套接字对象
		DatagramSocket socket = null;
		try {
			// socket
			socket = new DatagramSocket(9000);

			// 数据包
			DatagramPacket packet = new DatagramPacket(buf, buf.length);

			// 接收数据
			System.out.println("接收端：");
			socket.receive(packet);

			// 转化数据，显示数据
			String data = new String(packet.getData(), 0, packet.getLength());
			System.out.println(data);

			// 关闭套接字
			socket.close();

		} catch (Exception e) {
			System.out.println("程序异常！");
			e.printStackTrace();
		} finally {
			// 进一步纠错
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		}
	}

	/**
	 * 循环接收。
	 */
	public void receive2() {
		// 数据
		StringBuilder sb = new StringBuilder();

		// 数据缓存
		byte[] buf = new byte[1024];

		// 循环接收
		// 套接字
		DatagramSocket socket = null;

		try {
			// 构造socket
			socket = new DatagramSocket(PORT);
			// 构造数据包
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			
			while (!socket.isClosed()) {
				// 接收
				socket.receive(packet);
				
				// 拿出数据
				buf = packet.getData();
				String data = new String(buf, 0, packet.getLength());
				
				//关闭命令
				if (data.equals(CLOSE_RECEIVER)) {
					break;
				}
				
				// 拿出发送端口
				int port = packet.getPort();
				// 拿出发送IP
				String addr = packet.getAddress().getHostAddress();
				// 接收时间
				long time = System.currentTimeMillis();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				String t = sdf.format(time);
				//构造显示数据
				sb.append("接收数据---------------------");
				sb.append("接收时间：" + t).append("\n");
				sb.append("数据：" + data).append("\n");
				sb.append("发送端口：" + port).append("\n");
				sb.append("发送地址：" + addr).append("\n");
				//显示
				System.out.println(sb.toString());
			}

			// 关闭socket
			socket.close();
			System.out.println("socket关闭（接收方）");

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (socket != null && !socket.isClosed()) {
				socket.close();
				System.out.println("socket关闭（接收方）");
			}
		}
	}

}
