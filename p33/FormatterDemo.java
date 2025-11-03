import java.util.Formatter;
import java.util.Date;
import java.io.FileWriter;
import java.io.IOException;

public class FormatterDemo {
    public static void main(String[] args) {
        // Практика 1 - спецификаторы форматирования
        System.out.println("=== Практика 1 - Спецификаторы форматирования ===");
        
        String name = "Иван";
        int age = 25;
        double salary = 1234.5678;
        boolean isActive = true;
        char grade = 'A';
        
        // 1. %s - строковое представление
        System.out.printf("1. %%s: Имя: %s%n", name);
        
        // 2. %d - десятичное целое
        System.out.printf("2. %%d: Возраст: %d лет%n", age);
        
        // 3. %f - десятичное с плавающей точкой
        System.out.printf("3. %%f: Зарплата: %.2f руб.%n", salary); // .2 - 2 знака после запятой
        
        // 4. %b - логическое значение
        System.out.printf("4. %%b: Активен: %b%n", isActive);
        
        // 5. %c - символьное представление
        System.out.printf("5. %%c: Оценка: %c%n", grade);
        
        // Дополнительные спецификаторы
        System.out.printf("6. %%h: Хэшкод имени: %h%n", name);
        System.out.printf("7. %%e: Зарплата в эксп. форме: %e%n", salary);
        System.out.printf("8. %%n%n"); // Вставка пустой строки
        
        // Комбинированное форматирование
        System.out.printf("9. Комбинированный: %s, возраст %d, зарплата %.2f%n%n", name, age, salary);
        
        // Практика 2 - метод flush()
        System.out.println("=== Практика 2 - Метод flush() ===");
        
        try (FileWriter writer = new FileWriter("test.txt")) {
            writer.write("Первая строка\n");
            writer.write("Вторая строка\n");
            
            // Без flush() данные могут остаться в буфере
            writer.flush(); // Принудительная запись из буфера в файл
            System.out.println("Данные записаны в файл после flush()");
            
            writer.write("Третья строка после flush\n");
            // При закрытии FileWriter автоматически вызывает flush()
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
        
        // Пример с Formatter
        try (Formatter formatter = new Formatter(new FileWriter("formatted.txt"))) {
            formatter.format("Имя: %s%n", name);
            formatter.format("Возраст: %d%n", age);
            formatter.flush(); // Принудительная запись отформатированных данных
            System.out.println("Formatter данные записаны после flush()");
        } catch (IOException e) {
            System.out.println("Ошибка Formatter: " + e.getMessage());
        }
        
        // Практика 3 - спецификаторы времени и даты
        System.out.println("\n=== Практика 3 - Спецификаторы времени и даты ===");
        
        Date currentDate = new Date();
        
        // 1. %tH - час (00-23)
        System.out.printf("1. %%tH: Текущий час: %tH%n", currentDate);
        
        // 2. %tM - минуты (00-59)
        System.out.printf("2. %%tM: Текущие минуты: %tM%n", currentDate);
        
        // 3. %tS - секунды (00-59)
        System.out.printf("3. %%tS: Текущие секунды: %tS%n", currentDate);
        
        // 4. %tY - год в четырехзначном формате
        System.out.printf("4. %%tY: Текущий год: %tY%n", currentDate);
        
        // 5. %tB - полное название месяца
        System.out.printf("5. %%tB: Текущий месяц: %tB%n", currentDate);
        
        // Дополнительные спецификаторы даты/времени
        System.out.printf("6. %%tA: День недели: %tA%n", currentDate);
        System.out.printf("7. %%td: День месяца: %td%n", currentDate);
        System.out.printf("8. %%tI: Час (1-12): %tI%n", currentDate);
        
        // Комбинированное форматирование даты/времени
        System.out.printf("9. Полная дата: %tA, %td %tB %tY года%n", 
                         currentDate, currentDate, currentDate, currentDate);
        System.out.printf("10. Время: %tH:%tM:%tS%n", 
                         currentDate, currentDate, currentDate);
        
        // Использование Formatter для сложного форматирования
        System.out.println("\n=== Дополнительные примеры Formatter ===");
        
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        
        formatter.format("Отчет от %tD%n", currentDate);
        formatter.format("Сотрудник: %s (%d лет)%n", name, age);
        formatter.format("Зарплата: %,.2f руб.%n", salary);
        formatter.format("Статус: %b%n", isActive);
        
        System.out.println(sb.toString());
        formatter.close();
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 2 - Метод flush():
НАЗНАЧЕНИЕ: Принудительно записывает данные из буфера в выходной поток

ЗАЧЕМ НУЖЕН:
1. Для немедленной записи данных (без ожидания заполнения буфера)
2. Для обеспечения сохранности данных при сбоях
3. Для отладки (чтобы увидеть данные сразу)

КОГДА ВЫЗЫВАЕТСЯ АВТОМАТИЧЕСКИ:
- При закрытии потока (close())
- При заполнении буфера
- В некоторых классах при определенных условиях

*/
