package cn.jasper.java15.textblocks.style;

/**
 * G11. 同样，当高行数导致关闭分隔符可能垂直滚动到视图之外时，将文本块完全左对齐也是合理的。这允许读者在关闭分隔符不在视线范围内时使用左边距跟踪缩进。
 */
public class G11HighLineCount {

    public static void main(String[] args) {
        // ORIGINAL

        String validWords = """
                    aa
                    aah
                    aahed
                    aahing
                    aahs
                    aal
                    aalii
                    aaliis
                    bb
                    bbh
                    bbhed
                    bbhing
                    bbhs
                    bbl
                    bblii
                    bbliis
                    cc
                    cch
                    cched
                    cching
                    cchs
                    ccl
                    ...
                    zythum
                    zythums
                    zyzzyva
                    zyzzyvas
                    zzz
                    zzzs
                    """;


// BETTER

        String validWords2 = """
aa
aah
aahed
aahing
aahs
aal
aalii
aaliis
bb
bbh
bbhed
bbhing
bbhs
bbl
bblii
bbliis
cc
cch
cched
cching
cchs
ccl
...
zythum
zythums
zyzzyva
zyzzyvas
zzz
zzzs
""";
    }
}
