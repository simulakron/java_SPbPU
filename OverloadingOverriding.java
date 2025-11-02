// Практика 1 - перегруженные методы (overloading)
class Calculator {
    // Перегруженные методы - одинаковое имя, разные параметры
    
    public int add(int a, int b) {
        return a + b;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
}

// Практика 2 - переопределенный метод (overriding)
class Animal {
    public void makeSound() {
        System.out.println("Животное издает звук");
    }
    
    public String getName() {
        return "Животное";
    }
}

class Dog extends Animal {
    // Переопределение метода - совпадает имя и параметры
    @Override
    public void makeSound() {
        System.out.println("Собака лает: Гав-гав!");
    }
    
    // ОШИБКА КОМПИЛЯЦИИ: тип возвращаемого значения не совпадает
    /*
    @Override
    public int getName() { // Должен возвращать String, а не int
        return 1;
    }
    */
}

// Практика 3 - аннотация @Override для обнаружения ошибок
class Parent {
    public void display() {
        System.out.println("Метод Parent");
    }
    
    public void show(String message) {
        System.out.println("Parent: " + message);
    }
}

class Child extends Parent {
    // ПРАВИЛЬНО: метод действительно переопределяет родительский
    @Override
    public void display() {
        System.out.println("Метод Child");
    }
    
    // ОШИБКА КОМПИЛЯЦИИ: аннотация @Override обнаруживает, что метод не переопределяет родительский
    /*
    @Override
    public void display(String text) { // Опечатка в имени метода - должно быть show
        System.out.println("Child: " + text);
    }
    */
    
    // БЕЗ @Override компилятор не заметит ошибку - создаст новый метод
    public void sho(String message) { // Опечатка в имени метода - должно быть show
        System.out.println("Child: " + message);
    }
}

public class OverloadingOverriding {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - перегруженные методы ===");
        Calculator calc = new Calculator();
        System.out.println("add(2, 3) = " + calc.add(2, 3));           // int + int
        System.out.println("add(2.5, 3.7) = " + calc.add(2.5, 3.7));   // double + double
        System.out.println("add(1, 2, 3) = " + calc.add(1, 2, 3));     // три int
        System.out.println("add(\"Hello\", \" World\") = " + calc.add("Hello", " World")); // String + String
        
        System.out.println("\n=== Практика 2 - переопределенные методы ===");
        Animal animal = new Animal();
        Animal dog = new Dog(); // Полиморфизм - ссылка Animal на объект Dog
        
        animal.makeSound(); // Животное издает звук
        dog.makeSound();    // Собака лает: Гав-гав! (динамическое связывание)
        
        System.out.println("\n=== Практика 3 - аннотация @Override ===");
        Parent parent = new Parent();
        Child child = new Child();
        
        parent.display(); // Метод Parent
        child.display();  // Метод Child
        
        parent.show("test"); // Parent: test
        child.sho("test");   // Child: test (но это НЕ переопределение!)
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - перегруженные методы (overloading):
- Методы с одинаковым именем, но разными параметрами
- Выбор метода происходит на этапе КОМПИЛЯЦИИ по типам аргументов
- Могут находиться в одном классе или связанных классах
- Тип возвращаемого значения НЕ влияет на перегрузку

ПРАКТИКА 2 - переопределенные методы (overriding):
- Метод в подклассе с такой же сигнатурой, как в суперклассе
- Выбор метода происходит на этапе ВЫПОЛНЕНИЯ (динамическое связывание)
- Тип возвращаемого значения ДОЛЖЕН совпадать или быть ковариантным
- При несовпадении типов возвращаемых значений - ОШИБКА КОМПИЛЯЦИИ

ПРАКТИКА 3 - аннотация @Override:
- Помогает обнаружить ошибки при попытке переопределения
- Если метод с @Override не переопределяет реальный метод родителя - ошибка компиляции
- Без @Override компилятор не заметит опечатки в имени метода и создаст новый метод
- Рекомендуется всегда использовать @Override для переопределяемых методов
*/