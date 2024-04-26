import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Freelancer extends Employees{
    Integer hourInDay;
    Double countDay ;
    Double rubInhour;


    Random random = new Random();

    /**
     * Создает список Freelancer из общего списка
     * @param employ
     * @return
     */
    public static List<Freelancer> getListFreelance(List<Employees> employ){
        List <Freelancer> listFreelance = new ArrayList<>();
        for (int i = 0; i < employ.size(); i++) {
            if (employ.get(i).getTypeSalary() == "Freelancer")
                listFreelance.add((Freelancer) employ.get(i));
        }
        return listFreelance;
    }
    /**
     * Переопределение абстрактной функции базового класса для Freelancer
     * @return посчитанная зарплата в Double
     */
    @Override
    public Double averMonthSalary() {
        setHourInDay(8);
        setCountDay(20.8);
        setRubInhour(random.nextDouble(250.0,450.0));
        return rubInhour * getCountDay() * getHourInDay();
    }

    // getters and setters
    public Integer getHourInDay() {
        return hourInDay;
    }
    public void setHourInDay(Integer hourInDay) {
        this.hourInDay = hourInDay;
    }
    public Double getCountDay() {
        return countDay;
    }
    public void setCountDay(Double countDay) {
        this.countDay = countDay;
    }
    public Double getRubInhour() {
        return rubInhour;
    }
    public void setRubInhour(Double rubInhour) {
        this.rubInhour = rubInhour;
    }
}
