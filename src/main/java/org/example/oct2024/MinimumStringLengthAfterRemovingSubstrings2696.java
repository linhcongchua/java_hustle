package org.example.oct2024;

import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings2696 {
    public int minLength(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                stack.pop();
                continue;
            }
            if (charArray[i] == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                stack.pop();
                continue;
            }
            stack.add(charArray[i]);
        }
        return stack.size();
    }
}
