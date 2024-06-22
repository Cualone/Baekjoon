package org.example.Recursion.P1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, r, c;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 초기 배열 길이 2^N
        z((int) Math.pow(2, N), 0, 0);
    }

    static void z(int size, int x, int y) {
        if (x == r && y == c) {
            System.out.println(count);
            return;
        }

        if (r < x + size && r >= x && c < y + size && c >= y) {
            // 길이 절반
            size /= 2;
            z(size, x, y);  // 왼쪽 위
            z(size, x, y + size);   // 오른쪽 위
            z(size, x + size, y);   // 왼쪽 아래
            z(size, x + size, y + size);    // 오른쪽 아래
        } else {
            // 지정 위치가 포함되지 않은 칸은 모두 count+
            count += size * size;
        }
    }
}
