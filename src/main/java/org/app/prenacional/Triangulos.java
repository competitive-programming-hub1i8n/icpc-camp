package org.app.prenacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Triangulos {

    static record Point(int x, int y) {}
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] line = bufferedReader.readLine().trim().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);

        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            String[] pointInfo = bufferedReader.readLine().trim().split("\\s+");
            int x = Integer.parseInt(pointInfo[0]);
            int y = Integer.parseInt(pointInfo[1]);
            points[i] = new Point(x, y);
        }

        IntStream.range(0, q).forEach(index -> {
            try {
                String[] queryInfo = bufferedReader.readLine().trim().split("\\s+");
                int li = Integer.parseInt(queryInfo[0]);
                int ri = Integer.parseInt(queryInfo[1]);
                solution(points, li, ri);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });



    }
    static void solution(Point[] points, int li, int ri) {
        System.out.println(Arrays.toString(points));
        System.out.println(li + " " + ri);

    }
}

/*
6 3
1 2
14 7
6 3
8 7
11 10
14 2
0 10
2 22
11 17
 */