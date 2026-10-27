public class Tree {
    private double x;
    private double y;
    private double rotation;
    private double scale;

    private final TreeType type;

    public Tree(double x, double y, double rotation, double scale, TreeType type){
        this.x=x;
        this.y=y;
        this.rotation=rotation;
        this.scale=scale;
        this.type=type;
    }
    public void draw(){
        type.draw(x, y, rotation, scale);
    }
}
