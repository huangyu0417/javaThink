package com.hy.think.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
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
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(DiscardServerHandler.class);

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf) msg;
        try {
            if (logger.isInfoEnabled()) {
                logger.info(buf.toString(CharsetUtil.US_ASCII));
            }
        } finally {
            ReferenceCountUtil.release(buf);
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        final ByteBuf time = ctx.alloc().buffer(4);
        SimpleDateFormat format = (SimpleDateFormat) DateFormat.getInstance();
        format.applyPattern("HHmmss");
        int t = Integer.valueOf(format.format(new Date()));
        time.writeInt(t);
        
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
