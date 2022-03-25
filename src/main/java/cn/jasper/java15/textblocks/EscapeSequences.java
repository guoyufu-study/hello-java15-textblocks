package cn.jasper.java15.textblocks;

public class EscapeSequences {

    public static void main(String[] args) {
        String s = """
                Color   Shape
                Red     Circle
                Green   Square
                Blue    Triangle
                """;

        System.out.println(s);


        String code = """
                String source = \"""
                    String message = "Hello, World!";
                    System.out.println(message);
                    \""";
                """;
        System.out.println(code);


        String ss = """
           red  \040
           green\040
           blue \040
           """;
        System.out.println(ss);
    }
}
