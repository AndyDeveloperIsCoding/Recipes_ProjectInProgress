import java.util.List;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        for (Integer number : list) {
            System.out.println(number);
        }
    }
}