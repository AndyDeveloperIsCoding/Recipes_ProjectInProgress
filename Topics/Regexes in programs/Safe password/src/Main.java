import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String userInput = scanner.nextLine();

        String regexRule = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{12,}";

        if(userInput.matches(regexRule)){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }




        // System.out.println(userInput.matches(regexRule));
    }
}