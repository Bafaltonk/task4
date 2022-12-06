import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Ввод данных
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] words = s.split(" ");
        String[] numbers = words[0].split(",");
        int n = Integer.parseInt(numbers[0]);
        int k = Integer.parseInt(numbers[1]);
        // Заполнение индексов words, которыми заканчиваются строки
        String str = words[1];
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 1; i < words.length - 1; i++){
            if ((str + words[i+1]).length() <= k ){
                str += words[i+1];
            }else{
                str = words[i+1];
                array.add(i);
            }
        }
        // Вывод по найденным индексам
        for (int j = 1; j < array.get(1)-1; j++){
            System.out.print(words[j]+" ");
        }
        System.out.println("");
        for (int i = 1; i < array.size(); i++){
            for (int j = array.get(i-1)+1; j < array.get(i)+1; j++){
                System.out.print(words[j]+" ");
            }
            System.out.println("");
        }
        for (int j = array.get(array.size()-1)+1; j < words.length; j++){
            System.out.print(words[j]+" ");
        }
        System.out.println("");
        // Вывод остальных заданий
        System.out.println(split("((())())(()(()()))"));
        System.out.println(toCamelCase("hello_world"));
        System.out.println(toSnakeCase("helloWorld"));
        double[] a = new double[] {13.25, 15, 30, 1.5};
        System.out.println(overTime(a));
        System.out.println(BMI("90 kilos","1.86 meters"));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("aabbbccccd"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        String[] b = {"451999277", "41177722899"};
        System.out.println(trouble(b));
        String[] c = {"AZYWABBCATTTA", "A"};
        System.out.println(countUniqueBooks(c));
    }

    static ArrayList<String> split(String s){
        int indexOpen = 0;
        int indexClose = 0;
        ArrayList<String> result = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.substring(i, i+1).equals("(")){
                indexOpen += 1;
            }else if (s.substring(i, i+1).equals(")")){
                indexClose += 1;
            }
            if (indexOpen-indexClose == 0){
                result.add(s.substring(index, i+1));
                index = i+1;
            }
        }
        return result;
    }

    static String toCamelCase(String s){
        String[] words = s.split("_");
        String result = words[0];
        for (int i = 1; i<words.length; i++){
            result += words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }
        return result;
    }

    static String toSnakeCase(String s){
        String result = "";

        char c = s.charAt(0);
        result = result + Character.toLowerCase(c);

        for (int i = 1; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result += Character.toLowerCase(ch);
            }

            else {
                result = result + ch;
            }
        }

        return result;
    }

    static String overTime(double[] a){
        if (a[1] <= 17){
            return "$"+String.format("%(.2f", ((a[1]-a[0])*a[2]));
        }else{
            return "$"+String.format("%(.2f", (((17-a[0])*a[2])+(a[1]-17)*a[2]*a[3]));
        }
    }

    static String BMI(String a, String b){
        String[] words_a = a.split(" ");
        String[] words_b = b.split(" ");
        double weight = Double.parseDouble(words_a[0]);
        double height = Double.parseDouble(words_b[0]);
        if (words_a[1].equals("pounds")){
            weight *= 0.45359237;
        }
        if (words_b[1].equals("inches")){
            weight *= 0.025;
        }
        double BMI = weight/(height*height);
        if (BMI < 18.5){
            return String.format("%(.1f ", BMI)+"Underweight";
        }else if (BMI >= 25){
            return String.format("%(.1f ", BMI)+"Overweight";
        }else{
            return String.format("%(.1f ", BMI)+"Normal weight";
        }
    }

    static int bugger(int a){
        int i = 0;
        String s = Integer.toString(a);
        while (s.length() != 1){
            int summ = 1;
            for (int j = 0; j < s.length();j++){
                summ = summ * Integer.parseInt(s.substring(j,j+1));
            }
            s = Integer.toString(summ);
            i += 1;
        }
        return i;
    }

    static String toStarShorthand(String lines) {
        String outputStr = "";
        int counter = 0;
        String line = lines + "0";
        for (int i = 0; i < line.length() - 1; i++) {
            if (!line.substring(i, i + 1).equals(line.substring(i + 1, i + 2)) && counter == 0) {
                outputStr += line.substring(i, i + 1);
            } else if (line.substring(i, i + 1).equals(line.substring(i + 1, i + 2))) {
                counter += 1;
            } else {
                outputStr += line.substring(i, i + 1) + "*" + (counter + 1);
                counter = 0;
            }
        }
        return outputStr;
    }

    static Boolean doesRhyme(String line1, String line2) {
        String lineCheck1 = line1;
        String lineCheck2 = line2;
        if (lineCheck1.substring(lineCheck1.length() - 1, lineCheck1.length()).matches("[?!.]($|\\s)")) {
            lineCheck1 = lineCheck1.substring(0, lineCheck1.length() - 1);
        }
        if (lineCheck2.substring(lineCheck2.length() - 1, lineCheck2.length()).matches("[?!.]($|\\s)")) {
            lineCheck2 = lineCheck2.substring(0, lineCheck2.length() - 1);
        }
        if (lineCheck1.substring(lineCheck1.length() - 2, lineCheck1.length())
                .equals(lineCheck2.substring(lineCheck2.length() - 2, lineCheck2.length()))) {
            return true;
        } else
            return false;
    }

    static Boolean trouble(String[] strings) {
        String first = strings[0];
        String second = strings[1];
        int ch = 0;
        for (int i = 0; i < first.length() - 2; i++) {
            if ((first.charAt(i) == first.charAt(i + 1)) && (first.charAt(i) == first.charAt(i + 2))) {
                ch = first.charAt(i);
            }
        }
        if (ch == 0) {
            return false;
        }
        for (int i = 0; i < second.length() - 1; i++) {
            if ((second.charAt(i) == ch) && (second.charAt(i + 1) == ch)) {
                return true;
            }
        }
        return false;
    }

    static int countUniqueBooks(String[] strings) {
        String[] _strings = strings[0].split("");
        Set<String> stringSet = new HashSet<String>();
        int k = 0;
        for (int i = 0; i < _strings.length; i++) {
            if (_strings[i].equals(strings[1])) {
                k += 1;
            }
            if (k % 2 != 0) {
                stringSet.add(_strings[i]);
            }
        }
        return stringSet.size() - 1;
    }
}