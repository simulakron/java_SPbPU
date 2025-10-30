/**
 * Класс для демонстрации работы с банковским счетом и javadoc.
 * 
 * @author Ульяна
 * @version 1.0
 * @since 1.8
 */
public class JavadocPractice {
    private double balance;
    private String ownerName;
    
    /**
     * Конструктор для создания банковского счета.
     * 
     * @param ownerName имя владельца счета
     * @param initialBalance начальный баланс счета
     */
    public JavadocPractice(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        this.balance = initialBalance;
    }
    
    /**
     * Метод для пополнения счета.
     * 
     * @param amount сумма для пополнения
     * @return новый баланс счета после пополнения
     * @throws IllegalArgumentException если сумма отрицательная
     */
    public double deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной");
        }
        balance += amount;
        return balance;
    }
    
    /**
     * Метод для снятия денег со счета.
     * 
     * @param amount сумма для снятия
     * @return новый баланс счета после снятия
     * @throws IllegalArgumentException если сумма отрицательная
     * @throws IllegalStateException если недостаточно средств
     */
    public double withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной");
        }
        if (amount > balance) {
            throw new IllegalStateException("Недостаточно средств на счете");
        }
        balance -= amount;
        return balance;
    }
    
    /**
     * Получить текущий баланс счета.
     * 
     * @return текущий баланс счета
     */
    public double getBalance() {
        return balance;
    }
    
    /**
     * Получить имя владельца счета.
     * 
     * @return имя владельца счета
     */
    public String getOwnerName() {
        return ownerName;
    }
    
    /**
     * Основной метод программы для демонстрации работы.
     * 
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаем банковский счет
        JavadocPractice account = new JavadocPractice("Ульяна", 1000.0);
        
        // Демонстрируем операции со счетом
        System.out.println("Создан счет для: " + account.getOwnerName());
        System.out.println("Начальный баланс: " + account.getBalance());
        
        // Пополнение счета
        account.deposit(500.0);
        System.out.println("После пополнения на 500: " + account.getBalance());
        
        // Снятие со счета
        account.withdraw(200.0);
        System.out.println("После снятия 200: " + account.getBalance());
        
        // Попытка снять слишком много
        try {
            account.withdraw(2000.0);
        } catch (IllegalStateException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        
        // Попытка отрицательного пополнения
        try {
            account.deposit(-100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}

// javadoc -d docs -author -version JavadocPractice.java