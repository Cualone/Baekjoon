package org.example.Imple.P25206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double score = 0;
        double cnt = 0;
        for (int i=0;i<20;i++) {
            String[] str = br.readLine().split(" ");
            if(str[2].equals("P")) {
                continue;
            } else if (str[2].equals("A+")){
                score += 4.5*Double.parseDouble(str[1]);
            } else if (str[2].equals("A0")){
                score += 4.0*Double.parseDouble(str[1]);
            } else if (str[2].equals("B+")){
                score += 3.5*Double.parseDouble(str[1]);
            } else if (str[2].equals("B0")){
                score += 3.0*Double.parseDouble(str[1]);
            } else if (str[2].equals("C+")){
                score += 2.5*Double.parseDouble(str[1]);
            } else if (str[2].equals("C0")){
                score += 2.0*Double.parseDouble(str[1]);
            } else if (str[2].equals("D+")){
                score += 1.5*Double.parseDouble(str[1]);
            } else if (str[2].equals("D0")){
                score += 1.0*Double.parseDouble(str[1]);
            } else if (str[2].equals("F")){
                score += 0;
            }
            cnt += Double.parseDouble(str[1]);


        }
        System.out.println(score/cnt);

    }
}
