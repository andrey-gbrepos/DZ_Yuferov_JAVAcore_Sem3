import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Вспомогательный класс для создания списка сотрудников
 */
public class Services {
    private final Random random = new Random();

    /**
     * Создает список работников на основе базового абстрактного класса Employees
     */
    public  List<Employees> createEmployList () {
        String[] typeRate = new String[]{"Freelancer", "Worker"};
        String[] names = new String[]
                {"Artur", "Adel", "Bruno", "Bella", "Henry", "Inga", "Marta",
                        "Martin", "Jek", "Maik", "Oskar", "Timur", "Felix", "German"};
        List <Employees> listEmployees = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
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
    }
    public  List<Employees> sortWithAlphabit (List <Employees> employ){
        List <Employees> empl = employ;
        empl.sort(new AlphabitComporator());
        return empl;
    }
}
