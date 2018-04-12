package com.hy.think.script;

import com.google.common.collect.Maps;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyCodeSource;
import groovy.lang.GroovyObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

/**
 * desc:
 *
 * @author hy
 * @version 1.0
 * @Created on 2018/3/23 20:50
 */
public class ScripRunner {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, IOException {
        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
        URL resource = ScripRunner.class.getClassLoader().getResource("Test.groovy");
        Class groovyClass = groovyClassLoader.parseClass(new GroovyCodeSource(resource));
        GroovyObject object = (GroovyObject) groovyClass.newInstance();
        Map<String,String> param = Maps.newHashMap();
        param.put("aaaa","AAAA");
        param.put("bbbb","BBBB");
        object.invokeMethod("a",param);

        long begin = System.currentTimeMillis();
        param.put("cccc","CCCC");
        param.put("dddd","DDDD");
        object.invokeMethod("a",param);
        System.out.println("本段运行时间： " + (System.currentTimeMillis() - begin));

    }
}
