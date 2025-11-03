public class InterfaceMethodsExample {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - default и статические методы ===");
        
        // Создание объекта класса, реализующего интерфейс
        MathOperationsImpl calculator = new MathOperationsImpl();
        
        // Вызов абстрактного метода
        int sum = calculator.calculate(10, 5);
        
        // Вызов default метода через объект класса
        calculator.displayResult(sum);
        
        // Вызов статического метода через имя интерфейса
        String info = MathOperations.getInfo();
        System.out.println(info);
        
        System.out.println("\n=== Практика 2 - конфликт default методов ===");
        
        // Создание объекта класса с конфликтующими интерфейсами
        MultiFunction machine = new MultiFunction();
        
        // Вызов переопределенного конфликтующего метода
        machine.process("данные");
        
        // Вызов другого переопределенного метода
        machine.initialize();
    }
}

// Практика 1 - интерфейс с default и статическим методами
interface MathOperations {
    // Абстрактный метод (обязателен для реализации)
    int calculate(int a, int b);
    
    // default метод (неабстрактный, с реализацией по умолчанию)
    default void displayResult(int result) {
        System.out.println("Результат вычисления: " + result);
    }
    
    // Статический метод
    static String getInfo() {
        return "Интерфейс математических операций версия 1.0";
    }
}

// Класс, реализующий интерфейс
class MathOperationsImpl implements MathOperations {
    @Override
    public int calculate(int a, int b) {
        return a + b; // Реализация абстрактного метода
    }
    
    // default метод можно переопределить, но не обязательно
    @Override
    public void displayResult(int result) {
        System.out.println(">>> " + result + " <<<");
    }
}

// Практика 2 - интерфейсы с конфликтующими default методами
interface Printer {
    // default метод с конфликтом
    default void process(String data) {
        System.out.println("Печать: " + data);
    }
    
    // Еще один конфликтующий метод
    default void initialize() {
        System.out.println("Инициализация принтера");
    }
}

interface Scanner {
    // default метод с таким же именем
    default void process(String data) {
        System.out.println("Сканирование: " + data);
    }
    
    // Конфликтующий метод
    default void initialize() {
        System.out.println("Инициализация сканера");
    }
}

// Класс, реализующий оба интерфейса с конфликтующими методами
class MultiFunction implements Printer, Scanner {
    // ОБЯЗАТЕЛЬНОЕ переопределение конфликтующего метода process()
    @Override
    public void process(String data) {
        // Решение 1: Создание новой реализации
        System.out.println("Многофункциональное устройство обрабатывает: " + data);
    }
    
    // ОБЯЗАТЕЛЬНОЕ переопределение второго конфликтующего метода initialize()
    @Override
    public void initialize() {
        // Решение 2: Выбор конкретной реализации из одного из интерфейсов
        Printer.super.initialize(); // Вызываем реализацию из Printer
        
        // Решение 3: Комбинирование реализаций из обоих интерфейсов
        Scanner.super.initialize(); // Вызываем реализацию из Scanner
        
        System.out.println("МФУ готово к работе");
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1 - default и статические методы в интерфейсах:

Default методы:
- Имеют реализацию по умолчанию
- Вызываются через объект класса: объект.метод()
- Могут быть переопределены в классе (необязательно)
- Пример: displayResult()

Статические методы:
- Принадлежат интерфейсу, а не объектам
- Вызываются через имя интерфейса: Интерфейс.метод()
- Не могут быть переопределены в классе
- Пример: getInfo()

ПРАКТИКА 2 - конфликт default методов:

Проблема: 
Когда класс реализует два интерфейса с одинаковыми default методами,
возникает неоднозначность - компилятор не знает, какую реализацию использовать.

Решение - класс ОБЯЗАН переопределить конфликтующий метод. Возможные варианты:

1. Создать совершенно новую реализацию (как в методе process())
2. Выбрать одну из существующих реализаций: Интерфейс.super.метод()
3. Скомбинировать реализации из разных интерфейсов (как в методе initialize())

Без переопределения конфликтующих методов код не скомпилируется!
*/
