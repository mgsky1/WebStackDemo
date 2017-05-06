package com.example.administrator.webstackdemo.DS;

/**
 * Created by Martin Huang on 2017/4/27.
 */

//不带头节点的单链表
public class LinkedList<T>
{
    private Node<T> head;
    private int size;

    public LinkedList()
    {
        this.size = 0;
        head = null;
    }

    //头插法
    public boolean insert(T data)
    {
         Node<T> node = new Node<T>();
         node.setData(data);
        //第一个节点
        if(head == null)
        {
            node.setNext(null);
            head = node;
        }
        else
        {
            //不是第一个节点
            node.setNext(head);
        }
        head = node;
        size++;
        return true;
    }

    //删除链表第i个位置的元素
    public T delete(int position)
    {
        if(position < 1 || head == null)
        {
            return null;
        }

        Node<T> p = head;
        //如果删除的是第一个元素
        if(position == 1)
        {
            T data = p.getData();
            head = p.getNext();
            size--;
            return data;
        }
        for(int i = 1 ; i < position-1 ; i++)
        {
            p = p.getNext();
        }
        T data = (T) p.getNext().getData();
        p.setNext(p.getNext().getNext());
        size--;
        return data;
    }

    //获取某一个位置的元素

    public T getElement(int position)
    {
        if(position < 1 || head == null)
        {
            return null;
        }

        Node<T> p = head;
        for(int i = 1 ; i < position ; i++)
        {
            p = p.getNext();
        }
        return p.getData();
    }

    public  boolean isEmpty()
    {
        return size == 0 ? true : false;
    }

    public void display()
    {
        Node<T> p = head;
        System.out.println("-------");
        while(p != null)
        {
            System.out.println(p.getData());
            p = p.getNext();
        }
        System.out.println("---END----");
        System.out.println();
    }
}
