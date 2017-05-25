package com.problem23;

import com.linknode.LinkedListNode;

/**
 * Created by CHILI_USER on 2017/5/23.
 */
public class DeleteNode {
    public boolean deleteNode(LinkedListNode<Integer> n){
        if (n==null || n.next == null){
            return false;
        }
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }

    public static void main(String [] args){
        LinkedListNode<Integer> n0 = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n2 = new LinkedListNode<Integer>(2);
        LinkedListNode<Integer> n3 = new LinkedListNode<Integer>(4);
        LinkedListNode<Integer> n4 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n5 = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> n6 = new LinkedListNode<Integer>(5);
        LinkedListNode<Integer> n7 = new LinkedListNode<Integer>(2);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        n5.setNext(n6);
        n6.setNext(n7);

        DeleteNode dn = new DeleteNode();
        dn.deleteNode(n3);
        LinkedListNode<Integer> p = n0;
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
