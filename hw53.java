/*
 * Написать метод, определяющую правильность расстановки скобок в выражении.
 * Могут содержаться следующие скобки: ()[]{}<>
 * () -> true
 * []{}((<>)) -> true
 * ) -> false
 * [) -> false
 * []{}(<)> -> false
 */
package hw5;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class hw53 {
    public static void main(String[] args) {
        System.out.println(validBrackets("()")); // 1 - true
        System.out.println(validBrackets("[]{}((<>))")); // 2 - true
        System.out.println(validBrackets("(({}[()]))")); // 3 - true
        System.out.println(validBrackets("[]{}(<)>")); // 4 - false
        System.out.println(validBrackets("((]")); // 5 - false
        System.out.println(validBrackets("]")); // 6 - false
    }

    private static boolean validBrackets(String input) {
        Map<Character, Character> brackets = new HashMap<>();
        // создаем Map, в которой ключом является закрывающая скобка, 
        //а значением - открывающая
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        brackets.put('>', '<');
        // создаем stack, в который кладем открывающие скобки, для сравнения с закрывающими
        Deque<Character> stack = new LinkedList<>();
    for (char c : input.toCharArray()) {
        if (brackets.containsValue(c)) {
        // если попадается одна из открывающих скобок, то добавляем ее в стэк
            stack.push(c);
        } else if (brackets.containsKey(c)) {
        // если попадается одна из закрывающих скобок, и стэк не пустой, то в нем должна быть
        // последней такая же открывающая скобка. Иначе ложь.
            if (stack.isEmpty() || stack.pop() != brackets.get(c)) {
                return false;
            }
        }
    }
    // в конце стек должен быть пустым
    return stack.isEmpty();
    }
}