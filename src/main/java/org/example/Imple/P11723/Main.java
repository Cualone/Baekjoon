package org.example.Imple.P11723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int S = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int x = 0;
            if (!command.equals("all") && !command.equals("empty")) {
                x = Integer.parseInt(st.nextToken());
            }

            switch (command) {
                case "add":
                    S |= (1 << x);
                    break;
                case "remove":
                    S &= ~(1 << x);
                    break;
                case "check":
                    sb.append((S & (1 << x)) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    S ^= (1 << x);
                    break;
                case "all":
                    S = (1 << 21) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }
        System.out.print(sb.toString());
    }
}