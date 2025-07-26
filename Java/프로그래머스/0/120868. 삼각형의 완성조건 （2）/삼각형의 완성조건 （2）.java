class Solution {
    public int solution(int[] sides) {
        int maxX = sides[0] + sides[1] - 1;
        int normalX = Math.abs(sides[0] - sides[1]) + 1;
        
        int maxCount = maxX - Math.max(sides[0], sides[1]);
        int normalCount = Math.max(sides[0], sides[1]) - normalX + 1;
        
        int total = maxCount + normalCount;
        
        return total;
    }
}