public class Main {
    public static void main(String[] args) {
        HeavyTree tree = new HeavyTree(10,20,0,1,"Кора берёзы");
        tree.draw();

        TreeType birchType = new TreeType("Кора берёзы");
        Tree first = new Tree(10, 20, 0, 1, birchType);
        Tree second = new Tree(50, 80, 45, 2, birchType);

        first.draw();
        second.draw();

    }
}