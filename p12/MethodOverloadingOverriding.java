// Практика #1 - Перегрузка и переопределение методов

class Animal {
    // Перегруженные методы (overloading) - в одном классе
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    
    public void makeSound(String sound) {
        System.out.println("Животное издает: " + sound);
    }
    
    public void makeSound(String sound, int volume) {
        System.out.println("Животное издает: " + sound + " громкостью " + volume);
    }
    
    // Метод для переопределения
    public void move() {
        System.out.println("Животное двигается");
    }
}

class Dog extends Animal {
    // Переопределение метода (override)
    @Override
    public void move() {
        System.out.println("Собака бежит");
    }
}

public class MethodOverloadingOverriding {
    public static void main(String[] args) {
        System.out.println("=== Перегрузка методов ===");
        Animal animal = new Animal();
        animal.makeSound();
        animal.makeSound("Рррр");
        animal.makeSound("Гав", 5);
        
        System.out.println("\n=== Переопределение методов ===");
        Animal dog = new Dog();
        animal.move();  // Животное двигается
        dog.move();     // Собака бежит (переопределено)
    }
}
