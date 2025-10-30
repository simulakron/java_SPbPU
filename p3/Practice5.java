public class Practice5 {
    public static void main(String[] args) {
        // Пример 1: byte + short → int
        byte b = 10;
        short s = 20;
        int result1 = b + s;  // byte + short → int (оба расширяются до int)
        System.out.println("byte + short = " + result1 + " (тип int)");
        
        // Пример 2: int + long → long
        int i = 100;
        long l = 200L;
        long result2 = i + l;  // int + long → long (int расширяется до long)
        System.out.println("int + long = " + result2 + " (тип long)");
        
        // Пример 3: long + float → float
        long longVal = 1000L;
        float f = 2.5f;
        float result3 = longVal + f;  // long + float → float (long расширяется до float)
        System.out.println("long + float = " + result3 + " (тип float)");
        
        // Пример 4: float + double → double
        float floatVal = 3.14f;
        double d = 2.71828;
        double result4 = floatVal + d;  // float + double → double (float расширяется до double)
        System.out.println("float + double = " + result4 + " (тип double)");
        
        // Пример 5: char + int → int
        char c = 'A';  // Unicode 65
        int intVal = 10;
        int result5 = c + intVal;  // char + int → int (char расширяется до int)
        System.out.println("char 'A' + int = " + result5 + " (тип int)");
        
        // Пример 6: byte + byte → int
        byte b1 = 5;
        byte b2 = 10;
        int result6 = b1 + b2;  // byte + byte → int (оба byte расширяются до int)
        System.out.println("byte + byte = " + result6 + " (тип int)");
    }
}