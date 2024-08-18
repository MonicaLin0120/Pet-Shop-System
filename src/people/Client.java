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

    public Client(String id, String name, int[] birthday, Gender gender) {
        super(id, name, birthday, gender);
        balance = (int)(1000000.0 * Math.random());
        petList = new ArrayList<>();
    }

    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        else {
            System.out.println(getName() + "存款不足！");
            return false;
        }
    }

    public void addPet(Animal newPet) {
        petList.add(newPet);
    }

    @Override
    public String toString() {
        String str = "";
        str += super.toString() + ", balance = " + balance + "\n";

        for (int i = 0; i < petList.size(); i++) {
            str += "Pet " + (i + 1) + " is { " + "}" + petList.get(i).toString() + "}";
        }

        return str;
    }


}
