package cn.jasper.java15.textblocks.style;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * G6. 避免复杂表达式中的内嵌文本块，因为这样做会扭曲可读性。考虑重构为局部变量或静态最终字段。
 */
public class G06ComplexExpression {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("jabberwocky.txt");
        // ORIGINAL
        String poem = new String(Files.readAllBytes(path));
        String middleVerses = Pattern.compile("\\n\\n")
                .splitAsStream(poem)
                .filter(verse -> !"""
                                   ’Twas brillig, and the slithy toves
                                   Did gyre and gimble in the wabe;
                                   All mimsy were the borogoves,
                                   And the mome raths outgrabe.
                                   """.equals(verse))
                .collect(Collectors.joining("\n\n"));

        // BETTER
        String firstLastVerse = """
                    ’Twas brillig, and the slithy toves
                    Did gyre and gimble in the wabe;
                    All mimsy were the borogoves,
                    And the mome raths outgrabe.
                    """;
        String poem2 = new String(Files.readAllBytes(path));
        String middleVerses2 = Pattern.compile("\\n\\n")
                .splitAsStream(poem2)
                .filter(verse -> !firstLastVerse.equals(verse))
                .collect(Collectors.joining("\n\n"));
    }
}
