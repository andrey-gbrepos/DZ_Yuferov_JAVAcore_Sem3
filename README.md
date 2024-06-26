# DZ_Yuferov_JAVAcore_Sem3
# Задание 1
## Построить три класса (базовый и 2 потомка), описывающих некоторых работников с почасовой оплатой (один из потомков - Freelancer) и фиксированной оплатой (второй потомок -Worker).

Построена иерархическая структура: Базовый абстрактный класс **Employees**
и два дочерних класса: 
- **Worker** - работники с фиксированной заработной платой и 
- **Freelancer** - работники с почасовой оплатой.

В базовом классе переопределен метод toString() для корректного отображения полей класса **Employees** и его дочерних классов.
Кроме того здесь реализован метод для форматированного вывод всего списка
```
@Override
        public String toString(){
            return String.format("\n %10d \t %10s \t %10s \t %10.2f", idEmploye, nameEmploye, typeSalary, salaryEmploye);
        }
```
а так же метод **printEmployList** для форматированного вывод всего списка
```
public static void printEmployList(List<Employees> employList){
        System.out.printf("\n %10s \t %10s \t %10s \t %10s \n" , "id", "Name", "Employer_type", "Salary");
        System.out.printf("%10s","---------------------------------------------------------------");
        for (Employees item : employList) {
            System.out.print(item);
        }
    }
```
Для формирования списка **Worker** и **Freelancer** из общего списка **Employees** в каждом из дочерних классов реализован соотвтетсвующий метод:

**public static List<Freelancer> getListFreelance(List<Employees> employ){...**

**public static List<Worker> getListWorkers(List<Employees> employ){...**
## а) Описать в базовом классе абстрактный метод для расчёта среднемесячной заработной платы.
## Для «повременщиков» формула для расчета такова: 
**"среднемесячная заработная плата"**  =  20.8  *  8  *  **"почасовая ставка"**, 

## для работников с фиксированной оплатой:

**"среднемесячная заработная плата"**  =  **"фиксированная месячная оплата"**

В основном классе **Employees** создан абстрактный метод averMonthSalary():
```
        /**
         * Абстрактный метод для расчета среденемесячной зарплаты
         */
        public abstract Double averMonthSalary();
```
В классе **Worker** этот метод переопределен следеующим образом:
```
@Override
    public Double averMonthSalary() {
        return random.nextDouble(30000.0, 80000.0);
    }
```
В классе **Freelancer** согласно формуле:
```
@Override
    public Double averMonthSalary() {
        setHourInDay(8);
        setCountDay(20.8);
        setRubInhour(random.nextDouble(250.0,450.0));
        return rubInhour * getCountDay() * getHourInDay();
    }
```
## б) Создать на базе абстрактного класса массив/коллекцию сотрудников и заполнить его.

Для формирования списка создан вспомогательный класс **Services**. Список генерируется при помощи генератора псевдослучайных чисел класса **Random**. Список содержит элементы класса **Employees**.

```
List <Employees> listEmployees = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            Employees employF = new Freelancer();
            Employees employW = new Worker();
            int tempIndex;
            tempIndex = random.nextInt(typeRate.length);
            if (typeRate[tempIndex] == "Freelancer") {
                employF.setIdEmploye(i+1);
                employF.setNameEmploye(names[random.nextInt(names.length)]);
                employF.setTypeSalary(typeRate[tempIndex]);
                employF.setSalaryEmploye(employF.averMonthSalary());
                listEmployees.add(employF);
            }
            if (typeRate[tempIndex] == "Worker") {
                employW.setIdEmploye(i + 1);
                employW.setNameEmploye(names[random.nextInt(names.length)]);
                employW.setTypeSalary(typeRate[tempIndex]);
                employW.setSalaryEmploye(employW.averMonthSalary());
                listEmployees.add(employW);
            }
        }
        return listEmployees;
```
## в) ** Реализовать интерфейсы для возможности сортировки массива/коллекции (обратите ваше внимание на интерфейсы Comparator, Comparable), добавьте новое состояние на уровне базового типа и создайте свой уникальный компаратор.

В базовый класс **Employees** имплементирован интерфейс **Comparable**:
```
public abstract class Employees implements Comparable <Employees> {...
```
Здесь же переопределен метод **compareTo** интерфейса Comparable относительно величины зарплат сотрудников:
```
@Override
    public int compareTo(Employees employ){
        if (this.salaryEmploye > employ.salaryEmploye)
            return 1;
        else if (this.salaryEmploye < employ.salaryEmploye)
            return -1;
        else
            return 0;
    }
```
Сортировка реализована с помощью вызова метода Коллекции **sort()**:
**Collections.sort(listEmployees);**

Для имплементации интерфейса Comparator создан отдельный класс **AlphabitComporator**. В нем переопределен метод **compare**. Сравнение идет по первым буквам имен сотрудников:
```
public class AlphabitComporator implements Comparator<Employees> {
    @Override
    public int compare(Employees emp1, Employees emp2){
        return Integer.compare (emp1.getNameEmploye().charAt(0),
                                emp2.getNameEmploye().charAt(0));
    }
}
```
Сам же метод сортировки реализован в классе **Service**:
```
public  List<Employees> sortWithAlphabit (List <Employees> employ){
        List <Employees> empl = employ;
        empl.sort(new AlphabitComporator());
        return empl;
    }
```
## г) ** Создать класс, содержащий массив или коллекцию сотрудников (как Worker так и Freelancer), и реализовать возможность вывода данных с использованием foreach (подсказка: вам потребуется поработать с интерфейсом Iterable).

Создан отдельный класс **EmployIterator** в который имплементирован интерфейс Iterable. Внутри самого класса переопределены методы **hasNext()** и **next()** интерфейса **Iterator**. Кроме того в этом классе инициализированы три списка для **Employees**, **Worker**  и **Freelancer**.
```
public class EmployIterator implements Iterable<Employees> {
List<Employees> listEmploye = new ArrayList<>();
List<Freelancer> listFreelancer = new ArrayList();
List<Worker> listWorker = new ArrayList<>();
    @Override
    public Iterator<Employees> iterator() {
        Iterator <Employees> iterat = new Iterator<Employees>(){
            int index;
            /**
             * Переопределенный метод hasNext() для Employees
             * @return
             */
            @Override
            public boolean hasNext(){
                return index < listEmploye.size();
            }
            /**
             * Переопределенный метод Next() для Employees
             * @return Employees
             */
            @Override
            public Employees next() {
                return listEmploye.get(index);
            }
        };
        return iterat;
    }
}
```

Таким образом результат выполнения клиентского кода выглядит следущим образом:
```
Форматированный вывод всего списка
         id            Name      Employer_type       Salary
---------------------------------------------------------------
          1          Martin          Worker        51623,51
          2            Adel      Freelancer        63297,57
          3            Inga          Worker        54639,37
          4           Timur      Freelancer        47838,27
          5          Martin      Freelancer        62905,58
          6            Inga          Worker        74896,95
          7          Martin      Freelancer        41851,96
          8           Timur      Freelancer        52130,36
          9           Marta      Freelancer        47729,17
         10           Felix      Freelancer        70483,18
         11            Inga          Worker        60316,42
         12           Henry          Worker        58669,53
 Сортировка по алфавиту (Comparator)
         id            Name      Employer_type       Salary
---------------------------------------------------------------
          2            Adel      Freelancer        63297,57
         10           Felix      Freelancer        70483,18
         12           Henry          Worker        58669,53
          3            Inga          Worker        54639,37
          6            Inga          Worker        74896,95
         11            Inga          Worker        60316,42
          1          Martin          Worker        51623,51
          5          Martin      Freelancer        62905,58
          7          Martin      Freelancer        41851,96
          9           Marta      Freelancer        47729,17
          4           Timur      Freelancer        47838,27
          8           Timur      Freelancer        52130,36
 Сортировка по зарплате (Comparable)
         id            Name      Employer_type       Salary
---------------------------------------------------------------
          7          Martin      Freelancer        41851,96
          9           Marta      Freelancer        47729,17
          4           Timur      Freelancer        47838,27
          1          Martin          Worker        51623,51
          8           Timur      Freelancer        52130,36
          3            Inga          Worker        54639,37
         12           Henry          Worker        58669,53
         11            Inga          Worker        60316,42
          5          Martin      Freelancer        62905,58
          2            Adel      Freelancer        63297,57
         10           Felix      Freelancer        70483,18
          6            Inga          Worker        74896,95
 Вывод через цикл For Each списка Worker
          1          Martin          Worker        51623,51
          3            Inga          Worker        54639,37
         12           Henry          Worker        58669,53
         11            Inga          Worker        60316,42
          6            Inga          Worker        74896,95
 Вывод через цикл For Each списка Freelancer
          7          Martin      Freelancer        41851,96
          9           Marta      Freelancer        47729,17
          4           Timur      Freelancer        47838,27
          8           Timur      Freelancer        52130,36
          5          Martin      Freelancer        62905,58
          2            Adel      Freelancer        63297,57
         10           Felix      Freelancer        70483,18
```