package com.hy.think.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/12/19 18:47
 */
@ChannelHandler.Sharable
public class EchoClientHander extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger logger = LoggerFactory.getLogger(EchoClientHander.class);

    public EchoClientHander() {
        super(true);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.copiedBuffer("Netty rocks!",CharsetUtil.UTF_8));
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) {
        if (logger.isInfoEnabled()) {
            logger.info("客户端接收消息 => {}",msg.toString(CharsetUtil.UTF_8));
        }
    }
}
