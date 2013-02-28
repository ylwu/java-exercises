import java.math.BigInteger;
import java.util.HashMap;


public class Fibonacci {
    
    private static HashMap hm = new HashMap();
    
   

    /**
     * @param args
     */
    
    public static void main(String[] args) {
        Thread thread1 = new Thread(){
            public void run() {
                System.out.println("iter" + fibo(50000)); 
            }
        };
        
        Thread thread2 = new Thread(){
            public void run() {
                System.out.println("recur" + fibo(50000));
            }
        };
        
        thread1.start();
        thread2.start();
        
        
    }
    
    public static int fib(int n){
        if (hm.containsKey(n)){
            return (int) hm.get(n);
        } else {
            if (n == 1) {
                hm.put(1, 1);
                return 1;
            } else if (n == 0){
                hm.put(0, 0);
                return 0;
            } else {
                int result = fib(n-2) + fib(n-1);
                hm.put(n, result);
                return result;
            }
            
        }
    }
    
    public static BigInteger fibo(int n){
        BigInteger prev = new BigInteger("0");
        BigInteger cur = new BigInteger("1");
        BigInteger temp = new BigInteger("0");
        for (int i=2; i<=n; i++){
            temp = cur;
            cur = cur.add(prev);
            prev = temp;
        }
        return cur;
    }

}
