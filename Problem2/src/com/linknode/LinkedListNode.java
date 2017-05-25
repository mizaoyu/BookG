package com.linknode;

/**
 * Created by CHILI_USER on 2017/5/22.
 */
public class LinkedListNode<T> {
    public LinkedListNode<T> next;
    public T data;
    public LinkedListNode(){
    }
    public LinkedListNode(T d){
        data = d;
    }

    public void setNext(LinkedListNode n){
        next = n;
    }
}
