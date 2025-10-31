// Практика #1 - Инициализация элементов перечисления
enum Size {
    // Инициализация элементов с параметрами
    SMALL("S", 10),
    MEDIUM("M", 20),
    LARGE("L", 30);
    
    private final String abbreviation;
    private final int value;
    
    // Конструктор для инициализации
    Size(String abbreviation, int value) {
        this.abbreviation = abbreviation;
        this.value = value;
    }
    
    public String getAbbreviation() {
        return abbreviation;
    }
    
    public int getValue() {
        return value;
    }
}

// Практика #2 - Перечисление с дополнительным методом
enum Operation {
    PLUS("+") {
        public double apply(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double apply(double x, double y) { return x - y; }
    },
    MULTIPLY("*") {
        public double apply(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double apply(double x, double y) { return x / y; }
    };
    
    private final String symbol;
    
    Operation(String symbol) {
        this.symbol = symbol;
    }
    
    // Абстрактный метод, который реализуется каждым элементом
    public abstract double apply(double x, double y);
    
    public String getSymbol() {
        return symbol;
    }
}

public class EnumExamples {
    public static void main(String[] args) {
        // Практика #1 - использование перечисления с инициализацией
        Size size = Size.MEDIUM;
        System.out.println("Size: " + size + ", Abbreviation: " + size.getAbbreviation() + ", Value: " + size.getValue());
        
        // Практика #2 - использование перечисления с методом
        Operation op = Operation.PLUS;
        double result = op.apply(5, 3);
        System.out.println("5 " + op.getSymbol() + " 3 = " + result);
    }
}