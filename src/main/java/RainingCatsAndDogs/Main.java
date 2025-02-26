package RainingCatsAndDogs;

public class Main {
    public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();

        shelter.enqueue(new Dog("Brandon", 3, "Labrador"));
        shelter.enqueue(new Cat("Adam", 2, "Siamese"));
        shelter.enqueue(new Dog("Brian", 4, "Beagle"));
        shelter.enqueue(new Cat("Kyle", 1, "Persian"));

        System.out.println("Shelter is empty: " + shelter.isEmpty());

        System.out.println("Adopted: " + shelter.dequeueAny());

        System.out.println("Adopted: " + shelter.dequeueCat());

        System.out.println("Adopted: " + shelter.dequeueDog());

        System.out.println("Adopted: " + shelter.dequeueAny());

        System.out.println("Adopted: " + shelter.dequeueAny());

        System.out.println("Shelter is empty: " + shelter.isEmpty());
    }
}

