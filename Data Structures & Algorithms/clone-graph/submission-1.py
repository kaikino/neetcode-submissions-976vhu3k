"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node == None:
            return None
        out = Node(node.val)
        found = {node.val: out}

        def fillChildren(original, cur):
            for i in original.neighbors:
                if i.val in found:
                    cur.neighbors.append(found[i.val])
                else:
                    new = Node(i.val)
                    found[i.val] = new
                    cur.neighbors.append(new)
                    fillChildren(i, new)

        fillChildren(node, out)
        return out


        