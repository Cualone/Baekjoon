package org.example.MATH.P9506;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {

            int n = Integer.parseInt(br.readLine());
            int sum = 0;
            if (n == -1)
                break;

            ArrayList<Integer> list = new ArrayList<>();


            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    list.add(i);
                    sum += i;
                }
            }
            sb.append(n);
            if (n == sum) {
                sb.append(" = ");
                for (Integer num : list) {
                    sb.append(num).append(" + ");
                }
                sb.delete(sb.length()-2, sb.length());
            } else {
                sb.append(" is NOT perfect.");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }
}
