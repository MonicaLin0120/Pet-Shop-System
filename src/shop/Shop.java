package shop;

import people.*;

import java.util.Scanner;
import java.util.ArrayList;
public abstract class Shop {
    protected Manager manager;
    protected ArrayList<Staff> staffList;
    protected Scanner scanner;

    public Shop(Manager manager) {
        this.manager = manager;
        staffList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }


    protected Person createPerson() {
        //todo 具體功能
        System.out.print("輸入ID: ");
        String id = scanner.next();

        System.out.print("輸入姓名: ");
        String name = scanner.next();

        int year;
        while(true) {
            System.out.print("輸入出生年: ");
            year = scanner.nextInt();
            if(year >= 1900 && year <= 2100)
                break;
            else
                System.out.println("輸入錯誤，請輸入合理的年份(1900到2100)。");
        }

        int month;
        while(true) {
            System.out.print("請輸入出生月: ");
            month = scanner.nextInt();
            if(month >= 1 && month <= 12)
                break;
            else
                System.out.println("輸入錯誤，請輸入合理月份(1到12)");
        }

        int day;
        while(true) {
            System.out.print("請輸入出生日: ");
            day = scanner.nextInt();
            if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
                if (day >= 1 && day <= 31)
                    break;
            }
            else if (month == 4 || month == 6 || month == 9 || month == 11){
                if (day >= 1 && day <= 30)
                    break;
            }
            else if (month == 2){
                if (year % 4 == 0 && year >= 1 && year <= 29)
                    break;
                else if(year % 4 != 0 && day >= 1 && day <= 28)
                    break;

            }

            System.out.println("輸入錯誤，請輸入合理日期");
        }

        Gender gender;
        while (true) {
            System.out.print("輸入性別: ");
            String gender_str = scanner.next();
            if (gender_str.equalsIgnoreCase("Female") || gender_str.equalsIgnoreCase("F")) {
                gender = Gender.Female;
                break;
            }
            else if (gender_str.equalsIgnoreCase("Male") || gender_str.equalsIgnoreCase("M")) {
                gender = Gender.Male;
                break;
            }
            else {
                System.out.println("輸入錯誤，請輸入合理性別(Female 或 F 或 Male 或 M)。");
            }
        }


        return new Person(id, name, new int[]{year, month, day}, gender);
    }

    protected Staff createStaff() {
        Person person = createPerson();
        return new Staff(person.getID(), person.getName(), person.getBirthday(), person.getGender());
    }

    protected Client createClient() {
        Person person = createPerson();
        return new Client(person.getID(), person.getName(), person.getBirthday(), person.getGender());
    }

    public boolean addStaff(Staff staff) {
        // todo 檢查員工身份

        staffList.add(staff);

        return true;
    }

    public boolean addStaff() {
        return addStaff(createStaff());
    }

    public boolean deleteStaff(String id) {
        for (int i = 0; i < staffList.size(); i++) {
            if (id.equals(staffList.get(i).getID())) {
                staffList.remove(i);
                return true;
            }
        }

        System.out.println("員工名冊沒有對應ID! 刪除員工失敗!");
        return false;
    }
    public abstract void runSystem();

    public String toString() {
        String str = "";

        str += "Manager is " + manager.toString() + "\n";

        for (int i = 0; i < staffList.size(); i++) {
            str += "Staff " + (i + 1) + " is " + staffList.get(i).toString() + "\n";
        }
        return str;
    }

}
