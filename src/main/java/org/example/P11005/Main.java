package org.example.P11005;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        br.close();

        while (n > 0) {
            int input = n % b;
            if (input >= 10) {
                sb.append((char) (input + 'A' - 10));
            } else {
                sb.append(input);
            }
            n /= b;
        }
        System.out.println(sb.reverse());


    }
}
