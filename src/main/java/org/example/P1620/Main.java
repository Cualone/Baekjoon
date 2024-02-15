package org.example.P1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, String> numDogam = new HashMap<Integer, String>();
        HashMap<String, Integer> nameDogam = new HashMap<String, Integer>();


        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            numDogam.put(i, name);
            nameDogam.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String find = br.readLine();
            if (isNum(find)) {
                sb.append(numDogam.get(Integer.parseInt(find))).append("\n");
            } else {
                sb.append(nameDogam.get(find)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static boolean isNum(String poketmon) {
        try {
            Integer.parseInt(poketmon);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
