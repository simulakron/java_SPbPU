public class AccessModifiersDemo {
    public static void main(String[] args) {
        AccessExample example = new AccessExample();
        
        // Практика #1 - Демонстрация спецификаторов доступа
        
        // 1. public - доступно отовсюду
        System.out.println("=== public доступ ===");
        System.out.println("publicVar: " + example.publicVar);     // Доступно
        example.publicMethod();                                    // Доступно
        
        // 2. protected - доступно в том же пакете и подклассах
        System.out.println("\n=== protected доступ ===");
        System.out.println("protectedVar: " + example.protectedVar); // Доступно (тот же пакет)
        example.protectedMethod();                                   // Доступно (тот же пакет)
        
        // 3. default (package-private) - доступно только в том же пакете
        System.out.println("\n=== default доступ ===");
        System.out.println("defaultVar: " + example.defaultVar);   // Доступно (тот же пакет)
        example.defaultMethod();                                   // Доступно (тот же пакет)
        
        // 4. private - доступно только внутри класса
        System.out.println("\n=== private доступ ===");
        // System.out.println(example.privateVar);    // ОШИБКА компиляции
        // example.privateMethod();                   // ОШИБКА компиляции
        
        // Доступ через public методы (инкапсуляция)
        System.out.println("privateVar через геттер: " + example.getPrivateVar());
    }
}

class AccessExample {
    // Спецификаторы доступа для переменных
    public String publicVar = "public переменная";
    protected String protectedVar = "protected переменная";
    String defaultVar = "default переменная"; // без спецификатора (package-private)
    private String privateVar = "private переменная";
    
    // public метод - доступен отовсюду
    public void publicMethod() {
        System.out.println("public метод вызван");
    }
    
    // protected метод - доступен в пакете и подклассах
    protected void protectedMethod() {
        System.out.println("protected метод вызван");
    }
    
    // default метод - доступен только в пакете
    void defaultMethod() {
        System.out.println("default метод вызван");
    }
    
    // private метод - доступен только внутри класса
    private void privateMethod() {
        System.out.println("private метод вызван");
    }
    
    // public геттер для private переменной (инкапсуляция)
    public String getPrivateVar() {
        return privateVar;
    }
}