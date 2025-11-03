import java.util.StringJoiner;

public class StringMethodsDemo {
    public static void main(String[] args) {
        // Практика 1 - методы класса String
        System.out.println("=== Практика 1 - Методы класса String ===");
        
        String text = "   Hello, Java World!   ";
        String emptyText = "";
        String nullText = null;
        String anotherText = "HELLO, JAVA WORLD!";
        
        // 1. length() - возвращает длину строки
        System.out.println("1. length(): " + text.length() + " - длина строки");
        
        // 2. trim() - удаляет пробелы в начале и конце строки
        System.out.println("2. trim(): '" + text.trim() + "' - удалены пробелы");
        
        // 3. toUpperCase() и toLowerCase() - преобразование регистра
        System.out.println("3. toUpperCase(): " + text.toUpperCase() + " - верхний регистр");
        System.out.println("4. toLowerCase(): " + text.toLowerCase() + " - нижний регистр");
        
        // 5. substring() - извлечение подстроки
        System.out.println("5. substring(3, 8): '" + text.substring(3, 8) + "' - подстрока с 3 по 7 индекс");
        
        // 6. replace() - замена символов/подстрок
        System.out.println("6. replace('l', 'L'): " + text.replace('l', 'L') + " - замена символов");
        
        // 7. contains() - проверка наличия подстроки
        System.out.println("7. contains('Java'): " + text.contains("Java") + " - содержит 'Java'");
        
        // 8. startsWith() и endsWith() - проверка начала/конца строки
        System.out.println("8. startsWith('Hello'): " + text.startsWith("Hello") + " - начинается с 'Hello'");
        System.out.println("9. endsWith('!'): " + text.endsWith("!") + " - заканчивается на '!'");
        
        // 10. equals() и equalsIgnoreCase() - сравнение строк
        System.out.println("10. equalsIgnoreCase(): " + text.trim().equalsIgnoreCase(anotherText) + 
                          " - сравнение без учета регистра");
        
        // 11. isEmpty() - проверка пустой строки
        System.out.println("11. isEmpty(): " + emptyText.isEmpty() + " - строка пустая");
        
        // 12. split() - разделение строки на массив
        String[] words = text.trim().split(" ");
        System.out.println("12. split(): Разделено на " + words.length + " слова");
        for (String word : words) {
            System.out.println("   - " + word);
        }
        
        // Практика 2 - StringJoiner
        System.out.println("\n=== Практика 2 - StringJoiner ===");
        
        // Создание StringJoiner с разделителем, префиксом и суффиксом
        StringJoiner sj1 = new StringJoiner(", ", "[", "]");
        sj1.add("Яблоко");
        sj1.add("Банан");
        sj1.add("Апельсин");
        System.out.println("StringJoiner с префиксом/суффиксом: " + sj1.toString());
        
        // StringJoiner для CSV
        StringJoiner csvJoiner = new StringJoiner(";");
        csvJoiner.add("Иван");
        csvJoiner.add("25");
        csvJoiner.add("Разработчик");
        System.out.println("CSV формат: " + csvJoiner.toString());
        
        // Объединение двух StringJoiner
        StringJoiner sj2 = new StringJoiner(" - ");
        sj2.add("Понедельник");
        sj2.add("Вторник");
        
        StringJoiner sj3 = new StringJoiner(" | ");
        sj3.merge(sj2); // Объединение
        sj3.add("Среда");
        System.out.println("Объединенные joiner: " + sj3.toString());
        
        // Практика 3 - текстовые блоки (три двойные кавычки)
        System.out.println("\n=== Практика 3 - Текстовые блоки (Java 13+) ===");
        
        String htmlTemplate = """
            <html>
                <head>
                    <title>%s</title>
                </head>
                <body>
                    <h1>%s</h1>
                    <p>%s</p>
                </body>
            </html>
            """.formatted("Мой сайт", "Добро пожаловать", "Это пример HTML шаблона");
        
        System.out.println("HTML шаблон:\n" + htmlTemplate);
        
        String sqlQuery = """
            SELECT id, name, email
            FROM users
            WHERE active = true
            AND created_date > '%s'
            ORDER BY name ASC
            """.formatted("2024-01-01");
        
        System.out.println("SQL запрос:\n" + sqlQuery);
        
        String json = """
            {
                "user": {
                    "id": 123,
                    "name": "Иван Иванов",
                    "roles": ["admin", "user"]
                }
            }
            """;
        
        System.out.println("JSON данные:\n" + json);
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1 - Методы String:
1. length() - возвращает количество символов в строке
2. trim() - удаляет ведущие и завершающие пробелы
3. toUpperCase()/toLowerCase() - преобразует все символы в верхний/нижний регистр
4. substring(start, end) - возвращает подстроку от start до end-1 индекса
5. replace(old, new) - заменяет все вхождения old на new
6. contains(seq) - проверяет, содержит ли строка указанную последовательность
7. startsWith()/endsWith() - проверяет начало/конец строки
8. equals()/equalsIgnoreCase() - сравнивает строки (с учетом и без учета регистра)
9. isEmpty() - проверяет, пустая ли строка (length() == 0)
10. split(regex) - разделяет строку на массив подстрок по регулярному выражению

ПРАКТИКА 2 - StringJoiner:
- Упрощает объединение строк с разделителем
- Может иметь префикс и суффикс
- Полезен для создания CSV, JSON, SQL запросов
- Метод merge() объединяет два StringJoiner

ПРАКТИКА 3 - Текстовые блоки (три двойные кавычки """);
- Позволяют удобно работать с многострочным текстом
- Сохраняют форматирование (отступы, переносы строк)
- Упрощают написание HTML, SQL, JSON шаблонов
- Метод formatted() для подстановки значений
*/
