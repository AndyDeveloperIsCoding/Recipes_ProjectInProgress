import java.util.*;

public class Main {

    static void changeList(List<String> list) {
        // write your code here

        String longest = "";

        for (String item : list) {
            if (item.length() > longest.length()) {
                longest = item;
            }
        }

        for (int i = 0; i < list.size(); i++) {
            list.set(i, longest);
        }
    }


    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        List<String> lst = Arrays.asList(s.split(" "));
        changeList(lst);
        lst.forEach(e -> System.out.print(e + " "));
    }
}