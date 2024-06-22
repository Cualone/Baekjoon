package org.example.MATH.P11022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            int n1 = Integer.parseInt(st2.nextToken());
            int n2 = Integer.parseInt(st2.nextToken());
            System.out.printf("Case #%d: %d + %d = %d\n", i+1, n1, n2, n1+n2);
        }
    }
}
