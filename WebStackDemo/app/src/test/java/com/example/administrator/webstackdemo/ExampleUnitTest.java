package com.example.administrator.webstackdemo;

import com.example.administrator.webstackdemo.DS.LinkedList;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testLinkedList()
    {
        LinkedList<String> linkedList = new LinkedList<String>();
        linkedList.insert("面包");
        linkedList.insert("小远");
        linkedList.insert("明明");
        linkedList.insert("航航");
        linkedList.delete(2);
        System.out.println(linkedList.getElement(2));
    }
}