package cn.jasper.java15.textblocks;

/**
 * 新转义序列
 */
public class EscapeSequencesNew {

    public static void main(String[] args) {
        String literal = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit, sed do eiusmod tempor incididunt ut labore " +
                "et dolore magna aliqua.";

        String text = """
                Lorem ipsum dolor sit amet, consectetur adipiscing \
                elit, sed do eiusmod tempor incididunt ut labore \
                et dolore magna aliqua.\
                """;
        System.out.println(literal == text);

        String colors = """
                    red  \s
                    green\s
                    blue \s
                    """;

        System.out.println(colors);
    }
}
