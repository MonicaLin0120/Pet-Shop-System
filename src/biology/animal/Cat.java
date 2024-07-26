package biology.animal;

import biology.animal.Pet;
public class Cat extends Mammal implements Pet {
    public static String species = "貓科動物";

    public Cat(){
        super();
    }
    public Cat(String _name, int _age, double _weight) {
        super(_name, _age, _weight);
    }

    public void eat(int gram) {
        if (gram> 500)
            weight +=0.1;
    }

    public void play(int min) {
        if (min > 90)
            weight -= 0.1;
    }

    @Override
    public String toString() {
        return "Category=Cat, " + super.toString();
    }
}