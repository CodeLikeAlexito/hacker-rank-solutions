import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println(angryProfessor(7, List.of(26, 94, -95, 34, 67, -97, 17, 52, 1, 86)));
    }

    public static String angryProfessor(int k, List<Integer> a) {
        // Write your code here

        int lateStudents = 0;

        for (Integer integer : a) {
            if (integer > 0) {
                lateStudents++;
            }
        }

        if(lateStudents > k) {
            return "NO";
        }

        return "YES";

    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here
        int longest = 0;
        for(int i : a) {
            int count = 0;
            for(int j : a) {
                if(i == j || i - j == 1) {
                    count++;
                }
            }
            if(count > longest) longest = count;
        }
        return longest;
    }

    public static int designerPdfViewer(List<Integer> h, String word) {
        // Write your code here
        HashMap<Character, Integer> alphabet = new HashMap<>();

        if(h.size() != 26)
            return -1;

        for (char letter = 'a', i = 0; letter <= 'z' ; letter++, i++) {
            alphabet.put(letter, h.get(i));
        }

//        System.out.println(alphabet);

        int tallestLetter = Integer.MIN_VALUE;

        for (Character ch: word.toCharArray()) {
            if(alphabet.containsKey(ch)) {
//                System.out.println(alphabet.get(ch));
                if(alphabet.get(ch) > tallestLetter)
                    tallestLetter = alphabet.get(ch);
            }
        }

//        System.out.println("Tallest letter: " + tallestLetter);

        return tallestLetter * word.length();
    }

    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */

        int mostExpensive = Integer.MIN_VALUE;

        for (int i = 0; i <= keyboards.length - 1; i++) {
            for (int j = 0; j < drives.length; j++) {
                int possibleAnswer = keyboards[i] + drives[j];
                if(possibleAnswer <= b) {
                    if(possibleAnswer > mostExpensive) {
                        mostExpensive = possibleAnswer;
                    }
                }
            }
        }

        return mostExpensive != Integer.MIN_VALUE ? mostExpensive : -1;

    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static String twoStrings(String s1, String s2) {
        // Write your code here

        Set<Character> uniqueChars = new HashSet<>();

        for (Character ch: s1.toCharArray()) {
            uniqueChars.add(ch);
        }

        for (Character ch: s2.toCharArray()) {
            if(uniqueChars.contains(ch))
                return "YES";
        }

//        for (int i = 0; i < s1.length() - 1; i++) {
//            for (int j = 0; j < s2.length(); j++) {
//                if(s1.charAt(i) == s2.charAt(j)){
//                    return "YES";
//                }
//            }
//        }

        return "NO";
    }

    static void iceCreamParlour(List<Integer> cost, int money) {
        Map<Integer, Integer> flavorIndices = new HashMap<>();

        for (int i = 0; i < cost.size(); i++) {
            int c = cost.get(i);
            int complement = money - c;

            if (flavorIndices.containsKey(complement)) {
                // Found a pair of flavors that match the budget
                System.out.println((flavorIndices.get(complement) + 1) + " " + (i + 1));
                return;
            }

            flavorIndices.put(c, i);
        }

        System.out.println(flavorIndices);
    }

    static void whatFlavors(List<Integer> cost, int money) {
        // Write your code here

        HashMap<Integer, Integer> costMap = new HashMap<>();
        HashMap<Integer, Integer> resultMap = new HashMap<>();

        int index = 1;

        for (Integer singlePrice: cost) {
            costMap.put(index, singlePrice);
            index++;
        }

        System.out.println(costMap);

        costMap.forEach((key, value) -> {
            int complement = money - value;
            if(costMap.containsValue(complement)) {
                resultMap.put(key, value);
            }
        });

        System.out.println(costMap);
        System.out.println(resultMap);

        resultMap.forEach((key, value) -> {
            System.out.printf("%d ", key);
        });
    }

    public static void checkMagazine(List<String> magazine, List<String> note) {
        // Write your code here
        HashMap<String, Integer> magazineMap = new HashMap<>();
        HashMap<String, Integer> noteMap = new HashMap<>();

        for (String str : magazine) {
            magazineMap.put(str, magazineMap.getOrDefault(str, 0) + 1);
        }

        for (String noteStr : note) {
            noteMap.put(noteStr, noteMap.getOrDefault(noteStr, 0) + 1);
        }
//
        System.out.println(magazineMap);
        System.out.println(noteMap);

        boolean allValuesEqual = true;

        for (Integer val : noteMap.values()) {
            if(!magazineMap.containsValue(val)) {
                allValuesEqual = false;
            }
        }

        System.out.println(allValuesEqual);

        boolean allWordsContained = true;

        for (String word : noteMap.keySet()) {
            if(!magazineMap.containsKey(word)) {
                allWordsContained = false;
            }
        }

        System.out.println(allWordsContained);

        System.out.println(allWordsContained && allValuesEqual ? "Yes" : "No");
    }

    static long largestRectangle2(List<Integer> h) {
//        int sum = h.stream().mapToInt(Integer::intValue).sum();
        OptionalDouble avrg = h.stream().mapToInt(Integer::intValue).average();
        int closesValue = (int) Math.floor(avrg.getAsDouble());

//        System.out.println(avrg);
//        System.out.println(closesValue);

        Collections.sort(h);

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0, k = 0; i < h.size(); i++) {
            int currentArea = h.get(i) * (h.size() - k);
            if(h.get(i) >= closesValue) {
                if(currentArea > maxArea) {
                    maxArea = currentArea;
                }
            }
            k++;
        }

        return maxArea;
    }

    public static long largestRectangle(List<Integer> h) {
        // Write your code here

        int maxArea = Integer.MIN_VALUE;

        Collections.sort(h);

        for (int i = 0, k = 0; i < h.size(); i++) {
            int currentArea = h.get(i) * (h.size() - k);
            if(currentArea > maxArea) {
                maxArea = currentArea;
            }
            k++;
        }

        return maxArea;
    }


    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String isBalanced(String s) {
        // Write your code here
        // {[()]}

        Stack<Character> bracketsStack = new Stack<>();
        for (char c: s.toCharArray()) {
            if(c == '{' || c == '[' || c == '(') {
                bracketsStack.push(c);
            }

            if(c == '}' || c == ']' || c== ')') {
                if(bracketsStack.isEmpty()) return "NO";
                char top = bracketsStack.pop();
                if((c == ')' && top != '(') ||
                   (c == ']' && top != '[') ||
                   (c == '}' && top != '{')) {

                   return "NO";

                }
            }
        }

        return bracketsStack.isEmpty() ? "YES" : "NO";
    }

    static String isValidChatGpt(String s) {
        // Count the frequency of each character in the string
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }


        // Count the frequencies of the character frequencies
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int count : charCount.values()) {
            freqCount.put(count, freqCount.getOrDefault(count, 0) + 1);
        }

        // If there's only one distinct frequency, it's valid
        if (freqCount.size() == 1) {
            return "YES";
        }

        // If there are two distinct frequencies, check if we can remove one character
        if (freqCount.size() == 2) {
            int[] frequencies = new int[2];
            int[] counts = new int[2];
            int i = 0;
            for (int freq : freqCount.keySet()) {
                frequencies[i] = freq;
                counts[i] = freqCount.get(freq);
                i++;
            }

            // Check if we can remove one character to make the string valid
            if ((Math.abs(frequencies[0] - frequencies[1]) == 1 && (counts[0] == 1 || counts[1] == 1)) ||
                    (frequencies[0] == 1 && counts[0] == 1) ||
                    (frequencies[1] == 1 && counts[1] == 1)) {
                return "YES";
            }
        }

        // Otherwise, it's not possible to make it valid
        return "NO";
    }

    public static String isValid(String s) {
        // Write your code here
        boolean isValid = true;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            if(hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }

        System.out.println(hashMap);

        boolean allValuesEqual = hashMap.values()
                .stream()
                .distinct()
                .count() == 1;

        System.out.println("All values equal: " + allValuesEqual);

        if(!allValuesEqual) {
            // check if we can delete only one character at one index in the string
            long distinctValuesInMap = hashMap.values()
                    .stream()
                    .distinct()
                    .count();

            for (Map.Entry<Character, Integer> set : hashMap.entrySet()) {

            }


            long distinctKeysInMap = hashMap.keySet()
                            .stream()
                            .distinct()
                            .count();


            System.out.println("Distinct values in map: " + distinctValuesInMap);
            System.out.println("Distinct keys in map: " + distinctKeysInMap);

            // we need to have 2 distinct values to change isValid to true, otherwise it is false
//            3, 2, 2, 2 = distinct = 2 / size 4
//            3, 3, 2, 2 = distinct = 2 / size 4
//            3, 3, 3, 2, 2 = distinct 2 / size 5

            if(distinctValuesInMap != 2)
                isValid = false;
        }

        return isValid ? "YES" : "NO";

    }

    public static int alternatingCharacters(String s) {
        // Write your code here

        int charsToBeDeleted = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                charsToBeDeleted++;
            }
        }

        return charsToBeDeleted;
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static int minimumSwapsMin(int[] arr) {
        int swaps = 0;

        // Finding the min element of array
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;

            swaps++;
        }

        return swaps;
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {

        int swaps = 0;
        int[] resArr = new int[arr.length];

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaps++;
                }
            }
        }

        System.out.println(arr.length);
        for (int i = 0; i < arr.length - 1; i++) {

            System.out.printf("%d - ", arr[i]);
        }

        return swaps;

    }

    public static void minimumBribes(int[] q) {
        int bribes = 0;

        for (int i = q.length - 1; i >= 0; i--) {
            if (q[i] - (i + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }

            for (int j = Math.max(0, q[i] - 2); j < i; j++) {
                if (q[j] > q[i]) {
                    bribes++;
                }
            }
        }

        System.out.println(bribes);
    }

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */

//    public static List<Integer> rotLeft(int[] a, int d) {
//
//        List<Integer> resList = new ArrayList<>();
//
//        int[] resArr = new int[a.length];
//
//        int initialIndex = 0;
//        // Write your code here
//        for (int i = d; i < resArr.length; i++) {
//            resArr[initialIndex++] = a[i];
//        }
//
//        int startingIndex = a.length - d;
//        for (int i = 0; i < d; i++) {
//            resArr[startingIndex++] = a[i];
//        }
//
//        return Arrays.asList(Arrays.stream(resArr).boxed().toArray(Integer[]::new));
//    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        List<Integer> resList = new ArrayList<>();

        int[] resArr = new int[a.size()];

        int initialIndex = 0;
        // Write your code here
        for (int i = d; i < resArr.length; i++) {
            resArr[initialIndex++] = a.get(i);
        }

        int startingIndex = a.size() - d;
        for (int i = 0; i < d; i++) {
            resArr[startingIndex++] = a.get(i);
        }

        return Arrays.asList(Arrays.stream(resArr).boxed().toArray(Integer[]::new));
    }

    public static List<Integer> rotLeftSplit(List<Integer> a, int d) {
        List<Integer> resArr = new ArrayList<>();

        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();

        for (int i = 0; i < d; i++) {
            firstHalf.add(a.get(i));
        }

        for (int i = d; i < a.size(); i++) {
            secondHalf.add(a.get(i));
        }

        System.out.println(firstHalf);
        System.out.println(secondHalf);

        resArr.addAll(secondHalf);

        resArr.addAll(firstHalf);

        return resArr;
    }

    static boolean checkIfAnagram(String firstStr, String secondStr) {

        /*
            "abcd" -> "aacc"
        */


        if(firstStr.length() != secondStr.length()){
            return false;
        }

        HashMap<Character, Integer> firstStrHashMap = new HashMap<>();

        for (char c: firstStr.toCharArray()) {
            if (firstStrHashMap.containsKey(c)) {
                firstStrHashMap.put(c, firstStrHashMap.get(c) + 1);
            } else {
                firstStrHashMap.put(c, 1);
            }
        }

        HashMap<Character, Integer> secondStrHashMap = new HashMap<>();

        for (char c: secondStr.toCharArray()) {
            if (secondStrHashMap.containsKey(c)) {
                secondStrHashMap.put(c, secondStrHashMap.get(c) + 1);
            } else {
                secondStrHashMap.put(c, 1);
            }
        }

        return firstStrHashMap.equals(secondStrHashMap);
    }

    static boolean checkIfAnagramInitial(String firstStr, String secondStr) {
        if(firstStr.length() != secondStr.length())
            return false;

        char[] charArr1 = firstStr.toCharArray();
        char[] charArr2 = secondStr.toCharArray();

        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        for (int i = 0; i < charArr1.length; i++) {
            if(charArr1[i] != charArr2[i])
                return false;
        }

        return true;
    }
}

