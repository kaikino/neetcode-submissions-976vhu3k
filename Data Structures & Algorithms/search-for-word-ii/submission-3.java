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
                if (trie.head.children.containsKey(board[i][j])) {
                    step(board,trie.head, new StringBuilder(), i, j, out, found);
                }
            }
        }
        return new ArrayList<String>(out);
    }
    void step(char[][] board, TNode curC, StringBuilder cur, int i, int j, Set<String> out, boolean[][] found) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || found[i][j]) {
            return;
        }
        char c = (board[i][j]);
        if (curC.children.containsKey(c)) {
            found[i][j] = true;
            cur.append(c);
            TNode next = curC.children.get(c);
            if (next.end) {
                out.add(cur.toString());
            }
            step(board, next, cur, i + 1, j, out, found);
            step(board, next, cur, i - 1, j, out, found);
            step(board, next, cur, i, j + 1, out, found);
            step(board, next, cur, i, j - 1, out, found);
            found[i][j] = false;
            cur.deleteCharAt(cur.length() - 1);
        }
    }
    class PrefixTree {
        TNode head;
        public PrefixTree() {
            head = new TNode();
        }

        public void insert(String word) {
            TNode cur = head;
            for (char c: word.toCharArray()) {
                TNode temp = cur.children.get(c);
                if (temp == null) {
                    temp = new TNode();
                    cur.children.put(c, temp);
                }
                cur = temp;
            }
            cur.end = true;
        }
    }
    class TNode {
        public HashMap<Character, TNode> children;
        public boolean end;

        public TNode() {
            this.children = new HashMap<Character, TNode>();
            end = false;
        }
    }
}


