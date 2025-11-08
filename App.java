public class App {
    final static int START_COUNTER;
    static {
        START_COUNTER = Integer.parseInt("Y-"); // Ошибка здесь!
    }
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}

/*
ОБЪЯСНЕНИЕ:

Что произойдет:

1. При загрузке класса App выполнится статический блок инициализации
2. В строке Integer.parseInt("Y-") произойдет NumberFormatException
   - Метод parseInt() пытается преобразовать строку "Y-" в число
   - Строка "Y-" не является числом, поэтому возникает исключение
3. Исключение NumberFormatException НЕ перехватывается в статическом блоке
4. Произойдет ExceptionInInitializerError - ошибка инициализации класса
5. Программа НЕ выполнит метод main(), строка "Hello" НЕ будет напечатана

ВЫВОД ПРОГРАММЫ:
Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.NumberFormatException: For input string: "Y-"
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
	at java.base/java.lang.Integer.parseInt(Integer.java:661)
	at java.base/java.lang.Integer.parseInt(Integer.java:777)
	at App.<clinit>(App.java:4)

ПОЧЕМУ ТАК ПРОИСХОДИТ:
- Статические блоки выполняются при загрузке класса, ДО вызова main()
- Неперехваченные исключения в статических блоках приводят к ExceptionInInitializerError
- Класс не может быть корректно загружен, поэтому main() никогда не выполняется

КАК ИСПРАВИТЬ:
1. Перехватить исключение в статическом блоке:
   static {
       try {
           START_COUNTER = Integer.parseInt("Y-");
       } catch (NumberFormatException e) {
           START_COUNTER = 0; // значение по умолчанию
       }
   }

2. Использовать корректную числовую строку:
   START_COUNTER = Integer.parseInt("10");
*/