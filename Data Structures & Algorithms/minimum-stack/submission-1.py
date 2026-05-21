class MinStack:
    
    def __init__(self):
        self.stack = list()
        self.lastMin = float("inf")

    def push(self, val: int) -> None:
        self.lastMin = min(val, self.lastMin)
        self.stack.append((val, self.lastMin))

    def pop(self) -> None:
        self.stack.pop()
        if self.stack:
            self.lastMin = self.stack[-1][1]
        else:
            self.lastMin = float("inf")

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]
        
