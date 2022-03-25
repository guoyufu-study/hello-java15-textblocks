package cn.jasper.java15.textblocks.style;

public class SingleLine {

    public static void main(String[] args) {
        // ORIGINAL - is a text block helpful here?
        String name = """
              Pat Q. Smith""";

        // BETTER - a string literal works fine
        String name2 = "Pat Q. Smith";

        // ORIGINAL
        final String string = """
                        red
                        green
                        blue
                        """;


    }
}
