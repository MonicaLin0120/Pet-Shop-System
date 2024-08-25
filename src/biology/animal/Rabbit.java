package biology.animal;

public class Rabbit extends Mammal implements Pet {

    public Rabbit() {
        super();
    }

    public Rabbit (String _name, int _age, double _weight) {
        super(_name, _age, _weight);
    }

    public void eat(int gram) {
        if (gram> 200)
            weight += 0.1;
    }

    public void play(int min) {
        if (min > 30)
            weight -= 0.1;
    }

    @Override
    public String toString() {
        return "Category=Rabbit, " + super.toString();
    }
}

