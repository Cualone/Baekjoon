package org.example.DFS_BFS.P13549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100_001];

        find();

        System.out.println(min);

    }

    static class Node {
        int location;
        int count;

        public Node(int location, int count) {
            this.location = location;
            this.count = count;
        }
    }

    static void find() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.location] = true;
            if (cur.location == K) {
                min = Math.min(min, cur.count);
            }

            if (cur.location * 2 < 100_001 && !visited[cur.location * 2]) {
                q.add(new Node(cur.location * 2, cur.count));
            }

            if (cur.location + 1 < 100_001 && !visited[cur.location + 1]) {
                q.add(new Node(cur.location + 1, cur.count + 1));
            }
            if (cur.location - 1 >= 0 && !visited[cur.location - 1]) {
                q.add(new Node(cur.location - 1, cur.count + 1));
            }
        }
    }
}
