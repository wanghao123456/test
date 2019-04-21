package com.wh.demo.io.network.oio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    private Socket socket;

    private OutputStream outputStream;

    private InputStream inputStream;

    public Client(String host, int port) throws IOException {
        socket = new Socket(host, port);
        outputStream = socket.getOutputStream();
        inputStream = socket.getInputStream();
    }

    public String send(String str) {
        byte[] bytes = new byte[1024];
        int readByteSize;
        try {
            outputStream.write(str.getBytes());
            outputStream.flush();
            if ((readByteSize = inputStream.read(bytes)) != -1) {
                return new String(bytes, 0, readByteSize - 1);
            } else {
                close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            close();
        }
        return "socket close";
    }

    public void close() {
        try {
            socket.close();
            System.out.println("client socket close");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
