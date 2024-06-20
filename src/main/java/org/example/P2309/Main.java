package org.example.P2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] dwarf = new int[9];
        int height = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(br.readLine());
            height += dwarf[i];
        }
        Arrays.sort(dwarf);
        int notDwarf1 = 0;
        int notDwarf2 = 0;
        boolean check = false;

        for (int i = 0; i < dwarf.length; i++) {
            for (int j = i + 1; j < dwarf.length; j++) {
                if (height - (dwarf[i] + dwarf[j]) == 100) {
                    notDwarf1 = i;
                    notDwarf2 = j;
                    check = true;
                    break;
                }
            }
            if(check) break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dwarf.length; i++) {
            if (i != notDwarf1 && i != notDwarf2) {
                sb.append(dwarf[i]).append("\n");
            }
        }

        System.out.println(sb);
    }
}
