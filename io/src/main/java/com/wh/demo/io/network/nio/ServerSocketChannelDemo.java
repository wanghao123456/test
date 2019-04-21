package com.wh.demo.io.network.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ServerSocketChannelDemo {

    private ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

    public ServerSocketChannelDemo(int port) throws IOException {
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
//        serverSocketChannel.configureBlocking(false);
    }

    public void doStart() throws IOException {
        for (; ; ) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            doWork(socketChannel);
        }
    }

    public void doWork(SocketChannel socketChannel) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (ByteBuffer byteBuffer = ByteBuffer.allocate(1024); socketChannel.read(byteBuffer) != -1; ) {
                        byteBuffer.flip();
                        System.out.println(new String(byteBuffer.array(), "UTF-8"));
                        byteBuffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        ServerSocketChannelDemo serverSocketChannelDemo = new ServerSocketChannelDemo(8888);
        serverSocketChannelDemo.doStart();
    }


}
