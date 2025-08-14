package org.app.prenacional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FrancinRumboA_LosYungas {

    static long X[] = new long[1_050_000];
    static long Y[] = new long[1_050_000];

    static void calcSumSubArray(List<Long> a, long x[], int n, int c){
        for (int i = 0; i< (1 << n); i++){
            long sum = 0;
            for (int j=0; j<n; j++){
                if ((i & (1 << j)) != 0){
                    sum += a.get(j + c);
                }
            }
            x[i] = sum;
        }
    }

    static int lowerBound(long a[], long x, int size){
        int l = -1, r = size;
        while (l + 1 < r){
            int m = (l + r) >>> 1;
            if (a[m] >= x)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static Long solution(List<Long> items, int t){
        int n = items.size();
        calcSumSubArray(items, X, n / 2, 0);
        calcSumSubArray(items, Y, n - n / 2, n / 2);

        int sizeX = 1 << (n / 2);
        int sizeY = 1 << (n - n / 2);

        Arrays.sort(Y, 0, sizeY);
        long maxTime = 0;

        for (int i = 0; i < sizeX; i++){
            if(X[i] <= t){
                int p = lowerBound(Y, t - X[i], sizeY);

                if (p == sizeY || Y[p] != (t - X[i]))
                    p--;
                maxTime = Math.max(maxTime, Y[p] + X[i]);
            }
        }

        return maxTime;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]);
        int t = Integer.parseInt(input[1]);
        List<Long> items = Stream.of(br.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .toList();

        System.out.println(solution(items, t));
    }
}

/*
5 17
2 3 5 7 11

40 1000000000
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40
 */