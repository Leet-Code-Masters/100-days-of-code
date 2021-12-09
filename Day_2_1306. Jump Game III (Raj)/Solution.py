class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        # array to keep track of visited posititions
        visited = [False]*len(arr)
        # mark starting position as visited
        visited[start] = True
        # queue for BFS approach
        q = deque()
        q.append(start)
        while len(q) > 0:
            curr = q.popleft()
            if arr[curr] == 0:
                return True
            front = curr + arr[curr]
            back = curr - arr[curr]
            if front < len(arr) and not visited[front]:
                q.append(front)
                visited[front] = True
            if back >= 0 and not visited[back]:
                q.append(back)
                visited[back] = True
        return False
