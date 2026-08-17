class Solution:
    def stoneGameV(self, stoneValue):

        n = len(stoneValue)

        # Prefix sum
        prefix = [0] * (n + 1)

        for i in range(n):
            prefix[i + 1] = prefix[i] + stoneValue[i]

        # dp[l][r]
        dp = [[-1] * n for _ in range(n)]

        def solve(l, r):

            # Only one stone
            if l == r:
                return 0

            # Already calculated
            if dp[l][r] != -1:
                return dp[l][r]

            ans = 0

            # Try every possible split
            for k in range(l, r):

                left = prefix[k + 1] - prefix[l]
                right = prefix[r + 1] - prefix[k + 1]

                # Left smaller
                if left < right:
                    ans = max(
                        ans,
                        left + solve(l, k)
                    )

                # Right smaller
                elif right < left:
                    ans = max(
                        ans,
                        right + solve(k + 1, r)
                    )

                # Equal
                else:
                    ans = max(
                        ans,
                        left + max(
                            solve(l, k),
                            solve(k + 1, r)
                        )
                    )

            dp[l][r] = ans

            return ans

        return solve(0, n - 1)