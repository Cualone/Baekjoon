package org.example.P25501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static String recursion(String s, int l, int r, int cnt){
        cnt++;
        if(l >= r) return 1 + " " + cnt;
        else if(s.charAt(l) != s.charAt(r)) return 0 + " " + cnt;
        else return recursion(s, l+1, r-1, cnt);
    }
    public static String isPalindrome(String s){
        return recursion(s, 0, s.length()-1, 0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String S = br.readLine();
            st.append(isPalindrome(S)).append("\n");
        }

        System.out.println(st);

    }
}