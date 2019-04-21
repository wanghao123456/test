package com.wh.demo.io.network.netty;

import com.wh.demo.io.network.netty.handler.AuthHandler;
import com.wh.demo.io.network.netty.handler.ByteToIntegerDecoderA;
import com.wh.demo.io.network.netty.handler.ByteToIntegerDecoderB;
import com.wh.demo.io.network.netty.handler.ExceptionCaughtHandler;
import com.wh.demo.io.network.netty.handler.ExceptionInBoundHandlerA;
import com.wh.demo.io.network.netty.handler.ExceptionInBoundHandlerB;
import com.wh.demo.io.network.netty.handler.ExceptionInBoundHandlerC;
import com.wh.demo.io.network.netty.handler.ExceptionOutBoundHandlerA;
import com.wh.demo.io.network.netty.handler.ExceptionOutBoundHandlerB;
import com.wh.demo.io.network.netty.handler.ExceptionOutBoundHandlerC;
import com.wh.demo.io.network.netty.handler.InBoundHandlerA;
import com.wh.demo.io.network.netty.handler.InBoundHandlerB;
import com.wh.demo.io.network.netty.handler.InBoundHandlerC;
import com.wh.demo.io.network.netty.handler.IntegerToByteEncoder;
import com.wh.demo.io.network.netty.handler.OutBoundHandlerA;
import com.wh.demo.io.network.netty.handler.OutBoundHandlerB;
import com.wh.demo.io.network.netty.handler.OutBoundHandlerC;
import com.wh.demo.io.network.netty.handler.ServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.AttributeKey;

public class Server {


    private void start() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);


        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childAttr(AttributeKey.newInstance("childAttr"), "childAttrValue")
                .handler(new ServerHandler())
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel socketChannel) {
                        socketChannel.pipeline().addLast(
                                new ByteToIntegerDecoderA(),
                                new ByteToIntegerDecoderB(),

                                new AuthHandler(),
                                new InBoundHandlerA(),
                                new InBoundHandlerB(),
                                new InBoundHandlerC(),

                                new OutBoundHandlerA(),
                                new OutBoundHandlerB(),
                                new OutBoundHandlerC(),

                                new IntegerToByteEncoder(),

                                new ExceptionCaughtHandler(),
                                new ExceptionInBoundHandlerA(),
                                new ExceptionInBoundHandlerB(),
                                new ExceptionInBoundHandlerC(),
                                new ExceptionOutBoundHandlerA(),
                                new ExceptionOutBoundHandlerB(),
                                new ExceptionOutBoundHandlerC());
                    }
                });

        try {
            ChannelFuture future = serverBootstrap.bind(8888).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }


}
