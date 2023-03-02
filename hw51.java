/*
 * Написать метод, определяющую правильность расстановки скобок в выражении.
 * Могут содержаться следующие скобки: ()[]{}<>
 * () -> true
 * []{}((<>)) -> true
 * ) -> false
 * [) -> false
 * []{}(<)> -> false
 */
// private static boolean isCorrectParentheses(String parentheses) {
//     // парсим текст на слова
//     // печатаем слова в порядке возрастания длины
//     throw new UnsupportedOperationException();
// }
//Работает только для симметричного набора
package hw5;

import java.util.HashMap;
import java.util.Map;

public class hw51 {
    public static void main(String[] args) {
//        String text= "({<({)>})";
        System.out.println(isCorrectParentheses("({<({)>})"));
        System.out.println(isCorrectParentheses("({<()>})"));
    }  
    private static boolean isCorrectParentheses(String parentheses) {
        System.out.println(parentheses);
        String [] splitText=parentheses.split("");
        Map<String, Integer> db = new HashMap<>();
        db.put("(", 1);
        db.put(")", 2);
        db.put("[", 3);
        db.put("]", 4);
        db.put("{", 5);
        db.put("}", 6);
        db.put("<", 7);
        db.put(">", 8);
        if(splitText.length%2!=0){
            return false;
        }

        // for (String string : splitText) {
        //     //System.out.println(string);    
        // }
        int stl=parentheses.length();
        //System.out.println(stl);

        for (int i=0; i<stl/2; i++){
            //System.out.println(splitText[i]);            
            //System.out.println(splitText[splitText.length-i-1]);
            int temp=db.get(splitText[splitText.length-i-1])-db.get(splitText[i]);
            //System.out.println(temp);
            if (temp!=1){
                return false;
            }           
        }
        return true;
    }  
}
