import java.util.Scanner;

public class GreetingProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "CP866");
        
        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine();
        
        System.out.println("Привет, " + name);
        
        scanner.close();
    }
}
