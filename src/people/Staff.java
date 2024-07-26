package people;

import static java.lang.Math.*;
public class Staff extends Person {
    private int salary;
    public Staff(){
        super();
        salary = 0;
    }

    public Staff(String id, String name, int[] birthday, String gender) {
        super(id, name, birthday, gender);
        salary = 40000 + (int)(20000.0 * Math.random()); //薪水區間40000~60000，Math.random()隨機給值0.0~1.0
    }

    public Staff(String id, String name, int[] birthday, String gender, int salary) {
        super(id,name,birthday,gender);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString(); // todo 選擇性再印出salary
    }
}