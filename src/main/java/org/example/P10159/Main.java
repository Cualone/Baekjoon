package org.example.P10159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] upGraph;
    static ArrayList<Integer>[] downGraph;
    static boolean[] visited;
    static int N;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        upGraph = new ArrayList[N + 1];
        downGraph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++) {
            upGraph[i] = new ArrayList<>();
            downGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int up = Integer.parseInt(st.nextToken());
            int down = Integer.parseInt(st.nextToken());
            upGraph[down].add(up);
            downGraph[up].add(down);
        }

        for (int i = 1; i <= N; i++) {
            cnt = 0;
            visited = new boolean[N + 1];
            upDfs(i);
            downDfs(i);
            sb.append(N - cnt - 1).append("\n");
        }

        System.out.println(sb);
    }

    static void upDfs(int node) {
        for (int i =0; i < upGraph[node].size(); i++) {
            int next = upGraph[node].get(i);
            if (!visited[next]) {
                visited[next] = true;
                upDfs(next);
                cnt++;
            }
        }
    }

    static void downDfs(int node) {
        for (int i =0; i < downGraph[node].size(); i++) {
            int next = downGraph[node].get(i);
            if (!visited[next]) {
                visited[next] = true;
                downDfs(next);
                cnt++;
            }
        }
    }
}
