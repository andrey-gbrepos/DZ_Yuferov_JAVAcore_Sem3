
import java.util.List;

/**
 * Базовый абстрактный класс "Сотрудники"
 */
public abstract class Employees implements Comparable <Employees> {
    /**
     * id Сотрудника
     */
    protected Integer idEmploye;
    /**
     * Имя сотрудника
     */
    protected String nameEmploye;
    /**
     * Тип занятости, например  Freelancer или Worker
     */
    protected String typeSalary;
    /**
     * Зарплата сотрудника
     */
    protected Double salaryEmploye;
    /**
     * Список  сотрудников (объектов Employees)
     */
    protected List <Employees> listEmployees;

        /**
         * Абстрактный метод для расчета среденемесячной зарплаты
         */
        public abstract Double averMonthSalary();
    /**
     * Форматированный вывод списка Employees
     * @param employList
     */
    public static void printEmployList(List<Employees> employList){
        System.out.printf("\n %10s \t %10s \t %10s \t %10s \n" , "id", "Name", "Employer_type", "Salary");
        System.out.printf("%10s","---------------------------------------------------------------");
        for (Employees item : employList) {
            System.out.print(item);
        }
    }

        /**
        * Переопределение toString для объектов Employees
        */
        @Override
        public String toString(){
            return String.format("\n %10d \t %10s \t %10s \t %10.2f", idEmploye, nameEmploye, typeSalary, salaryEmploye);
        }

    @Override
    public int compareTo(Employees employ){
        if (this.salaryEmploye > employ.salaryEmploye)
            return 1;
        else if (this.salaryEmploye < employ.salaryEmploye)
            return -1;
        else
            return 0;
    }
        // getters and setters
        public String getTypeSalary() {
            return typeSalary;
        }
        public void setTypeSalary(String typeSalary) {
            this.typeSalary = typeSalary;
        }
        public Integer getIdEmploye() {
            return idEmploye;
        }
        public void setIdEmploye(Integer idEmploye) {
            this.idEmploye = idEmploye;
        }
        public String getNameEmploye() {
            return nameEmploye;
        }
        public void setNameEmploye(String name) {
            this.nameEmploye = name;
        }
        public Double getSalaryEmploye() {
            return salaryEmploye;
        }
        public void setSalaryEmploye(Double salaryEmploye) {
            this.salaryEmploye = salaryEmploye;
        }
}
