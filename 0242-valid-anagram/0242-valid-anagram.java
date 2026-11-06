import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        // Count characters from string s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        
        // Decrease counts using characters from string t
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            
            // If character doesn't exist or its count is already 0, not an anagram
            if (!charCountMap.containsKey(c)) {
                return false;
            }
            
            int count = charCountMap.get(c) - 1;
            if (count == 0) {
                charCountMap.remove(c);
            } else {
                charCountMap.put(c, count);
            }
        }
        
        // If map is empty, all characters matched perfectly
        return charCountMap.isEmpty();
    }
}