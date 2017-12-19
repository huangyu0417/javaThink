package com.hy.think.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * desc:处理服务端
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/11/30 18:22
 */
public class EchoServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(EchoServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        if (logger.isInfoEnabled()) {
            logger.info(ctx.channel().remoteAddress() + "      " + buf.toString(CharsetUtil.UTF_8));
        }
        ctx.writeAndFlush(buf).addListener(ChannelFutureListener.CLOSE);

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final ByteBuf time = ctx.alloc().buffer(4);
        SimpleDateFormat format = (SimpleDateFormat) DateFormat.getInstance();
        format.applyPattern("HH:mm ss");
        String t = format.format(new Date());
        time.writeCharSequence(String.format("现在时间 %s",t),CharsetUtil.UTF_8);
        ctx.writeAndFlush(time);
        
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
