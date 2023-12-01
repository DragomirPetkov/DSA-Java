import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char curr : s.toCharArray()){
            if (curr == '(' || curr == '[' || curr == '{'){
                stack.push(curr);
            }else if (!stack.isEmpty() && isMatch(stack.peek(),curr)) {
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    private boolean isMatch(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
