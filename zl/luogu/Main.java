import java.util.Scanner;

public class Main{

  public static void main(String[] args){
    Scanner scanner =  new Scanner(System.in);
    int x1 = scanner.nextInt();
    int y1 = scanner.nextInt();
    int x2 = scanner.nextInt();
    int y2 = scanner.nextInt();
    int n = scanner.nextInt();
    Item[] dpl = new Item [n+1];
    Item[] dpr = new Item [n+1];
    dpl[0] = new Item(0,0);
    dpr[0] = new Item(0,0);

    for(int i = 1;i<=n;i++){
      int x = scanner.nextInt();
      int y = scanner.nextInt();

      int d1 =(x1-x) *(x1-x) + (y1-y)*(y1-y);
      int d2 = (x2-x)*(x2-x) + (y2-y)*(y2-y);

      int ll = Math.max(d1,dpl[i-1].lr) + dpl[i-1].rr; 
      int rl =Math.max(d1,dpr[i-1].lr) + dpr[i-1].rr;  
      if(ll< rl){
        dpl[i]  = new Item(Math.max(d1,dpl[i-1].lr),dpl[i-1].rr);
      }else{
        dpl[i]  = new Item(Math.max(d1,dpr[i-1].lr),dpr[i-1].rr);
      }
      
      int lr = dpl[i-1].lr + Math.max(d2,dpl[i-1].rr); 
      int rr = dpr[i-1].lr + Math.max(d2,dpr[i-1].rr);  
      if(lr< rr){
        dpr[i]  = new Item(dpl[i-1].lr,Math.max(d2,dpl[i-1].rr));
      }else{
        dpr[i]  = new Item(dpr[i-1].lr,Math.max(d2,dpr[i-1].rr));
      } 
    }
    System.out.println(Math.min(dpl[n].lr+dpl[n].rr,dpr[n].lr+dpr[n].rr));
  }
}

class Item{
  public Item(int l,int r){
    this.lr = l;
    this.rr = r;
  }
  public int lr = 0;
  public int rr = 0;
}