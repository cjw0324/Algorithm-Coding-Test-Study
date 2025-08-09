class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        String[] numbers = s.split(" ");
        
        for (String numberString : numbers) {
            int number = Integer.parseInt(numberString);
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        
        return min+" "+max;
    }
}