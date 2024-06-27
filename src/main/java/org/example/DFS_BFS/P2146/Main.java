package org.example.DFS_BFS.P2146;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int number = 0;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    number++;
                    visited[i][j] = true;
                    map[i][j] = number;
                    dfs(i, j);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 0) {
                    visited = new boolean[N][N];
                    int result = bfs(i, j);
                    if (result == -1) continue;
                    min = Math.min(min, result);
                }
            }
        }
        System.out.println(min);
    }

    static void dfs(int row, int col) {
        for (int k = 0; k < cross.length; k++) {
            int nRow = row + cross[k][0];
            int nCol = col + cross[k][1];
            if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) continue;
            if (map[nRow][nCol] == 0) continue;
            if (!visited[nRow][nCol]) {
                visited[nRow][nCol] = true;
                map[nRow][nCol] = number;
                dfs(nRow, nCol);
            }
        }
    }

    static int bfs(int row, int col) {
        Queue<Node> q = new LinkedList<>();
        int num = map[row][col];
        visited[row][col] = true;
        q.add(new Node(row, col, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curRow = cur.row;
            int curCol = cur.col;
            int cnt = cur.count;



            for (int k = 0; k < cross.length; k++) {
                int nRow = curRow + cross[k][0];
                int nCol = curCol + cross[k][1];
                if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= N) continue;
                if (visited[nRow][nCol] || map[nRow][nCol] == num) continue;
                if (map[nRow][nCol] != 0 && map[nRow][nCol] != num) {
                    return cnt;
                }
                visited[nRow][nCol] = true;
                q.add(new Node(nRow, nCol, cnt+1));
            }
        }
        return -1;
    }

    static class Node {
        int row;
        int col;
        int count;

        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }
}
