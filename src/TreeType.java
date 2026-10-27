public class TreeType {
    private final float[] model;
    private final byte[] texture;
    private final String material;

    public TreeType(String material){
        this.material=material;
        this.model = new float[256];
        this.texture= new byte[1024];
    }
    public void draw(double x, double y, double rotation, double scale){
        System.out.println(
                "Дерево: материал = " + material
                +", положение = (" + x + "," + y + ")"
                +", поворот = " + rotation
                +", масштаб = " + scale
        );
    }
}
