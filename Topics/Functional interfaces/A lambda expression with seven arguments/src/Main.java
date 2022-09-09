// import static jdk.nashorn.internal.objects.NativeString.toUpperCase;

class Seven {
    public static SeptenaryStringFunction fun = (a, b, c, d, e, f, g) -> {
        String sentence = a + b + c + d + e + f + g;
        String sentenceFinal = sentence.toUpperCase();
        return sentenceFinal;
    };


        //write your code here
}

@FunctionalInterface
interface SeptenaryStringFunction {
    String apply(String s1, String s2, String s3, String s4, String s5, String s6, String s7);
}