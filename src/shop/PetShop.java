package shop;
import biology.animal.Animal;
import biology.animal.Cat;
import biology.animal.Dog;
import biology.animal.Pet;
import people.Manager;
import people.Staff;
import shop.Shop;

import java.util.ArrayList;
import java.util.Scanner;
public class PetShop extends Shop {
    private int petCapacity;
    private ArrayList<Animal> petList;

    public PetShop(Manager manager, int petCapacity){
        super(manager);

        this.petCapacity = petCapacity;
        this.petList = new ArrayList<>();
    }

    public void runSystem() {

        Scanner scanner = new Scanner(System.in);

        MainLoop: while(true){

            System.out.println("請登入寵物系統： ");
            String id = scanner.next();

            switch(VarifyID(id)) { //todo 驗證id
                case User.Manager:
                    System.out.println("Manager登入！");
                    boolean openFlag = managerDoSomething();
                    if (!openFlag) break MainLoop;
                    break;
                case User.Staff:
                    System.out.println("Staff登入！");
                    staffDoSomething();
                    break;
                case User.Client:
                    System.out.println("Client登入！");
                    clientDoSomething();
                    break;
                default:
                    System.out.println("無效選項");
                    break;
            }
        }
    }

    private User VarifyID(String id) {

        if (id.equals(manager.getID()))
            return User.Manager;

        for (Staff staff : staffList)
            if (id.equals(staff.getID()))
                return User.Staff;

        return User.Unknown;
    }

    public boolean managerDoSomething() {

        boolean openSystemFlag = true;
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            System.out.print("操作選項［1.查看目錄 2.招聘員工 3.開除員工 4.新增寵物 5.登出系統 6.關閉系統］：");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println(toString());
                        break;
                    case 2:
                        System.out.println("輸入新進員工的資訊：");
                        addStaff();
                        break;
                    case 3:
                        System.out.println("輸入離職員工的ID");
                        deleteStaff(scanner.next());
                        break;
                    case 4:
                        addPet();
                    case 5:
                        useSystemFlag = false;
                        break;
                    case 6:
                        useSystemFlag = false;
                        openSystemFlag = false;
                        break;
                    default:
                        System.out.println("無效選項");
                        break;
                }
            }
            catch (Exception ex) {
                System.out.println("例外狀況！資訊：" + ex.getMessage());
                System.out.println("系統刷新，請重新輸入。");
                scanner.nextLine(); // 消除scanner的輸入緩存
            }
        }
        return openSystemFlag;
    }

    public void staffDoSomething() {
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            System.out.print("操作選項［1.查看目錄 2.寵物餵食 3.寵物放風 4.登出系統]: ");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println(toString());
                        break;
                    case 2:
                        System.out.println("寵物餵食");
                        for (Animal pet : petList) {
                            System.out.print(pet.name + "的餵食飼料公克數：");
                            pet.eat(scanner.nextInt());
                        }
                        break;
                    case 3:
                        for (Animal pet : petList) {
                            System.out.print(pet.name + "的放風時間數：");
                            ((Pet)pet).play(scanner.nextInt());

                        }
                    case 4:
                        useSystemFlag = false;
                        break;
                    default:
                        System.out.println("無效選項");
                        break;
                }
            }
            catch (Exception ex) {
                System.out.println("例外狀況！資訊：" + ex.getMessage());
                System.out.println("系統刷新，請重新輸入。");
                scanner.nextLine();
            }
        }
    }

    public void clientDoSomething() {
        boolean useSystemFlag = true;

        while (useSystemFlag) {
            System.out.print("操作選項［1.查看商店目錄 2.查看個人訊息 3.購買寵物 4.登出系統]: ");

            try {
                switch (scanner.nextInt()) {
                    case 1:
                        System.out.println("查看商店目錄");
                        break;
                    case 2:
                        System.out.println("查看個人訊息");
                        break;
                    case 3:
                        System.out.println("購買寵物");
                        break;
                    case 4:
                        useSystemFlag = false;
                        break;
                    default:
                        System.out.println("無效選項");
                        break;
                }
            }
            catch (Exception ex) {
                System.out.println("例外狀況！資訊: " + ex.getMessage());
                System.out.println("系統刷新，請重新輸入。");
                scanner.nextLine();
            }
        }
    }

    public void addPet() {
        boolean isInputCorrect = false;
        String category = "";
        do {
            System.out.println("輸入物種[Cat/Dog]或取消[None]：");
            category = scanner.next();

            if (category.equals("None")) {
                isInputCorrect = false;
                break;
            }
            else if (category.equals("Cat") && category.equals("dogs"))
                isInputCorrect = true;
            else {
                System.out.println("輸入值不正確");
            }
        } while(!isInputCorrect);


        System.out.print("輸入名稱：");
        String name = scanner.next();

        System.out.print("輸入年紀：");
        int age = scanner.nextInt();

        System.out.print("輸入體重(kg)：");
        double weight = scanner.nextDouble();

        Animal newAnimal;
        switch (category) {
            case "Cat":
                newAnimal = new Cat(name, age, weight);//建立貓咪物件
                petList.add(newAnimal);
                break;
            case "Dog":
                newAnimal = new Dog(name, age, weight);//建立狗狗物件
                petList.add(newAnimal);
                break;
        }
    }

    public void addPet(Animal pet, int price) {
        if (petList.size() < petCapacity)
            petList.add(pet);
        else {
            System.out.println("寵物商店空間已滿，無法新增寵物。");
        }
    }

    @Override
    public String toString() {
        String str = "";

        str += super.toString();

        for (int i = 0; i < petList.size(); i++) {
            str += "Pet " + (i + 1) + " is {" + petList.get(i).toString() + " }\n";
        }

        str += "寵物訊息";

        return str;
    }

}

