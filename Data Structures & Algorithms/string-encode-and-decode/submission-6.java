class Solution {

    public String encode(List<String> strs) {
        String out = "";
        for (String s : strs) {
            out += len(s)+s;
        }
        return out;
    }

    private String len(String s) {
        String a = Integer.toString(s.length());
        for (int i = 0; a.length() < 3; i++) {
            a = "0" + a;
        }
        System.out.println(a);
        return a;
    }

    public List<String> decode(String str) {
        List<String> out = new ArrayList<>();
        decode(str, 0, out);
        return out;
    }

    private void decode(String str, int cur, List<String> out) {
        if (cur < str.length()) {
            int len = Integer.parseInt(str.substring(cur, cur + 3));
            out.add(take(str, cur + 3, len));
            decode(str, cur + len + 3, out);
        }
    }

    private String take(String str, int start, int l) {
        if (l == 0) {return "";};
        return str.charAt(start) + take(str, start + 1, l - 1);
    }
}
