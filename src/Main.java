/**
 * @version 21.08.2018
 * @author Viktor Chernyaev
 * @Java2 homework Lesson-1
 * @link https://github.com/des1z
 */
import Course.*;
import Animals.*;

public class Main {
    public static void main(String[] args) {
        Course c = new Course();  // Создаем полосу препятствий
        Team team = new Team(); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты

    }

}
