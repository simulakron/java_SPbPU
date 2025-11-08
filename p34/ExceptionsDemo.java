public class ExceptionsDemo {
    public static void main(String[] args) {
        System.out.println("=== Практика 1 - Классы исключений ===");
        
        // Практика 2 - примеры исключений
        System.out.println("\n=== Практика 2 - Примеры исключений ===");
        
        // 1. ArithmeticException - арифметическая ошибка
        try {
            System.out.println("1. ArithmeticException:");
            int result = 10 / 0; // Деление на ноль
        } catch (ArithmeticException e) {
            System.out.println("   Поймано: " + e.getMessage());
        }
        
        // 2. ArrayIndexOutOfBoundsException - выход за границы массива
        try {
            System.out.println("2. ArrayIndexOutOfBoundsException:");
            int[] array = {1, 2, 3};
            int value = array[5]; // Несуществующий индекс
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("   Поймано: " + e.getMessage());
        }
        
        // 3. IllegalArgumentException - неверный аргумент
        try {
            System.out.println("3. IllegalArgumentException:");
            setAge(-5); // Передаем отрицательный возраст
        } catch (IllegalArgumentException e) {
            System.out.println("   Поймано: " + e.getMessage());
        }
        
        // 4. ClassCastException - неверное приведение типов
        try {
            System.out.println("4. ClassCastException:");
            Object obj = "Это строка";
            Integer number = (Integer) obj; // Попытка привести String к Integer
        } catch (ClassCastException e) {
            System.out.println("   Поймано: " + e.getMessage());
        }
        
        // 5. NullPointerException - обращение к null
        try {
            System.out.println("5. NullPointerException:");
            String text = null;
            int length = text.length(); // Вызов метода у null
        } catch (NullPointerException e) {
            System.out.println("   Поймано: " + e.getMessage());
        }
        
        // Дополнительные примеры с пользовательской логикой
        System.out.println("\n=== Дополнительные примеры ===");
        
        // Обработка нескольких исключений
        try {
            processData(null, 10);
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("Обработано несколько исключений: " + e.getClass().getSimpleName());
        }
        
        // Блок finally
        try {
            riskyOperation();
        } catch (RuntimeException e) {
            System.out.println("Исключение в riskyOperation: " + e.getMessage());
        } finally {
            System.out.println("Блок finally выполнен всегда");
        }
    }
    
    // Метод, генерирующий IllegalArgumentException
    public static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
        System.out.println("Возраст установлен: " + age);
    }
    
    // Метод, который может генерировать разные исключения
    public static void processData(String data, int index) {
        if (data == null) {
            throw new NullPointerException("Данные не могут быть null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным: " + index);
        }
        System.out.println("Данные обработаны: " + data.charAt(index));
    }
    
    // Метод с блоком finally
    public static void riskyOperation() {
        try {
            // Имитация операции, которая может завершиться ошибкой
            if (Math.random() > 0.5) {
                throw new RuntimeException("Случайная ошибка в операции");
            }
            System.out.println("Операция завершена успешно");
        } finally {
            System.out.println("Очистка ресурсов в riskyOperation");
        }
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1 - Классы исключений и их назначение:

Throwable - базовый класс для всех исключений и ошибок
│
├── Error - критические ошибки, которые обычно не обрабатываются
│   ├── OutOfMemoryError - нехватка памяти
│   ├── StackOverflowError - переполнение стека
│   └── VirtualMachineError - ошибки JVM
│
└── Exception - исключения, которые можно и нужно обрабатывать
    │
    ├── RuntimeException (Unchecked) - непроверяемые исключения
    │   ├── NullPointerException - обращение к null
    │   ├── IllegalArgumentException - неверный аргумент
    │   ├── ArrayIndexOutOfBoundsException - выход за границы массива
    │   ├── ArithmeticException - арифметическая ошибка
    │   └── ClassCastException - неверное приведение типов
    │
    └── Другие Exception (Checked) - проверяемые исключения
        ├── IOException - ошибки ввода-вывода
        ├── SQLException - ошибки базы данных
        └── FileNotFoundException - файл не найден

НАЗНАЧЕНИЕ КЛАССОВ:
- Error: для серьезных проблем, которые приложение не должно пытаться обрабатывать
- Exception: для условий, которые разумное приложение может захотеть обработать
- RuntimeException: для ошибок программирования (не проверяются компилятором)

ПРАКТИКА 2 - Примеры исключений:

1. ArithmeticException - возникает при арифметических ошибках (деление на 0)
2. ArrayIndexOutOfBoundsException - при обращении к несуществующему индексу массива
3. IllegalArgumentException - когда метод получает неподходящий аргумент
4. ClassCastException - при неудачном приведении типов объектов
5. NullPointerException - при вызове метода или обращении к полю у null объекта

ОБРАБОТКА ИСКЛЮЧЕНИЙ:
- try-catch - перехват и обработка исключений
- finally - блок, который выполняется всегда (для очистки ресурсов)
- throw - явная генерация исключения
- throws - объявление исключений в сигнатуре метода

*/
