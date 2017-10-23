package com.hy.think.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2017/8/24 18:58
 */
public class SocktServer {
    public static void main(String[] args) throws Exception{
        System.out.println("run");
        ServerSocket serverSocket = new ServerSocket(3221);
        Socket socket1 = serverSocket.accept();
        System.out.println("accept");
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket1.getInputStream()));
        String buf = null;
        while ((buf = reader.readLine()) != null) {
            System.out.println(buf);
            Pattern pattern = Pattern.compile("0888.+==");
            Matcher matcher = pattern.matcher(buf);
            if (matcher.find())
                System.out.println(matcher.group().split("==")[0] + "==");
        }
    }

}

