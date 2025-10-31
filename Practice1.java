public class Practice1 {
    public static void main(String[] args) {
        System.out.println("=== Метод decode() для разных систем счисления ===");
        
        // 1. DECIMAL (десятичная система) - по умолчанию
        Integer dec1 = Integer.decode("123");
        System.out.println("Decimal '123' = " + dec1); // 123
        
        // 2. HEXADECIMAL (шестнадцатеричная система) - префикс 0x или 0X
        Integer hex1 = Integer.decode("0x7B");
        Integer hex2 = Integer.decode("0X7B");
        Integer hex3 = Integer.decode("#7B");
        System.out.println("Hex '0x7B' = " + hex1);    // 123
        System.out.println("Hex '0X7B' = " + hex2);    // 123
        System.out.println("Hex '#7B' = " + hex3);     // 123
        
        // 3. OCTAL (восьмеричная система) - префикс 0
        Integer oct1 = Integer.decode("0173");
        System.out.println("Octal '0173' = " + oct1); // 123 (1*64 + 7*8 + 3 = 123)
        
        // 4. Отрицательные числа
        Integer negDec = Integer.decode("-123");
        Integer negHex = Integer.decode("-0x7B");
        Integer negOct = Integer.decode("-0173");
        System.out.println("Negative decimal '-123' = " + negDec); // -123
        System.out.println("Negative hex '-0x7B' = " + negHex);    // -123
        System.out.println("Negative octal '-0173' = " + negOct);  // -123
        
        // 5. Для других классов-оболочек
        System.out.println("\n=== Другие классы-оболочки ===");
        
        Long longDec = Long.decode("123456789");
        Long longHex = Long.decode("0x75BCD15");
        Long longOct = Long.decode("0726746425");
        System.out.println("Long decimal '123456789' = " + longDec);   // 123456789
        System.out.println("Long hex '0x75BCD15' = " + longHex);       // 123456789
        System.out.println("Long octal '0726746425' = " + longOct);    // 123456789
        
        Short shortDec = Short.decode("1234");
        Short shortHex = Short.decode("0x4D2");
        System.out.println("Short decimal '1234' = " + shortDec); // 1234
        System.out.println("Short hex '0x4D2' = " + shortHex);    // 1234
        
        Byte byteDec = Byte.decode("127");
        Byte byteHex = Byte.decode("0x7F");
        System.out.println("Byte decimal '127' = " + byteDec); // 127
        System.out.println("Byte hex '0x7F' = " + byteHex);    // 127
        
        // 6. Сравнение с другими методами парсинга
        System.out.println("\n=== Сравнение с другими методами ===");
        
        // valueOf только для десятичных чисел
        Integer v1 = Integer.valueOf("123");        // работает
        // Integer v2 = Integer.valueOf("0x7B");    // NumberFormatException!
        
        // parseInt с указанием системы счисления
        Integer p1 = Integer.parseInt("123", 10);   // 123
        Integer p2 = Integer.parseInt("7B", 16);    // 123
        Integer p3 = Integer.parseInt("173", 8);    // 123
        
        System.out.println("valueOf('123') = " + v1);
        System.out.println("parseInt('123', 10) = " + p1);
        System.out.println("parseInt('7B', 16) = " + p2);
        System.out.println("parseInt('173', 8) = " + p3);
        
        // 7. Обработка исключений
        System.out.println("\n=== Обработка исключений ===");
        
        try {
            Integer invalid1 = Integer.decode("12A"); // недопустимый символ
        } catch (NumberFormatException e) {
            System.out.println("Ошибка для '12A': " + e.getMessage());
        }
        
        try {
            Integer invalid2 = Integer.decode("0xGH"); // недопустимые hex символы
        } catch (NumberFormatException e) {
            System.out.println("Ошибка для '0xGH': " + e.getMessage());
        }
        
        try {
            Integer invalid3 = Integer.decode("0189"); // недопустимые octal символы
        } catch (NumberFormatException e) {
            System.out.println("Ошибка для '0189': " + e.getMessage());
        }
        
        // 8. Практическое применение
        System.out.println("\n=== Практическое применение ===");
        
        // Чтение цветов из CSS/HTML (hex форматы)
        Integer color1 = Integer.decode("#FF0000"); // красный
        Integer color2 = Integer.decode("#00FF00"); // зеленый
        Integer color3 = Integer.decode("#0000FF"); // синий
        
        System.out.println("Color #FF0000 = " + color1 + " (red)");
        System.out.println("Color #00FF00 = " + color2 + " (green)");
        System.out.println("Color #0000FF = " + color3 + " (blue)");
        
        // Чтение файловых прав в Unix (octal форматы)
        Integer permissions = Integer.decode("0755");
        System.out.println("File permissions 0755 = " + permissions);
    }
}