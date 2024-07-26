package people;

public class Person {
    protected String id;
    protected String name;
    protected int[] birthday;
    protected String gender;

    public Person(){
        this.id = "unknown";
        this.name = "unknown";
        this.birthday = new int[]{9999, 9999, 9999};
        this.gender = "unknown";
    }

    public Person(String id, String name, int[] birthday, String gender){
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int[] getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String toString() {
        String str = "ID=" + id +
                ", Name=" + name +
                ", Birthday=" + birthday[0] + "/" + birthday[1] + "/" + birthday[1] +
                ", Gender=" + gender;
        return str;
    }
}
