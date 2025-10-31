public class Main {
    public static void main(String[] args) {
        A a = new A();
        Number[] num = {new Integer(1), 11, 1.11f, 11.11};
        
        // цикл for (1)
        System.out.println("=== Цикл for (1) ===");
        for (Number n : num) {
            a.printNum(n); // Компилятор видит тип Number, поэтому всегда вызывается printNum(Number n)
        }
        
        // (2)
        System.out.println("\n=== Прямые вызовы (2) ===");
        a.printNum(new Integer(1)); // Компилятор видит Integer, вызывает printNum(Integer i)
        a.printNum(11);             // Компилятор видит int, вызывает printNum(int i)
        a.printNum(1.11f);          // Компилятор видит float, вызывает printNum(Float f)
        a.printNum(11.11);          // Компилятор видит double, вызывает printNum(Number n) - ближайший родитель
    }
}

class A {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i); // Вызывается для Integer объектов
    }
    
    public void printNum(int i) {
        System.out.printf("int = %d%n", i); // Вызывается для int примитивов
    }
    
    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f); // Вызывается для Float объектов
    }
    
    public void printNum(Number n) {
        System.out.println("Number=" + n); // Вызывается для любых Number и родительских типов
    }
}

/*
ОЖИДАЕМЫЙ ВЫВОД ПРОГРАММЫ:
=== Цикл for (1) ===
Number=1
Number=11
Number=1.11
Number=11.11

=== Прямые вызовы (2) ===
Integer = 1
int = 11
Float = 1.1100
Number=11.11

ОБЪЯСНЕНИЕ РАЗЛИЧИЙ:

В ЦИКЛЕ (1):
- Компилятор видит тип переменной n как Number (объявлен в массиве)
- Выбор метода происходит на этапе КОМПИЛЯЦИИ (static binding)
- Поэтому ВСЕГДА вызывается printNum(Number n), независимо от реального типа объекта

В ПРЯМЫХ ВЫЗОВАХ (2):
- Компилятор видит реальные типы аргументов:
  * new Integer(1) → Integer → printNum(Integer i)
  * 11 → int → printNum(int i)  
  * 1.11f → float → printNum(Float f) (автоупаковка)
  * 11.11 → double → printNum(Number n) (ближайший родитель)
- Выбор метода происходит на этапе КОМПИЛЯЦИИ по типу аргумента

КЛЮЧЕВОЙ МОМЕНТ:
Перегрузка разрешается на этапе КОМПИЛЯЦИИ, а не выполнения!
Тип переменной (Number) важнее реального типа объекта при перегрузке.
*/