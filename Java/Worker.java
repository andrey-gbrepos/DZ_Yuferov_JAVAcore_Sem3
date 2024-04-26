import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Worker extends Employees {

    Random random = new Random();

    /**
     * Создает список Worker из общего списка
     * @param employ
     * @return
     */
    public static List<Worker> getListWorkers(List<Employees> employ){
       List<Worker> workers = new ArrayList<>();
        for (int i = 0; i < employ.size(); i++) {
            if (employ.get(i).getTypeSalary() == "Worker")
               workers.add((Worker) employ.get(i));
        }
        return workers;
    }

    /**
     * Переопределение абстрактной функции базового класса для Worker
     * @return
     */
    @Override
    public Double averMonthSalary() {
        return random.nextDouble(30000.0, 80000.0);
    }

}

