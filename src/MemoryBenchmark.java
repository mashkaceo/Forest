import java.util.Arrays;
public class MemoryBenchmark {
    private static Object measuredForest;
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
    public static long usedMemory() {
        Runtime runtime = Runtime.getRuntime();
        return runtime.totalMemory() - runtime.freeMemory();
    }

    public static long measureForest(boolean heavy) {
        measuredForest = null;
        System.gc();
        long before = usedMemory();

        if (heavy) {
            measuredForest = createHeavyForest();
        } else {
            measuredForest = createLightForest();
        }

        System.gc();
        long after = usedMemory();

        return after - before;
    }

    public static void main(String[] args) {
        long[] heavyResults = new long[3];
        long[] lightResults = new long[3];

        for (int i = 0; i < 3; i++) {
            heavyResults[i] = measureForest(true);
            lightResults[i] = measureForest(false);

            System.out.printf(
                    "Повтор %d: тяжёлый — %.2f МиБ, лёгкий — %.2f МиБ%n",
                    i + 1,
                    heavyResults[i] / (1024.0 * 1024.0),
                    lightResults[i] / (1024.0 * 1024.0)
            );
        }

        Arrays.sort(heavyResults);
        Arrays.sort(lightResults);

        long heavyMedian = heavyResults[1];
        long lightMedian = lightResults[1];

        System.out.printf(
                "Медиана тяжёлого леса: %.2f МиБ%n",
                heavyMedian / (1024.0 * 1024.0)
        );

        System.out.printf(
                "Медиана лёгкого леса: %.2f МиБ%n",
                lightMedian / (1024.0 * 1024.0)
        );

        System.out.printf(
                "Лёгкий лес занимает в %.2f раза меньше памяти%n",
                (double) heavyMedian / lightMedian
        );
    }
}