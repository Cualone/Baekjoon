package org.example.P1316;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static boolean check() {
        boolean[] alp = new boolean[26];
        int prev = 0;
        String str = sc.next();

        for (int i=0;i<str.length();i++) {
            int now = str.charAt(i);
            if (prev != now) {
                if (alp[now-'a']==false) {
                    alp[now-'a']=true;
                    prev = now;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int cnt = 0;
        int num = sc.nextInt();

        for (int i=0;i<num;i++) {
            if(check()==true)
                cnt++;
        }
        System.out.println(cnt);
    }

}