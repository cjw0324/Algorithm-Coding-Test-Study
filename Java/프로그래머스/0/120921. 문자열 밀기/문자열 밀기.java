class Solution {
    public int solution(String A, String B) {
        String update = A;
        
        if (A.equals(B)) return 0;
        
        for (int i = 0; i<A.length(); i++) {
            String front = update.substring(0, A.length() - 1);
            String back = update.substring(A.length()-1, A.length());
            update = back + front;
            
            System.out.println("front : " + front);
            System.out.println("back : " + back);
            System.out.println("update : " + update);
            if (update.equals(B)) return i + 1;
        }
        return -1;
    }
}