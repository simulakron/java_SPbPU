public class Practice3 {
    public static void main(String[] args) {
        System.out.println("=== NullPointerException при автоупаковке/автораспаковке ===");
        
        // 1. АВТОРАСПАКОВКА null Boolean → boolean
        System.out.println("1. Автораспаковка Boolean null:");
        Boolean boolWrapper = null;
        try {
            boolean boolPrimitive = boolWrapper; // NullPointerException!
            System.out.println("Этот код не выполнится");
        } catch (NullPointerException e) {
            System.out.println("NPE при: boolean prim = Boolean null");
        }
        
        // 2. АВТОРАСПАКОВКА null Integer → int
        System.out.println("\n2. Автораспаковка Integer null:");
        Integer intWrapper = null;
        try {
            int intPrimitive = intWrapper; // NullPointerException!
            System.out.println("Этот код не выполнится");
        } catch (NullPointerException e) {
            System.out.println("NPE при: int prim = Integer null");
        }
        
        // 3. АВТОРАСПАКОВКА в арифметических операциях
        System.out.println("\n3. Автораспаковка в арифметических операциях:");
        Integer nullInt = null;
        try {
            int result = nullInt + 10; // NullPointerException!
            System.out.println("Этот код не выполнится");
        } catch (NullPointerException e) {
            System.out.println("NPE при: nullInt + 10");
        }
        
        // 4. АВТОРАСПАКОВКА в условиях
        System.out.println("\n4. Автораспаковка в условиях:");
        Boolean nullBool = null;
        try {
            if (nullBool) { // NullPointerException!
                System.out.println("Этот код не выполнится");
            }
        } catch (NullPointerException e) {
            System.out.println("NPE при: if (nullBool)");
        }
        
        // 5. АВТОРАСПАКОВКА в switch
        System.out.println("\n5. Автораспаковка в switch:");
        Integer caseValue = null;
        try {
            switch (caseValue) { // NullPointerException!
                case 1: System.out.println("1"); break;
                default: System.out.println("default");
            }
        } catch (NullPointerException e) {
            System.out.println("NPE при: switch (nullInteger)");
        }
        
        // 6. АВТОРАСПАКОВКА при вызове методов
        System.out.println("\n6. Автораспаковка при вызове методов:");
        Integer nullParam = null;
        try {
            printIntValue(nullParam); // NullPointerException!
        } catch (NullPointerException e) {
            System.out.println("NPE при вызове метода с int параметром и Integer null");
        }
        
        // 7. БЕЗОПАСНЫЕ операции (не вызывают NPE)
        System.out.println("\n7. Безопасные операции (не вызывают NPE):");
        
        // Автоупаковка - всегда безопасна
        Integer safe1 = null; // просто присваивание null
        System.out.println("Автоупаковка null: " + safe1); // null
        
        // Сравнение с null - безопасно
        Boolean safeBool = null;
        if (safeBool == null) {
            System.out.println("Boolean is null - безопасно");
        }
        
        // Вызов методов на null объекте - безопасно до автораспаковки
        Integer safeInt = null;
        System.out.println("Integer.toString(): " + safeInt.toString()); // NPE, но не из-за автораспаковки
        
        // 8. КАК ИЗБЕЖАТЬ NPE
        System.out.println("\n8. Как избежать NullPointerException:");
        
        Integer possiblyNull = getPossibleNull();
        
        // Способ 1: Проверка на null перед автораспаковкой
        if (possiblyNull != null) {
            int safeValue = possiblyNull; // безопасно
            System.out.println("Safe unboxing: " + safeValue);
        } else {
            System.out.println("Значение null - используем значение по умолчанию");
            int defaultValue = 0;
            System.out.println("Default value: " + defaultValue);
        }
        
        // Способ 2: Использование ternary оператора
        int value = (possiblyNull != null) ? possiblyNull : 0;
        System.out.println("Ternary safe unboxing: " + value);
        
        // Способ 3: Использование Objects.requireNonNullElse()
        int safeVal = java.util.Objects.requireNonNullElse(possiblyNull, 0);
        System.out.println("Objects.requireNonNullElse: " + safeVal);
    }
    
    public static void printIntValue(int value) {
        System.out.println("Value: " + value);
    }
    
    public static Integer getPossibleNull() {
        // Может вернуть null в реальном приложении
        return null;
    }
}