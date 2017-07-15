package com.hy.think.thinking.generics;

/**
 * desc: 泛型链表栈
 * @author hy
 * @version 1.0
 * @Created on 2017/6/28 13:35
 */
public class LinkedStack<T> {
    private Node<T> top = new Node<T>();

    public void push(T data) {
        top = new Node<>(top,data);//存入栈的最顶端
    }

    public T pop(){
        T result = top.data;
        if(!top.isEmpty()) {
            top = top.next;
        }
        return result;
//      使用上面写法较好        
//        if (top.isEmpty()) {
//            return null;
//        }else {
//           T result = top.data;
//           top = top.next;
//           return result;
//        }
    }


    class Node<V> {
        Node<V> next = null;
        V data = null;

        Node(){}

        Node(Node<V> next,V data){
            this.data = data;
            this.next = next;
        }

        boolean isEmpty() {
            return this.next == null && this.data == null;
        }

    }
    
    public static void main(String[] args){
        LinkedStack<String> stack = new LinkedStack<>();
        for (String s : "<logger name=\"java.sql\" level=\"INFO\" />".split(" ")) {
            stack.push(s);
        }

        String data = null;
        while ((data = stack.pop()) != null) {
            System.out.println(data);
        }

    }
}
