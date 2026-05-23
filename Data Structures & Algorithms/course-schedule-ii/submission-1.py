class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        self.adj = {i: [] for i in range(numCourses)}
        for p in prerequisites:
            self.adj[p[0]].append(p[1])
        self.order = []
        for c in range(numCourses):
            if not self.dfs(c, set()):
                return []
        return self.order
    def dfs(self, c, vis):
        if c in self.order:
            return True
        if c in vis:
            return False
        vis.add(c)
        for d in self.adj[c]:
            if not self.dfs(d, vis):
                return False
        vis.remove(c)
        self.order.append(c)
        return True

