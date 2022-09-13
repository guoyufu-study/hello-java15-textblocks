package cn.jasper.java15.textblocks.style;

/**
 * G5. 避免对齐开始和结束分隔符和文本块的左边距。如果变量名或修饰符被更改，这需要重新缩进文本块。
 */
public class G05Align {

    public static void main(String[] args) {
        // ORIGINAL
        String string = """
                        red
                        green
                        blue
                        """;

        // ORIGINAL - after variable declaration changes
        final String rgbNames = """
                                 red
                                 green
                                 blue
                                 """;

        // BETTER
        String a = """
                red
                green
                blue
                """;

        // BETTER - after variable declaration changes
        final String rgb = """
                red
                green
                blue
                """;
    }
}
