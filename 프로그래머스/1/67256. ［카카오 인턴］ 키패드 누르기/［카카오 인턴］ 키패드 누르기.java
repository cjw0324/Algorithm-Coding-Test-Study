class Solution {
    static int[] leftlocation = {0,0};
    static int[] rightlocation = {0,2};
    static String answer = "";
    static String hand;
    public String solution(int[] numbers, String hand) {
        this.hand = hand;
        for (int number : numbers) {
            int x = 0;
            int y = 0;
            if (number == 1 || number == 4 || number == 7) { // 1, 4, 7 선택 -> 왼손
                x = 3 - (number / 3);
                y = 0;
                useLeft(x,y);
            }
            else if (number == 3 || number == 6 || number == 9){ // 3,6,9 선택 -> 오른손
                x = 4 - (number / 3); 
                y = 2;
                useRight(x,y);
            }
            else {  // 2,5,8,0 선택
                x = getX(number);
                y = 1;
                pressMiddleLine(x, y);
            }
            
            // System.out.println("number "+ number+": [" +x+ "," +y+ "]");
            // System.out.println("left : ["+leftlocation[0]+","+leftlocation[1]+"]");
            // System.out.println("right : ["+rightlocation[0]+","+rightlocation[1]+"]");
            // System.out.println("answer : " + answer);
        }
        
        return answer;
    }
    
    public int getX(int number) {
        if (number == 0) return 0;
        return 3 - (number / 3);
    }
    
    public void pressMiddleLine(int x, int y) {
        int leftDistance = Math.abs(leftlocation[0] - x) + Math.abs(leftlocation[1] - y);
        int rightDistance = Math.abs(rightlocation[0] - x) + Math.abs(rightlocation[1] - y);
        if (leftDistance == rightDistance) { // 왼손 오른손 거리가 같을때
            if (hand.equals("left")) { // 왼손잡이인 경우, 왼손 이동
                useLeft(x,y);
            } else {  // 오른손 잡이인 경우, 오른손 이동
                useRight(x,y);
            }
        }
        else {
            if (leftDistance < rightDistance) { //왼손이 가까이 있을 때, 왼손 이동
                useLeft(x,y);
            } else { // 오른손이 가까이 있을 때, 오른손 이동
                useRight(x,y);
            }
        }
    }
    
    public void useLeft(int x, int y) {
        answer += "L";
        leftlocation[0] = x;
        leftlocation[1] = y;
    }
    
    public void useRight(int x, int y) {
        answer += "R";
        rightlocation[0] = x;
        rightlocation[1] = y;
    }
    
}