package com.wh.demo.io.network.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class AuthHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) throws Exception {
        if (check(byteBuf)) {
            channelHandlerContext.pipeline().remove(this);
        } else {
            channelHandlerContext.close();
        }
    }

    private boolean check(ByteBuf byteBuf) {
        return true;
    }
}
