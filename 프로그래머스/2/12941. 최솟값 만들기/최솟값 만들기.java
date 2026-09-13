import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A); // 오름차순 정렬
        Arrays.sort(B); // 오름차순 정렬하고 뒤에서부터 쓰기
        
        for(int i = 0; i < A.length; i++) {
            answer += A[i] * B[B.length - (i + 1)];
        }

        return answer;
    }
}