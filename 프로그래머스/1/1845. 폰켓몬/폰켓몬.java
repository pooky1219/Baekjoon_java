import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> pokemons = new HashMap<>();
        // 포켓몬 입력
        for(int pokemon : nums) {
            int num = pokemons.getOrDefault(pokemon, 0);
            pokemons.put(pokemon, num + 1);
        }
        
        int answer = Math.min(pokemons.size(), nums.length / 2);
            
        return answer;
    }
}