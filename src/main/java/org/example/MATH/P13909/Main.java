package org.example.MATH.P13909;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = N;

        for( int i = 2; i <= N; i++ ){
            boolean isOpen = true;
            boolean isPrime = true;
            for( int j = 2; j <= i; j++){

                if( i % j == 0 ){
                    isOpen = !isOpen;
                    isPrime = false;
                }
                else if( j*j >= i && isPrime) {
                    isOpen = false;
                    break;
                }

            }
            if( !isOpen )
                count--;

        }
        System.out.println(count);
    }
}