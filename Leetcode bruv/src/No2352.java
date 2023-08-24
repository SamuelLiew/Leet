import java.util.Arrays;
import java.util.HashMap;

public class No2352 {

    No2352(){

    }
    public void No2352_EqualPairs() {
        int[][] grid = new int[][] {{13, 13},{13, 13}};
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        for (int[] i : grid) {
            if (map.containsKey(Arrays.toString(i))) {
                map.put(Arrays.toString(i), map.get(Arrays.toString(i)) + 1);
            } else {
                map.put(Arrays.toString(i), 1);
            }
        }

        for (int i = 0; i < grid.length; i++) {
            int[] key = new int[grid.length];
            for (int j = 0; j < grid.length; j++) {
                key[j] = grid[j][i];
            }
            if (map.containsKey(Arrays.toString(key))) {
                map.put(Arrays.toString(key), map.get(Arrays.toString(key)) + 1);
            }
        }


        for (int i : map.values()) {
            System.out.println(i);
            if (i == 1) {
                continue;
            }
            if (i == 2) {
                answer++;
            } else if (i > 2) {
                if (i % 2 == 0) {
                    answer += ((i/2) * (i/2) - 1);
                } else {
                    int temp = i - 1;
                    if (temp == 2) {
                        answer++;
                    } else {
                        answer += ((temp/2) * (temp/2) - 1);
                    }
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
