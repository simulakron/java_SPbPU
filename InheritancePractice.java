// Практика 1 - использование this и super
class Parent {
    String name = "Parent";  // поле родительского класса
    
    Parent() {
        System.out.println("Конструктор Parent");
    }
    
    void display() {
        System.out.println("Метод Parent: " + name);
    }
}

class Child extends Parent {
    String name = "Child";  // поле подкласса (перекрывает поле родителя)
    
    Child() {
        super(); // вызов конструктора родителя - ДОЛЖЕН быть первой строкой
        System.out.println("Конструктор Child");
    }
    
    void showNames() {
        // this - ссылка на текущий объект подкласса
        System.out.println("this.name: " + this.name); // обращение к полю Child ("Child")
        // super - ссылка на родительскую часть объекта  
        System.out.println("super.name: " + super.name); // обращение к полю Parent ("Parent")
    }
    
    void callMethods() {
        this.display(); // вызов переопределенного метода (метод Child)
        super.display(); // вызов метода родителя (метод Parent)
    }
    
    // Переопределение метода родителя
    void display() {
        System.out.println("Метод Child: " + name);
    }
}

// Практика 2 - спецификаторы доступа при наследовании
class A {
    int a1;              // default (package-private) - доступ в том же пакете
    public int a2;       // public - доступ везде
    protected int a3;    // protected - доступ в пакете и наследникам  
    private int a4;      // private - доступ только в классе A

    void method1() {     // default - доступ в том же пакете
        System.out.println("A.method1() default");
    }

    public void method2() { // public - доступ везде
        System.out.println("A.method2() public");
    }

    protected void method3() { // protected - доступ в пакете и наследникам
        System.out.println("A.method3() protected");
    }
    
    private void method4() { // private - доступ только в классе A
        System.out.println("A.method4() private");
    }
}

class B extends A {
    void testAccessInB() {
        a1 = 1;     // ДОСТУПНО: default - наследуется в том же пакете
        a2 = 2;     // ДОСТУПНО: public - наследуется всегда
        a3 = 3;     // ДОСТУПНО: protected - наследуется всегда
        // a4 = 4;  // НЕДОСТУПНО: private - НЕ наследуется
        
        method1();  // ДОСТУПНО: default - наследуется в том же пакете
        method2();  // ДОСТУПНО: public - наследуется всегда
        method3();  // ДОСТУПНО: protected - наследуется всегда
        // method4(); // НЕДОСТУПНО: private - НЕ наследуется
    }
}

class C extends B {
    void testAccessInC() {
        a1 = 1;     // ДОСТУПНО: default - наследуется в том же пакете
        a2 = 2;     // ДОСТУПНО: public - наследуется всегда
        a3 = 3;     // ДОСТУПНО: protected - наследуется всегда
        // a4 = 4;  // НЕДОСТУПНО: private - НЕ наследуется (только в A)
        
        method1();  // ДОСТУПНО: default - наследуется в том же пакете
        method2();  // ДОСТУПНО: public - наследуется всегда
        method3();  // ДОСТУПНО: protected - наследуется всегда
        // method4(); // НЕДОСТУПНО: private - НЕ наследуется (только в A)
    }
}

public class InheritancePractice {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - this и super ===");
        Child child = new Child();
        child.showNames();  // демонстрация this и super для полей
        child.callMethods(); // демонстрация this и super для методов
        
        System.out.println("\n=== Практика 2 - спецификаторы доступа ===");
        B b = new B();
        b.testAccessInB(); // тест доступа из первого подкласса
        
        C c = new C();  
        c.testAccessInC(); // тест доступа из второго подкласса
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - this и super:
- this - ссылка на текущий объект (подкласс)
- super - ссылка на родительскую часть объекта
- this.name обращается к полю подкласса
- super.name обращается к полю родителя  
- this.method() вызывает переопределенный метод
- super.method() вызывает метод родителя

ПРАКТИКА 2 - спецификаторы доступа:
private:    Только в классе A - НЕ наследуется
default:    В пакете - наследуется в том же пакете  
protected:  В пакете + наследники - наследуется всегда
public:     Везде - наследуется всегда

Наследование не влияет на private доступ - он остается только в исходном классе.
*/