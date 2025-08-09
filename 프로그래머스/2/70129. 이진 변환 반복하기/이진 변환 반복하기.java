class Solution {
    public int[] solution(String s) {
        int change = 0;
        int zero = 0;
        
        String tmp = s;
        
        while(!tmp.equals("1")) {
            change++;
            char[] arr = tmp.toCharArray();    
            tmp = "";
            int count = 0;
            for (char c : arr) {
                if (c == '1') {
                    count++;
                } else {
                    zero++;
                }
            }            
            
            tmp = Integer.toString(count,2);

            System.out.println("change : " + change +", tmp : " + tmp);

            
        }
        return new int[]{change, zero};
        
    }
}