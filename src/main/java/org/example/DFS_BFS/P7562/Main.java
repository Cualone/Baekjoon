package org.example.DFS_BFS.P7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int[] start, end;
    static int[][] move = {{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};
    static Queue<int[]> q;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int len = Integer.parseInt(br.readLine());
            board = new int[len][len];
            visited = new boolean[len][len];
            q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(br.readLine());
            end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            if (start[0] == end[0] && start[1] == end[1]) {
                System.out.println(0);
                continue;
            }
            visited[start[0]][start[1]] = true;
            q.add(new int[]{start[0], start[1], 0});
            System.out.println(bfs());
        }
    }

    static int bfs() {
        while(!q.isEmpty()) {
            int[] point = q.poll();
            int row = point[0], col = point[1], count = point[2];
            for (int i = 0; i < move.length; i++) {
                int nRow = row + move[i][0], nCol = col + move[i][1];
                if (nRow < 0 || nRow >= board.length || nCol < 0 || nCol >= board[0].length) continue;
                if (nRow == end[0] && nCol == end[1]) {
                    return count + 1;
                }
                if (!visited[nRow][nCol]){
                    visited[nRow][nCol] = true;
                    q.add(new int[]{nRow, nCol, count + 1});
                }

            }

        }

        return 0;
    }
}
