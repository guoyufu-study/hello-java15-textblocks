package cn.jasper.java15.textblocks;

public class TraditionalDoubleQuotedStringLiteral {



    public static void main(String[] args) {
        // Using a literal string
        String dqName = "Pat Q. Smith";

        // Using a text block
        String tbName = """
                Pat Q. Smith""";

        // Both dqName and tbName are strings of equal value  等值的字符串
        System.out.println(dqName.equals(tbName));    // true

        // Both dqName and tbName intern to the same string 扣押到同一字符串
        System.out.println(dqName == tbName);         // true

    }
}
