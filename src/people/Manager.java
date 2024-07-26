package people;
import java.util.Scanner;
public class Manager extends Person {
    private double stockPercentage;
    public Manager(){
        super();
        stockPercentage = 0;
    }

    public Manager(String id, String name, int[] birthday, String gender) {
        super(id,name,birthday,gender);
        stockPercentage = 100.0;
    }

    @Override
    public String toString() {
        return super.toString(); // todo 選擇性再印出stockPercentage
    }


}
