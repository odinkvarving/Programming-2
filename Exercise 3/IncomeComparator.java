import java.util.Comparator;

public class IncomeComparator implements Comparator<Tribune>{
    public int compare(Tribune a, Tribune b){
        return a.findIncome() - b.findIncome();
    }
}
