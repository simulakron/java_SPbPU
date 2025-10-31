public class Practice2 {
    public static void main(String[] args) {
        System.out.println("=== Все способы создания Boolean ===");
        
        // 1. Конструктор 
        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean(false);
        Boolean bool3 = new Boolean("true");
        Boolean bool4 = new Boolean("false");
        Boolean bool5 = new Boolean("TRUE"); // нечувствителен к регистру
        Boolean bool6 = new Boolean("anything"); // false для любой строки кроме "true"
        
        System.out.println("1. Конструкторы:");
        System.out.println("new Boolean(true) = " + bool1);        // true
        System.out.println("new Boolean(false) = " + bool2);       // false
        System.out.println("new Boolean(\"true\") = " + bool3);    // true
        System.out.println("new Boolean(\"false\") = " + bool4);   // false
        System.out.println("new Boolean(\"TRUE\") = " + bool5);    // true
        System.out.println("new Boolean(\"anything\") = " + bool6); // false
        
        // 2. valueOf(boolean) - предпочтительный способ
        Boolean bool7 = Boolean.valueOf(true);
        Boolean bool8 = Boolean.valueOf(false);
        
        System.out.println("\n2. Boolean.valueOf(boolean):");
        System.out.println("Boolean.valueOf(true) = " + bool7);   // true
        System.out.println("Boolean.valueOf(false) = " + bool8);  // false
        
        // 3. valueOf(String) - предпочтительный способ
        Boolean bool9 = Boolean.valueOf("true");
        Boolean bool10 = Boolean.valueOf("false");
        Boolean bool11 = Boolean.valueOf("TRUE");
        Boolean bool12 = Boolean.valueOf("FALSE");
        Boolean bool13 = Boolean.valueOf("True");
        Boolean bool14 = Boolean.valueOf("anything"); // false
        
        System.out.println("\n3. Boolean.valueOf(String):");
        System.out.println("Boolean.valueOf(\"true\") = " + bool9);      // true
        System.out.println("Boolean.valueOf(\"false\") = " + bool10);    // false
        System.out.println("Boolean.valueOf(\"TRUE\") = " + bool11);     // true
        System.out.println("Boolean.valueOf(\"FALSE\") = " + bool12);    // false
        System.out.println("Boolean.valueOf(\"True\") = " + bool13);     // true
        System.out.println("Boolean.valueOf(\"anything\") = " + bool14); // false
        
        // 4. parseBoolean(String) - возвращает примитив boolean
        boolean prim1 = Boolean.parseBoolean("true");
        boolean prim2 = Boolean.parseBoolean("false");
        boolean prim3 = Boolean.parseBoolean("TRUE");
        boolean prim4 = Boolean.parseBoolean("anything"); // false
        
        System.out.println("\n4. Boolean.parseBoolean(String):");
        System.out.println("Boolean.parseBoolean(\"true\") = " + prim1);      // true
        System.out.println("Boolean.parseBoolean(\"false\") = " + prim2);     // false
        System.out.println("Boolean.parseBoolean(\"TRUE\") = " + prim3);      // true
        System.out.println("Boolean.parseBoolean(\"anything\") = " + prim4);  // false
        
        // 5. Автоупаковка (autoboxing)
        Boolean bool15 = true;  // автоупаковка boolean → Boolean
        Boolean bool16 = false; // автоупаковка
        
        System.out.println("\n5. Автоупаковка:");
        System.out.println("Boolean bool15 = true → " + bool15);   // true
        System.out.println("Boolean bool16 = false → " + bool16);  // false
        
        // 6. Константы Boolean
        Boolean bool17 = Boolean.TRUE;
        Boolean bool18 = Boolean.FALSE;
        
        System.out.println("\n6. Константы:");
        System.out.println("Boolean.TRUE = " + bool17);   // true
        System.out.println("Boolean.FALSE = " + bool18);  // false
        
        // 7. Логические операции, возвращающие Boolean
        Boolean bool19 = (10 > 5);   // true
        Boolean bool20 = (10 < 5);   // false
        Boolean bool21 = Boolean.logicalAnd(true, false); // false
        Boolean bool22 = Boolean.logicalOr(true, false);  // true
        Boolean bool23 = Boolean.logicalXor(true, true);  // false
        
        System.out.println("\n7. Логические операции:");
        System.out.println("(10 > 5) = " + bool19);                          // true
        System.out.println("(10 < 5) = " + bool20);                          // false
        System.out.println("Boolean.logicalAnd(true, false) = " + bool21);   // false
        System.out.println("Boolean.logicalOr(true, false) = " + bool22);    // true
        System.out.println("Boolean.logicalXor(true, true) = " + bool23);    // false
        
        // 8. Сравнение производительности и рекомендации
        System.out.println("\n8. Рекомендации:");
        System.out.println("Конструкторы DEPRECATED - не использовать!");
        System.out.println("Лучше использовать Boolean.valueOf() или автоупаковку");
        System.out.println("Для примитивов - Boolean.parseBoolean()");
        
        // Демонстрация кэширования valueOf
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf(true);
        Boolean b3 = Boolean.TRUE;
        
        System.out.println("\nКэширование Boolean.valueOf(true):");
        System.out.println("b1 == b2: " + (b1 == b2)); // true - один объект
        System.out.println("b1 == b3: " + (b1 == b3)); // true - один объект
        System.out.println("b1.equals(b2): " + b1.equals(b2)); // true
    }
}