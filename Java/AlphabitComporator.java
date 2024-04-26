import java.util.Comparator;


public class AlphabitComporator implements Comparator<Employees> {
    @Override
    public int compare(Employees emp1, Employees emp2){
        return Integer.compare (emp1.getNameEmploye().charAt(0),
                                emp2.getNameEmploye().charAt(0));
    }
}
