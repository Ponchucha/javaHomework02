/*Дана строка (получение через обычный текстовый файл!!!)

"фамилия":"Иванов","оценка":"5","предмет":"Математика"
"фамилия":"Петрова","оценка":"4","предмет":"Информатика"

Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
Студент [фамилия] получил [оценка] по предмету [предмет].

Пример вывода в консоль:
Студент Иванов получил 5 по предмету Математика.
Студент Петрова получил 4 по предмету Информатика.
Студент Краснов получил 5 по предмету Физика. */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class task02 {
    public static void main(String[] args) {
        PrintClassBook("text.txt");
    }
    static void PrintClassBook(String filePath){
        String data = "";
        try {
            File text = new File(filePath);
            if (text.createNewFile()){
                System.out.println("An empty file has been created");
            }
            else{
                BufferedReader bufReader = new BufferedReader(new FileReader(text));
                HashMap<String,String> classBookHashMap = new HashMap<>();
                String [] entry = new String [3];                               // Одна запись в журнале, разбитая по блокам
                String [] template = {"Студент ", " получил ", " по предмету "};// шаблон
                StringBuilder removeQuotes = new StringBuilder();
                StringBuilder resultStringBuilder = new StringBuilder();
                String result = "";
                while ((data = bufReader.readLine()) != null){                  //читаем строку за строкой, пока они не кончатся
                    removeQuotes.delete(0, removeQuotes.length());        // обнуляем удалитель кавычек
                    for (int i = 0; i < data.length(); i++) {
                        if (data.charAt(i) != '"'){
                            removeQuotes.append(data.charAt(i));                //убираем кавычки
                        }
                    }
                    data = removeQuotes.toString();
                    entry = data.split(",");                              // разбиваем на блоки
                    for (int index = 0; index < entry.length; index++) {
                        entry[index] = entry[index].split(":")[1];        // убираем ненужный текст
                    }
                    for (int i = 0; i < template.length; i++) {                 // собираем строку из данных файла и шаблона
                        resultStringBuilder.append(template[i]);
                        resultStringBuilder.append(entry[i]);
                    }
                    resultStringBuilder.append(".\n");                      // переход на новую строку
                }
                bufReader.close();
                result = resultStringBuilder.toString();
                System.out.println(result);
            }
                
        }
        catch (Exception e) {
            System.out.println("Can't read data");
        }
        finally{
                System.out.println("Готово!");
            }

    }
}

