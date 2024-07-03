package org.example.DFS_BFS.P14226;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int S;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        visited = new boolean[S + 1][S + 1];
        bfs();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        visited[1][0] = true;
        q.add(new Node(1, 0, 0));
        while (!q.isEmpty()) {
            Node now = q.poll();
            if (now.emoCnt == S) {
                System.out.println(now.count);
                return;
            }
            if (!visited[now.emoCnt][now.emoCnt]) {
                visited[now.emoCnt][now.emoCnt] = true;
                q.add(new Node(now.emoCnt, now.emoCnt, now.count + 1));
            }
            if (now.clipboard > 0 && now.emoCnt + now.clipboard <= S && !visited[now.emoCnt + now.clipboard][now.clipboard]) {
                visited[now.emoCnt + now.clipboard][now.clipboard] = true;
                q.add(new Node(now.emoCnt + now.clipboard, now.clipboard, now.count + 1));
            }
            if (now.emoCnt > 0 && !visited[now.emoCnt - 1][now.clipboard]) {
                visited[now.emoCnt - 1][now.clipboard] = true;
                q.add(new Node(now.emoCnt - 1, now.clipboard, now.count + 1));
            }
        }

    }

    static class Node {
        int emoCnt;
        int clipboard;
        int count;

        public Node(int emoCnt, int clipboard, int count) {
            this.emoCnt = emoCnt;
            this.clipboard = clipboard;
            this.count = count;
        }
    }
}
