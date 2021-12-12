class Solution {

  // code for gcd, lcm taken from GFG
  private long gcd(long a, long b) {
    if (a == 0) return b;
    return gcd(b % a, a);
  }

  private long lcm(long a, long b) {
    return (a / gcd(a, b)) * b;
  }

  public int nthMagicalNumber(int n, int a, int b) {
    long left = 1, right = 900000000000000L;
    int mod = 1000000007;
    while (left < right) {
      long mid = left + (right - left) / 2;
      long divByA = mid / a;
      long divByB = mid / b;
      // lcm hint taken from Discussions section
      long divByAB = mid / lcm(a, b);
      long total = divByA + divByB - divByAB;
      if (total < n) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return (int) (left % mod);
  }
}
