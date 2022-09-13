package cn.jasper.java15.textblocks.style;

/**
 * G2. 如果一个字符串适合单行，没有连接和转义换行符，您可能应该继续使用字符串字面量。
 */
public class G02SingleLine {

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
