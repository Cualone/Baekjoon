package org.example.P11399;


import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int people = sc.nextInt();

        int[] time = new int[people];

        for(int i = 0; i < people; i++) {
            time[i] = sc.nextInt();
        }

        Arrays.sort(time);

        int prev = 0;
        int sum = 0;

        for(int i = 0; i < people; i++) {

            sum += prev + time[i];

            prev += time[i];
        }
        System.out.println(sum);
    }
}