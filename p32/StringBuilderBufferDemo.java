public class StringBuilderBufferDemo {
    public static void main(String[] args) {
        // Практика 1 - методы StringBuilder и StringBuffer
        System.out.println("=== Практика 1 - Методы StringBuilder и StringBuffer ===");
        
        // Создание объектов
        StringBuilder sb = new StringBuilder("Hello");
        StringBuffer sbf = new StringBuffer("World");
        
        System.out.println("Исходный StringBuilder: " + sb);
        System.out.println("Исходный StringBuffer: " + sbf);
        
        // 1. append() - добавление в конец
        sb.append(" Java"); // StringBuilder: "Hello Java"
        sbf.append("!");    // StringBuffer: "World!"
        System.out.println("1. append(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - добавление в конец");
        
        // 2. insert() - вставка в указанную позицию
        sb.insert(5, ",");  // StringBuilder: "Hello, Java"
        sbf.insert(0, "Hello "); // StringBuffer: "Hello World!"
        System.out.println("2. insert(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - вставка");
        
        // 3. delete() - удаление символов
        sb.delete(5, 6);    // StringBuilder: "Hello Java" (удалена запятая)
        sbf.delete(5, 11);  // StringBuffer: "Hello!" (удалено " World")
        System.out.println("3. delete(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - удаление");
        
        // 4. deleteCharAt() - удаление одного символа
        sb.deleteCharAt(5); // StringBuilder: "HelloJava" (удален пробел)
        sbf.deleteCharAt(5); // StringBuffer: "Hello" (удален '!')
        System.out.println("4. deleteCharAt(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - удаление символа");
        
        // 5. reverse() - обратный порядок символов
        sb.reverse();       // StringBuilder: "avaJolleH"
        sbf.reverse();      // StringBuffer: "olleH"
        System.out.println("5. reverse(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - реверс");
        
        // 6. setCharAt() - замена символа по индексу
        sb.setCharAt(0, 'A'); // StringBuilder: "AvaJolleH"
        sbf.setCharAt(0, 'H'); // StringBuffer: "HlleH"
        System.out.println("6. setCharAt(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - замена символа");
        
        // 7. replace() - замена подстроки
        sb.replace(0, 3, "Java"); // StringBuilder: "JavaJolleH"
        sbf.replace(1, 4, "i");   // StringBuffer: "HiH"
        System.out.println("7. replace(): StringBuilder='" + sb + "', StringBuffer='" + sbf + "' - замена подстроки");
        
        // 8. capacity() - текущая емкость
        System.out.println("8. capacity(): StringBuilder=" + sb.capacity() + ", StringBuffer=" + sbf.capacity() + " - емкость буфера");
        
        // 9. ensureCapacity() - гарантированная минимальная емкость
        sb.ensureCapacity(50);
        sbf.ensureCapacity(50);
        System.out.println("9. ensureCapacity(50): StringBuilder=" + sb.capacity() + ", StringBuffer=" + sbf.capacity() + " - минимальная емкость");
        
        // 10. length() - текущая длина
        System.out.println("10. length(): StringBuilder=" + sb.length() + ", StringBuffer=" + sbf.length() + " - длина строки");
        
        // Дополнительные полезные методы
        // 11. charAt() - получение символа по индексу
        System.out.println("11. charAt(0): StringBuilder='" + sb.charAt(0) + "', StringBuffer='" + sbf.charAt(0) + "' - символ по индексу");
        
        // 12. indexOf() - поиск подстроки
        System.out.println("12. indexOf('Java'): StringBuilder=" + sb.indexOf("Java") + " - позиция подстроки");
        
        // 13. substring() - извлечение подстроки
        System.out.println("13. substring(0,4): StringBuilder='" + sb.substring(0, 4) + "' - подстрока");
        
        // Практика 2 - преобразование между String, StringBuilder, StringBuffer
        System.out.println("\n=== Практика 2 - Преобразование между типами ===");
        
        // String → StringBuilder
        String str = "Пример строки";
        StringBuilder sbFromString = new StringBuilder(str);
        System.out.println("String → StringBuilder: '" + str + "' → '" + sbFromString + "'");
        
        // String → StringBuffer  
        StringBuffer sbfFromString = new StringBuffer(str);
        System.out.println("String → StringBuffer: '" + str + "' → '" + sbfFromString + "'");
        
        // StringBuilder → String
        String strFromSB = sb.toString();
        System.out.println("StringBuilder → String: '" + sb + "' → '" + strFromSB + "'");
        
        // StringBuffer → String
        String strFromSBF = sbf.toString();
        System.out.println("StringBuffer → String: '" + sbf + "' → '" + strFromSBF + "'");
        
        // StringBuilder → StringBuffer (через String)
        StringBuffer sbfFromSB = new StringBuffer(sb.toString());
        System.out.println("StringBuilder → StringBuffer: '" + sb + "' → '" + sbfFromSB + "'");
        
        // StringBuffer → StringBuilder (через String)
        StringBuilder sbFromSBF = new StringBuilder(sbf.toString());
        System.out.println("StringBuffer → StringBuilder: '" + sbf + "' → '" + sbFromSBF + "'");
        
        // Демонстрация изменяемости
        System.out.println("\n=== Демонстрация изменяемости ===");
        StringBuilder mutable = new StringBuilder("Исходный");
        System.out.println("До изменения: " + mutable);
        mutable.append(" измененный");
        System.out.println("После изменения: " + mutable);
        
        String immutable = "Исходный";
        System.out.println("String до изменения: " + immutable);
        immutable = immutable + " измененный"; // Создается новый объект
        System.out.println("String после 'изменения': " + immutable);
    }
}

/*
ОБЪЯСНЕНИЕ МЕТОДОВ:

ПРАКТИКА 1 - Основные методы StringBuilder/StringBuffer:

1. append() - добавляет строку в конец текущей
2. insert() - вставляет строку в указанную позицию
3. delete() - удаляет символы в диапазоне [start, end)
4. deleteCharAt() - удаляет один символ по индексу
5. reverse() - переворачивает строку задом наперед
6. setCharAt() - заменяет символ по указанному индексу
7. replace() - заменяет подстроку в указанном диапазоне
8. capacity() - возвращает текущую емкость буфера
9. ensureCapacity() - гарантирует минимальную емкость
10. length() - возвращает текущую длину строки
11. charAt() - возвращает символ по индексу
12. indexOf() - ищет первое вхождение подстроки
13. substring() - возвращает подстроку

РАЗЛИЧИЯ:
- StringBuilder - НЕ потокобезопасный, но быстрее
- StringBuffer - потокобезопасный, но медленнее

ПРАКТИКА 2 - Преобразование между типами:

String → StringBuilder: new StringBuilder(string)
String → StringBuffer: new StringBuffer(string)
StringBuilder → String: stringBuilder.toString()
StringBuffer → String: stringBuffer.toString()
StringBuilder → StringBuffer: new StringBuffer(stringBuilder.toString())
StringBuffer → StringBuilder: new StringBuilder(stringBuffer.toString())

String - неизменяемый (immutable)
StringBuilder/StringBuffer - изменяемые (mutable)
*/
