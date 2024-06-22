package org.example.Structure.P7785;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<String> inCompany = new HashSet<String>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String situ = st.nextToken();
            if (situ.equals("enter")) {
                inCompany.add(name);
            } else {
                inCompany.remove(name);
            }
        }

        inCompany.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}
