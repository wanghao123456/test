package com.wh.demo.io.network.oio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void start() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doStart();
            }
        }).start();
    }

    private void doStart() {
        for (; ; ) {
            try {
                Socket socket = serverSocket.accept();
                socket.setTcpNoDelay(true);
                new Handler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
