package biology.animal;

import biology.animal.Animal;

public abstract class Mammal extends Animal {
    public Mammal(){ super(); }
    public Mammal(String _name, int _age, double _weight) {
        super(_name, _age, _weight);
    }

    public abstract void eat(int gram);

    @Override
    public String toString() {
        return super.toString();
    }
}
