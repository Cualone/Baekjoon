package org.example.BruteForce.P7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        String[] spec;
        for(int i = 0; i < N; i++) {
            spec = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(spec[0]);  //키
            arr[i][1] = Integer.parseInt(spec[1]);  //몸무게
        }


        for(int i = 0; i < N; i++) {
            int rank = 1;

            for(int j = 0; j < N; j++) {
                //자기 자신은 제외
                if(i == j) continue;
                //키와 몸무게가 둘 다 높은 사람이 있으면 등수++
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }

            System.out.print(rank + " ");
        }

    }
}