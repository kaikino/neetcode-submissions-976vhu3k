class Solution {
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++) {
            int c = prerequisites[i][0];
            int p = prerequisites[i][1];
            List<Integer> n = adj.get(c);
            if (n == null) {
                List<Integer> l = new ArrayList<>();
                l.add(p);
                adj.put(c, l);
            } else {
                n.add(p);
            }
        }

        for (int i : adj.keySet()) {
            if (!dfs(i)) {
                return false;
            };
        }
        return true;
    }

    boolean dfs(int course) {
        if (adj.get(course) == null || adj.get(course).size() == 0) {
            return true;
        }
        if (visiting.contains(course)) {
            return false;
        }
        visiting.add(course);
        for (int prereq : adj.get(course)) {
            if (!dfs(prereq)) {
                return false;
            }
        }
        visiting.remove(course);
        adj.put(course, null);
        return true;
    }
}
