public class Practice4 {
    public static void main(String[] args) {
        // Значение 128 - ВНЕ диапазона кэша Integer (-128 до 127)
        int i1 = 128;
        Integer a1 = i1;  // автоупаковка через Integer.valueOf(128) - создает новый объект
        Integer b1 = i1;  // автоупаковка через Integer.valueOf(128) - создает новый объект
        
        System.out.println("a1==i1 " + (a1 == i1));        
        // true - при сравнении Integer == int происходит автораспаковка a1 в int 128
        
        System.out.println("b1==i1 " + (b1 == i1));        
        // true - при сравнении Integer == int происходит автораспаковка b1 в int 128
        
        System.out.println("a1==b1 " + (a1 == b1));        
        // false - a1 и b1 разные объекты (128 вне кэша), сравнение ссылок дает false
        
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));  
        // true - equals сравнивает значения, происходит автораспаковка i1
        
        System.out.println("b1.equals(i1) -> " + b1.equals(i1));  
        // true - equals сравнивает значения, происходит автораспаковка i1
        
        System.out.println("a1.equals(b1) -> " + a1.equals(b1));  
        // true - equals сравнивает значения (оба 128)

        // Значение 127 - В диапазоне кэша Integer (-128 до 127)
        int i2 = 127;
        Integer a2 = i2;  // автоупаковка через Integer.valueOf(127) - объект из кэша
        Integer b2 = i2;  // автоупаковка через Integer.valueOf(127) - тот же объект из кэша
        
        System.out.println("a2==i2 " + (a2 == i2));        
        // true - при сравнении Integer == int происходит автораспаковка a2 в int 127
        
        System.out.println("b2==i2 " + (b2 == i2));        
        // true - при сравнении Integer == int происходит автораспаковка b2 в int 127
        
        System.out.println("a2==b2 " + (a2 == b2));        
        // true - a2 и b2 ссылаются на ОДИН объект из кэша (127 в диапазоне кэша)
        
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));  
        // true - equals сравнивает значения, происходит автораспаковка i2
        
        System.out.println("b2.equals(i2) -> " + b2.equals(i2));  
        // true - equals сравнивает значения, происходит автораспаковка i2
        
        System.out.println("a2.equals(b2) -> " + a2.equals(b2));  
        // true - equals сравнивает значения (оба 127)

        /*
        Класс IntegerCache:
        - Назначение: кэширует объекты Integer для часто используемых значений
        - Диапазон по умолчанию: от -128 до 127
        - Экономит память: для значений в этом диапазоне создается только один объект
        - Автоупаковка использует Integer.valueOf(), который возвращает объекты из кэша
        
        Почему a1==b1 false, а a2==b2 true:
        - 128 > 127 → вне диапазона кэша → создаются разные объекты → сравнение ссылок false
        - 127 в диапазоне кэша → возвращается один объект → сравнение ссылок true
        
        Рекомендация: всегда используйте equals() для сравнения объектов-оболочек!
        */
    }
}