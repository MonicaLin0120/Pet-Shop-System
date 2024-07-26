package biology.animal;

import java.util.Scanner;
public abstract class Animal {
    String name;

    public int age;

    public double weight;

    public Animal () {
        name = "unknown";
        age = 0;
        weight = 0;
    }

    public Animal(String _name, int _age, double _weight) {
        name = _name;
        age = _age;
        weight = _weight;
    }

    public abstract void eat(int gram);

    private void userInputVariable() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入名稱：");
        name = scanner.next();

        System.out.print("輸入年紀：");
        age = scanner.nextInt();

        System.out.print("輸入體重(kg)：");
        weight = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Age=" + age + ", Weight=" + weight;
    }
}
