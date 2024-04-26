

import java.util.Collections;
import java.util.List;

class Program {
   public static void main(String[] args) {
     // Создание и заполнение  списка  Сотрудники, вывод его на печать
     Services service = new Services();
     List<Employees> listEmployees;
     listEmployees = service.createEmployList();
     System.out.printf("\n %s", "Форматированный вывод всего списка");
     Employees.printEmployList(listEmployees);
     // Сортировка по алфавиту (по первой букве) с помощью компаратора
     // реализованного в классе AlphabitComporator и вывод на печеть
     System.out.printf("\n %s", "Сортировка по алфавиту (Comparator)");
     Employees.printEmployList(service.sortWithAlphabit(listEmployees));
     // Сортировка по заработной плате с использованием интерфейса Comparable
     // и метода Коллекции sort() и вывод на печать.
     Collections.sort(listEmployees);
     System.out.printf("\n %s", "Сортировка по зарплате (Comparable)");
     Employees.printEmployList(listEmployees);
     // Реализация цикла For Each для объектов класса Employees, Freelancer, Worker
     EmployIterator iter = new EmployIterator();
     // Формирование списков объектов классов Freelancer и Worker
     iter.listFreelancer = Freelancer.getListFreelance(listEmployees);
     iter.listWorker = Worker.getListWorkers(listEmployees);
     System.out.printf("\n %s", "Вывод через цикл For Each списка Worker");
     for(Worker item: iter.listWorker){
       System.out.print(item);
     }
     System.out.printf("\n %s", "Вывод через цикл For Each списка Freelancer");
     for(Freelancer item: iter.listFreelancer){
       System.out.print(item);
     }
   }
}
