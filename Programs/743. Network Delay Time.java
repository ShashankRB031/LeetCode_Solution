class Solution {
    static class Edge {
        int src, dest, wt;
        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    static class Pair implements Comparable<Pair> {
        int n, path;
        Pair(int n, int p) {
            this.n = n;
            this.path = p;
        }
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] time : times) {
            int u = time[0] - 1;
            int v = time[1] - 1;
            int w = time[2];
            graph[u].add(new Edge(u, v, w));
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(k - 1, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.n;
            int d = curr.path;

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int wt = e.wt;
                if (dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        int res = 0;
        for (int t : dist) {
            if (t == Integer.MAX_VALUE) return -1;
            res = Math.max(res, t);
        }

        return res;
    }
}