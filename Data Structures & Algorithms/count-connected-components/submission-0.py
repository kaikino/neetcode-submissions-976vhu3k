class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = [list() for _ in range(n)]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        visited = [False] * n
        def dfs(n):
            visited[n] = True
            for e in adj[n]:
                if not visited[e]:
                    dfs(e)
        out = 0
        for i in range(n):
            if not visited[i]:
                out += 1
                dfs(i)
        return out