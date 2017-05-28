package com.problem26;

import com.linknode.LinkedListNode;

/**
 * Created by Misky on 5/28/2017.
 */
public class CircleStart {
    public LinkedListNode<Integer> findCircleStart(LinkedListNode<Integer> head){
        LinkedListNode<Integer> fast = head;
        LinkedListNode<Integer> slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
        if (fast == null || fast.next == null){//没有环
            return null;
        }

        fast = head;
        while(fast != slow && fast.next!= null && slow.next!= null){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
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
        n7.setNext(n1);

        CircleStart cs = new CircleStart();
        System.out.println(cs.findCircleStart(n0).data);
    }

}
