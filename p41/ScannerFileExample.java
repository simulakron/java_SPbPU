import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerFileExample {
    public static void main(String[] args) {
        // Практика 1 - чтение данных из текстового файла с помощью Scanner
        
        System.out.println("=== Чтение файла построчно ===");
        try (Scanner fileScanner = new Scanner(new File("test.txt"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
        
        
        System.out.println("\n=== Чтение чисел из файла ===");
        try (Scanner numberScanner = new Scanner(new File("numbers.txt"))) {
            while (numberScanner.hasNextInt()) {
                int number = numberScanner.nextInt();
                System.out.println("Число: " + number);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
    }
}

/*
ОБЪЯСНЕНИЕ:

1. Scanner для чтения файлов:
   - new Scanner(new File("имя_файла"))
   - Автоматически закрывается в try-with-resources

2. Основные методы:
   - hasNextLine()/nextLine() - для построчного чтения
   - hasNext()/next() - для чтения слов
   - hasNextInt()/nextInt() - для чтения целых чисел
*/