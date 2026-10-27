public class HeavyTree {
    private double x;
    private double y;
    private double rotation;
    private double scale;

    private float[] model;
    private byte[] texture;
    private String material;

    public HeavyTree(double x, double y, double rotation, double scale, String material){
        this.x=x;
        this.y=y;
        this.material=material;
        this.scale = scale;
        this.rotation=rotation;

        this.model=new float[256];
        this.texture=new byte[1024];
    }
    public void draw(){
        System.out.println(
            "Дерево: материал = " + material
             +", положение = (" + x + "," + y +")"
             +", поворот = " + rotation
             +", масштаб = " + scale
        );
    }
}

