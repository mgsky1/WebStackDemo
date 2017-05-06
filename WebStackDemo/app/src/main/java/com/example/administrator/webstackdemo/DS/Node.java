package com.example.administrator.webstackdemo.DS;

/**
 * Created by Martin Huang on 2017/4/27.
 */

public class Node<T>
{
    private T data;
    private Node next;

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
