package org.example.DFS_BFS.P7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] tomato;
    static Queue<int[]> queue = new LinkedList<>();
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        bfs();


        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                } else if (tomato[i][j] != -1) {
                    max = Math.max(max, tomato[i][j]);
                }
            }
        }
        System.out.println(max - 1);
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int row = p[0];
            int col = p[1];

            for (int i = 0; i < 4; i++) {
                int nRow = row + cross[i][0];
                int nCol = col + cross[i][1];
                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                if (tomato[nRow][nCol] == 0) {
                    queue.add(new int[]{nRow, nCol});
                    tomato[nRow][nCol] = tomato[row][col] + 1;
                }
            }
        }
    }
}
