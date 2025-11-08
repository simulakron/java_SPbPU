import java.io.*;
import java.util.Arrays;

public class StreamsDemo {
    public static void main(String[] args) {
        // Практика 1 - InputStream и метод read()
        System.out.println("=== Практика 1 - InputStream read() ===");
        try (InputStream input = new ByteArrayInputStream("Hello".getBytes())) {
            int data;
            System.out.print("Прочитанные байты: ");
            while ((data = input.read()) != -1) {
                System.out.print((char) data + "(" + data + ") ");
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Практика 2 - OutputStream и метод write(int)
        System.out.println("\n=== Практика 2 - OutputStream write(int) ===");
        try (OutputStream output = new ByteArrayOutputStream()) {
            byte[] bytes = "Java".getBytes();
            for (byte b : bytes) {
                output.write(b); // Записываем каждый байт отдельно
            }
            System.out.println("Записано: " + output.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Практика 4 - AutoCloseable
        System.out.println("\n=== Практика 4 - AutoCloseable ===");
        try (MyResource resource = new MyResource()) {
            resource.use();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Ресурс автоматически закроется в блоке finally
    }
}

// Практика 4 - пример класса с AutoCloseable
class MyResource implements AutoCloseable {
    public void use() {
        System.out.println("Используем ресурс");
    }
    
    @Override
    public void close() {
        System.out.println("Ресурс автоматически закрыт");
    }
}

/*
ОБЪЯСНЕНИЕ:

ПРАКТИКА 1 - InputStream read():
- InputStream - абстрактный класс для чтения байтов
- Метод read() возвращает:
  * следующий байт (0-255) или
  * -1 если конец потока
- ByteArrayInputStream - реализация для работы с байтовыми массивами

ПРАКТИКА 2 - OutputStream write(int):
- OutputStream - абстрактный класс для записи байтов
- Метод write(int) записывает младший байт переданного int
- ByteArrayOutputStream - реализация для записи в байтовый массив

ПРАКТИКА 3 - Зачем Reader/Writer если есть InputStream/OutputStream:

InputStream/OutputStream работают с БАЙТАМИ (8 бит)
- Подходят для любых двоичных данных
- Не учитывают кодировку текста

Reader/Writer работают с СИМВОЛАМИ (Unicode, 16 бит)
- Специализированы для текста
- Учитывают кодировку (UTF-8, Windows-1251 и т.д.)
- Автоматически преобразуют байты в символы и обратно

Пример различий:
- InputStream.read() → байт 0-255
- Reader.read() → символ 0-65535 (Unicode)

ПРАКТИКА 4 - AutoCloseable:
- Интерфейс для ресурсов, которые нужно закрывать
- Позволяет использовать try-with-resources
- Гарантирует вызов close() даже при исключениях
- Избавляет от необходимости писать блоки finally
*/