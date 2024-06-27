package org.example.DFS_BFS.P13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited = new boolean[100_001];
    static int[] parent = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        sb.append(bfs(N)).append("\n");

        Deque<Integer> stack = new LinkedList<>();
        stack.push(K);
        int index = K;
        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static class Node {
        int index;
        int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }

    static int bfs(int start) {
        Queue<Node> q = new LinkedList<>();
        visited[start] = true;
        q.add(new Node(start, 0));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.index == K) {
                return cur.count;
            }

            int[] nextMove = {cur.index + 1, cur.index - 1, cur.index * 2};
            for (int next : nextMove) {
                if (next >= 0 && next < 100_001 && !visited[next]) {
                    visited[next] = true;
                    parent[next] = cur.index;
                    q.add(new Node(next, cur.count + 1));
                }
            }
        }
        return 0;
    }
}
