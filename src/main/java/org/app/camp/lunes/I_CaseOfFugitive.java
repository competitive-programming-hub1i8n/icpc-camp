/*package org.app.camp.lunes;

import java.util.*;

public class I_CaseOfFugitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Island> islands = new ArrayList<Island>();
        for (int i = 0; i < n; i++) {
            islands.add(new Island(sc.nextLong(), sc.nextLong()));
        }
        List<BridgeDistance> distances = new ArrayList<BridgeDistance>();
        for (int i = 0; i < m; i++) {
            Long distance = sc.nextLong();
            distances.add(new BridgeDistance(distance, i + 1));
        }
        distances.sort(Comparator.comparingLong(o -> o.value));

        solution(islands, distances, n, m);
    }

    static void solution(List<Island> islands, List<BridgeDistance> distances, int n, int m){
        int[] answer = new int[n-1];
        boolean[] visited = new boolean[m];
        List<DistanceRange> ranges = new ArrayList<>();
        for (int i = 0; i < islands.size()-1; i++) {
            Long minRangeDistance = islands.get(i+1).x - islands.get(i).y;
            Long maxRangeDistance = islands.get(i+1).y - islands.get(i).x;
            DistanceRange rangeDistance = new DistanceRange(minRangeDistance, maxRangeDistance, i);
            ranges.add(rangeDistance);
        }
        ranges.sort(Comparator.comparingLong(o -> o.min));
        int j = 0;
        PriorityQueue<DistanceRange> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            while (j < n - 1 && ranges.get(j).min <= distances.get(i).value) {
                if (ranges.get(j).max >= distances.get(i).value) {
                    pq.add(ranges.get(j));
                }
                j++;
            }

            while (!pq.isEmpty() && pq.peek().max < distances.get(i).value) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                DistanceRange chosen = pq.poll();
                answer[chosen.index] = distances.get(i).index;
                visited[i] = true;
            }
        }
        boolean ok = true;
        for (int x : answer){
            if (x == 0) ok = false;
        }

        if (!ok) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            for (int i = 0; i < n - 1; i++) {
                System.out.print(answer[i] + " ");
            }
        }
    }

    private static class Island {
        Long x;
        Long y;

        public Island(Long x, Long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class DistanceRange implements Comparable<DistanceRange> {

        Long min;
        Long max;
        Integer index;
        public DistanceRange(Long min, Long max, Integer index) {
            this.min = min;
            this.max = max;
            this.index = index;
        }

        @Override
        public int compareTo(DistanceRange o) {
            return Long.compare(this.max, o.max);
        }
    }

    private static class BridgeDistance{
        Long value;
        Integer index;

        public BridgeDistance(Long value, Integer index) {
            this.value = value;
            this.index = index;
        }
    }
}*/

package org.app.camp.lunes;

import java.util.*;

public class I_CaseOfFugitive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextLong();
            y[i] = sc.nextLong();
        }

        long[] bridgeLength = new long[m];
        int[] bridgeIndex = new int[m];
        for (int i = 0; i < m; i++) {
            bridgeLength[i] = sc.nextLong();
            bridgeIndex[i] = i + 1;
        }

        Integer[] bridgeOrder = new Integer[m];
        for (int i = 0; i < m; i++) bridgeOrder[i] = i;
        Arrays.sort(bridgeOrder, Comparator.comparingLong(i -> bridgeLength[i]));

        long[] min = new long[n - 1];
        long[] max = new long[n - 1];
        int[] idx = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            min[i] = x[i + 1] - y[i];
            max[i] = y[i + 1] - x[i];
            idx[i] = i;
        }

        Integer[] rangeOrder = new Integer[n - 1];
        for (int i = 0; i < n - 1; i++) rangeOrder[i] = i;
        Arrays.sort(rangeOrder, Comparator.comparingLong(i -> min[i]));

        int[] answer = new int[n - 1];
        boolean[] visited = new boolean[m];

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingLong(i -> max[i]));

        int j = 0;
        for (int i = 0; i < m; i++) {
            int bridgeIdx = bridgeOrder[i];
            long bridge = bridgeLength[bridgeIdx];

            while (j < n - 1 && min[rangeOrder[j]] <= bridge) {
                int ri = rangeOrder[j];
                if (max[ri] >= bridge) {
                    pq.add(ri);
                }
                j++;
            }

            while (!pq.isEmpty() && max[pq.peek()] < bridge) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                int chosen = pq.poll();
                answer[chosen] = bridgeIndex[bridgeIdx];
                visited[bridgeIdx] = true;
            }
        }

        boolean ok = true;
        for (int val : answer) {
            if (val == 0) {
                ok = false;
                break;
            }
        }

        if (!ok) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            for (int a : answer) {
                System.out.print(a + " ");
            }
        }
    }
}

