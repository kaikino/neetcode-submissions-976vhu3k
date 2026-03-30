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
