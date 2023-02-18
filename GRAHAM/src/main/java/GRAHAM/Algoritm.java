/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GRAHAM;

import GRAHAM.Lista.Node;
import static GRAHAM.Main.rezDeterminant;


public class Algoritm {
    
    Lista lista;
    Node v;
    
    
    
    
    
    
    public Algoritm(Lista l,Node p){
        
        this.lista=l;
        this.v=p;
        
        
        
        
    }
    
    public void Graham(Lista s,Node vm){
        
        Node temp=new Node();
        temp=s.head.next;
       while(temp.next!=s.head);
        {
            
            if(rezDeterminant(temp.data.getX(),temp.data.getY(),temp.next.data.getX(),temp.next.data.getY(),temp.next.next.data.getX(),temp.next.next.data.getY())>=0)
                temp=temp.next;
           
            else{
                
                s.deleteNode(s.head,temp.next.data.getX(),temp.next.data.getY());
                if(s.head!=temp)temp=temp.prev;
            }
        }
            
           //s.printNode();
            
                
        
        
        
        
        
        
        }
        
    
    
    
    
    
}
