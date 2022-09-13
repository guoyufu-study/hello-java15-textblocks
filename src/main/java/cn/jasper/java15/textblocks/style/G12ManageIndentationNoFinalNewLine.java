package cn.jasper.java15.textblocks.style;

/**
 * 没有最后的新行场景中管理缩进
 * <p>G12. 当 `\<line-terminator>` 需要排除文本块的最后一个新行时，应使用转义序列。这可以更好地框住文本块并允许关闭分隔符管理缩进。</p>
 */
public class G12ManageIndentationNoFinalNewLine {

    public static void main(String[] args) {
        // ORIGINAL
        String name = """
                red
                green
                blue""".indent(4);


        // BETTER
        String name2 = """
                red
                green
                blue\
            """;
    }
}
