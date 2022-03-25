package cn.jasper.java15.textblocks;

public class StringIndent {

    public static void main(String[] args) {
        String colors = """
                red
                green
                blue""";
        System.out.println(colors);

        String colors2 = """
                red
                green
                blue""".indent(4);
        System.out.println(colors2);
    }
}
