package cn.jasper.java15.textblocks.style;

public class HighLineCount {

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
