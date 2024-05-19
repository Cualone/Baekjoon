package org.example.P2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze = new int[101][101];
    static int[][] D = {{-1,0}, {1,0}, {0,-1}, {0,1}};

    static class Point {
        int x, y, disc;

        Point(int x, int y, int disc) {
            this.x =x;
            this.y =y;
            this.disc = disc;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= M; j++) {
                maze[i][j] = line.charAt(j-1) - '0';
            }
        }
        System.out.println(bfs(1, 1, N, M));
    }

    static int bfs(int sRow, int sCol, int dRow, int dCol) {
        boolean[][] visited = new boolean[101][101];
        Queue<Point> q = new LinkedList<>();
        visited[sRow][sCol] = true;
        q.add(new Point(sRow, sCol, 1));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if (curr.x == dRow && curr.y == dCol) {
                return curr.disc;
            }

            for (int i = 0; i < 4; i++) {
                int nr = curr.x + D[i][0], nc = curr.y + D[i][1];
                if (nr < 1 || nc < 1 || nr > 100 || nc > 100) continue;
                if (visited[nr][nc]) continue;
                if (maze[nr][nc] == 0) continue;
                visited[nr][nc] = true;
                q.add(new Point(nr, nc, curr.disc + 1));
            }
        }
        return 0;
    }

}
