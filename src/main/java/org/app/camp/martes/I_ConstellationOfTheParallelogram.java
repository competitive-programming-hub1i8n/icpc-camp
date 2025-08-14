package org.app.camp.martes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class I_ConstellationOfTheParallelogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points.add(new Point(x, y));
        }
    }


    static int solution(List<Point> points) {
        int answer = 0;

        return answer;
    }


    static private class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
