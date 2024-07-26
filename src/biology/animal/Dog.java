package biology.animal;

import biology.animal.Pet;
public class Dog extends Mammal implements Pet {
    public static String species = "犬科動物";

    public Dog(){
        super();
    }
    public Dog(String _name, int _age, double _weight) { super(_name, _age, _weight);}

    public void eat(int gram) {
        if (gram > 1000)
            weight += 0.2;
    }
    public void play(int min) {
        if (min > 60)
            weight -= 0.1;
    }

    @Override
    public String toString() {
        return "Category=Dog, " + super.toString();
    }
}
