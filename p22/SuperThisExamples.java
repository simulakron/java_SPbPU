// Практика 1 - три варианта использования super
class A {
    int value = 10;
    
    A() {
        System.out.println("Конструктор A()");
    }
    
    A(int value) {
        this.value = value;
        System.out.println("Конструктор A(int) с value = " + value);
    }
    
    void display() {
        System.out.println("Метод A.display(), value = " + value);
    }
}

class B extends A {
    int value = 20;
    
    B() {
        super(); // 1. Вызов конструктора суперкласса - ДОЛЖЕН быть первой строкой
        System.out.println("Конструктор B()");
    }
    
    B(int value) {
        super(value); // 1. Вызов конструктора суперкласса с параметром
        System.out.println("Конструктор B(int)");
    }
    
    void showValues() {
        System.out.println("value в B: " + this.value); // поле текущего класса
        System.out.println("value в A: " + super.value); // 2. Доступ к полю суперкласса
    }
    
    void display() {
        super.display(); // 3. Доступ к методу суперкласса
        System.out.println("Метод B.display(), value = " + value);
    }
}

// Практика 2 - наследование через промежуточный класс
class X {
    int a = 100;
    
    void method() {
        System.out.println("Метод класса X, a = " + a);
    }
}

class Y extends X {
    // Класс Y не переопределяет поля и методы класса X
}

class Z extends Y {
    void method() {
        int a = super.a; // Обращение к полю a из класса X (через Y)
        super.method(); // Вызов метода method() из класса X (через Y)
        System.out.println("Метод класса Z, унаследованное a = " + a);
    }
}

// Практика 3 - переписывание конструкторов с this()
class A2 {
    int a;
    int b;
    int c;
    int z;

    public A2() {
        this(0, 0, 0); // Вызов конструктора с тремя параметрами
    }

    public A2(int a) {
        this(a, 0, 0); // Вызов конструктора с тремя параметрами
    }

    public A2(int a, int b) {
        this(a, b, 0); // Вызов конструктора с тремя параметрами
    }

    public A2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.z = 1; // Общая инициализация
    }
}

public class SuperThisExamples {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - три варианта super ===");
        B b1 = new B();
        b1.showValues();
        b1.display();
        
        System.out.println("\n=== Практика 2 - наследование через промежуточный класс ===");
        Z z = new Z();
        z.method();
        
        System.out.println("\n=== Практика 3 - конструкторы с this() ===");
        A2 obj1 = new A2();
        A2 obj2 = new A2(10);
        A2 obj3 = new A2(10, 20);
        A2 obj4 = new A2(10, 20, 30);
        
        System.out.println("obj4: a=" + obj4.a + ", b=" + obj4.b + ", c=" + obj4.c + ", z=" + obj4.z);
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

ПРАКТИКА 1 - три варианта super:
1. super() - вызов конструктора суперкласса (должен быть первой строкой)
2. super.поле - доступ к полю суперкласса (если поле перекрыто в подклассе)
3. super.метод() - вызов метода суперкласса (если метод переопределен в подклассе)

ПРАКТИКА 2 - наследование через промежуточный класс:
- Если класс B не переопределяет поле 'a' и метод 'method()' из класса A,
  то в классе C можно использовать super.a и super.method() для доступа 
  к членам класса A через цепочку наследования
- super ищет члены в ближайшем родительском классе, где они определены

ПРАКТИКА 3 - конструкторы с this():
- this() используется для вызова других конструкторов того же класса
- Должен быть первой строкой в конструкторе
- Позволяет избежать дублирования кода инициализации
- В данном случае общая логика (z=1) вынесена в конструктор с тремя параметрами
*/
