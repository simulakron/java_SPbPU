// Пример - соблюдение LSP

// Базовый интерфейс для ВСЕХ птиц
interface Bird {
    void eat();
}

// Интерфейс для птиц, которые могут летать
interface FlyingBird extends Bird {
    void fly();
}

// Конкретные реализации
class Duck implements FlyingBird {
    @Override
    public void eat() {
        System.out.println("Утка ест");
    }
    
    @Override
    public void fly() {
        System.out.println("Утка летит");
    }
}

class Penguin implements Bird {
    @Override
    public void eat() {
        System.out.println("Пингвин ест рыбу");
    }
    
    // Пингвин не реализует FlyingBird, поэтому у него нет метода fly()
}

public class Example {
    public static void main(String[] args) {
        Duck duck = new Duck();
        Penguin penguin = new Penguin();
        
        // Работает с уткой
        makeBirdFly(duck);
    
        // makeBirdFly(penguin); // Ошибка компиляции!
        
        // Но мы можем кормить обеих птиц
        feedBird(duck);
        feedBird(penguin);
    }
    
    // Этот метод принимает только летающих птиц
    public static void makeBirdFly(FlyingBird bird) {
        bird.fly();
    }
    
    // Этот метод принимает любых птиц
    public static void feedBird(Bird bird) {
        bird.eat();
    }
}
