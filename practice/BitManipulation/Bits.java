import java.util.Scanner;
public class Bits {

  public static int get(int n, int p){
    int bitMask = 1<<p;
    if((n&bitMask)>0){
      return 1;
    }
    
    return 0;
  }

  public static int clear(int n, int p){
    int bitMask = 1<<p;
    return ~bitMask & n;
  }

  public static int set(int n, int p){
    int bitMask = 1<<p;
    return bitMask | n;
  }

  public static int update(int n, int p, int a){
    if(a==0){
      return clear(n, p);
    }
    return set(n, p);
  }

  public static int toggle(int n, int p){
    int bitMask = 1<<p;
    return n^bitMask;
  }

  public static void powerOf2(int n){
    if((n & (n-1))==0){
      System.out.print("yes");
      return;
    }
    System.out.print("no");
  }

  public static void count1(int n){
    int count=0;
    while(n!=0){
      n=n&n-1;
      count++;
    }
    System.out.print(count);
  }

  public static int d2B(int n){
    // for (int i = 31; i >= 0; i--) { 
    //   int bit = (n >> i) & 1; 
    //   System.out.print(bit); 
    // }

    StringBuilder sb= new StringBuilder();
    while(n!=0){
      int r = n%2;
      n = n/2;
      sb.append(r);
    }
    sb.reverse();
    return Integer.valueOf(sb.toString());
  }

  public static int b2D(String n) {
    int sum = 0;
    int p = 0;
    for(int i = 0;i<n.length();i++){
      sum= sum+ (((int)n.charAt(i)-'0')*(1<<p));
      p++;
    }
    return sum;
  }


   public static void main(String args[]) {
     Scanner sc = new Scanner (System.in);
     int n = sc.nextInt();
     sc.close();
     int b =d2B(n);
     System.out.println("Binary is "+ b);

     int d =b2D(String.valueOf(b));
     System.out.print("Decimal is "+ d);
   }
}

