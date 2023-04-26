package StudentService;

import StudentDomen.Employee;
import StudentDomen.Student;
import StudentDomen.Teacher;
import StudentDomen.User;

/**
 * Обобщенный класс для подсчета среднего возраста любых объектов, наследующих
 * класс User.
 * 
 * @param <T> тип объектов, наследующих класс User.
 */
public class AverageAge<T extends User> {
    private int count; // счетчик количества объектов
    private double sum; // сумма возрастов объектов

    /**
     * Метод для добавления объекта в подсчет.
     * @param person объект, наследующий класс User.
     */
    public void add(T person) {
        if (person instanceof Student) {// если объект - студент
            sum += ((Student) person).getAge(); // добавляем возраст студента к сумме
            count++; // увеличиваем счетчик на 1
        } else if (person instanceof Teacher) {
            sum += ((Teacher) person).getAge();
            count++;
        } else if (person instanceof Employee) {
            sum += ((Employee) person).getAge();
            count++;
        }
    }

    /**
     * Метод для получения среднего возраста объектов.
     * @return средний возраст объектов.
     */
    public double getAverageAge() {
        return sum / count;
    }

    /**
     * Переопределенный метод toString для вывода среднего возраста объектов.
     * @return строка с информацией о среднем возрасте.
     */
    @Override
    public String toString() {
        return "Средний возраст: " + getAverageAge();
    }
}