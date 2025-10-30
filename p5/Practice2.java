class Animal {}
class Mammal extends Animal {}
class Dog extends Mammal {}
class Cat extends Mammal {}
class Bird extends Animal {}

public class Practice2 {
    public static void main(String[] args) {
        // Создаем объекты разных типов
        Animal animal = new Animal();
        Mammal mammal = new Mammal();
        Dog dog = new Dog();
        Cat cat = new Cat();
        Bird bird = new Bird();
        
        Object obj = new Dog();
        String str = "Hello";
        
        // 1. Проверка наследования
        System.out.println("=== Проверка наследования ===");
        System.out.println("dog instanceof Dog: " + (dog instanceof Dog));        // true
        System.out.println("dog instanceof Mammal: " + (dog instanceof Mammal));  // true
        System.out.println("dog instanceof Animal: " + (dog instanceof Animal));  // true
        System.out.println("dog instanceof Object: " + (dog instanceof Object));  // true
        
        // 2. Проверка между разными ветвями наследования (убраны несовместимые проверки)
        System.out.println("\n=== Проверка между разными ветвями ===");
        System.out.println("mammal instanceof Animal: " + (mammal instanceof Animal)); // true
        System.out.println("bird instanceof Animal: " + (bird instanceof Animal));     // true
        
        // 3. Проверка с родительскими классами
        System.out.println("\n=== Проверка с родительскими классами ===");
        System.out.println("animal instanceof Dog: " + (animal instanceof Dog));    // false
        System.out.println("mammal instanceof Dog: " + (mammal instanceof Dog));    // false
        System.out.println("animal instanceof Mammal: " + (animal instanceof Mammal)); // false
        
        // 4. Проверка с Object ссылкой
        System.out.println("\n=== Проверка с Object ссылкой ===");
        System.out.println("obj instanceof Dog: " + (obj instanceof Dog));        // true
        System.out.println("obj instanceof Mammal: " + (obj instanceof Mammal));  // true
        System.out.println("obj instanceof Animal: " + (obj instanceof Animal));  // true
        System.out.println("obj instanceof String: " + (obj instanceof String));  // false
        
        // 5. Проверка со строками и стандартными классами
        System.out.println("\n=== Проверка со стандартными классами ===");
        System.out.println("str instanceof String: " + (str instanceof String));  // true
        System.out.println("str instanceof Object: " + (str instanceof Object));  // true
        
        // 6. Практическое использование в условиях
        System.out.println("\n=== Практическое использование ===");
        checkAnimalType(dog);     // Это собака
        checkAnimalType(cat);     // Это кошка
        checkAnimalType(bird);    // Это птица
        checkAnimalType(animal);  // Это неизвестное животное
        
        // 7. ПРОВЕРКА С NULL-ОБЪЕКТОМ
        System.out.println("\n=== Проверка с null-объектом ===");
        Animal nullAnimal = null;
        String nullString = null;
        Object nullObject = null;
        
        System.out.println("nullAnimal instanceof Animal: " + (nullAnimal instanceof Animal));    // false
        System.out.println("nullString instanceof String: " + (nullString instanceof String));    // false
        System.out.println("nullObject instanceof Object: " + (nullObject instanceof Object));    // false
        
        // 8. Проверка в массивами
        System.out.println("\n=== Проверка с массивами ===");
        int[] numbers = new int[5];
        String[] strings = new String[3];
        
        System.out.println("numbers instanceof int[]: " + (numbers instanceof int[]));          // true
        System.out.println("numbers instanceof Object: " + (numbers instanceof Object));        // true
        System.out.println("strings instanceof String[]: " + (strings instanceof String[]));    // true
        System.out.println("strings instanceof Object[]: " + (strings instanceof Object[]));    // true
        
        // 9. Безопасное приведение типов с instanceof
        System.out.println("\n=== Безопасное приведение типов ===");
        safeCast(obj);      // Успешное приведение к Dog
        safeCast(str);      // Объект не является Dog
        safeCast(nullAnimal); // Объект null - приведение невозможно
        
        // Используем переменную dog, чтобы убрать предупреждение
        System.out.println("Собака создана: " + dog.getClass().getSimpleName());
    }
    
    // Метод для проверки типа животного
    public static void checkAnimalType(Animal animal) {
        if (animal instanceof Dog) {
            System.out.println("Это собака");
        } else if (animal instanceof Cat) {
            System.out.println("Это кошка");
        } else if (animal instanceof Bird) {
            System.out.println("Это птица");
        } else {
            System.out.println("Это неизвестное животное");
        }
    }
    
    // Метод для безопасного приведения типов
    public static void safeCast(Object obj) {
        if (obj instanceof Dog) {
            Dog dog = (Dog) obj;  // Безопасное приведение
            System.out.println("Успешное приведение к Dog");
        } else if (obj == null) {
            System.out.println("Объект null - приведение невозможно");
        } else {
            System.out.println("Объект не является Dog");
        }
    }
}