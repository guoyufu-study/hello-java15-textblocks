package cn.jasper.java15.textblocks.style;

public class AvoidHorizontalScrollingOrLineWrap {

    public static void main(String[] args) {
        // ORIGINAL

        class Outer {
            class Inner {
                void printPoetry() {
                    String lilacs = """
                Over the breast of the spring, the land, amid cities,
                Amid lanes and through old woods, where lately the violets peep’d from the ground, spotting the gray debris,
                Amid the grass in the fields each side of the lanes, passing the endless grass,
                Passing the yellow-spear’d wheat, every grain from its shroud in the dark-brown fields uprisen,
                Passing the apple-tree blows of white and pink in the orchards,
                Carrying a corpse to where it shall rest in the grave,
                Night and day journeys a coffin.
                """;
                    System.out.println(lilacs);
                }
            }
        }

        // BETTER
        class Outer2 {
            class Inner {
                void printPoetry() {
                    String lilacs = """
Over the breast of the spring, the land, amid cities,
Amid lanes and through old woods, where lately the violets peep’d from the ground, spotting the gray debris,
Amid the grass in the fields each side of the lanes, passing the endless grass,
Passing the yellow-spear’d wheat, every grain from its shroud in the dark-brown fields uprisen,
Passing the apple-tree blows of white and pink in the orchards,
Carrying a corpse to where it shall rest in the grave,
Night and day journeys a coffin.
""";
                    System.out.println(lilacs);
                }
            }
        }
    }
}
