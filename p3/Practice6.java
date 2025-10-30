public class Practice6 {
    public static void main(String[] args) {
        // Пример 1: double → float
        double d = 3.14159265359;
        float f = (float) d;  // double → float (потеря точности)
        System.out.println("double " + d + " → float " + f);
        
        // Пример 2: long → int
        long l = 2147483648L;
        int i = (int) l;  // long → int (переполнение)
        System.out.println("long " + l + " → int " + i);
        
        // Пример 3: int → short
        int largeInt = 32768;
        short s = (short) largeInt;  // int → short (переполнение)
        System.out.println("int " + largeInt + " → short " + s);
        
        // Пример 4: int → byte
        int intVal = 257;
        byte b = (byte) intVal;  // int → byte (переполнение)
        System.out.println("int " + intVal + " → byte " + b);
        
        // Пример 5: float → int
        float floatVal = 3.99f;
        int intFromFloat = (int) floatVal;  // float → int (отбрасывание дробной части)
        System.out.println("float " + floatVal + " → int " + intFromFloat);
        
        // Пример 6: char → byte
        char ch = 'A';  // Unicode 65
        byte byteFromChar = (byte) ch;  // char → byte (сужение диапазона)
        System.out.println("char '" + ch + "' → byte " + byteFromChar);
    }
}