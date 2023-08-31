import java.util.*;

public class Main {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

//        Integer[] height = new Integer[] {1,8,6,2,5,4,8,7,3};
//        System.out.println(Container_11(new Integer[] {1,8,6,2,5,4,8,7,3, 7}));

//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
//        Remove_19(head, 2);

//        Product_238(new Integer[] {1,2,3,4});

//        Jump_55(new Integer[] {2,3,1,1,4});

        K_347(new Integer[] {4,1,-1,2,-1,2,3}, 2);
//        Merge_1768("abc", "pqrjk");
//        Greatest_1071("ABCDEF","ABC");
//        System.out.println(Arrays.toString(Candies_1431(new int[]{2, 3, 5, 1, 3}, 3)));

//        System.out.println(Flowers_605(new int[] {0,1,0}, 2));
//        System.out.println(Reverse_345("Aa"));
//        System.out.println(Reverse_151("the  a good   example  "));
//        System.out.println(Triplet_334(new int[] {20,100,10,12,5,13}));
//        System.out.println(Compression_443(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
//        Move_283(new int[] {4,2,4,0,0,3,0,5,1,0});
//        System.out.println(Subsequence_392("abc", "ahbgdc"));
//        System.out.println(MaxKSum_1679(new int[] {3,1,3,4,3}, 6));
//        System.out.println(AverageSubarray_643(new int[] {-1}, 1));
//        System.out.println(AverageSubarray_643(new int[] {9,7,3,5,6,2,0,8,1,9}, 6));
//        System.out.println(VowelsSubstring_1456("abciiidef", 3));

//        System.out.println(ConsecutiveOnesIII_1004(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, 3));
//        System.out.println(ConsecutiveOnesIII_1004(new int[] {1,1,1,0,0,0,1,1,1,1}, 0));
//        System.out.println(longestSubarray_1493(new int[] {1,1,0,1}, 1));
//        System.out.println(HighestAltitude_1732(new int[] {-5,1,5,0,-7}));
//        System.out.println(PivotIndex_724(new int[] {-1,-1,0,1,1,0}));
//        System.out.println(DifferenceOfTwoArrays(new int[] {1,2,3,3}, new int[] {1,1,2,2}));
//        System.out.println(UniqueOccurrences(new int[] {1,2}));
//        System.out.println(CloseStrings_1657("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff"));
//        System.out.println(EqualPairs_2352(new int[][] {{3,1,2,2},{1,4,4,5},{2,4,2,2},{2,4,2,2}}));
//        System.out.println(EqualPairs_2352(new int[][] {{13, 13},{13, 13}}));
//        System.out.println(EqualPairs_2352(new int[][] {{3,3,3,6,18,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3},{1,1,1,11,19,1,1,1,1,1},{3,3,3,18,19,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3},{3,3,3,1,6,3,3,3,3,3},{3,3,3,3,1,3,3,3,3,3}}));
//        System.out.println(RemoveStars_2390("leet**cod*e"));
//        System.out.println(AsteroidCollision_735(new int[] {-10,10,5, -11}));
//        System.out.println(decodeString_394("10[ab]"));
//        System.out.println(predictPartyVictory("RRDDD"));
        
    }
    
    private static String predictPartyVictory(String senate) {
//        Use a queue to facilitate the order and elimination
//        Everytime a senate comes in, the head senate can decide to ban or not. If the senate bans then the senate will go out.
//        and the senate that was banned will not be included in the queue.
//        The senate that went out will be added to a counter from positive to negative. Positive for R and negative for D
//        RRDDD
//        R D
//        There could be multiple rounds.

        return "";
    }
    
    class RecentCounter { // 933
        private Queue<Integer> queue;
        public RecentCounter() {
            this.queue = new PriorityQueue<>();
        }

        public int ping(int t) {
            if (queue.isEmpty()) {
                this.queue.add(t);
            } else {
                while (!queue.isEmpty() && queue.element() < (t - 3000)) {
                    queue.remove();
                }
                this.queue.add(t);
            }
            
            return queue.size();
        }
    }
    
    private static String decodeString_394(String s) {
//        2[abc]3[cd]ef
//        abcabccdcdcdef
//        3[a2[c]]
//        3[acc]
//        accaccacc
//        Use a stack to keep track of the data specifically for the open and close brackets.
//        Use a for loop that loops through x amount of time where x is the number in front of the open bracket
        Stack<String> stringStack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            stringStack.add(""+s.charAt(i));
            if (stringStack.lastElement().equals("]")) {
                stringStack.pop();
                String temp = "";
                while (!stringStack.lastElement().equals("[")) {
                    temp = stringStack.pop() + temp;
                }
                stringStack.pop();
                String iterationString = "";
                while (true) {
                    if (stringStack.isEmpty()) break;
                    String lastElement = stringStack.pop();
                    try {
                        iterationString = Integer.parseInt(lastElement) + iterationString;
                    } catch (Exception e) {
                        stringStack.add(lastElement);
                        break;
                    }
                }
                int iteration = Integer.parseInt(iterationString);
                while (iteration > 0) {
                    stringStack.add(temp);
                    iteration--;
                }
                
            }
        }
        String answer = "";
        for (String string: stringStack){
            answer += string;
        }
        return answer;
    }
    
    private static int[] AsteroidCollision_735(int[] asteroids) {
//        10,2,-5 => 10
//        -10 10 5 -11 => -10 -11
//        Keep a stack the inserts each of the asteroids and if the last inserted is a positive and the next asteroid is positive
//        then we check which one is bigger and pop if the negative is bigger.
//        We need to continuously pop until the asteroid is either bigger than the next asteroid or until the asteroid is a negative
//        If the asteroids' absolute value is the same while having opposite direction then it cancels out
        Stack<Integer> integerStack = new Stack<>();
        for (int asteroid: asteroids) {
            if (integerStack.isEmpty()) {
                integerStack.add(asteroid);
                continue;
            }
            if (integerStack.lastElement() > 0) {
                if (asteroid > 0) {
                    integerStack.add(asteroid);
                } else {
                    while (integerStack.lastElement() > 0){
                        if (Math.abs(integerStack.lastElement()) > Math.abs(asteroid)) {
                            break;
                        } else if (Math.abs(integerStack.lastElement()) == Math.abs(asteroid)){
                            integerStack.pop();
                            break;
                        } else {
                            integerStack.pop();
                            if (integerStack.isEmpty() || integerStack.lastElement() < 0) {
                                integerStack.add(asteroid);
                            }
                        }
                    }
                }
            } else {
                integerStack.add(asteroid);
            }
        }
        return integerStack.stream().mapToInt(i->i).toArray();    
    }
    private static String RemoveStars_2390(String s) {
//        leet**cod*e => lecoe
//        Keep a stack input one by one from left to right
//        lee t *, if there is a star then pop => repeat
        Stack<Character> characterStack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i != '*'){
                characterStack.add(i);
            } else {
                characterStack.pop();
            }
        }
        String answer = "";
        for (char i : characterStack) answer += i;
        return answer;
    }
    private static int EqualPairs_2352(int[][] grid) {
        // the plan is to have two hashmaps, one that contains the rows and one that contains the columns
        // the logic is that the hashmaps will increment everytime the row or column is encountered
        // At the end we take the value and multiply with each other
        // To create the first hashmap, we will loop through the grid and store the row as the key
        // To create the second hashmap, we will have a nested for loop that will go through the columns and store the values
        // in a temporary int[]
        //        3122
        //        1445
        //        2422
        //        2422
        //        column : row
        //        3122_1 : 3122_1
        //        2422_3 : 2422_3
        //        2422_4 : 2422_3
        
        HashMap<String, Integer> row_map = new HashMap<>();
        HashMap<String, Integer> column_map = new HashMap<>();
        Set<String> all = new HashSet<>();
        for (int row_index = 0; row_index < grid.length; row_index++){
            String temp = "";
            String row = "";
            for (int i : grid[row_index]) {
                temp += i + ",";
            }
            row = temp;
            if (row_map.containsKey(row)){
                row_map.put(row, row_map.get(row) + 1);
            } else {
                row_map.put(row, 1);
                all.add(row);
            }
            String column = "";
            temp = "";
            for (int column_index = 0; column_index < grid[row_index].length; column_index++){
                temp += grid[column_index][row_index] + ",";
            }
            column = temp;
            if (column_map.containsKey(column)){
                column_map.put(column, column_map.get(column) + 1);
            } else {
                column_map.put(column, 1);
                all.add(column);
            }
        }
        int total = 0;
        for (String i : all) {
            if (row_map.containsKey(i) && column_map.containsKey(i)) {
                int loop_total = row_map.get(i) * column_map.get(i);
                total += loop_total;
            }
        }
        return total;
        
        

        
//        int answer = 0;
//        for (int[] i : grid) {
//            if (map.containsKey(Arrays.toString(i))) {
//                map.put(Arrays.toString(i), map.get(Arrays.toString(i)) + 1);
//            } else {
//                map.put(Arrays.toString(i), 1);
//            }
//        }
//
//        for (int i = 0; i < grid.length; i++) {
//            int[] key = new int[grid.length];
//            for (int j = 0; j < grid.length; j++) {
//                key[j] = grid[j][i];
//            }
//            if (map.containsKey(Arrays.toString(key))) {
//                map.put(Arrays.toString(key), map.get(Arrays.toString(key)) + 1);
//            }
//        }
//
//
//        for (int i : map.values()) {
//            System.out.println(i);
//            if (i == 1) {
//                continue;
//            }
//            if (i == 2) {
//                answer++;
//            } else if (i > 2) {
//                if (i % 2 == 0) {
//                    answer += ((i/2) * (i/2) - 1);
//                } else {
//                    int temp = i - 1;
//                    if (temp == 2) {
//                        answer++;
//                    } else {
//                        answer += ((temp/2) * (temp/2) - 1);
//                    }
//                    answer++;
//                }
//            }
//        }
//
//        return answer;
    }

    private static boolean CloseStrings_1657(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char i:word1.toCharArray()) {
            if (map1.containsKey(i)) {
                map1.put(i, map1.get(i) + 1);
            } else {
                map1.put(i, 1);
            }
        }
        for (char i:word2.toCharArray()) {
            if (map2.containsKey(i)) {
                map2.put(i, map2.get(i) + 1);
            } else {
                map2.put(i, 1);
            }
        }
        for (char i: map1.keySet()) {
            if (!map2.containsKey(i)) {
                return false;
            }
        }
        for (char i: map2.keySet()) {
            if (!map2.containsKey(i)) {
                return false;
            }
        }
        List<Integer> list1 = new ArrayList<>(map1.values());
        List<Integer> list2 = new ArrayList<>(map2.values());
        Collections.sort(list1);
        Collections.sort(list2);
        StringBuilder answer1 = new StringBuilder();
        StringBuilder answer2 = new StringBuilder();
        for (int i :list1)  answer1.append(i);
        for (int i :list2)  answer2.append(i);
        return answer1.toString().equals(answer2.toString());
    }

    private static boolean UniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i: arr) {
            if (map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());
        Set<Integer> set = new HashSet<>(map.values());

        return list.size() == set.size();
    }

    private static List<List<Integer>> DifferenceOfTwoArrays(int[] nums1, int[] nums2) {
        List<List<Integer>> list = new ArrayList<>() {{
            add(new ArrayList<>());
            add(new ArrayList<>());
        }};
        HashMap<Integer, Boolean> map1 = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();
        for (int i : nums1) {
            if (!map1.containsKey(i)) {
                map1.put(i, true);
            }
        }
        for (int i : nums2) {
            if (!map2.containsKey(i)) {
                map2.put(i, true);
            }
        }
        for (int i: map1.keySet()) {
            if (!map2.containsKey(i)) {
                if (!list.get(0).contains(i)) {
                    list.get(0).add(i);
                }
            }
        }
        for (int i: map2.keySet()) {
            if (!map1.containsKey(i)) {
                if (!list.get(1).contains(i)) {
                    list.get(1).add(i);
                }
            }
        }

        return list;
    }

    private static int PivotIndex_724(int[] nums) {
        int leftTotal = 0;
        int rightTotal = Arrays.stream(nums).sum() - nums[0];
        int index = 0;
        while (index < nums.length) {
            if (index == 0) {
                if (rightTotal == 0) {
                    return index;
                }
            } else {
                leftTotal += nums[index - 1];
                rightTotal -= nums[index];
                if (leftTotal == rightTotal) {
                    return index;
                }
            }
            index++;
        }
        if (leftTotal == 0 && index == nums.length) {
            return index;
        }
        return -1;
    }

    private static int HighestAltitude_1732(int[] nums) {
        int tracker = 0;
        int max = Integer.MIN_VALUE;
        int[] numsTracker = new int[nums.length + 1];
        numsTracker[0] = tracker;
        for (int i = 0; i < numsTracker.length - 1; i++) {
            tracker += nums[i];
            numsTracker[i+1] += tracker;
        }
        for (int num : numsTracker) {
            max = Math.max(max, num);
        }
        return max;
    }

    private static int longestSubarray_1493(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int lengthCounter = 0;
        int zeroCounter = 0;
        int max = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zeroCounter - k == 0) {
                    while (nums[left] != 0 && left < right) {
                        left++;
                        lengthCounter--;
                    }
                    if (nums[left] == 0) {
                        zeroCounter--;
                        lengthCounter--;
                        left++;
                    }
                }
                zeroCounter++;
            }
            lengthCounter++;
            max = Math.max(max,lengthCounter);
            right++;
        }
        return max - 1;
    }

    private static int ConsecutiveOnesIII_1004(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int lengthCounter = 0;
        int zeroCounter = 0;
        int max = Integer.MIN_VALUE;
        while (right < nums.length) {
            if (nums[right] == 0) {
                if (zeroCounter - k == 0) {
                    while (nums[left] != 0 && left < right) {
                        left++;
                        lengthCounter--;
                    }
                    if (nums[left] == 0) {
                        zeroCounter--;
                        lengthCounter--;
                        left++;
                    }
                }
                zeroCounter++;
            }
            lengthCounter++;
            max = Math.max(max,lengthCounter);
            right++;
        }
        return max;
    }

    private static int VowelsSubstring_1456(String s, int k) {
        HashMap<Character, Boolean> map = new HashMap<>(){{
            put('a',true);
            put('e',true);
            put('i', true);
            put('o', true);
            put('u', true);
        }};
        int maxCounter = Integer.MIN_VALUE;
        int counter = 0;
        int left = 0;
        int right = 0;
        char[] charArray = s.toCharArray();
        while (right < k) {
            if (map.containsKey(charArray[right])) {
                counter++;
            }
            right++;
        }
        maxCounter = counter;
        while (right < s.length()) {
            if (map.containsKey(charArray[right])) {
                counter++;
            }
            if (map.containsKey(charArray[left])) {
                counter--;
            }
            maxCounter = Math.max(counter, maxCounter);
            left++;
            right++;
        }
        maxCounter = Math.max(counter, maxCounter);
        return maxCounter;
    }

    private static double AverageSubarray_643(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double total = 0;
        int left = 0;
        int right = 0;

        //  |9,7,3,5,6,2|,0,8,1,9
//        k = 6
//        left = 0
//        right = 0
//        nums[left] = 9
//        nums[right] = 9

        while (right < k) {
            total += nums[right];
            right++;
        }
        // total 32
        max = Math.max(max, total/((double)(k)));
        while (right < nums.length) {
            total -= nums[left];
            total += nums[right];
            max = Math.max(max, total/((double)(k)));
            left++;
            right++;
        }
        max = Math.max(max, total/((double)(k)));
        return max;
    }

    private static int MaxKSum_1679(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num: map.keySet()) {
            if (map.containsKey(k-num)) {
                while (map.get(num) > 0 && map.get(k-num) > 0) {
                    if (num == k - num && map.get(num) == 1) {
                        map.put(num, map.get(num) - 1);
                    } else {
                        counter++;
                        map.put(num, map.get(num) - 1);
                        map.put(k - num, map.get(k - num) - 1);
                    }
                }
            }
        }
        return counter;
    }

    private static boolean Subsequence_392(String s, String t) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            stack.push(i);
        }
        char[] chars = t.toCharArray();
        int index = chars.length - 1;
        while (!stack.isEmpty() && index != -1) {
            if (stack.peek() == chars[index]) {
                stack.pop();
            }
            index--;
        }
        return stack.isEmpty();
    }

    private static void Move_283(int[] ints) {
        // 0,1,0,3,12
        //

        /***
         *  wow
         *  tracker = 0
         * i = 0
         * if index 0 is 0 then
         * ints[0] = 0
         * increase tracker by 1
         * check the next index if there's a value
         * i = 1 is 1
         * flip 0 and 1
         * 1,0,0,3,12
         * increase index
         * i = 1
         * ints[1] = 0
         * check next index if there's a value
         * ints[1 + 1] = 0
         * increase tracker by 1
         * increase index by 1
         * i = 2
         * ints[2] = 0
         * ints[2+1] = 3
         * for j of tracker flip each of the 0's in the list
         * j = 1
         * ints[2 - j + 1] = 0
         * temp = ints[2+2-j]
         * ints[2+1] = ints[2 - j + 1]
         * ints[2 - j + 1] = temp
         * [1,0,3,0,12]
         * j = 2
         * ints[2 - j + 1] = 0
         * temp = ints[2+2-j]
         * ints[2+2-j] = ints[2 - j + 1]
         * ints[2 - j + 1] = temp
         * [1,3,0,0,12]
         * i = 3
         * check next
         *
         *
         *0,1,0,3,12
         * 1,0,0,3,12
         * 1,0,3,0,12
         */
        int tracker = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                // i = 2
                tracker++; // 2
            }
            if (i + 1 < ints.length && ints[i+1] != 0 && ints[i] ==0) {
                for (int j = 1; j <= tracker; j++) {
                    int temp = ints[i + 2- j];
                    ints[i+2-j] = 0;
                    ints[1-j+i] = temp;
                }
                tracker--;
            }
        }
        System.out.println(Arrays.toString(ints));
    }

    private static Integer Compression_443(char[] chars) {
        int currentPosition = 0;
        for (int i = 0; i < chars.length;) {
            char currentCharacter = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == currentCharacter) {
                count++;
                i++;
            }
            chars[currentPosition++] = currentCharacter;
            if (count > 1) {
                for (char c:String.valueOf(count).toCharArray()){
                    chars[currentPosition++] = c;
                }
            }
        }
        return currentPosition;
    }

    private static boolean Triplet_334(int[] nums) {
        if (Arrays.stream(nums).max().getAsInt() - Arrays.stream(nums).min().getAsInt() >3) return false;
        int left = 0;
        int middle = 1;
        int right = 2;
        while (left < nums.length - 2) {
            if (middle == nums.length) {
                left++;
                middle = left + 1;
                right = middle + 1;
            } else if (right == nums.length) {
                middle++;
                right = middle+1;
            } else if (!(nums[left] < nums[middle])) {
                middle++;
                right = middle+1;
            } else if (!(nums[middle] < nums[right])) {
                right++;
            } else {
                return true;
            }
        }
        return false;
    }

    private static String Reverse_151(String s) {
        StringBuilder answer = new StringBuilder();
        String[] array = s.split(" ");
        for (int i = array.length-1; i>=0; i--) {
            if (Objects.equals(array[i], "")) {
            } else {
                answer.append(array[i].strip());
                answer.append(" ");
            }

        }
        return answer.toString().strip();
    }

    private static String Reverse_345(String s) {
        String wow = "aeiouAEIOU";
        StringBuilder answer = new StringBuilder();
        ArrayList<Character> array = new ArrayList<>();
        char[] answerArray = s.toCharArray();
        for (char c : answerArray) {
            if (wow.contains(c + "")) {
                array.add(c);
            }
        }
        int index = array.size();
        for (char c : answerArray) {
            if (wow.contains(c + "")) {
                answer.append(array.get(index - 1));
                index--;
            } else {
                answer.append(c);
            }
        }
        return answer.toString();
    }

    private static boolean Flowers_605(int[] flowerbed, int n) {
//        System.out.println(Arrays.toString(flowerbed));
//        int counter = 0;
//        int index = 0;
//        while (index < flowerbed.length - 1) {
//            if (index == 0 && flowerbed[index] == 0 && flowerbed[index+1] == 0){
//                flowerbed[index] = 1;
//                counter++;
//                System.out.println("increased");
//            } else {
//                if (flowerbed[index] == 0 && flowerbed[index+1] == 0 && flowerbed[index-1] == 0) {
//                    flowerbed[index] = 1;
//                    counter++;
//                }
//            }
//            System.out.println(Arrays.toString(flowerbed));
//
//            index++;
//        }
//        System.out.println(counter);
//        return counter >= n;
        int counter = 0;
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed.length == 1 ) {
                if (flowerbed[i] == 0) {
                    return 1 >= n;
                } else {
                    return 0 >= n;
                }
            }
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    counter++;
                }
                i++;
            } else if (i == flowerbed.length - 1) {
                if (flowerbed[i] == 0 && flowerbed[i-1] == 0){
                    flowerbed[i] = 1;
                    counter++;
                }
                i++;
            } else {
                if (flowerbed[i] == 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    counter++;
                }
            }
            i++;
        }

        return counter >= n;
    }

    public static boolean[] Candies_1431(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        boolean[] booleanAnswer = new boolean[candies.length];
        for (int candy: candies) {
            max = Math.max(max, candy);
        }
        for (int i = 0; i < candies.length; i++) {
            booleanAnswer[i] = candies[i] + extraCandies >= max;
        }
        return booleanAnswer;
    }
    public static String Greatest_1071(String str1, String str2) {

        String smaller = "";
        String other = "";
        String answer = "";
        if (str1.length() < str2.length()){
            smaller = str1;
            other = str2;
        } else {
            smaller = str2;
            other = str1;
        }
        if (!other.contains(smaller)){
            return "";
        }

        int a = smaller.length();
        int b = other.length();
        while (b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        if (other.replaceAll(smaller.substring(0,a),"").length() == 0) {
            answer = smaller.substring(0,a);
        } else {
            answer = "";
        }
        System.out.println(answer);
        return answer;


    }

    public static void Merge_1768(String word1, String word2){
        StringBuilder answer = new StringBuilder();
        int index = 0;
        while (index < word1.length() || index < word2.length()) {
            if (index < word1.length()){
                answer.append(word1.charAt(index));
            }
            if (index < word2.length()){
                answer.append(word2.charAt(index));
            }
            index++;
        }
        System.out.println(answer);
    }

    public static void K_347(Integer[] nums, int k) {
        /*
        Given an array nums
        return the k most frequent elements
         */

        // populate hashmap with number as key and counter as value
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for (int num : nums) {
            if (hashmap.contains(num)) {
                hashmap.put(num, hashmap.get(num) + 1);
            } else {
                hashmap.put(num,1);
            }
        }

        // loop through the hashmap, get the counters
        // keep track of the max counter
        // populate the second hashmap with the counters as key and array of number as value
        for (int num : hashmap.valueSet()) {

        }

        // loop decrementingly the second hashmap from the max counter as key
        // and have a counter that keeps track of the total elements in arrays
        // Once the counter gets higher than k then break;
        // Keep track of all the keys before the counter gets higher than k

        // loop through the keys and loop through the arrays and then return the int[]


        return new int[5];
    }
    public static void Product_238(Integer[] nums) {
        /*
        Given an integer array nums, return an array answer such that answer[i]
         is equal to the product of all the elements of nums except nums[i].
         */
        // 1, 2, 3, 4
        // 24,12,8,6
        // 1 , 1 * 1 , 2 * 1, 3 * 2
        // 2 * 3 * 4, 3 * 4, 4 * 1, 1
        // 3 * 4 * 2 , 3 * 4, 4 * 2, 1
        // for this problem we can go through each one of the integers and s

//        int[] answer = new int[nums.length];
//        int left = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0) {
//                left = nums[i - 1] * left;
//            }
//            answer[i] = left;
//        }
//
//        int right = 1;
//        for (int i = nums.length - 1; i >= 0; i--) {
//            if (i < nums.length - 1) {
//                right = nums[i+1] * right;
//            }
//            answer[i] = right * answer[i];
//        }
//        System.out.println(Arrays.toString(answer));



        int[] answer = new int[nums.length];
        int left = 1;
        for (int i = 0; i<answer.length; i++) {
            if (i > 0) {
                left = nums[i-1] * left;
            }
            answer[i] = left;
        }
        int right = 1;
        for (int i = answer.length-1; i>=0; i--) {
            if (i < answer.length-1) {
                right = nums[i+1] * right;
            }
            answer[i] = right * answer[i];
        }
        System.out.println(Arrays.toString(answer));
    }

    public static int Container_11(Integer[] height){
        int left = 0;
        int right = height.length -1;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            if (height[left] >= height[right]) {
                max = Math.max(max, height[right] * (right - left));
                right--;
            } else if (height[right] > height[left]) {
                max = Math.max(max, height[left] * (right - left));
                left++;
            }

        }
        return max;
    }

//    public static void Container_11(Integer[] height){
//        System.out.println(Arrays.toString(height));
//
//        /*
//         Container with most water
//         Given height of length n
//         There are n vertical lines
//         Fine two lines that together form a container
//         Such that the container contains the most water
//         8 and 7 should be it since 7 * 6 = 42
//         */
//
//        // have a max
//        int max = 0;
//        // sliding window
//        int left = 0;
//        int right = height.length - 1;
//        // slide the left side if it is less than the right side and vice versa
//        while (left < right) {
//            if (height[left] > height[right]) {
//                max = Math.max(max, (right - left) * height[right]);
//                right--;
//            } else {
//                max = Math.max(max, (right - left) * height[left]);
//                left++;
//            }
//        }
//        System.out.println(max);
//        // everytime it slides take the container size and store the max
//
//    }

    public static void Remove_19(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            assert head != null;
            System.out.println(head.next.val);
            return;
        }

        while (fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        assert slow.next != null;
        slow.next = slow.next.next;
        System.out.println(head.next.next.next.val);
    }

    public static void Jump_55(Integer[] nums) {
        /*
        Given integer array nums
        initially at first index
        each element represents maximum jump length, may be less than the maximum jump length
        true if you reach the last index
        or false otherwise
         */
        // get the length - 1, this will be the target
        // get the addition of each possible step


    }
    

}