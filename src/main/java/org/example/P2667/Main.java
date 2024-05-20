package org.example.P2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

    static int[][] map = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int cnt = 0;
    static int N;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> aptCount = new ArrayList<>();

    static class Apt {
        int x, y;
        Apt(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        Collections.sort(aptCount);
        System.out.println(cnt);
        for (int count : aptCount) {
            System.out.println(count);
        }

    }

    static void dfs(int i, int j) {
        Stack<Apt> stack = new Stack<>();
        stack.push(new Apt(i, j));
        int count = 0;

        while (!stack.isEmpty()) {
            Apt apt = stack.pop();
            if (visited[apt.x][apt.y]) continue;

            visited[apt.x][apt.y] = true;
            map[apt.x][apt.y] = cnt;
            count++;
            for (int k = 0; k < 4; k++) {
                int nx = apt.x + cross[k][0], ny = apt.y + cross[k][1];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 0) continue;
                stack.push(new Apt(nx, ny));
            }
        }
        aptCount.add(count);
    }
}
