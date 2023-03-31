/**
Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
результат после каждой итерации запишите в лог-файл.
 */
import java.io.File;
import java.io.FileWriter;
public class task01 {
public static void main(String[] args) {
    
    int[] arr = new int [] {2,6,1,7,5,9,3,6,3,0,4};
    int temp = 0;
    boolean isSorted = false;
    String path = "log.txt";
    File log = new File(path);
    try{
        FileWriter writer = new FileWriter(log,false);
        for (int element : arr) {
            writer.write(Integer.toString(element));
            writer.write(" ");
        }
        writer.write("\n");
    while (!isSorted){
        isSorted = true;
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] > arr[i+1]){
                isSorted = false;
                temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                for (int element : arr) {
                    writer.write(Integer.toString(element));
                    writer.write(" ");
                }
                writer.write("\n");
            }
        }
    }
    writer.close();
    }
    catch (Exception e){
        System.out.println("Log writing failed");
    }
    for (int i : arr) {
        System.out.print(i);
        System.out.print(" ");
    }
}    
}