package server;

import handler.TimeServerHandler;
import handler.TimeServerHandlerExecutePool;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 伪异步I/O服务端
 * author: 小宇宙
 * date: 2018/5/18
 */
public class TimeServer {

    public static void main(String[] args) throws IOException{
        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }

        ServerSocket serverSocket = null;
        try {

            serverSocket = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);

            Socket socket = null;
            //创建IO任务线程池
            TimeServerHandlerExecutePool timeServerHandlerExecutePool = new TimeServerHandlerExecutePool(50,10000);

            while (true) {
                socket = serverSocket.accept();
                timeServerHandlerExecutePool.execute(new TimeServerHandler(socket));
            }
        } finally {

            if (serverSocket != null) {
                System.out.println("The time server close");
                serverSocket.close();
                serverSocket = null;
            }
        }
    }
}
