class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adj = [list() for i in range(n)]
        for edge in edges:
            adj[edge[0]].append(edge[1])
            adj[edge[1]].append(edge[0])
        seen = set()
        def dfs(i) -> bool:
            if i in seen:
                return False
            else:
                seen.add(i)
                for next in adj[i]:
                    adj[next].remove(i)
                    if not dfs(next):
                        return False
            return True;
        return dfs(0) and (len(seen) == n)