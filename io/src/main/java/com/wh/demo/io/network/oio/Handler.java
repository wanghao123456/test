package com.wh.demo.io.network.oio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Handler {

    private Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
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
        try {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            byte[] bytes = new byte[1024];
            for (int length; (length = inputStream.read(bytes)) != -1; ) {
                String msg = new String(bytes, 0, length);
                System.out.println("收到消息：" + msg);
                outputStream.write("hello client".getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("server socket close");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
