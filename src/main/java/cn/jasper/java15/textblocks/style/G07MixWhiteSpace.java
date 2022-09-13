package cn.jasper.java15.textblocks.style;

/**
 * G7. 仅使用空格或仅使用制表符来缩进文本块。混合空白将导致不规则缩进的结果。
 */
public class G07MixWhiteSpace {

    public static void main(String[] args) {
        // ORIGINAL
        String code = """
                String source = \"\"\"\"\"\"
                    String message = "Hello, World!";
                    System.out.println(message);
                    \"\"\";
                """;
        System.out.println(code);

        // BETTER
        String code2 = """
                String source = \"""\"""
                    String message = "Hello, World!";
                    System.out.println(message);
                    \""";
                """;
        System.out.println(code2);
    }
}
