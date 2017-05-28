package com.problem27;

import com.linknode.LinkedListNode;

import java.util.Stack;

/**
 * Created by Misky on 5/28/2017.
 */
public class PalinDrome {
    //反转比较
    public boolean existPD1(LinkedListNode<Integer> head){
        LinkedListNode<Integer> head2 = copyLink(head);
        head2 = reverseLink(head2);
        LinkedListNode<Integer> p = head2;
        while(p != null){
            System.out.println(p.data);
            p = p.next;
        }
        LinkedListNode<Integer> p1 = head;
        LinkedListNode<Integer> p2 = head2;
        for(int i = 0;i<length(head)/2;i++){
            if (p1.data != p2.data){
                return false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return true;
    }

    //迭代
    public boolean existPD2(LinkedListNode<Integer> head){
        LinkedListNode<Integer> slow = head;
        LinkedListNode<Integer> fast = head;
        Stack<Integer> stack = new Stack<Integer>();
        while (fast != null && fast.next!=null){
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null){//单数
            slow = slow.next;
        }
        while (slow != null){
            if (slow.data != stack.pop()){
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    //递归
    public boolean existPD3(LinkedListNode<Integer> head){
        int length = length(head);
        Result r = pd3Recur(head,length);
        return r.exist;
    }

    public Result pd3Recur(LinkedListNode<Integer> node, int length){
        if (node == null || length == 0){
            return new Result(true,null);
        }
        if (length == 1){
            return new Result(true,node.next);
        }
        if (length == 2){
            return new Result(node.data == node.next.data,node.next.next);
        }
        Result r = pd3Recur(node.next,length - 2);
        if (!r.exist || r.node == null){//result为false
            return r;
        }else{
            return new Result(r.node.data == node.data, r.node.next);
        }
    }

    public int length(LinkedListNode<Integer> head){
        int count = 0;
        LinkedListNode<Integer> p = head;
        while (p != null){
            count ++;
            p = p.next;
        }
        return count;
    }

    public LinkedListNode<Integer> copyLink(LinkedListNode<Integer> head){
        if (head == null) return null;
        LinkedListNode<Integer> newHead = new LinkedListNode<Integer>();
        newHead.data = head.data;
        LinkedListNode<Integer> point = newHead;
        while(head.next != null){
            LinkedListNode<Integer> newnode = new LinkedListNode<Integer>();
            newnode.data = head.next.data;
            newHead.next = newnode;
            newHead = newnode;
            head = head.next;
        }
        return point;
    }

    public LinkedListNode<Integer> reverseLink(LinkedListNode<Integer> node){
        if (node == null) return null;
        if (node.next == null) return node;
        LinkedListNode<Integer> newHead = reverseLink(node.next);
        node.next.next = node;
        node.next = null;
        return newHead;
    }

    public static void main(String [] args){
        LinkedListNode<Integer> n0 = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n2 = new LinkedListNode<Integer>(2);
        LinkedListNode<Integer> n3 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n4 = new LinkedListNode<Integer>(1);
        n0.setNext(n1);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);

        LinkedListNode<Integer> n5 = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> n6 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n7 = new LinkedListNode<Integer>(3);
        LinkedListNode<Integer> n8 = new LinkedListNode<Integer>(1);
        n5.setNext(n6);
        n6.setNext(n7);
        n7.setNext(n8);

        PalinDrome pd = new PalinDrome();
        System.out.println(pd.existPD3(n0));
        System.out.println(pd.existPD3(n5));
    }
}

class Result{
    boolean exist;
    LinkedListNode<Integer> node;
    public Result(boolean e, LinkedListNode<Integer> n){
        exist = e;
        node = n;
    }
}
