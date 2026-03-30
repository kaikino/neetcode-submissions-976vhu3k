class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str: strs) {
            HashMap<Character, Integer> ordered = calc(str);
            if (map.containsKey(ordered)) {
                map.get(ordered).add(str);
            } else {
                map.put(ordered, new ArrayList<>(Arrays.asList(str)));
            }
        }
        List<List<String>> out = new ArrayList<>();
        for (HashMap<Character, Integer> k: map.keySet()) {
            out.add(map.get(k));
        }
        return out;
    }
    private HashMap<Character, Integer> calc(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c: s.toCharArray()) {
            if (count.containsKey(c)) {
                count.put(c, count.get(c)+1);
            } else {
                count.put(c, 1);
            }
        }
        return count;
    }
}