import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], true);
            }
        }

        int result = 0;
        for (Integer key : map.keySet()) {
            result = key;
        }

        return result;
    }
}
