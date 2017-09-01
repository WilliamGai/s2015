package java8_5_cuncurrent;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class TestFibonaci {
	public static Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) {
		System.out.println(fibonacci(5));
	}
	static int fibonacci(int i){
		if(i==0){
			return i;
		}
		if(i==1){
			return 1;
		}
		return map.computeIfAbsent(i, k->{
				System.out.println(i);
				return fibonacci(i-2)+fibonacci(i-1);});
	}
	
	  // 递归实现方式  
    public static int fibonacci2(int n){  
        if(n <= 2){  
            return 1;  
        }else{  
            return fibonacci2(n-1) + fibonacci2(n-2);  
        }  
    }  
      
    // 递推实现方式  
    public static int fibonacciNormal(int n){  
        if(n <= 2){  
            return 1;  
        }  
        Integer ii;
        Boolean boo;
        int n1 = 1, n2 = 1, sn = 0;  
        for(int i = 0; i < n - 2; i ++){  
            sn = n1 + n2;  
            n1 = n2;  
            n2 = sn;  
        }  
        return sn;  
    }  
}
