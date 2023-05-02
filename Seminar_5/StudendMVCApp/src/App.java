import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Controller.Controller;
import Controller.iGetModel;
import Controller.iGetView;
import Model.FileRepo;
import Model.Model;
import Model.ModelHashMap;
import Model.Student;
import View.View;
import View.ViewEng;

/**
 * Главный класс приложения.
 */
public class App {
   /**
    * Объект сканера для считывания пользовательского ввода.
    */
   public static Scanner in = new Scanner(System.in, "Cp866");
   /**
    * Возвращает объект отображения в зависимости от выбранного языка.
    * @param lang выбранный язык
    * @return объект отображения
    * @throws IllegalArgumentException если выбран неподдерживаемый язык
    */
   public static iGetView view(String lang) {
      iGetView view;
      if (lang.equals("RUS")) {
         view = new View();
      } else if (lang.equals("ENG")) {
         view = new ViewEng();
      } else {
         throw new IllegalArgumentException("Неподдерживаемый язык!");
      }
      return view;
   }
   /**
    * Точка входа в приложение.
    * @param args аргументы командной строки
    * @throws Exception если возникла ошибка
    */
   public static void main(String[] args) throws Exception {
      System.out.printf("Выберите язык, RUS/ENG: ");
      String lang = in.nextLine().toUpperCase();

      ModelHashMap studentsHash = new ModelHashMap();
      studentsHash.addStudent("Сергей", "Иванов", 22, (long) 101);
      studentsHash.addStudent("Андрей", "Сидоров", 22, (long) 111);
      studentsHash.addStudent("Иван", "Петров", 22, (long) 121);
      studentsHash.addStudent("Игорь", "Иванов", 23, (long) 301);
      studentsHash.addStudent("Даша", "Цветкова", 23, (long) 171);
      studentsHash.addStudent("Лена", "Незабудкина", 23, (long) 104);

      List<Student> studentsList = new ArrayList<Student>(Arrays.asList(
            new Student("Сергей", "Иванов", 22, (long) 101),
            new Student("Андрей", "Сидоров", 22, (long) 111),
            new Student("Иван", "Петров", 22, (long) 121),
            new Student("Игорь", "Иванов", 23, (long) 301),
            new Student("Даша", "Цветкова", 23, (long) 171),
            new Student("Арина", "Будкина", 23, (long) 194)));

      FileRepo fileRepo = new FileRepo("StudentDb.txt");
      for (Student person : studentsList) {
         fileRepo.addStudent(person);
      }
      fileRepo.saveAllStudentsToFile();

      iGetView view = view(lang);
      iGetModel modelHashMap = studentsHash;
      iGetModel modelList = new Model(studentsList);
      iGetModel modelFileRepo = fileRepo;
      
      Controller control = new Controller(view, modelHashMap, lang);
      control.run();
   }
}