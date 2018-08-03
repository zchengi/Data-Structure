package _Optional_01_Recursive_LinkedList;

/**
 * LeetCode 20. Valid Parentheses
 * <p>
 * 括号匹配问题
 * 该代码主要用于使用 LeetCode 上的问题测试 LinkedListR
 *
 * @author cheng
 *         2018/8/3 12:35
 */
public class Solution {
    public interface Stack<E> {

        int getSize();

        boolean isEmpty();

        void push(E e);

        E pop();

        E peek();
    }

    private class LinkedListStackR<E> implements Stack<E> {

        private LinkedListR<E> list;

        public LinkedListStackR() {
            this.list = new LinkedListR<>();
        }

        @Override
        public int getSize() {
            return list.getSize();
        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }

        @Override
        public void push(E e) {
            list.addFirst(e);
        }

        @Override
        public E pop() {
            return list.removeFirst();
        }

        @Override
        public E peek() {
            return list.getFirst();
        }

        @Override
        public String toString() {
            return "Stack: top " + list;
        }
    }

    public boolean isValid(String s) {

        LinkedListStackR<Character> stack = new LinkedListStackR<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("([)]"));
    }
}
