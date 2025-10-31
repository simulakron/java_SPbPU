public class Practice2 {
    public static void main(String[] args) {
        int value = 2;
        int i = 0;
        
        switch(value) {
            case 1:
                i = 1;
                break;  // break завершает выполнение switch
            case 2:
                i = 2;  // выполняется при value = 2
                // ОТСУТСТВУЕТ break! Выполнение "проваливается" в следующий case
            case 3:
                i = 3;  // выполняется из-за проваливания из case 2
                break;  // завершает выполнение switch
            default:
                i = 0;
                break;
        }
        
        System.out.println("Результат для value = 2: " + i); 
        // Вывод: Результат для value = 2: 3
        // Пояснение: i = 2 выполнилось, но затем i = 3 перезаписало значение из-за отсутствия break
    }
}