package org.example.DFS_BFS.P13023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer>[] link;
    static boolean[] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        link = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            link[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            link[a].add(b);
            link[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            if (result == 1) break;
            visited[i] = true;
            tracking(i, 1);
            visited[i] = false;
        }

        System.out.println(result);
    }

    static void tracking(int idx, int cnt) {
        if (cnt == 5) {
            result = 1;
            return;
        }

        for (int next : link[idx]) {
            if (!visited[next]) {
                visited[next] = true;
                tracking(next, cnt + 1);
                visited[next] = false;
                if (result == 1) return;
            }
        }
    }
}
