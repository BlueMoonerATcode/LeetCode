// 1207. Unique Number of Occurrences: 
//Given an array of integers arr, 
//return true if the number of occurrences of each value in the array is unique or false otherwise.

 
/////////////////////////////////////////////////////////////////////////////////////////
import java.util.Arrays;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        int[] v = new int[arr.length];
        int idx = 0;

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;

            // Count occurrences of the current element
            while (i + 1 < arr.length && arr[i] == arr[i + 1]) {
                cnt++;
                i++;
            }

            v[idx++] = cnt;
        }

        Arrays.sort(v);

        for (int i = 1; i < v.length; i++) {
            if (v[i] == v[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
////////////////////////////////////////////////////////////////////////////////////////
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : arr) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        Set<Integer> s = new HashSet<>();
        for (int x : freq.values()) {
            s.add(x);
        }

        return freq.size() == s.size();
    }
}
////////////////////////////////////////////////////////////////////////////////////////
