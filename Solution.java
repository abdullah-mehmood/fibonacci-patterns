import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

   public static long finalcount = 0;
   public static long prevcount =0;
   public static long nextcount =0;
   public static long midcount =0;
   
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
              
                
            
                Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                String p = sc.next();
                int l=0,r=0;

                String[] arr = new String[n+1];
                String[] midarr = new String[n+1];
                Arrays.fill(arr, "-1");
               
                
                myFun(n,arr,p);
                System.out.println(finalcount);
                
    
    }
    
    
    public static void resultmidFun(int n, String p, String result,long num){
                
                char[] ch = new char[result.length()];
                for (int i = 0; i < ch.length; i++) {
                    ch[i] = result.charAt(i);
                }
                
                String ps =p;
                char[] pchar = new char[ps.length()];
                for (int i = 0; i < pchar.length; i++) {
                    pchar[i] = ps.charAt(i);
                }
                // int num = 0;
                for (int i = 0; i < ch.length-(ps.length()-1); i++) {
                    boolean flag = false;
                    for (int j = 0; j < pchar.length; j++) {
                        if(ch[i+j] != pchar[j]){
                            flag = false;
                            break;
                        }else{
                            flag = true;
                        }
                        
                    }
                    if(flag){num++;}
                }
                
                midcount = midcount + num;
    }
    public static void resultFun(int n, String p, String result,long num){
                
                char[] ch = new char[result.length()];
                for (int i = 0; i < ch.length; i++) {
                    ch[i] = result.charAt(i);
                }
                
                String ps =p;
                char[] pchar = new char[ps.length()];
                for (int i = 0; i < pchar.length; i++) {
                    pchar[i] = ps.charAt(i);
                }
             
                for (int i = 0; i < ch.length-(ps.length()-1); i++) {
                    boolean flag = false;
                    for (int j = 0; j < pchar.length; j++) {
                        if(ch[i+j] != pchar[j]){
                            flag = false;
                            break;
                        }else{
                            flag = true;
                        }
                        
                    }
                    if(flag){num++;}
                }
           
                finalcount = finalcount + num;
        
    }
    
    
    
    
    public static void myFun(int n, String[] arr, String p){
    
       
        long evenMid = 0;
         long oddMid=0;
        
        for (int i = 0; i <= n; i++) {
                 if(arr[i] == "-1"){
                     if(i == 0){
                    arr[i] = "0";
                     }
                    else if(i == 1){
                    arr[i] = "1";
                    }else{
                        
                       if(i>7){
                       
        
         String evensubString="";
        String oddsubString ="";
        
        if(i==8){
            evensubString = arr[i-1];
            evensubString= evensubString.substring((evensubString.length()-p.length())+1)+evensubString.substring(0, p.length()-1);
            
            arr[i]= arr[i-1]+arr[i-2];
            resultmidFun(n, p, evensubString, 0);
            evenMid = midcount;
            midcount = 0;
        }
       
        if(i==9){
            oddsubString = arr[i-1];
            oddsubString = oddsubString.substring((oddsubString.length()-p.length())+1)+oddsubString.substring(0, p.length()-1);
          
            arr[i]= arr[i-1]+arr[i-2];
            resultmidFun(n, p, oddsubString, 0);
            oddMid = midcount;
        }
                        
                        long mergeMid = 0;
                         if(i%2==0){
                            mergeMid = evenMid; 
                           

                         }else{
                             mergeMid = oddMid; 
                            
                         }
                         long temp1 = 0;
                        long temp2 =0;
                     
                        temp1 = nextcount;
                        temp2 = prevcount;
                    
                        finalcount = temp1+temp2+mergeMid;
                        prevcount = nextcount;
                        nextcount = finalcount;
                       
                       }else{
                        
                           arr[i] = arr[i-1]+arr[i-2];
                          
                           finalcount=0;   
                           resultFun(n, p, arr[i], 0);
                          
                            if(i ==6){
                            prevcount = finalcount;
                            
                            }
                            if(i ==7){
                            nextcount = finalcount;
                           
                           }
                       } 
                    
                    }
                 }
        }
                   
      
    }
}
