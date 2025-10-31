public class VarArgsOverloading {
    
    // Перегруженные методы с переменным числом параметров
    
    public static void printValues(String... values) {
        System.out.print("Strings: ");
        for (String s : values) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
    
    public static void printValues(int... values) {
        System.out.print("Integers: ");
        for (int num : values) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void printValues(String prefix, int... values) {
        System.out.print(prefix + " ");
        for (int num : values) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printValues("Hello", "World");
        printValues(1, 2, 3);
        printValues("Numbers:", 10, 20);
    }
}
