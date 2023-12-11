package org.rice.entity;

public class Linkedlist{
    public Node head;
    public class Node{   //////class is made static so main() program can access it ////// Node structure = data and next node value
        public int data;
        public Node next;

        public Node(int d){   ///////Ig constructor is used in place of getters and setters
            data = d;
            next = null;
        }
        public Node(){}
    }
    public Linkedlist InsertAtEnd(Linkedlist list, int data){

        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
    return list;
    }

    public Linkedlist InsertAtBeg(Linkedlist list, int data){
        Node new_node = new Node(data);
        if(list.head == null){
            list.head = new_node;
        }
        else{
            new_node.next = list.head;
            list.head = new_node;
        }
        return list;
    }

    public Linkedlist InsertatPos(Linkedlist list, int data, int pos){
        Node new_node = new Node(data);
        if(pos==1){
            new_node.next = list.head;
            list.head = new_node;
        }
        else{
            Node tmp = list.head;
            for(int i=0;i<pos && tmp!=null;i++){
                tmp = tmp.next;
            }
            new_node.next = tmp.next;
            tmp.next = new_node;
        }
    return list;
    }

    public Linkedlist deleteNode(int pos, Linkedlist list){
        Node tmp = list.head;
        for(int i=0;i<pos-1;i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
    return list;
    }

    public Linkedlist reverseList(Linkedlist list){
        Node prev=null,curr=list.head,later=null;

        while(curr!=null){
            later = curr.next;
            curr.next = prev;

            prev = curr;
            curr = later;
            // later = curr.next;
            // curr.next = prev;

            // prev = curr;
            // curr = later;
        }
        list.head = prev;
        return list;
    }

    public int lengthList(Linkedlist list){
        int c = 0;
        Node tmp = list.head;
        while(tmp!=null){
            c++;
            tmp = tmp.next;
        }
    return c;
    }


    public void printList(Linkedlist list){
        Node currNode = list.head;
        while(currNode != null){
            System.out.println(currNode.data + "");
            currNode = currNode.next;
        }
    }
}

