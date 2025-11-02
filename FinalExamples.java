// Практика 1 - final метод нельзя переопределять
class Parent {
    // final метод - нельзя переопределять в подклассах
    public final void finalMethod() {
        System.out.println("Это final метод в классе Parent");
    }
    
    // обычный метод - можно переопределять
    public void normalMethod() {
        System.out.println("Это обычный метод в классе Parent");
    }
}

class Child extends Parent {
    // НОРМАЛЬНО: переопределение обычного метода
    @Override
    public void normalMethod() {
        System.out.println("Переопределенный метод в классе Child");
    }
    
    // ОШИБКА КОМПИЛЯЦИИ: нельзя переопределить final метод
    /*
    @Override
    public void finalMethod() {
        System.out.println("Попытка переопределить final метод");
    }
    */
}

// Практика 2 - final класс нельзя наследовать
final class FinalClass {
    public void method() {
        System.out.println("Метод final класса");
    }
}

// ОШИБКА КОМПИЛЯЦИИ: нельзя наследовать от final класса
/*
class ExtendedClass extends FinalClass {
    public void newMethod() {
        System.out.println("Метод подкласса");
    }
}
*/

public class FinalExamples {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - final методы ===");
        Parent parent = new Parent();
        Child child = new Child();
        
        parent.finalMethod();    // Вызов final метода родителя
        child.finalMethod();     // Вызов final метода через подкласс (наследуется, но не переопределяется)
        child.normalMethod();    // Вызов переопределенного метода
        
        System.out.println("\n=== Практика 2 - final классы ===");
        FinalClass finalObj = new FinalClass();
        finalObj.method();       // Можно создавать объекты final класса
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - final методы:
- final метод finalMethod() в классе Parent НЕ может быть переопределен в Child
- При попытке переопределения возникает ошибка компиляции
- final методы наследуются, но их реализация фиксирована
- Обычные методы (normalMethod()) можно свободно переопределять

ПРАКТИКА 2 - final классы:
- final класс FinalClass НЕ может иметь подклассов
- При попытке наследования возникает ошибка компиляции
- От final классов можно создавать объекты, но нельзя расширять функциональность через наследование
- final классы часто используются для создания неизменяемых (immutable) классов
*/