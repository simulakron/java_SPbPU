public class TernaryPractice {
    public static void main(String[] args) {
        int a = 2; // пример значения
        
        // Исходный код с if-else if-else:
        int i = 0;
        if (a == 1) {
            i = 1;
        } else if (a == 2) {
            i = 2;
        } else {
            i = 3; 
        }
        
        System.out.println("if-else результат: " + i);
        
        // Преобразование в тернарный оператор:
        int j = (a == 1) ? 1 : (a == 2) ? 2 : 3;
        
        System.out.println("тернарный оператор результат: " + j);
        
        // Альтернативный вариант с промежуточными переменными для лучшей читаемости:
        int k = (a == 1) ? 1 : 
                (a == 2) ? 2 : 3;
        
        System.out.println("форматированный тернарный результат: " + k);
    }
}
