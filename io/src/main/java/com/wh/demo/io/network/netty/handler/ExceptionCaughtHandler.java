package com.wh.demo.io.network.netty.handler;

import com.wh.demo.io.network.netty.CustomException.TestException;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ExceptionCaughtHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {

        if (cause instanceof TestException) {
            System.out.println("TestException");
        } else {
            ctx.fireExceptionCaught(cause);
        }
    }
}
