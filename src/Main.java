public class Main {
    public static void main(String[] args) {
        HeavyTree tree = new HeavyTree(10,20,0,1,"Кора берёзы");
        tree.draw();

        TreeCreator creator = new BirchCreator();
        TreeType birchType = creator.createType();
        Tree first = new Tree(10, 20, 0, 1, birchType);
        Tree second = new Tree(50, 80, 45, 2, birchType);

        first.draw();
        second.draw();

        TreeCreator[] creators = {
                new BirchCreator(),
                new OakCreator(),
                new PineCreator(),
                new ElCreator()
        };

        for (int i = 0; i < creators.length; i++) {
            TreeType type = creators[i].createType();
            Tree example = new Tree(i * 10, 0, 0, 1, type);
            example.draw();
        }
    }
}