package RainingCatsAndDogs;

import java.util.Date;

abstract public class Pet {
    private String name;
    private int age;
    private Date timestamp;
    private String type;

    public Pet(String name, int age, String type) {
        this.name = name;
        this.age = age;
        this.timestamp = new Date();
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Type: " + type + ", Timestamp: " + timestamp;
    }
}