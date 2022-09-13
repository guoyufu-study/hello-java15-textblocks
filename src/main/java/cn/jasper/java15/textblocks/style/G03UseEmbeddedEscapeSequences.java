package cn.jasper.java15.textblocks.style;

/**
 * G3. 在保持可读性时使用嵌入式转义序列。
 */
public class G03UseEmbeddedEscapeSequences {

    public static void main(String[] args) {
        var data = """
                 Name | Address | City
                 Bob Smith | 123 Anytown St\nApt 100 | Vancouver
                 Jon Brown | 1000 Golden Place\nSuite 5 | Santa Ana
                 """;

        System.out.println(data);
    }
}
