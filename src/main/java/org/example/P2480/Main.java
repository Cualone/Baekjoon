package org.example.P2480;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(br.readLine(), " ");
        int prize = 0;
        int n1 = Integer.parseInt(str.nextToken());
        int n2 = Integer.parseInt(str.nextToken());
        int n3 = Integer.parseInt(str.nextToken());
        if (n1==n2 && n2==n3) {
            prize = 10000 + n1*1000;
        } else if (n1==n2||n1==n3) {
            prize = 1000 + n1*100;
        } else if (n2==n3) {
            prize = 1000 + n2*100;
        } else {
            int max = Math.max(Math.max(n1, n2), n3);
            prize = max*100;
        }
        System.out.println(prize);

    }
}
