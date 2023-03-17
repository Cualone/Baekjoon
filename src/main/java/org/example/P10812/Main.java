package org.example.P10812;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt(); //숫자 개수
        int cnt = sc.nextInt(); //반복 횟수

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < num; i++)
            arr.add(i + 1);





        for (int i = 0; i < cnt; i++) {
            int begin = sc.nextInt()-1;
            int end = sc.nextInt()-1;
            int mid = sc.nextInt()-1;
            ArrayList<Integer> add = new ArrayList<>();


            for (int j = begin ; j < mid; j++) {

                add.add(arr.get(j));
            }


            arr.addAll(end+1,add);

            for (int j=0 ; j<mid-begin;j++) {
                arr.remove(begin);
            }

        }
        for (int i=0;i<num;i++) {
            System.out.print(arr.get(i) + " ");
        }

    }
}
