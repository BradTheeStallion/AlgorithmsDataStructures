package RainingCatsAndDogs;

public class Cat extends Pet {
    private String breed;

    public Cat(String name, int age, String breed) {
        super(name, age, "Cat");
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
