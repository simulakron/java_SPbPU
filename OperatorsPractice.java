public class OperatorsPractice {
    public static void main(String[] args) {
        // БАЗОВЫЕ ТИПЫ
        int a = 10, b = 3, c = 5;
        double x = 2.5, y = 1.5;
        boolean bool1 = true, bool2 = false;
        
        // СТРОКИ
        String str1 = "Hello", str2 = "World";
        
        System.out.println("=== БАЗОВЫЕ ТИПЫ ===");
        
        // 1. Арифметические операторы
        System.out.println("Арифметические операторы:");
        System.out.println("a + b = " + (a + b));      // 13
        System.out.println("a - b = " + (a - b));      // 7
        System.out.println("a * b = " + (a * b));      // 30
        System.out.println("a / b = " + (a / b));      // 3 (целочисленное деление)
        System.out.println("a % b = " + (a % b));      // 1 (остаток от деления)
        System.out.println("x / y = " + (x / y));      // 1.666... (вещественное деление)
        
        // 2. Операторы ++ и -- (префиксная и постфиксная форма)
        System.out.println("\nОператоры ++ и --:");
        int num1 = 5;
        System.out.println("Исходное значение: " + num1);              // 5
        System.out.println("Постфиксный num1++: " + (num1++));         // 5 (возвращает, затем увеличивает)
        System.out.println("После num1++: " + num1);                   // 6
        System.out.println("Префиксный ++num1: " + (++num1));          // 7 (увеличивает, затем возвращает)
        
        int num2 = 8;
        System.out.println("Исходное значение: " + num2);              // 8
        System.out.println("Постфиксный num2--: " + (num2--));         // 8 (возвращает, затем уменьшает)
        System.out.println("После num2--: " + num2);                   // 7
        System.out.println("Префиксный --num2: " + (--num2));          // 6 (уменьшает, затем возвращает)
        
        // 3. Операторы сравнения
        System.out.println("\nОператоры сравнения:");
        System.out.println("a > b: " + (a > b));        // true
        System.out.println("a < b: " + (a < b));        // false
        System.out.println("a >= b: " + (a >= b));      // true
        System.out.println("a <= b: " + (a <= b));      // false
        System.out.println("a == b: " + (a == b));      // false
        System.out.println("a != b: " + (a != b));      // true
        
        // 4. Логические операторы
        System.out.println("\nЛогические операторы:");
        System.out.println("bool1 && bool2: " + (bool1 && bool2));    // false
        System.out.println("bool1 || bool2: " + (bool1 || bool2));    // true
        System.out.println("!bool1: " + (!bool1));                    // false
        
        // 5. Побитовые операторы
        System.out.println("\nПобитовые операторы:");
        int bit1 = 5;  // 0101
        int bit2 = 3;  // 0011
        System.out.println("bit1 & bit2: " + (bit1 & bit2));   // 0001 = 1 (AND)
        System.out.println("bit1 | bit2: " + (bit1 | bit2));   // 0111 = 7 (OR)
        System.out.println("bit1 ^ bit2: " + (bit1 ^ bit2));   // 0110 = 6 (XOR)
        System.out.println("~bit1: " + (~bit1));               // 1111...1010 = -6 (NOT)
        
        // 6. Операторы сдвига
        System.out.println("\nОператоры сдвига:");
        int shift = 8;  // 1000
        System.out.println("shift << 1: " + (shift << 1));     // 10000 = 16 (левый сдвиг)
        System.out.println("shift >> 1: " + (shift >> 1));     // 0100 = 4 (правый сдвиг)
        System.out.println("shift >>> 1: " + (shift >>> 1));   // 0100 = 4 (беззнаковый правый сдвиг)
        
        // 7. Тернарный оператор
        System.out.println("\nТернарный оператор:");
        int max = (a > b) ? a : b;
        System.out.println("max(a,b) = " + max);  // 10
        
        System.out.println("\n=== СТРОКИ ===");
        
        // 8. Операторы для строк
        System.out.println("Конкатенация строк:");
        String result1 = str1 + " " + str2;                    // "Hello World"
        String result2 = str1 + 123;                           // "Hello123"
        String result3 = str1 + true;                          // "Hellotrue"
        
        System.out.println("str1 + str2: " + result1);
        System.out.println("str1 + 123: " + result2);
        System.out.println("str1 + true: " + result3);
        
        // 9. Операторы сравнения для строк
        System.out.println("\nСравнение строк:");
        System.out.println("str1 == str2: " + (str1 == str2));          // false (сравнение ссылок)
        System.out.println("str1 != str2: " + (str1 != str2));          // true
        System.out.println("str1.equals(str2): " + str1.equals(str2));  // false (сравнение содержимого)
        
        // 10. Составные операторы присваивания
        System.out.println("\nСоставные операторы присваивания:");
        int value = 10;
        value += 5;  // value = value + 5
        System.out.println("value += 5: " + value);  // 15
        
        value -= 3;  // value = value - 3
        System.out.println("value -= 3: " + value);  // 12
        
        value *= 2;  // value = value * 2
        System.out.println("value *= 2: " + value);  // 24
        
        value /= 4;  // value = value / 4
        System.out.println("value /= 4: " + value);  // 6
        
        value %= 4;  // value = value % 4
        System.out.println("value %= 4: " + value);  // 2
        
        // Для строк
        String text = "Hello";
        text += " World";  // text = text + " World"
        System.out.println("text += ' World': " + text);  // "Hello World"
        
        // 11. Демонстрация приоритета операторов
        System.out.println("\nДемонстрация приоритета:");
        int result = a + b * c;      // 10 + (3 * 5) = 25
        System.out.println("a + b * c = " + result);
        
        result = (a + b) * c;        // (10 + 3) * 5 = 65
        System.out.println("(a + b) * c = " + result);
        
        boolean logicResult = a > b && b < c || a == c;  // true && true || false = true
        System.out.println("a > b && b < c || a == c = " + logicResult);
    }
}