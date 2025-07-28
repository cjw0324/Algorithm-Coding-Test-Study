import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int time = 0;
        int jobIndex = 0;
        int answer = 0;
        int count = 0;
        
        while(true) {
            for (int i = jobIndex; i<jobs.length; i++) {
                if (jobs[i][0] <= time) {
                    pq.offer(new Job(jobs[i][0], jobs[i][1]));
                    jobIndex = i + 1;
                    System.out.print("jobIndex : ");
                    System.out.println(jobIndex);
                }
            }
            
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                count++;
                System.out.print("job : ");
                System.out.println(job.start +", "+ job.length);
                time += job.length;
                System.out.print("time : ");
                System.out.println(time);
                answer += (time - job.start);
            } else {
                time++;
            }
            if (count == jobs.length) break;
        }
        System.out.print("answer : ");
        System.out.println(answer);
        
        return answer / jobs.length;
    }
    
    public class Job implements Comparable<Job> {
        int start;
        int length;
        public Job (int s, int l) {
            this.start = s;
            this.length = l;
        }
        @Override
        public int compareTo(Job j) {
            if (this.length == j.length) return this.start - j.start;
            else return this.length - j.length;
        }
    }
}