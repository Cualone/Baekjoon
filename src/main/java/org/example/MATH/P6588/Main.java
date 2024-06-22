package org.example.MATH.P6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] nums = new boolean[1000001];

        nums[1] = true;
        for (int i = 2; i * i < 1000001; i++) {
            if (!nums[i]) {
                for (int j = i * i; j < 1000001; j += i) {
                    nums[j] = true;
                }
            }
        }

        int n;
        StringBuilder sb = new StringBuilder();
        while ((n = Integer.parseInt(br.readLine())) != 0) {
            boolean flag = false;
            for (int i = 3; i <= n / 2; i++) {
                if (!nums[i] && !nums[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
        }

        System.out.println(sb);

    }
}
