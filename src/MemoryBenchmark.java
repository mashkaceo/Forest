public class MemoryBenchmark {
    private static final int TREE_COUNT = 200_000;

    private static final String[] MATERIALS = {
            "Кора берёзы",
            "Кора дуба",
            "Кора сосны",
            "Кора ели"
    };

    public static HeavyTree[] createHeavyForest() {
        HeavyTree[] forest = new HeavyTree[TREE_COUNT];

        for (int i = 0; i < forest.length; i++) {
            int typeIndex = i % MATERIALS.length;

            forest[i] = new HeavyTree(
                    i % 1000,
                    i / 1000,
                    0,
                    1,
                    MATERIALS[typeIndex]
            );
        }

        return forest;
    }
    public static Tree[] createLightForest() {
        Tree[] forest = new Tree[TREE_COUNT];

        TreeTypeStorage storage = new TreeTypeStorage();

        String[] names = {"birch", "oak", "pine", "el"};

        TreeCreator[] creators = {
                new BirchCreator(),
                new OakCreator(),
                new PineCreator(),
                new ElCreator()
        };

        for (int i = 0; i < forest.length; i++) {
            int typeIndex = i % names.length;

            TreeType type = storage.getType(
                    names[typeIndex],
                    creators[typeIndex]
            );

            forest[i] = new Tree(i % 1000, i / 1000, 0, 1, type);
        }

        return forest;
    }
    public static void main(String[] args) {
        HeavyTree[] heavyForest = createHeavyForest();
        System.out.println("Тяжёлых деревьев: " + heavyForest.length);
        heavyForest[0].draw();
        heavyForest[199999].draw();

        Tree[] lightForest = createLightForest();
        System.out.println("Лёгких деревьев: " + lightForest.length);
        lightForest[0].draw();
        lightForest[199999].draw();
    }
}