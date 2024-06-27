package org.example.DFS_BFS.P1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        System.out.println(bfs(N));
    }

    static int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.index] = true;
            if (cur.index == K) {
                return cur.count;
            }
            int[] next = {cur.index - 1, cur.index + 1, cur.index * 2};
            for (int n : next) {
                if (n >= 0 && n < 100_001 && !visited[n]) {
                    visited[n] = true;
                    q.add(new Node(n, cur.count + 1));
                }
            }
        }
        return 0;
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}
