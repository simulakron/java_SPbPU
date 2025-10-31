public class Practice4 {
    public static void main(String[] args) {
        // С базовыми типами
        String str = "Result: ";
        int num = 10;
        double d = 3.14;
        boolean bool = true;
        char ch = 'A';
        
        // Конкатенация String с разными типами
        String result1 = str + num;      
        String result2 = str + d;        
        String result3 = str + bool;    
        String result4 = str + ch;     
        
        // С объектами
        Object obj = new Object();
        String result5 = "Object: " + obj; 
        
        // Комбинации разных типов
        String combined = "Value: " + 25 + " is " + true + " and " + 3.5;
        
        // Вывод результатов
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(combined);
    }
}
