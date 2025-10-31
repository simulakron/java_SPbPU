import java.util.Arrays;

public class ArrayPractice {
    public static void main(String[] args) {
        
        // Практика #1 - Что произойдет в результате выполнения кода?
        System.out.println("=== Практика #1 ===");
        
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        
        System.out.println("До присваивания a1 = a2:");
        System.out.println("a1: " + Arrays.toString(a1)); // [1,2,3,4,5]
        System.out.println("a2: " + Arrays.toString(a2)); // [6,7,8,9,10]
        
        a1 = a2; // a1 теперь ссылается на тот же массив, что и a2
        
        System.out.println("После присваивания a1 = a2:");
        System.out.println("a1: " + Arrays.toString(a1)); // [6,7,8,9,10]
        System.out.println("a2: " + Arrays.toString(a2)); // [6,7,8,9,10]
        
        // Изменяем элемент через a2
        a2[0] = 100;
        System.out.println("После изменения a2[0] = 100:");
        System.out.println("a1: " + Arrays.toString(a1)); // [100,7,8,9,10] - тоже изменился!
        System.out.println("a2: " + Arrays.toString(a2)); // [100,7,8,9,10]
        
        // Практика #2 - Методы класса java.util.Arrays
        System.out.println("\n=== Практика #2 ===");
        
        int[] arr1 = {5, 2, 8, 1, 9};
        int[] arr2 = {5, 2, 8, 1, 9};
        int[] arr3 = {1, 2, 3, 4, 5};
        
        // 1. String toString(...) - преобразует массив в строку
        System.out.println("1. Arrays.toString():");
        System.out.println("arr1: " + Arrays.toString(arr1)); // [5, 2, 8, 1, 9]
        
        // 2. void sort(...) - сортирует массив
        System.out.println("\n2. Arrays.sort():");
        Arrays.sort(arr1);
        System.out.println("После сортировки arr1: " + Arrays.toString(arr1)); // [1, 2, 5, 8, 9]
        
        // 3. int binarySearch(...) - бинарный поиск в отсортированном массиве
        System.out.println("\n3. Arrays.binarySearch():");
        int index = Arrays.binarySearch(arr1, 8); // ищем 8 в отсортированном массиве
        System.out.println("Индекс элемента 8 в arr1: " + index); // 3
        
        // 4. boolean equals(...) - сравнивает два массива
        System.out.println("\n4. Arrays.equals():");
        System.out.println("arr1 equals arr2: " + Arrays.equals(arr1, arr2)); // false (arr1 отсортирован)
        System.out.println("arr2 equals arr3: " + Arrays.equals(arr2, arr3)); // false (разные элементы)
        
        // 5. int compare(...) - сравнивает два массива лексикографически
        System.out.println("\n5. Arrays.compare():");
        int[] sorted1 = {1, 2, 3};
        int[] sorted2 = {1, 2, 4};
        int[] sorted3 = {1, 2, 3};
        
        int result1 = Arrays.compare(sorted1, sorted2); // -1 (sorted1 < sorted2)
        int result2 = Arrays.compare(sorted2, sorted1); // 1 (sorted2 > sorted1)  
        int result3 = Arrays.compare(sorted1, sorted3); // 0 (равны)
        
        System.out.println("compare([1,2,3], [1,2,4]): " + result1); // -1
        System.out.println("compare([1,2,4], [1,2,3]): " + result2); // 1
        System.out.println("compare([1,2,3], [1,2,3]): " + result3); // 0
        
        // Дополнительные примеры с многомерными массивами
        System.out.println("\n=== Многомерные массивы ===");
        int[][] multiArr = {{1}, {2, 3}, {4, 5, 6}};
        System.out.println("Многомерный массив: " + Arrays.deepToString(multiArr));
        System.out.println("multiArr[2][1] = " + multiArr[2][1]); // 5
    }
}
