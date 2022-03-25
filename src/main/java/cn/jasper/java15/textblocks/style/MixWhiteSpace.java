package cn.jasper.java15.textblocks.style;

public class MixWhiteSpace {

    public static void main(String[] args) {
        // ORIGINAL
        String code = """
                String source = \"\"\"\"\"\"
                    String message = "Hello, World!";
                    System.out.println(message);
                    \"\"\";
                """;

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
