// Практика 1 - создание собственного класса исключения
class MyException extends Exception {
    
    // Конструктор по умолчанию
    public MyException() {
        super("Произошла моя исключительная ситуация");
    }
    
    // Конструктор с сообщением
    public MyException(String message) {
        super(message);
    }
    
    // Конструктор с сообщением и причиной
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class CustomExceptionDemo {
    
    // Метод, который бросает наше исключение
    public static void testMethod(int value) throws MyException {
        if (value < 0) {
            throw new MyException("Значение не может быть отрицательным: " + value);
        }
        System.out.println("Значение корректно: " + value);
    }
    
    public static void main(String[] args) {
        try {
            testMethod(10);  // Корректное значение
            testMethod(-5);  // Выбросит исключение
        } catch (MyException e) {
            System.out.println("Поймано исключение: " + e.getMessage());
        }
    }
}

/*
ОБЪЯСНЕНИЕ:

Создан класс MyException, который:
1. Наследуется от Exception (проверяемое исключение)
2. Имеет три рекомендуемых конструктора:
   - По умолчанию
   - С сообщением об ошибке
   - С сообщением и причиной

В методе testException() исключение бросается при отрицательном значении.
В main() исключение перехватывается и обрабатывается.
*/
