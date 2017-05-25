package com.problem25;

import com.linknode.LinkedListNode;

/**
 * Created by CHILI_USER on 2017/5/23.
 */
public class SumLink {
    //个位数在前，反向存储
    public LinkedListNode<Integer> sumReverse(LinkedListNode<Integer> l1,LinkedListNode<Integer> l2,int carry){
        if (l1 == null && l2 == null && carry == 0){//只有这一种情况后面不用加
            return null;
        }
        LinkedListNode<Integer> sum = new LinkedListNode<Integer>();
        int value = 0;
        if (l1 != null){
            value += l1.data;
        }
        if (l2 != null){
            value += l2.data;
        }
        value += carry;

        sum.data = value % 10;
        LinkedListNode<Integer> next = sumReverse(l1 == null ? null : l1.next,
                                                    l2 == null ? null : l2.next,
                                                    value>=10 ? 1 : 0);
        sum.next = next;
        return sum;
    }

    //正向存储
    public LinkedListNode<Integer> sumForward(LinkedListNode<Integer> l1,LinkedListNode<Integer> l2){
        int len1 = length(l1);
        int len2 = length(l2);
        //填0
        if (len1 < len2){
            l1 = padZero(l1,len2-len1);
        }else{
            l2 = padZero(l2,len1-len2);
        }
        //获取下一个位的和以及结果node
        IntWrap sum = sumForwardRec(l1,l2);
        if (sum.carry ==0){
            return sum.node;
        }else{
            LinkedListNode<Integer> n = new LinkedListNode<Integer>(1);
            n.next = sum.node;
            return n;
        }
    }

    public IntWrap sumForwardRec(LinkedListNode<Integer> l1,LinkedListNode<Integer> l2){
        if (l1==null && l2==null){
            IntWrap sum = new IntWrap();
            return sum;
        }
        IntWrap nextSum = sumForwardRec(l1==null?null:l1.next,l2==null?null:l2.next);
        int value = nextSum.carry;
        if (l1!=null){
            value += l1.data;
        }
        if (l2!=null){
            value += l2.data;
        }
        IntWrap sum = new IntWrap();
        if (value>=10){
            sum.carry = 1;
        }
        LinkedListNode<Integer> sumNode = new LinkedListNode<Integer>(value % 10);
        sumNode.next = nextSum.node;
        sum.node = sumNode;
        return sum;
    }

    public int length(LinkedListNode<Integer> head){
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        return size;
    }

    public LinkedListNode<Integer> padZero(LinkedListNode<Integer> head, int n){
        for (int i=0;i<n;i++){
            LinkedListNode<Integer> zero = new LinkedListNode<Integer>(0);
            zero.next = head;
            head = zero;
        }
        return head;
    }

    public static void main(String [] args){
        LinkedListNode<Integer> n0 = new LinkedListNode<Integer>(7);
        LinkedListNode<Integer> n1 = new LinkedListNode<Integer>(1);
        LinkedListNode<Integer> n2 = new LinkedListNode<Integer>(6);
        n0.setNext(n1);
        n1.setNext(n2);

        LinkedListNode<Integer> p0 = new LinkedListNode<Integer>(5);
        LinkedListNode<Integer> p1 = new LinkedListNode<Integer>(9);
        LinkedListNode<Integer> p2 = new LinkedListNode<Integer>(2);
        LinkedListNode<Integer> p3 = new LinkedListNode<Integer>(2);
        p0.setNext(p1);
        p1.setNext(p2);
        p2.setNext(p3);

        SumLink sl = new SumLink();
        LinkedListNode<Integer> sum = sl.sumForward(n0,p0);
        while(sum != null){
            System.out.println(sum.data);
            sum = sum.next;
        }
    }
}

class IntWrap{
    LinkedListNode<Integer> node = null;
    int carry = 0;
}
