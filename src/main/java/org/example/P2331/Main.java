package org.example.P2331;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            int prev = list.get(list.size() - 1);

            int result = 0;

            //math.pow 함수를 이용해 각 자리 수의 p제곱 값을 더해 result에 저장
            while (prev != 0) {
                result += Math.pow(prev % 10, P);
                prev /= 10;
            }
            //리스트에 값이 존재할 경우 break
            if (list.contains(result)) {
                System.out.println(list.indexOf(result));
                break;
            }

            list.add(result);
        }
        br.close();
    }

}
