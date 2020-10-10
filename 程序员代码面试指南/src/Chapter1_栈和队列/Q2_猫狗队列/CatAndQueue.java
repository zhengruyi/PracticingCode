package Chapter1_栈和队列.Q2_猫狗队列;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author Ruyi ZHENG
 * @version 1.00
 * @time 24/05/2020 22:08
 **/

public class CatAndQueue {
    private LinkedBlockingDeque <Animal> dogQueue;
    private LinkedBlockingDeque <Animal> catQueue;
    final String dog = "dog";
    final String cat = "cat";
    CatAndQueue cq;

    public CatAndQueue() {
        this.dogQueue = new LinkedBlockingDeque <>();
        this.catQueue = new LinkedBlockingDeque <>();
    }

    public void add(Pet pet) {
        Animal animal = new Animal(pet);
        if (pet.getType().equals(dog)) {
            dogQueue.add(animal);
        } else {
            catQueue.add(animal);
        }
    }

    public Pet pollAll() {
        Pet pet;
        if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {

            if (dogQueue.peek().getTimestamp() < catQueue.peek().getTimestamp()) {
                pet = dogQueue.poll().getPet();
            } else {
                pet = catQueue.poll().getPet();
            }
        } else if (!dogQueue.isEmpty()) {
            pet = dogQueue.poll().getPet();
        } else {
            pet = catQueue.poll().getPet();
        }
        return pet;
    }

    public Pet pollDog() {
        if (!dogQueue.isEmpty()) {
            return dogQueue.poll().getPet();
        }
        return null;
    }

    public Pet pollCat() {
        if (!catQueue.isEmpty()) {
            return catQueue.poll().getPet();
        }
        return null;
    }

    public boolean isEmpty() {
        return dogQueue.isEmpty() && catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty() {
        return catQueue.isEmpty();
    }

    @BeforeEach
    void setup(){
        cq = new CatAndQueue();
        Pet dog = new Dog();
        Pet dog1 = new Dog();
        Pet cat = new Cat();
        Pet cat1 = new Cat();
        cq.add(dog);
        cq.add(cat);
        cq.add(cat1);
        cq.add(dog1);
    }

    @Test
    @DisplayName("Poll All Test")
    void pollAllTest() {
        Assertions.assertEquals(dog,cq.pollAll().getType());
        Assertions.assertEquals(cat,cq.pollAll().getType());
        Assertions.assertEquals(cat,cq.pollAll().getType());
        Assertions.assertEquals(dog,cq.pollAll().getType());
    }
    @Test
    @DisplayName("Dog Queue Test")
    void pollDogQueueTest(){
        cq.pollDog();
        cq.pollDog();
        Assertions.assertTrue(cq.isDogEmpty());
    }



}

class Animal {
    private static long count = 1;
    private long timestamp;
    private Pet pet;

    public Animal(Pet pet) {
        this.pet = pet;
        this.timestamp = count;
        count++;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public Pet getPet() {
        return pet;
    }
}
