package org.example.oct2024;

import java.util.Stack;

public class MinimumAddtoMakeParenthesesValid921 {
    public int minAddToMakeValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(charArray[i]);
        }
        return stack.size();
    }
}
