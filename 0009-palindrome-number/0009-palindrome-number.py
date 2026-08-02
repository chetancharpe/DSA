class Solution:
    def isPalindrome(self, x: int) -> bool:
        if x < 0:
            return False

        n = x
        revNum = 0

        while n > 0:
            d = n % 10
            revNum = revNum * 10 + d
            n = n // 10

        return revNum == x