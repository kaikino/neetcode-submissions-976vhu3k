class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree trie = new PrefixTree();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }

        Set<String> out = new HashSet<String>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean[][] found = new boolean[board.length][board[0].length];
                step(board, trie, "", i, j, out, found);
            }
        }

        return new ArrayList<>(out);
    }
    void step(char[][] board, PrefixTree trie, String cur, int i, int j, Set<String> out, boolean[][] found) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || found[i][j]) {
            return;
        }
        cur += board[i][j];
        if (trie.search(cur)) {
            out.add(cur);
        }
        if (trie.startsWith(cur)) {
            found[i][j] = true;
            step(board, trie, cur, i + 1, j, out, found);
            step(board, trie, cur, i - 1, j, out, found);
            step(board, trie, cur, i, j + 1, out, found);
            step(board, trie, cur, i, j - 1, out, found);
            found[i][j] = false;
        }
    }
}

class PrefixTree {
    Node head;
    public PrefixTree() {
        head = new Node();
    }

    public void insert(String word) {
        Node cur = head;
        for (char c: word.toCharArray()) {
            Node temp = cur.children.get(c);
            if (temp == null) {
                temp = new Node();
                cur.children.put(c, temp);
            }
            cur = temp;
        }
        cur.end = true;
    }

    public boolean search(String word) {
        Node cur = head;
        for (char c: word.toCharArray()) {
            Node temp = cur.children.get(c);
            if (temp == null) {
                return false;
            }
            cur = temp;
        }
        return cur.end;
    }

    public boolean startsWith(String prefix) {
        Node cur = head;
        for (char c: prefix.toCharArray()) {
            Node temp = cur.children.get(c);
            if (temp == null) {
                return false;
            }
            cur = temp;
        }
        return true;
    }

     
    class Node {
        HashMap<Character, Node> children;
        public boolean end;

        public Node() {
            this.children = new HashMap<Character, Node>();
            end = false;
        }
    }
}

