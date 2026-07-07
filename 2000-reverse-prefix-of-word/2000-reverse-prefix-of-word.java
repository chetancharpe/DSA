class Solution {
    public String reversePrefix(String word, char ch) {

        int firstOccurrence = word.indexOf(ch);

        if (firstOccurrence == -1)
            return word;

        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i <= firstOccurrence; i++)
            charStack.push(word.charAt(i));

        StringBuilder result = new StringBuilder();

        while (!charStack.isEmpty())
            result.append(charStack.pop());

        for (int i = firstOccurrence + 1; i < word.length(); i++)
            result.append(word.charAt(i));

        return result.toString();
    }
}