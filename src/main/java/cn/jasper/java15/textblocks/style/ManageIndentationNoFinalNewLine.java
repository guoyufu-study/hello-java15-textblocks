package cn.jasper.java15.textblocks.style;

public class ManageIndentationNoFinalNewLine {

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
