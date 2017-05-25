package com.problem22;

import com.linknode.LinkedListNode;

/**
 * Created by CHILI_USER on 2017/5/23.
 */
public class FindK {
    //递归
    public LinkedListNode<Integer> findK1(LinkedListNode<Integer> n, int k, IntWrapper iw){
        if (n == null){
            return null;
        }
        LinkedListNode<Integer> n1 = findK1(n.next,k,iw);
        iw.value ++;
        if (iw.value == k){
            return n;
        }else{
            return n1;
        }
    }

    //迭代，两个相隔k的指针
    public LinkedListNode<Integer> findK2(LinkedListNode<Integer> n, int k){
        LinkedListNode<Integer> start = n;
        LinkedListNode<Integer> startK = n;
        for (int i=0;i<k-1;i++){
            if (startK.next != null){
                startK = startK.next;
            }else{
                return null;
            }
        }
        while(startK.next != null){
            start = start.next;
            startK = startK.next;
        }
        return start;
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

        FindK fk = new FindK();
        IntWrapper iw = new IntWrapper();
        System.out.println(fk.findK1(n0,6,iw).data);
        System.out.println(fk.findK2(n0,6).data);
    }
}

class IntWrapper{
    int value = 0;
}
