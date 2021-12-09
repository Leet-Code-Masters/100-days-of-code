class Solution
{
public:
  bool canReach(vector<int> &arr, int start)
  {
    // array to keep track of visited posititions
    vector<bool> visited(arr.size(), false);
    // mark starting position as visited
    visited[start] = true;
    // queue for BFS approach
    queue<int> q;
    q.push(start);
    while (q.size() > 0)
    {
      int curr = q.front();
      q.pop();
      if (arr[curr] == 0)
        return true;
      int front = curr + arr[curr];
      int back = curr - arr[curr];
      if (front < arr.size() && !visited[front])
      {
        q.push(front);
        visited[front] = true;
      }
      if (back >= 0 && !visited[back])
      {
        q.push(back);
        visited[back] = true;
      }
    }
    return false;
  }
};