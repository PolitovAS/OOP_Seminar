import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Controllers.EmployeeController;
import StudentDomen.Employee;
import StudentDomen.Student;
import StudentDomen.StudentGroup;
import StudentDomen.StudentSteam;
import StudentDomen.Teacher;
import StudentDomen.User;
import StudentService.AverageAge;

/*
 * Главный класс приложения.
 */
public class App {
    /**
     * Метод main, запускающий приложение.
     * 
     * @param args аргументы командной строки.
     * @throws Exception возможные исключения.
     */
    public static void main(String[] args) throws Exception {

        // Создание объекта сотрудника
        Employee peron1 = new Employee("Олег", "Иванов", 55, "СПб", 110);

        // Выплата зарплаты сотруднику
        EmployeeController.paySalary(peron1);

        // Вычисление среднего количества часов и средней ЗП
        Integer studHour[] = { 124, 234, 231, 1, 45 };
        System.out.printf("Среднее количество часов: %.2f\n", EmployeeController.mean(studHour));
        Double emplSalary[] = { 12555.23, 34213.5, 10000.0 };
        System.out.printf("Средняя ЗП: %.2f\n", EmployeeController.mean(emplSalary));

        // Вычисление среднего возраста студентов, преподавателей и сотрудников
        AverageAge<Student> averageAgeStudents = new AverageAge<>();
        averageAgeStudents.add(new Student("Сергей", "Иванов ", 21, "Москва", 102));
        averageAgeStudents.add(new Student("Андрей", "Сидоров ", 22, "Москва", 101));
        averageAgeStudents.add(new Student("Иван", "Петров ", 24, "Москва", 105));
        System.out.println(averageAgeStudents);

        AverageAge<Teacher> averageAgeTeachers = new AverageAge<>();
        averageAgeTeachers.add(new Teacher("Аркадий", "Цветков ", 44, "Москва", 1012, "Кандидат наук"));
        averageAgeTeachers.add(new Teacher("Максим", "Прохоров ", 41, "Москва", 1301, "Доктор наук"));
        averageAgeTeachers.add(new Teacher("Юрий", "Гагарин ", 39, "Москва", 1005, "Кандидат наук"));
        System.out.println(averageAgeTeachers);
        
        AverageAge<Employee> averageAgeEmployees = new AverageAge<>();
        averageAgeEmployees.add(new Employee("Олег", "Игнатов ", 33, "Москва", 42));
        averageAgeEmployees.add(new Employee("Валерий", "Кипелов ", 36, "Москва", 51));
        averageAgeEmployees.add(new Employee("Екатерина", "Лесова ", 31, "Москва", 35));
        System.out.println(averageAgeEmployees);

        // /*
        // * Создаем экземпляры класса Student
        // */
        // Student s11 = new Student("Сергей", "Иванов ", 22, "Москва", 102);
        // Student s12 = new Student("Андрей", "Сидоров ", 22, "Москва", 101);
        // Student s13 = new Student("Иван", "Петров ", 22, "Москва", 105);
        // Student s14 = new Student("Игорь", "Иванов ", 23, "Москва", 106);
        // Student s15 = new Student("Даша", "Цветкова ", 23, "Москва", 103);
        // Student s16 = new Student("Лена", "Незабудкина ", 23, "Москва", 104);

        // Student s21 = new Student("Сергей", "Петров ", 22, "Москва", 202);
        // Student s22 = new Student("Андрей", "Иванов ", 22, "Москва", 201);
        // Student s23 = new Student("Иван", "Иванов ", 22, "Москва", 205);
        // Student s24 = new Student("Игорь", "Сидоров ", 23, "Москва", 206);

        // Student s31 = new Student("Сергей", "Сидоров ", 22, "Москва", 302);
        // Student s32 = new Student("Андрей", "Иванов ", 22, "Москва", 301);
        // Student s33 = new Student("Иван", "Иванов ", 22, "Москва", 305);
        // Student s34 = new Student("Игорь", "Петров ", 23, "Москва", 306);
        // Student s35 = new Student("Маша", "Цветкова ", 23, "Москва", 303);
        // Student s36 = new Student("Аня", "Незабудкина ", 23, "Москва", 304);
        // Student s37 = new Student("Даша", "Незабудкина ", 23, "Москва", 308);
        // Student s38 = new Student("Лена", "Цветкова ", 23, "Москва", 307);

        // /*
        // * Создаем и заполняем коллекции экземплярами класса Student
        // */
        // List<Student> listStud1 = new ArrayList<Student>();
        // listStud1.add(s11);
        // listStud1.add(s12);
        // listStud1.add(s13);
        // listStud1.add(s14);
        // listStud1.add(s15);
        // listStud1.add(s16);

        // List<Student> listStud2 = new ArrayList<Student>();
        // listStud2.add(s21);
        // listStud2.add(s22);
        // listStud2.add(s23);
        // listStud2.add(s24);

        // List<Student> listStud3 = new ArrayList<Student>();
        // listStud3.add(s31);
        // listStud3.add(s32);
        // listStud3.add(s33);
        // listStud3.add(s34);
        // listStud3.add(s35);
        // listStud3.add(s36);
        // listStud3.add(s37);
        // listStud3.add(s38);

        // /*
        // * Создаем экземпляры класса StudentGroup
        // */
        // StudentGroup group1 = new StudentGroup(1, listStud1);
        // StudentGroup group2 = new StudentGroup(2, listStud2);
        // StudentGroup group3 = new StudentGroup(3, listStud3);

        // /*
        // * Создаем и заполняем коллекцию экземплярами класса StudentGroup
        // */
        // List<StudentGroup> listSteam = new ArrayList<StudentGroup>();
        // listSteam.add(group1);
        // listSteam.add(group2);
        // listSteam.add(group3);

        // /*
        // * Создаем экземпляр класса StudentSteam
        // */
        // StudentSteam steam1 = new StudentSteam(1, listSteam);

        // /*
        // * С помощью цикла построчно выводим группы со списком студентов, не
        // отсортированно
        // */
        // for(StudentGroup group: steam1){
        // System.out.printf("Группа %d\n", group.getNumOfGroup());
        // for(Student stud : group){
        // System.out.println(stud);
        // }
        // }

        // System.out.println("___________________");
        // /*
        // * Сортируем
        // */
        // Collections.sort(steam1.getGroups());
        // Collections.sort(group1.getStudents());
        // Collections.sort(group2.getStudents());
        // Collections.sort(group3.getStudents());

        // /*
        // * С помощью цикла построчно выводим группы со списком студентов,
        // отсортированые по колличеству студентов в группе
        // */
        // for(StudentGroup group: steam1){
        // System.out.println(group);
        // }

        // /*
        // * Вывод на экран экземпляра класса StudentSteam с помощью переопределенного
        // метода ToString
        // */
        // System.out.println(steam1);

        // /*
        // * С помощью цикла построчно выводим студентов, не отсортированно
        // */
        // for(Student stud : group1){
        // System.out.println(stud);
        // }

        // System.out.println("___________________");

        // /*
        // * Сортируем
        // */
        // Collections.sort(group1.getStudents());

        // /*
        // * С помощью цикла построчно выводим студентов, отсортированно
        // * согласно логике метода compareTo() интерфейса Comparable для сравнения
        // студентов по возрасту и идентификатору.
        // */
        // for(Student stud : group1){
        // System.out.println(stud);
        // }

    }
}
