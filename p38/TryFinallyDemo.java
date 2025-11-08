public class TryFinallyDemo {

    public static void main(String[] args) {
        System.out.println("=== Практика 1-3 - Блоки try, catch, finally ===");
        
        // Практика 1: try без catch и finally - НЕВОЗМОЖНО
        System.out.println("1. try без catch и finally:");
        // ОШИБКА КОМПИЛЯЦИИ:
        /*
        try {
            System.out.println("Этот код не скомпилируется");
        }
        */
        System.out.println("   НЕВОЗМОЖНО - ошибка компиляции: 'try' without 'catch', 'finally' or resource declarations");
        
        // Практика 2: try только с finally - ВОЗМОЖНО
        System.out.println("\n2. try только с finally:");
        try {
            System.out.println("   Выполняем код в try");
            int result = 10 / 2; // Успешная операция
            System.out.println("   Результат: " + result);
        } finally {
            System.out.println("   Блок finally выполнен ВСЕГДА");
        }
        
        // try с finally при исключении
        System.out.println("\n3. try с finally при исключении:");
        try {
            System.out.println("   Выполняем код в try");
            int result = 10 / 0; // Исключение
            System.out.println("   Этот код не выполнится");
        } finally {
            System.out.println("   Блок finally выполнен даже при исключении");
        }
        
        // Практика 3: try с двумя finally - НЕВОЗМОЖНО
        System.out.println("\n4. try с двумя finally:");
        // ОШИБКА КОМПИЛЯЦИИ:
        /*
        try {
            System.out.println("Код в try");
        } finally {
            System.out.println("Первый finally");
        } finally {
            System.out.println("Второй finally");
        }
        */
        System.out.println("   НЕВОЗМОЖНО - ошибка компиляции: можно использовать только один блок finally");
        
        // Дополнительный пример с ресурсами
        System.out.println("\n5. try-with-resources (автоматический finally):");
        try (MyResource resource = new MyResource()) {
            System.out.println("   Используем ресурс в try-with-resources");
            resource.doSomething();
        } catch (Exception e) {
            System.out.println("   Исключение: " + e.getMessage());
        }
        // finally вызывается автоматически при закрытии ресурса
    }
    
    static class MyResource implements AutoCloseable {
        public void doSomething() {
            System.out.println("   Ресурс выполняет работу");
        }
        
        @Override
        public void close() {
            System.out.println("   Ресурс закрыт (автоматический finally)");
        }
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1: try без catch и finally
- НЕВОЗМОЖНО - ошибка компиляции
- Блок try должен иметь хотя бы один catch ИЛИ finally
- Исключение: try-with-resources

ПРАКТИКА 2: try только с finally
- ВОЗМОЖНО и часто используется
- finally выполняется ВСЕГДА, даже если:
  * Код в try выполнен успешно
  * В try произошло исключение
  * В try был return, break или continue

ПРАКТИКА 3: try с двумя finally
- НЕВОЗМОЖНО - ошибка компиляции
- Можно использовать только ОДИН блок finally на один try

ВАЖНОЕ О finally:
- Выполняется всегда (кроме System.exit() или сбоя JVM)
- Используется для освобождения ресурсов
- В try-with-resources finally вызывается автоматически
*/
