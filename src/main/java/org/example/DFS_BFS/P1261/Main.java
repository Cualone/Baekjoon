package org.example.DFS_BFS.P1261;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[][] cross = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로
        M = Integer.parseInt(st.nextToken());
        // 세로
        N = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        visited = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs();

    }

    static class Node implements Comparable<Node>{
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return count - o.count;
        }
    }

    static void bfs() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        visited[0][0] = true;
        q.offer(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.col == M - 1 && cur.row == N - 1) {
                System.out.println(cur.count);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nRow = cur.row + cross[i][0];
                int nCol = cur.col + cross[i][1];
                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue;
                if (!visited[nRow][nCol]) {
                    visited[nRow][nCol] = true;
                    if (maze[nRow][nCol] == 1) {
                        q.add(new Node(nRow, nCol, cur.count + 1));
                    } else {
                        q.add(new Node(nRow, nCol, cur.count));
                    }
                }
            }
        }
    }
}