package com.wh.demo.io.network.nio;

public class ServerBoot {

    public static void main(String[] args) {
        Server server = new Server(8888);

        server.start();
    }
}
