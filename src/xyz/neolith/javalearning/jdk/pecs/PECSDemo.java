package xyz.neolith.javalearning.jdk.pecs;

import java.util.ArrayList;
import java.util.List;

/**
 * producer extends consumer super
 * produce provider the data
 * extends ? extends T : Upper Bounds Wildcards
 * consumer store the data
 * super ? super T :  Lower Bounds Wildcards
 *
 * @author sunlggggg
 * @date 2018/3/28
 */

public class PECSDemo {

    public static void main(String[] args) {
        List<Mammal> ListMammal = new ArrayList<>();
        ListMammal.add(new Mammal());
        List<? extends Animal> listAnimal1 = ListMammal;
        System.out.println(listAnimal1.get(0));

        List<HelloKitty> ListHelloKitty = new ArrayList<>();
        ListHelloKitty.add(new HelloKitty());
        List<? extends Animal> listAnimal2 = ListHelloKitty;
        System.out.println(listAnimal2.get(0));

        List<? super Mammal > listAnimal3 = new ArrayList<>();
        // listAnimal3.add(new Animal()); error
        listAnimal3.add(new HelloKitty());
        listAnimal3.add(new Mammal());
        Mammal animal = (Mammal) listAnimal3.get(0);
        System.out.println(animal);
        animal = (Mammal) listAnimal3.get(1);
        System.out.println(animal);
    }
}
