
package GRAHAM;
import java.util.*;

public class Lista {
    
    static Node head;
    
    static class Node{
        
        Punct data;
        Node next;
        Node prev;
        
        
        
    };
    
    static void addNode(Punct val){
        
        if(head==null){
            Node new_node=new Node();
            new_node.data=val;
            new_node.next=new_node.prev=new_node;
            head=new_node;
            return;
            
            
        }
        
        Node last=(head).prev;
        
        Node new_node=new Node();
        new_node.data=val;
        
        new_node.next=head;
        (head).prev=new_node;
        new_node.prev=last;
        last.next=new_node;
        
    }
    
    static void printNode(){
        
        Node temp=head;
        while(temp.next!=head){
            
            temp.data.printCoord();
            temp=temp.next;
            
            
        }
        temp.data.printCoord();
        
        
        
    }
    
    static Node deleteNode(Node head,int x,int y)
    {
        
        if (head == null)
            return null;
 
        
        Node curr = head, prev_1 = null;
        while (curr.data.getX()!=x||curr.data.getY()!=y) {
            
            if (curr.next == head) {
                System.out.println("nu e bun");
                return head;
            }
 
            prev_1 = curr;
            curr = curr.next;
        }
 
        
        if (curr.next == head && prev_1 == null) {
            (head) = null;
            return head;
        }
 
        
        if (curr == head) {
            
            prev_1 = (head).prev;
 
            
            head = (head).next;
 
            
            prev_1.next = head;
            (head).prev = prev_1;
        }
 
       
        else if (curr.next == head) {
            
            prev_1.next = head;
            (head).prev = prev_1;
        }
        else {
            
            Node temp = curr.next;
 
            
            prev_1.next = temp;
            temp.prev = prev_1;
        }
        return head;
    }
    
    
}
