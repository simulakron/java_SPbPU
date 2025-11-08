public class MultipleExceptionsDemo {

    public static void main(String[] args) {
        System.out.println("=== Практика 1 - Обработка нескольких исключений ===");
        
        // Ситуация 1: несколько исключений обрабатываются идентично
        System.out.println("\n1. Идентичная обработка разных исключений:");
        try {
            processData("test", 10);
        } catch (IllegalArgumentException | NullPointerException e) {
            // Одинаковая обработка для разных типов исключений
            System.out.println("   Ошибка ввода данных: " + e.getMessage());
        }
        
        // Ситуация 2: иерархия исключений
        System.out.println("\n2. Иерархия исключений:");
        try {
            processWithHierarchy(2);
        } catch (Level3Exception e) {
            System.out.println("   Поймано Level3Exception: " + e.getMessage());
        } catch (Level2Exception e) {
            System.out.println("   Поймано Level2Exception: " + e.getMessage());
        } catch (Level1Exception e) {
            System.out.println("   Поймано Level1Exception: " + e.getMessage());
        }
        
        // Демонстрация порядка catch блоков с проверяемыми исключениями
        System.out.println("\n3. Порядок catch блоков с проверяемыми исключениями:");
        try {
            processWithCheckedExceptions(1);
        } catch (SpecificException e) {
            System.out.println("   Поймано SpecificException: " + e.getMessage());
        } catch (GeneralException e) {
            System.out.println("   Поймано GeneralException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("   Поймано общее Exception: " + e.getMessage());
        }
        
        // Практика 2 - final в catch
        System.out.println("\n=== Практика 2 - final в catch ===");
        try {
            String text = null;
            text.length();
        } catch (final NullPointerException e) {
            System.out.println("   final исключение: " + e.getMessage());
            // e = new NullPointerException("новое"); // ОШИБКА: нельзя изменить final переменную
        }
        
        // Вложенные try блоки
        System.out.println("\n=== Вложенные try блоки ===");
        nestedTryBlocks();
    }
    
    // Ситуация 1: одинаковая обработка разных исключений
    public static void processData(String data, int value) {
        if (data == null) {
            throw new NullPointerException("Данные не могут быть null");
        }
        if (value < 0) {
            throw new IllegalArgumentException("Значение не может быть отрицательным");
        }
        if (data.isEmpty()) {
            throw new IllegalArgumentException("Данные не могут быть пустыми");
        }
        System.out.println("   Данные успешно обработаны: " + data + ", " + value);
    }
    
    // Ситуация 2: иерархия исключений (непроверяемые)
    public static void processWithHierarchy(int type) {
        switch (type) {
            case 1:
                throw new Level3Exception("Ошибка уровня 3");
            case 2:
                throw new Level2Exception("Ошибка уровня 2");
            case 3:
                throw new Level1Exception("Ошибка уровня 1");
        }
    }
    
    // Ситуация 3: иерархия проверяемых исключений
    public static void processWithCheckedExceptions(int type) throws GeneralException {
        switch (type) {
            case 1:
                throw new SpecificException("Конкретная проверяемая ошибка");
            case 2:
                throw new GeneralException("Общая проверяемая ошибка");
        }
    }
    
    // Вложенные try блоки
    public static void nestedTryBlocks() {
        try {
            System.out.println("   Внешний try блок");
            
            try {
                System.out.println("   Внутренний try блок 1");
                int result = 10 / 0; // ArithmeticException
            } catch (ArithmeticException e) {
                System.out.println("   Внутренний catch: " + e.getMessage());
            }
            
            try {
                System.out.println("   Внутренний try блок 2");
                String text = null;
                text.length(); // NullPointerException
            } catch (NullPointerException e) {
                System.out.println("   Внутренний catch: " + e.getMessage());
                throw new RuntimeException("Обернутое исключение", e); // Повторное выбрасывание
            }
            
        } catch (RuntimeException e) {
            System.out.println("   Внешний catch: " + e.getMessage());
        } finally {
            System.out.println("   Внешний finally блок выполнен");
        }
    }
}

// Иерархия непроверяемых исключений для демонстрации
class Level1Exception extends RuntimeException {
    public Level1Exception(String message) {
        super(message);
    }
}

class Level2Exception extends Level1Exception {
    public Level2Exception(String message) {
        super(message);
    }
}

class Level3Exception extends Level2Exception {
    public Level3Exception(String message) {
        super(message);
    }
}

// Иерархия проверяемых исключений для демонстрации
class GeneralException extends Exception {
    public GeneralException(String message) {
        super(message);
    }
}

class SpecificException extends GeneralException {
    public SpecificException(String message) {
        super(message);
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1 - Обработка нескольких исключений:

1. Идентичная обработка разных исключений:
   - Используется оператор | для объединения исключений в одном catch
   - IllegalArgumentException | NullPointerException - оба обрабатываются одинаково
   - НЕЛЬЗЯ: IOException | FileNotFoundException (FileNotFoundException наследует IOException)

2. Иерархия исключений (Level1 ← Level2 ← Level3):
   - При обработке иерархии важен ПОРЯДОК catch блоков
   - Сначала должны обрабатываться потомки (Level3), затем предки (Level2, Level1)
   - Если поставить Level1Exception первым - остальные блоки будут недостижимы

3. Разница между проверяемыми и непроверяемыми исключениями:
   - Непроверяемые (RuntimeException): не требуют объявления в throws
   - Проверяемые (Exception): требуют объявления в throws или обработки в try-catch

ПРАКТИКА 2 - final в catch:

final Exception e означает:
- Переменная e не может быть переназначена внутри блока catch
- Защита от случайного изменения исключения
- Гарантия, что обрабатывается именно то исключение, которое было поймано

ВЛОЖЕННЫЕ TRY БЛОКИ:
- Позволяют обрабатывать исключения на разных уровнях
- Внутренние исключения могут быть обработаны независимо
- Можно перехватывать исключения и выбрасывать новые (обернутые)
- Каждый try может иметь свои catch и finally блоки
*/
