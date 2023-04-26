import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainClass {

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cow", 1));
        animals.add(new Animal("pig", 2));
        animals.add(new Animal("cat", 3));
        animals.add(new Animal("dog", 4));
        animals.add(new Animal("lion", 5));
        animals.add(new Animal("tiger", 6));
        animals.add(new Animal("zebra", 7));
        animals.add(new Animal("elephant", 8));
        animals.add(new Animal("hippo", 9));
        animals.add(new Animal("horse", 10));

        animals.stream()
                .filter(animal -> animal.getAge() > 5)
                .forEach(animal -> System.out.println(
                        "Животное: " +
                                animal.getName() +
                                "; возраст: " +
                                animal.getAge())
                );

        // 1. Если в коллекции есть лев, то выведите его возраст, если нет - исключение IllegalArgumentException
        Optional<Animal> lion = animals.stream()
                .filter(animal -> animal.getName().equals("lion"))
                .findFirst();
        if (lion.isPresent()) {
            System.out.println("Возраст льва: " + lion.get().getAge());
        } else {
            throw new IllegalArgumentException("Лев не найден в коллекции");
        }

//        2. Выведите на экран всех животных из коллекции в порядке возрастания их возраста
        animals.stream()
                .sorted(Comparator.comparing(Animal::getAge))
                .forEach(animal -> System.out.println(
                        "Животное: " +
                                animal.getName() +
                                "; возраст: " +
                                animal.getAge()));
//        3. Посчитайте сколько животных в коллекции, у которых возраст больше 4
        long count = animals.stream()
                .filter(animal -> animal.getAge() > 4)
                .count();
        System.out.println("Количество животных, возраст которых больше 4: " + count);

//        4. Создайте Map из коллекции животных. Ключ - название животного, значение - экземпляр животного. Выведите все пары ключ-значение в консоль
        Map<String, Animal> animalMap = animals.stream()
                .collect(Collectors.toMap(Animal::getName, Function.identity()));
        animalMap.forEach((name, animal) -> System.out.println("Живторные из Map: " + name + ": " + animal));

































//        5. Выведите названия всех животных одной строкой (используйте reduce())
        String animalNames = animals.stream()
                .map(Animal::getName)
                .reduce("", (name1, name2) -> name1 + ", " + name2);
        System.out.println("Названия животных строкой: " + animalNames.substring(2));

    }
}

