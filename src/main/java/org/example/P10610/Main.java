package org.example.P10610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split("");
        Arrays.sort(num, Collections.reverseOrder());
        int sum = 0;
        for(String nums : num) {
            sum += Integer.parseInt(nums);
        }

        if (sum%3==0 && num[num.length-1].equals("0")) {
            for(String nums : num) {
                System.out.print(nums);
            }
        } else {
            System.out.println(-1);
        }

    }

}
