package org.example.DFS_BFS.P16947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int N;
    static boolean[] isCycle, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        isCycle = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            if (checkCycle(i, i, i)) break;
        }

        int[] result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if(!isCycle[i]) {
                result[i] = bfs(i);
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i] + " ");
        }
    }

    static int bfs(int node) {
        visited = new boolean[N + 1];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(node, 0));
        visited[node] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if(isCycle[cur.v]) {
                return cur.count;
            }

            for (int next : list[cur.v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(new Node(next, cur.count + 1));
                }
            }
        }
        return 0;
    }

    static boolean checkCycle(int start, int prev, int now) {
        isCycle[now] = true;
        for (int next : list[now]) {
            if(!isCycle[next]) {
                if (checkCycle(start, now, next)) {
                    return true;
                }
            } else if (next != prev && next == start) {
                return true;
            }
        }
        isCycle[now] = false;
        return false;
    }

    static class Node {
        int v;
        int count;

        public Node(int v, int count) {
            this.v = v;
            this.count = count;
        }
    }
}
