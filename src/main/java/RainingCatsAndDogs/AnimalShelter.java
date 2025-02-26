package RainingCatsAndDogs;

import java.util.LinkedList;
import java.util.Queue;

/**

 * An Animal shelter, which holds only dogs and cats, operates on a strictly "first in, first out" bases.
 * People must adopt either the "oldest" (based on arrival time) of  all animals at the shelter, or they can select
 *  whether they would prefer a dog or cat (and will receive the oldest animal of that type).
 *  They cannot select which specific animal they would like.
 *  Create a datastucture to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog and DequeueCat.
 */

public class AnimalShelter {
    private final Queue<Dog> dogQueue;
    private final Queue<Cat> catQueue;

    public AnimalShelter() {
        dogQueue = new LinkedList<>();
        catQueue = new LinkedList<>();
    }

    public void enqueue(Pet pet) {
        if (pet instanceof Dog) {
            dogQueue.add((Dog) pet);
        } else if (pet instanceof Cat) {
            catQueue.add((Cat) pet);
        } else {
            throw new IllegalArgumentException("Shelter only accepts Dogs and Cats.");
        }
    }

    public Pet dequeueAny() {
        if (dogQueue.isEmpty() && catQueue.isEmpty()) {
            return null;
        } else if (dogQueue.isEmpty()) {
            return catQueue.poll();
        } else if (catQueue.isEmpty()) {
            return dogQueue.poll();
        } else {
            Dog nextDog = dogQueue.peek();
            Cat nextCat = catQueue.peek();
            if (nextDog == null || nextCat == null) {
                return null;
            }
            return (nextDog.getTimestamp().before(nextCat.getTimestamp()))
                    ? dogQueue.poll()
                    : catQueue.poll();
        }
    }

    public Dog dequeueDog() {
        return dogQueue.poll();
    }

    public Cat dequeueCat() {
        return catQueue.poll();
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }
}