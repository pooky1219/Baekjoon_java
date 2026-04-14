import java.util.*;

class Solution {
    static class Num implements Comparable<Num>{
        int num;
        Num(int num){
            this.num = num;
        }
        
        // numbers 정렬
        @Override
        public int compareTo(Num o){
            int num1 = Integer.parseInt( (this.num + "") + (o.num + "") );
            int num2 = Integer.parseInt( (o.num + "") + (this.num + "") );
            
            return num2 - num1;
        }
    }
    public String solution(int[] numbers) {
        String answer = "";
        
        // 수 입력
        List<Num> list = new ArrayList<>();
        for(int i = 0; i < numbers.length; i++) {
            list.add(new Num(numbers[i]));
        }
        
        // 정렬
        Collections.sort(list);
        
        // answer에 입력
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i).num;
            // 첫 번째가 0이면 0넣고 종료
            if(i == 0 && num == 0) {
                answer += (num + "");
                break;
            }
            answer += (list.get(i).num + "");
        }
        
        return answer;
    }
}