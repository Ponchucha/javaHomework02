import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class task03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        File calcLog = new File("calcLog.txt");
        while (true){
            System.out.println("Input first number or input 'close' to close the calc: ");
            String number01str = in.next();
            System.out.println(number01str);
            if (! number01str.equals("close")){   
                int number01 = Integer.parseInt(number01str);
                System.out.println("Input operation: ");
                String operation = in.next();
                System.out.println("Input second number: ");
                int number02 = in.nextInt();
                int result = 0;
                switch (operation) {
                    case "+":
                        result = number01+number02;
                        break;
                    case "-":
                        result = number01-number02;
                        break;
                    case "*":
                        result = number01*number02;
                        break;
                    case "/":
                        result = number01/number02;
                        break;
                }      
                System.out.printf("%d %s %d = %d\n", number01, operation, number02, result);
                try {                    
                    FileWriter writer = new FileWriter(calcLog, true); // не нашла, как делать форматированную запись в файл
                    writer.write(number01);// как вот к примеру сразу записать произвольную строку и переменные в ней?
                    writer.write(" ");
                    writer.write(operation);
                    writer.write(" ");
                    writer.write(number02);
                    writer.write(" = ");
                    writer.write(result);
                    writer.write("\n");
                    writer.close(); 
                } catch (Exception e) {
                    System.out.println("Unable to write log");
                }
            }
            else{
                in.close();
                break;
            }
        }
        
    }
}
