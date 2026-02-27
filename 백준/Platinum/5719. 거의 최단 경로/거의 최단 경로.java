import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, D;
    static List<Edge>[] graph;
    static List<Integer>[] parents; // 각 노드의 '직전 노드(부모)'를 저장할 리스트
    static boolean[][] isRemoved;   // 간선 삭제 여부를 체크할 2차원 배열
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        // 우선순위 큐 정렬을 위한 기준 (비용 오름차순)
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            // 종료 조건
            if (N == 0 && M == 0) break;

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            // 매 테스트 케이스마다 초기화
            graph = new ArrayList[N];
            parents = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                parents[i] = new ArrayList<>();
            }
            isRemoved = new boolean[N][N]; // 최대 500x500이므로 메모리 충분

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                graph[u].add(new Edge(v, p));
            }

            // 1. 첫 번째 다익스트라: 최단 거리 및 직전 노드(parents) 기록
            dijkstra(true);

            // 2. BFS 역추적: D부터 S까지 거슬러 올라가며 최단 경로 간선 삭제 처리
            removeShortestPaths();

            // 3. 두 번째 다익스트라: 삭제된 간선을 무시하고 거의 최단 경로 탐색
            dijkstra(false);

            // 결과 출력
            if (dist[D] == INF) {
                sb.append("-1\n");
            } else {
                sb.append(dist[D]).append("\n");
            }
        }
        System.out.print(sb);
    }

    // recordParents 플래그를 통해 부모 기록 여부를 제어합니다.
    static void dijkstra(boolean recordParents) {
        dist = new int[N];
        Arrays.fill(dist, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        dist[S] = 0;
        pq.offer(new Edge(S, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            // visited 배열 대신, 현재 꺼낸 거리가 기록된 최단 거리보다 크면 무시 (시간 단축)
            if (dist[curr.to] < curr.cost) continue;

            for (Edge next : graph[curr.to]) {
                // 이미 지워진 간선이라면 무시 (두 번째 다익스트라에서 작동)
                if (isRemoved[curr.to][next.to]) continue;

                int nextCost = curr.cost + next.cost;

                // 더 짧은 경로를 발견한 경우
                if (dist[next.to] > nextCost) {
                    dist[next.to] = nextCost;
                    
                    if (recordParents) {
                        parents[next.to].clear(); // 기존 부모 초기화
                        parents[next.to].add(curr.to); // 새로운 부모 등록
                    }
                    pq.offer(new Edge(next.to, nextCost));
                } 
                // 거리가 같은 또 다른 최단 경로를 발견한 경우
                else if (dist[next.to] == nextCost && recordParents) {
                    parents[next.to].add(curr.to); // 큐에 또 넣지 않고 부모만 추가해 줌
                }
            }
        }
    }

    // 도착점(D)부터 시작해서 부모 노드를 따라가며 간선을 지웁니다.
    static void removeShortestPaths() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(D);
        
        while (!q.isEmpty()) {
            int curr = q.poll();

            // 현재 노드(curr)로 들어왔던 직전 노드(p)들을 확인
            for (int p : parents[curr]) {
                // 중복 방문(무한 루프) 방지를 위해 아직 안 지워진 간선일 때만 큐에 삽입
                if (!isRemoved[p][curr]) {
                    isRemoved[p][curr] = true; // 간선 삭제 마킹
                    q.offer(p);
                }
            }
        }
    }
}