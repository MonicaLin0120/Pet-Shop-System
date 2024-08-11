package people;

import biology.animal.Animal;

import java.util.ArrayList;

public class Client extends Person {

    private int balance;
    private ArrayList<Animal> petList;

    public Client(){
        super();
        balance = 0;
        petList = new ArrayList<>();
    }

    public Client(String id, String name, int[] birthday, String gender) {
        super(id, name, birthday, gender);
        balance = (int)(1000000.0 * Math.random());
        petList = new ArrayList<>();
    }

    @Override
    public String toString() {
        //todo 選擇性再印出petList跟balance
        return super.toString();
    }


}
