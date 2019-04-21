package com.wh.demo.io.network.oio;

import java.io.IOException;

public class ServerBoot {
    public static void main(String[] args) throws IOException {
        Server server = new Server(8888);

        server.start();

        System.out.println("server start success");
    }
}
