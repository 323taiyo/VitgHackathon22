package main.java;

public class PrimeNum{
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        if(n < 2) {
            System.out.println(n + "は素数ではありません。");
        }else if(n == 2) {
            System.out.println(n + "は素数です。");
        }else if(n % 2 == 0){
            System.out.println(n + "は素数ではありません。");
        }else{
            for(int i = 3; i <= Math.sqrt(n); i += 2){
                if(n % i == 0){
                    System.out.println(n + "は素数ではありません。");
                    return;
                }
            }
            System.out.println(n + "は素数です。");
        }
    }
}
