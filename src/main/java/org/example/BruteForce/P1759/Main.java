package org.example.BruteForce.P1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int L, C;
    static char[] input;
    static char[] pwd;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new char[C];
        pwd = new char[L];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(input);
        solve(0,0);

        System.out.println(sb);

    }

    static void solve(int start, int cnt) {
        if (cnt == L) {
            if (check(pwd)) {
                for (char c : pwd) {
                    sb.append(c);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            pwd[cnt] = input[i];
            solve(i + 1, cnt + 1);
        }
    }

    static boolean check(char[] pwd) {
        int j = 0;
        int m = 0;
        for (int i = 0; i < pwd.length; i++) {
            if (pwd[i] == 'a' || pwd[i] == 'e' || pwd[i] == 'i' || pwd[i] == 'o' || pwd[i] == 'u') {
                m++;
            } else {
                j++;
            }
        }
        if (j >= 2 && m >= 1) return true;
        else return false;
    }
}
