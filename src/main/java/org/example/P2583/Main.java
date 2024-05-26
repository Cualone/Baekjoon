package org.example.P2583;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] board;
    static boolean[][] visited = new boolean[100][100];
    static int[][] cross = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static List<Integer> nums = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        board = new int[M][N];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int leftX = Integer.parseInt(st.nextToken());
            int leftY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            for (int j = leftX; j < rightX; j++) {
                for (int k = leftY; k < rightY; k++) {
                    board[k][j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && (board[i][j] == 0)) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        Collections.sort(nums);
        System.out.println(count);
        for (int i = 0; i < nums.size(); i++) {
            System.out.print(nums.get(i) + " ");
        }
    }

    static void dfs(int i, int j) {
        int cnt = 1;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        visited[i][j] = true;
        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + cross[k][0], ny = cur[1] + cross[k][1];
                if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
                if (visited[nx][ny]) continue;
                if (board[nx][ny] == 1) continue;
                stack.push(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }
        nums.add(cnt);
    }
}
