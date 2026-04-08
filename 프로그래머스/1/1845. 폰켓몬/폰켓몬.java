import java.util.*;
class Solution {
    public int solution(int[] nums) {
        //홍박사님을 아세요? 홍홍홍
        Map<Integer,Integer>map = new HashMap<>();
        for(int n : nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int size = map.size();
        int answer = Math.min(nums.length/2,size);
        return answer;
    }
}