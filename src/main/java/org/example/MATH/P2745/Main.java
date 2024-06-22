package org.example.MATH.P2745;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        br.close();

        long result = 0;
        int p = 0;

        for (int i = n.length() - 1; i >= 0; i--) {
            char c = n.charAt(i);
            if (c >= '0' && c <= '9') {
                result += (c - '0') * Math.pow(b, p++);
            } else {
                result += (c - 'A' + 10) * Math.pow(b, p++);
            }
        }

        System.out.println(result);


    }
}
