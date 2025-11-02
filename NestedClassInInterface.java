// Практика 1 - вложенный класс в интерфейсе
interface MathOperations {
    // Статический вложенный класс в интерфейсе
    static class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        
        public int multiply(int a, int b) {
            return a * b;
        }
        
        public double divide(double a, double b) {
            if (b == 0) {
                throw new IllegalArgumentException("Деление на ноль!");
            }
            return a / b;
        }
    }
    
    // Еще один вложенный класс
    class Constants {
        // Нестатический вложенный класс в интерфейсе 
        public static final double PI = 3.14159;
        public static final double E = 2.71828;
    }
    
    // Метод интерфейса (необязательно)
    void performOperation();
}

// Другой пример интерфейса с вложенным классом
interface Logger {
    // Уровни логирования
    enum Level {
        DEBUG, INFO, WARN, ERROR
    }
    
    // Вложенный класс для форматирования сообщений
    static class MessageFormatter {
        public static String format(Level level, String message) {
            return "[" + level + "] " + java.time.LocalDateTime.now() + " - " + message;
        }
        
        public static String formatWithUser(Level level, String user, String message) {
            return "[" + level + "] " + java.time.LocalDateTime.now() + " - " + 
                   user + ": " + message;
        }
    }
    
    void log(String message);
}

// Реализация интерфейса с использованием вложенных классов
class ConsoleLogger implements Logger {
    private Level level = Level.INFO;
    
    @Override
    public void log(String message) {
        String formatted = Logger.MessageFormatter.format(level, message);
        System.out.println(formatted);
    }
    
    public void setLevel(Level level) {
        this.level = level;
    }
}

public class NestedClassInInterface {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - вложенный класс в интерфейсе ===");
        
        // Способ вызова метода вложенного класса из интерфейса
        // 1. Прямой вызов через имя интерфейса и вложенного класса
        MathOperations.Calculator calc = new MathOperations.Calculator();
        System.out.println("5 + 3 = " + calc.add(5, 3));
        System.out.println("5 * 3 = " + calc.multiply(5, 3));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
        
        // 2. Использование констант из вложенного класса в интерфейсе
        System.out.println("Число PI: " + MathOperations.Constants.PI);
        System.out.println("Число E: " + MathOperations.Constants.E);
        
        // 3. Использование вложенного класса для форматирования
        Logger.MessageFormatter formatter = new Logger.MessageFormatter();
        String message = formatter.format(Logger.Level.INFO, "Тестовое сообщение");
        System.out.println("Форматированное сообщение: " + message);
        
        // 4. Использование в реальной реализации
        ConsoleLogger logger = new ConsoleLogger();
        logger.log("Приложение запущено");
        logger.setLevel(Logger.Level.DEBUG);
        logger.log("Отладочная информация");
        
        // 5. Статический вызов методов вложенного класса
        String staticMessage = Logger.MessageFormatter.formatWithUser(
            Logger.Level.WARN, "admin", "Внимание: низкая память");
        System.out.println("Статическое форматирование: " + staticMessage);
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ:

Вложенные классы в интерфейсах:

1. ОБЫЧНО СТАТИЧЕСКИЕ: 
   - Вложенные классы в интерфейсах по умолчанию static (даже без указания)
   - Могут быть объявлены явно как static

2. СПОСОБЫ ВЫЗОВА:
   - Интерфейс.ВложенныйКласс объект = new Интерфейс.ВложенныйКласс();
   - Затем вызов методов: объект.метод()

3. ПРЕИМУЩЕСТВА:
   - Группировка связанной функциональности
   - Вспомогательные классы для интерфейса
   - Классы-утилиты для работы с интерфейсом
   - Хранение констант и перечислений

4. ОСОБЕННОСТИ:
   - Не имеют доступа к нестатическим членам интерфейса (их нет)
   - Могут содержать статические и нестатические методы
   - Часто используются для классов-утилит, связанных с интерфейсом
*/