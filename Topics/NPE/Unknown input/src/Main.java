class Util {
    // correct this method to avoid NPE
    public static void printLength(String name) {

        int x = funk(10);
        System.out.println("X is: " + x);

    }
        public static int funk(int n){
        int a = 1;
        int b = 1;
        int x = 0;
        for (int j = 2; j < n; j++) {
            x = a + b;
            a = b;
            b = x;
        }

        return x;

    }
}