import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Decripter
{
    public static void main(String[] args) {

        System.out.println(getFile("src/resource/textIn.txt"));
        for (int i = 0; i < 33; i++) {
            System.out.println("Вдсиг "+i + " " +moveStringRight(getFile("src/resource/textIn.txt"), i));
        }
    }

    private static String getFile(String fileName) {
        StringBuilder result = new StringBuilder("");
        File file = new File(fileName);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
    private static String moveStringRight(String inputString, int shift){
        final String  bigAlfabetString = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
        final String  smallAlfabetString = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        List<String> bigList = Arrays.asList(bigAlfabetString.split(""));
        List<String> smalList = Arrays.asList(smallAlfabetString.split(""));

        String [] arrOfSymbol = inputString.split("");
        String [] shiftedText = new String[arrOfSymbol.length];
        for (int i = 0; i < arrOfSymbol.length; i++) {
            int newIndex=0;
            int oldIndex = 0;
            if(bigAlfabetString.contains(arrOfSymbol[i]))
            {
                oldIndex = bigAlfabetString.indexOf(arrOfSymbol[i]);
                if(shift+oldIndex<33){newIndex = oldIndex+shift;}
                if(shift+oldIndex>=33){newIndex = oldIndex+shift-33;}

                shiftedText[i] = bigList.get(newIndex);
            }

            else if(smallAlfabetString.contains(arrOfSymbol[i]))
            {
                oldIndex = smallAlfabetString.indexOf(arrOfSymbol[i]);
                if(shift+oldIndex<33){newIndex = oldIndex+shift;}
                if(shift+oldIndex>=33){newIndex = oldIndex+shift-33;}

                shiftedText[i] = smalList.get(newIndex);
            }
            else {shiftedText[i] = arrOfSymbol[i];}
        }
        StringBuilder sb = new StringBuilder();
        for (String s:shiftedText) {
            sb.append(s);
        }
        return sb.toString();
    }

}

