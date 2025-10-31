public class Practice1 {
    public static void main(String[] args) {
        // 1. byte
        byte byteValue = 1;
        switch(byteValue) {
            case 1: System.out.println("byte case 1"); break;
            case 2: System.out.println("byte case 2"); break;
        }
        
        // 2. short
        short shortValue = 10;
        switch(shortValue) {
            case 10: System.out.println("short case 10"); break;
            case 20: System.out.println("short case 20"); break;
        }
        
        // 3. int
        int intValue = 100;
        switch(intValue) {
            case 100: System.out.println("int case 100"); break;
            case 200: System.out.println("int case 200"); break;
        }
        
        // 4. char
        char charValue = 'A';
        switch(charValue) {
            case 'A': System.out.println("char case A"); break;
            case 'B': System.out.println("char case B"); break;
        }
        
        // 5. String (с Java 7)
        String stringValue = "hello";
        switch(stringValue) {
            case "hello": System.out.println("String case hello"); break;
            case "world": System.out.println("String case world"); break;
        }
        
        // 6. enum
        Color color = Color.RED;
        switch(color) {
            case RED: System.out.println("enum case RED"); break;
            case GREEN: System.out.println("enum case GREEN"); break;
        }
        
        // 7. Byte, Short, Integer, Character (автораспаковка)
        Integer integerValue = 5;
        switch(integerValue) {
            case 5: System.out.println("Integer case 5"); break;
            case 10: System.out.println("Integer case 10"); break;
        }
        
        // 8. var 
        var varValue = "test";
        switch(varValue) {
            case "test": System.out.println("var case test"); break;
            case "demo": System.out.println("var case demo"); break;
        }
    }
    
    enum Color {
        RED, GREEN, BLUE
    }
}
