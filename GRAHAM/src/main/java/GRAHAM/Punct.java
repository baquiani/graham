
package GRAHAM;


public class Punct {
    
    int x;
    int y;
    
    
    public Punct(int x,int y){
        
        this.x=x;
        this.y=y;
        
        
        
    }
    
    
    public int getX(){
        
        return this.x;
        
        
    }
    
    public int getY(){
        
        return this.y;
        
        
    }
    
    public void setX(int x){
        
        this.x=x;
        
        
    }
    public void setY(int y){
        
        this.y=y;
        
        
    }
    
    public Punct centruG(Punct x,Punct y,Punct z){
        
        Punct g=new Punct(0,0);
        g.setX((x.x+y.x+z.x)/3);
        g.setY((x.y+y.y+z.y)/3);
        
        return g;
        
        
    }
    public void printCoord(){
        
        System.out.println("("+this.x+","+this.y+")");
        
        
    }
    
    public int rezDeterminant(int xa,int ya,int xb,int yb,int xm,int ym){
    
    int det;
    det= (xa*ym*1+1*xm*yb+ya*1*xb)-(1*ym*xb+1*yb*xa+1*xm*ya);
    return det;
    
    
    }
    
    public int getCadran(){
        
        if(x>0&&y>=0)return 1;
        if(x<=0&&y>0)return 2;
        if(x<0&&y<=0)return 3;
        if(x>=0&&y<0)return 4;
        
        
        return 1;
        
    }
    
    
    
}
