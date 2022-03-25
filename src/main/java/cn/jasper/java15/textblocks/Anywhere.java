package cn.jasper.java15.textblocks;

// Text blocks can be used anywhere a string literal can be used.
public class Anywhere {

    public static void main(String[] args) {
        // text blocks may be intermixed with string literals in a string concatenation expression
        String str = "The old";
        String tb = """
                    the new""";
        String together = str + " and " + tb + ".";
        System.out.println(together);

        // Text blocks may be used as a method argument:
        System.out.println("""
                        This is the first line
                        This is the second line
                        This is the third line
                        """);


        // String methods may be applied to a text block
        System.out.println("""
                John Q. Smith""".substring(8).equals("Smith"));   // true

        // A text block can be used in place of a string literal to improve the readability and clarity of the code.
        // This primarily occurs when a string literal is used to represent a multi-line string.
        // In this case there is considerable clutter from quotation marks, newline escapes, and concatenation operators
        // ORIGINAL
        String message_orig = "'The time has come,' the Walrus said,\n" +
                "'To talk of many things:\n" +
                "Of shoes -- and ships -- and sealing-wax --\n" +
                "Of cabbages -- and kings --\n" +
                "And why the sea is boiling hot --\n" +
                "And whether pigs have wings.'\n";

        // BETTER
        String message_text = """
                    'The time has come,' the Walrus said,
                    'To talk of many things:
                    Of shoes -- and ships -- and sealing-wax --
                    Of cabbages -- and kings --
                    And why the sea is boiling hot --
                    And whether pigs have wings.'
                    """;

        System.out.println(message_orig.equals(message_text));
    }
}
