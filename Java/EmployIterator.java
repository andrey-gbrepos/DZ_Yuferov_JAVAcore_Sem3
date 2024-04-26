import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

