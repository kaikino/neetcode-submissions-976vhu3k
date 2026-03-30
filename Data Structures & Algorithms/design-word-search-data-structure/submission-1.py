class WordDictionary:

    def __init__(self):
        self.head = dict()

    def addWord(self, word: str) -> None:
        cur = self.head
        for i in list(word):
            if i not in cur:
                cur[i] = {0: False}
            cur = cur[i]
        cur[0] = True

    def search(self, word: str) -> bool:

        def path(index, cur) -> bool:
            if index == len(word):
                return cur[0]
            if word[index] == '.':
                for nextc in cur:
                    if nextc == 0:
                        continue
                    if path(index + 1, cur[nextc]):
                        return True
            else:
                if word[index] in cur:
                    return path(index + 1, cur[word[index]])
            return False

        return path(0, self.head)