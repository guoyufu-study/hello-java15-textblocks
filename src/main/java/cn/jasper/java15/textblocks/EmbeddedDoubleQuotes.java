package cn.jasper.java15.textblocks;

/**
 * 内嵌的双引号
 */
public class EmbeddedDoubleQuotes {

    public static void main(String[] args) {
        String sa = """
            String message = "Hello, World!";
            System.out.println(message);
            """;
        String sb = "String message = \"Hello, World!\";\n" +
                "System.out.println(message);\n";

        System.out.println(sa == sb);
    }
}
