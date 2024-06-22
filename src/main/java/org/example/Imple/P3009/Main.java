package org.example.Imple.P3009;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] loc1 = br.readLine().split(" ");
        String[] loc2 = br.readLine().split(" ");
        String[] loc3 = br.readLine().split(" ");

        String[] loc = new String[2];

        for (int i = 0; i < 2; i++) {
            if (loc1[i].equals(loc2[i])) {
                loc[i] = loc3[i];
            } else if (loc1[i].equals(loc3[i])) {
                loc[i] = loc2[i];
            } else {
                loc[i] = loc1[i];
            }
        }

        System.out.println(loc[0] + " " + loc[1]);



    }
}
