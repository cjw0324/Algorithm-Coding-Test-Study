class Solution {
    public int solution(int chicken) {
    
        int ticket = chicken % 10;
        int order = chicken / 10;
        int answer = order;
        
        while (true) {
            int nextTicket = ticket + order;
            order = nextTicket / 10;
            ticket = nextTicket % 10;
            answer += order;
            
            if ((order + ticket) / 10 == 0) break;
        }
        
        return answer;
    }
}