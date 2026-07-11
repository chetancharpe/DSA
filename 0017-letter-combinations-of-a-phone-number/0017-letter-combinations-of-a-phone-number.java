class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();

        if (digits.length() == 0)
            return ans;

        String[] s = {
                "", "", "abc", "def", "ghi",
                "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        solve(digits, 0, "", ans, s);

        return ans;
    }

    public void solve(String digits, int index, String current,
                      List<String> ans, String[] s) {

        
        if (index == digits.length()) {
            ans.add(current);
            return;
        }

        String letters = s[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            solve(digits, index + 1,
                  current + letters.charAt(i),
                  ans, s);
        }
    }
}