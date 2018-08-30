import java.util.*;

/**
 * @version 30.08.2018
 * @author Viktor Chernyaev
 * @Java2 homework Lesson-3
 * @link https://github.com/des1z
 */
public class Java2HW3 {
    public static void main(String[] args) {
        String[] words = {"Java", "C++", "C#", "Python", "Java", "Ruby", "Delphi", "PHP", "C++", "JavaScript"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        System.out.println(map);
        System.out.println("");

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");
    }
}
