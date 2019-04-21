package com.wh.demo.io.network.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;

public class ExceptionOutBoundHandlerB extends ChannelOutboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("ExceptionOutBoundHandlerB");
        ctx.fireExceptionCaught(cause);
    }
}
