package com.problem21;

import com.linknode.*;
import java.util.Hashtable;

/**
 * Created by CHILI_USER on 2017/5/22.
 */
public class RomoveRepeat {
    public void removeRepeat1(LinkedListNode<Integer> n){
        //用散列表
        Hashtable table = new Hashtable();
        LinkedListNode<Integer> pre = n;
        while(n != null){
            if (table.containsKey(n.data)){
                pre.next = n.next;
            }else{
                table.put(n.data,true);
                pre = n;
            }
            n = n.next;
        }
    }

    public void removeRepeat2(LinkedListNode<Integer> n){
        //用指针迭代
        LinkedListNode<Integer> current = n;
        LinkedListNode<Integer> runner;
        while(current != null){
            runner = current;
            while (runner.next != null){
                if (runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else {
                    runner = runner.next;
                }
            }
            current = current.next;
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

        RomoveRepeat rr = new RomoveRepeat();
        rr.removeRepeat2(n0);
        LinkedListNode<Integer> p = n0;
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
    }
}
