package com.wh.demo.io.network.oio;

import java.io.IOException;

public class ClientBoot {

    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 8888);

        System.out.println("收到消息：" + client.send("hello server"));

        client.close();
    }
}
