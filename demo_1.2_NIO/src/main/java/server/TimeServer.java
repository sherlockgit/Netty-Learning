package server;

import handle.MultiplexerTimeServer;

import java.io.IOException;

/**
 * NIO服务端
 * author: 小宇宙
 * date: 2018/5/19
 */
public class TimeServer {

    public static void main(String[] args) throws IOException {

        int port = 8080;
        if (args != null && args.length > 0) {

            try {
                port = Integer.valueOf(args[0]);
            } catch (NumberFormatException e) {
                //采用默认值
            }
        }

        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(port);

        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
