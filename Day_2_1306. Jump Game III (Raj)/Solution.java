class Solution {

  public boolean canReach(int[] arr, int start) {
    // array to keep track of visited posititions
    boolean[] visited = new boolean[arr.length];
    // mark starting position as visited
    visited[start] = true;
    // queue for BFS approach
    Queue<Integer> q = new LinkedList();
    q.add(start);
    while (!q.isEmpty()) {
      int curr = q.poll();
      if (arr[curr] == 0) return true;
      int front = curr + arr[curr];
      int back = curr - arr[curr];
      if (front < arr.length && !visited[front]) {
        q.add(front);
        visited[front] = true;
      }
      if (back >= 0 && !visited[back]) {
        q.add(back);
        visited[back] = true;
      }
    }
    return false;
  }
}
