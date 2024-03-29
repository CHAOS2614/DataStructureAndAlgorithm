package cn.edu.bjfu.io;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 客户端
 *
 * @author Lenovo
 */
public class Client {

    public static void main(String[] args) throws Exception {
        //1. 获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        //2. 切换非阻塞模式
        sChannel.configureBlocking(false);
        //3. 分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4. 发送数据给服务端
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.nextLine();
            buf.put((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis())
                    + "\n" + str).getBytes());
            buf.flip();
            sChannel.write(buf);
            System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis()));
            buf.clear();
        }
        //5. 关闭通道
        sChannel.close();
    }

}