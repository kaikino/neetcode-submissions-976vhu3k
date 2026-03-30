class Solution:
    def foreignDictionary(self, words: List[str]) -> str:
        adj = dict()
        splitWords = [words]
        while splitWords:
            newGroups = list()
            for group in splitWords:
                if len(group) > 0:
                    prev = ""
                    for word in group:
                        if not word:
                            if prev != "":
                                return ""
                            continue
                        if word[0] not in adj:
                            adj[word[0]]=set()
                        if word[0] != prev:
                            if prev != "":
                                adj[prev].add(word[0])
                            newGroups.append([word[1:]])
                            prev = word[0]
                        else:
                            newGroups[-1].append(word[1:])
            splitWords = newGroups
        stack = []
        visited = {x: False for x in adj}
        def dfs(c, path) -> bool:
            path.add(c)
            
            visited[c] = True
            for next in adj[c]:
                if (next in path):
                    return True
                if not visited[next]:
                    if dfs(next, path.copy()):
                        return True
            stack.insert(0, c)
            return False
        
        for i in visited:
            if not visited[i]:
                if dfs(i, set()):
                    return ""
        return ''.join(stack)
                            