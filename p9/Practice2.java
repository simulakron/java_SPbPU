public class Practice2 {
    public static void main(String[] args) {
        // Пример использования break и continue в цикле for
        for (int i = 1; i <= 10; i++) {
            if (i == 3) {
                continue; // пропускаем итерацию когда i = 3
            }
            if (i == 8) {
                break; // выходим из цикла когда i = 8
            }
            System.out.println("i = " + i);
        }
    }
}