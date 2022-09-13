package cn.jasper.java15.textblocks.style;

/**
 * 提高代码的清晰度
 *
 * <p>G1. 当文本块可以提高代码的清晰度时，尤其是多行字符串时，应该使用它。</p>
 */
public class G1ImproveClarityOfCode {

    public static void main(String[] args) {
        // ORIGINAL
        String message = "'The time has come,' the Walrus said,\n" +
                "'To talk of many things:\n" +
                "Of shoes -- and ships -- and sealing-wax --\n" +
                "Of cabbages -- and kings --\n" +
                "And why the sea is boiling hot --\n" +
                "And whether pigs have wings.'\n";

        // BETTER
        String message2 = """
                'The time has come,' the Walrus said,
                'To talk of many things:
                Of shoes -- and ships -- and sealing-wax --
                Of cabbages -- and kings --
                And why the sea is boiling hot --
                And whether pigs have wings.'
                """;
    }
}
