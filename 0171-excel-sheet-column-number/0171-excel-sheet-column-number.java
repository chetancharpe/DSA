class Solution {
    public int titleToNumber(String columnTitle) {
        int a=0;
        for(int i=0;i<columnTitle.length();i++) a=a*26+(columnTitle.charAt(i)-'A'+1);
        return a;
    }
}