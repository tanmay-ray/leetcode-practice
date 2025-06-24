/*
Given a string s, find the length of the longest substring without duplicate characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring app = new LengthOfLongestSubstring();
        System.out.println(app.lengthOfLongestSubstring("abcbde"));
    }

    // Sliding Window - Even Better
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0, right = 0;
        boolean[] seen = new boolean[256];

        for(; right < s.length(); right++) {
            while(seen[s.charAt(right)]) {
                seen[s.charAt(left++)] = false;
            }
            seen[s.charAt(right)] = true;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    // Sliding Window - Improved
    /*public int lengthOfLongestSubstring(String s) {
        int maxLen = 0, left = 0, right = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            if (seen.containsKey(c) && seen.get(c) >= left) {
                left = seen.get(c) + 1;
            }
            seen.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }*/

    // Sliding Window - This is actually faster than the improved solution
    // if done using basic arrays instead of java Collections
   /* public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        LinkedHashSet<Character> seen = new LinkedHashSet<>();

        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                maxLen = Math.max(maxLen, seen.size());
                Iterator<Character> itr = seen.iterator();
                while(itr.hasNext() && !itr.next().equals(c)) {
                    itr.remove();
                }
                itr.remove();
            }

            seen.add(c);
        }

        return Math.max(maxLen, seen.size());
    }*/

    // Brute force
    /*public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i = 0; i < s.length()-1; i++) {
            int len = 0;
            Set<Character> seen = new HashSet<>();
            for (char c : s.substring(i).toCharArray()) {
                if (seen.contains(c)) {
                    break;
                }
                seen.add(c);
                len++;
            }
            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }*/
}
