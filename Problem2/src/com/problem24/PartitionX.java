package com.problem24;

import com.linknode.LinkedListNode;

/**
 * Created by CHILI_USER on 2017/5/23.
 */
public class PartitionX {
    //插入链表尾端
    public LinkedListNode<Integer> partionX1(LinkedListNode<Integer> node,int x){
        LinkedListNode<Integer> leftStart = null;
        LinkedListNode<Integer> leftEnd = null;
        LinkedListNode<Integer> rightStart = null;
        LinkedListNode<Integer> rightEnd = null;

        if (node == null) return null;
        while (node != null){
            LinkedListNode<Integer> next = node.next;
            node.next = null;
            if (node.data < x){
                //put into left
                if (leftEnd == null){
                    leftStart = node;
                    leftEnd = node;
                }else{
                    leftEnd.next = node;
                    leftEnd = node;
                }
            }else{
                //put into right
                if (rightStart == null){
                    rightStart = node;
                    rightEnd = node;
                }else{
                    if (node.data == x){
                        //加前面
                        node.next = rightStart;
                        rightStart = node;
                    }else{
                        rightEnd.next = node;
                        rightEnd = node;
                    }

                }
            }
            node = next;
        }
        if (leftStart == null){
            return rightStart;
        }else{
            leftEnd.next = rightStart;
            return leftStart;
        }
    }

    //插入链表前部
    public LinkedListNode<Integer> partionX2(LinkedListNode<Integer> node,int x){
        LinkedListNode<Integer> leftStart = null;
        LinkedListNode<Integer> rightStart = null;

        if (node == null) return null;
        while (node != null){
            LinkedListNode<Integer> next = node.next;
            node.next = null;
            if (node.data < x){
                //put into left
                node.next = leftStart;
                leftStart = node;
            }else{
                //put into right
                node.next = rightStart;
                rightStart = node;
            }
            node = next;
        }
        if (leftStart == null){
            return rightStart;
        }else{
            LinkedListNode<Integer> leftEnd = leftStart;
            while (leftEnd.next != null){
                leftEnd = leftEnd.next;
            }
            leftEnd.next = rightStart;
            return leftStart;
        }
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

        PartitionX px = new PartitionX();
        LinkedListNode<Integer> p = px.partionX2(n0,4);
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
