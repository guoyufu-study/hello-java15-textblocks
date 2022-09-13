package cn.jasper.java15.textblocks;

/**
 * 文本块可以在任何可以使用字符串字面值的地方使用。
 */
public class Anywhere {

    public static void main(String[] args) {
        // 文本块可以在字符串连接表达式中与字符串字面值混合
        String str = "The old";
        String tb = """
                    the new""";
        String together = str + " and " + tb + ".";
        System.out.println(together);

        // 文本块可以用作方法参数：
        System.out.println("""
                        This is the first line
                        This is the second line
                        This is the third line
                        """);


        // 字符串方法可以应用于文本块
        System.out.println("""
                John Q. Smith""".substring(8).equals("Smith"));   // true

        // 可以使用文本块代替字符串字面值，以提高代码的可读性和清晰度。
        // 这主要发生在使用字符串字面值表示多行字符串时。
        // 在这种情况下，引号、换行符和连接运算符会造成相当大的混乱
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
