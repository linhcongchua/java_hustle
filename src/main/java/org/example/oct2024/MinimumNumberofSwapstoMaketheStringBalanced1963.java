package org.example.oct2024;

import java.util.Stack;

public class MinimumNumberofSwapstoMaketheStringBalanced1963 {
    public int minSwaps(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
                continue;
            }
            if (charArray[i] == ']') {
                count++;
            }
            stack.push(charArray[i]);
        }
        return count <= 1 ? count : count - 1;
    }
    // ]]]]]]][[[[[[[
}
