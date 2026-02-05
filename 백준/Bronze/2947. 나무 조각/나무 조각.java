import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];

        // 5개의 나무조각 숫자 입력
        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
        }

        // 버블 정렬 시작
        while (true) {
            boolean isSorted = true;
            
            // 모든 단계에서 인접한 두 원소를 비교
            for (int i = 0; i < 4; i++) {
                if (arr[i] > arr[i + 1]) {
                    // 위치 교환 (Swap)
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    
                    // 정렬이 한 번이라도 일어났으므로 아직 정렬 중임
                    isSorted = false;
                    
                    // 바뀔 때마다 배열의 현재 상태 출력
                    printArray(arr);
                }
            }

            // 배열이 1, 2, 3, 4, 5 순서가 되면 종료
            if (isSorted) break;
        }
        
        sc.close();
    }

    // 배열 상태를 출력하는 보조 메서드
    public static void printArray(int[] arr) {
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + (i == 4 ? "" : " "));
        }
        System.out.println();
    }
}