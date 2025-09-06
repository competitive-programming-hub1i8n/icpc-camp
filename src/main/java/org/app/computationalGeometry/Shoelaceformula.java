package org.app.computationalGeometry;

import java.util.List;

public class Shoelaceformula {
    public record Point(int x, int y){}
    public static void main(String[] args) {
        Point[] points = new Point[3];

        points[0] = new Point(3, 4);
        points[1] = new Point(5, 11);
        points[2] = new Point(12, 8);


        System.out.println(shoelaceFormula(points));
    }

    public static Double shoelaceFormula(Point[] point){
        double sum = 0;
        int n =  point.length;
        for(int i = 0; i < n; i++){
            int j = (i + 1) % n;
            sum += (point[i].x * point[j].y) - (point[j].x * point[i].y);
        }
        return Math.abs(sum)/2;
    }
}
