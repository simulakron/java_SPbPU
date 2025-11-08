public class ExceptionHandlingDemo {

    public static void main(String[] args) {
        System.out.println("=== Демонстрация обработки исключений ===");
        
        // Это исключение будет перехвачено
        System.out.println("\n1. Исключение, которое будет ПЕРЕХВАЧЕНО:");
        try {
            methodWithHandledException();
        } catch (ArithmeticException e) {
            System.out.println("   Перехвачено в main: " + e.getMessage());
        }
        
        // Это исключение НЕ будет перехвачено и приведет к аварийной остановке
        System.out.println("\n2. Исключение, которое НЕ будет перехвачено:");
        methodWithUnhandledException();
        
        // Этот код не выполнится из-за аварийной остановки
        System.out.println("Этот текст никогда не будет напечатан");
    }
    
    // Метод, в котором исключение перехватывается
    public static void methodWithHandledException() {
        System.out.println("   Выполняется methodWithHandledException...");
        try {
            // Генерируем исключение
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("   Исключение перехвачено в methodWithHandledException: " + e.getMessage());
            // Можно выполнить дополнительную обработку или передать дальше
            throw e; // Передаем исключение дальше (в main)
        }
    }
    
    // Метод, в котором исключение НЕ перехватывается
    public static void methodWithUnhandledException() {
        System.out.println("   Выполняется methodWithUnhandledException...");
        
        // Генерируем исключение, которое НЕ перехватывается в этом методе
        String text = null;
        int length = text.length(); // NullPointerException
        
        // Этот код не выполнится из-за исключения
        System.out.println("   Этот текст не будет напечатан из-за исключения");
    }
}

/*
ОБЪЯСНЕНИЕ РЕЗУЛЬТАТОВ ВЫПОЛНЕНИЯ:

ВЫВОД ПРОГРАММЫ:
=== Демонстрация обработки исключений ===

1. Исключение, которое будет ПЕРЕХВАЧЕНО:
   Выполняется methodWithHandledException...
   Исключение перехвачено в methodWithHandledException: / by zero
   Перехвачено в main: / by zero

2. Исключение, которое НЕ будет перехвачено:
   Выполняется methodWithUnhandledException...
   Exception in thread "main" java.lang.NullPointerException: Cannot invoke "String.length()" because "text" is null
        at ExceptionHandlingDemo.methodWithUnhandledException(ExceptionHandlingDemo.java:36)
        at ExceptionHandlingDemo.main(ExceptionHandlingDemo.java:16)

ЧТО ПРОИСХОДИТ:

1. ПЕРЕХВАЧЕННОЕ ИСКЛЮЧЕНИЕ (ArithmeticException):
   - Исключение генерируется в methodWithHandledException()
   - Оно перехватывается блоком catch внутри того же метода
   - После обработки исключение снова выбрасывается (throw e)
   - Исключение перехватывается в main()
   - Программа продолжает нормальное выполнение

2. НЕПЕРЕХВАЧЕННОЕ ИСКЛЮЧЕНИЕ (NullPointerException):
   - Исключение генерируется в methodWithUnhandledException()
   - В этом методе НЕТ блока try-catch для его обработки
   - Исключение передается вверх по стеку вызовов (в main())
   - В main() тоже НЕТ обработчика для этого исключения
   - Происходит АВАРИЙНАЯ ОСТАНОВКА программы
   - JVM выводит стек вызовов и завершает программу

КЛЮЧЕВЫЕ МОМЕНТЫ:
- Исключение ищет обработчик, поднимаясь вверх по стеку вызовов
- Если обработчик не найден - программа аварийно завершается
- Перехваченные исключения позволяют программе продолжить работу
- Неперехваченные исключения приводят к остановке программы
- Блок finally выполняется ВСЕГДА, даже при исключениях
*/