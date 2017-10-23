package com.hy.think.net;

import java.io.PrintStream;
import java.net.Socket;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/24 18:30
 */
public class SocktClient {
    public static void main(String[] args) throws Exception{
        String sendMsg = "0052huangyu@erayt.com             192.168.40.59   003221";
        Socket socket = new Socket("192.168.10.129",8007);
            if (socket.isConnected()) {
                System.out.println("connect success!" + sendMsg.length());
                PrintStream out = new PrintStream(socket.getOutputStream());
//                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.print(sendMsg);
                out.flush();
                out.close();
                System.out.println("send end");
            }
    }
}
