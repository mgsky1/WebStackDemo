package com.example.administrator.webstackdemo.DS;

/**
 * Created by Administrator on 2017/4/27 0027.
 */
public class Stack<T>
{
    LinkedList<T> list;
    int cSize;

    public Stack()
    {
        this.list = new LinkedList<T>();
        cSize = 0;
    }

    public boolean empty()
    {
        return cSize == 0 ? true : false;
    }


    public T pop()
    {
        if(empty()) return null;
        T e = list.delete(1);
        cSize--;
        return e;
    }

    public boolean pull(T element)
    {
        list.insert(element);
        cSize++;
        return true;
    }

    public int getSize()
    {
        return this.cSize;
    }

    public void display()
    {
        list.display();
    }

}
