public class A {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void main(String[] args) {
        // Практика #1 - Все варианты вызова статического метода printVars()
        
        // 1. Вызов через имя класса (рекомендуемый способ)
        A.printVars();
        
        // 2. Вызов через объект класса
        A obj = new A();
        obj.printVars();
        
        // 3. Вызов напрямую из того же класса (без указания имени класса)
        printVars();
        
        // 4. Вызов через наследование (если есть подкласс)
        B bObj = new B();
        bObj.callParentStaticMethod();
        
        // 5. Вызов через импорт статического метода (если в другом пакете)
        // import static A.printVars;
        // затем просто: printVars();
    }
}

class B extends A {
    public void callParentStaticMethod() {
        // Вызов статического метода родительского класса
        printVars();  // напрямую
        A.printVars(); // через имя класса
    }
}