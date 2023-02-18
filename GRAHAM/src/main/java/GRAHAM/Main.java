
package GRAHAM;
import GRAHAM.Lista.Node;
import java.util.*;

public class Main {
static int rezDeterminant(int xa,int ya,int xb,int yb,int xm,int ym){
    
    int det;
    det= (xa*ym*1+1*xm*yb+ya*1*xb)-(1*ym*xb+1*yb*xa+1*xm*ya);
    return det;
    
    
    }


    public static void main(String[] args) {
       int i;
       
       
       Punct vm;
       Lista lista=null;
        ArrayList<Punct> puncte=new ArrayList<Punct>();
        //Adaugarea coordonatelor
        puncte.add(new Punct(4,2));
        puncte.add(new Punct(7,3));
        puncte.add(new Punct(9,5));
        puncte.add(new Punct(7,6));
        puncte.add(new Punct(7,8));
        puncte.add(new Punct(3,7));
        puncte.add(new Punct(4,5));
        puncte.add(new Punct(2,3));
        
        Punct g=new Punct(0,0);
        g.setX((puncte.get(5).x+puncte.get(6).x+puncte.get(7).x)/3);
        g.setY((puncte.get(5).y+puncte.get(6).y+puncte.get(7).y)/3);
        //Centrul de greutate
        for(i=0;i<puncte.size();i++){
            
            
            puncte.get(i).setX(puncte.get(i).getX()-g.getX());
            puncte.get(i).setY(puncte.get(i).getY()-g.getY());
            
            
            
            
        }
        
        g.setX(0);
        g.setY(0);
        //Translatia
        
        int n=puncte.size();
        for(i=0;i<n-1;i++){
         for(int j=0;j<n-i-1;j++){
             if(puncte.get(j+1).getCadran()>puncte.get(j).getCadran()){
                 
                 Punct temp=new Punct(puncte.get(j).getX(),puncte.get(j).getY());
                 puncte.get(j).setX(puncte.get(j+1).getX());
                 puncte.get(j).setY(puncte.get(j+1).getY());
                 puncte.get(j+1).setX(temp.getX());
                 puncte.get(j+1).setY(temp.getY());
                                                 
             }
        
             if(puncte.get(j).getCadran()==puncte.get(j+1).getCadran()){
                 
                 int det=rezDeterminant(puncte.get(j).getX(),puncte.get(j).getY(),0,0,puncte.get(j+1).getX(),puncte.get(j+1).getY());
                 if(det>0){
                     
                 Punct temp=new Punct(puncte.get(j).getX(),puncte.get(j).getY());
                 puncte.get(j).setX(puncte.get(j+1).getX());
                 puncte.get(j).setY(puncte.get(j+1).getY());
                 puncte.get(j+1).setX(temp.getX());
                 puncte.get(j+1).setY(temp.getY());
                     
                     
                     
                 }
                 
                 
                 
             }
        
    } 
    
}
        //Sortarea punctelor dupa translatie
        
        for(i=0;i<n;i++){
            
            lista.addNode(puncte.get(i));
            
        }
        
        //Formarea listei
          
          
          vm=new Punct(puncte.get(0).getX(),puncte.get(0).getY());
          for(i=0;i<n;i++){
              
              if(puncte.get(i).getY()<vm.getY()){
                  vm.setX(puncte.get(i).getX());
                  vm.setY(puncte.get(i).getY());}
              
        
          }
          
          //Punctul de ordonata minima
          
          
          Node temp=lista.head.next;
          Node vmin;
          vmin = new Node();
          vmin.data=vm;
          vmin.next=temp.next;
          vmin.prev=temp.prev;
          while(temp!=lista.head)
          {
              
              if(temp.data.getY()<vmin.data.getY()){
                  
                  vmin.next=temp.next;
                  vmin.prev=temp.prev;
                  
                  
              }
              temp=temp.next;
              
          }
                 
         //Algoritmul Graham
          temp=vmin;
          while(temp!=lista.head)
        {
            
            if(rezDeterminant(temp.data.getX(),temp.data.getY(),temp.next.data.getX(),temp.next.data.getY(),temp.next.next.data.getX(),temp.next.next.data.getY())>=0)
                temp=temp.next;
           
            else{
                
                lista.deleteNode(lista.head,temp.next.data.getX(),temp.next.data.getY());
                if(lista.head!=temp)temp=temp.prev;
            }
        }
          
          lista.printNode();
          
          System.out.println("Acestea sunt punctele care formeaza infasuratoarea");
}
    
}