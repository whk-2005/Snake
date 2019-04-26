import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
    int row, col;
    int w = Yard.getBLOCK_XIZE();
    int h = Yard.getBLOCK_XIZE();
    private static Random r = new Random();// 蛋的随机生成位置
    private Color color = Color.green;// 蛋初始颜色

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Egg(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Egg() {
        this(r.nextInt(Yard.getROWS() - 2) + 2, r.nextInt(Yard.getCOLS()));
    }

    public void reAppear() {// 重新设定蛋的位置
        this.row = r.nextInt(Yard.getROWS() - 2) + 2;
        this.col = r.nextInt(Yard.getCOLS());
    }

    public Rectangle getRect() {
        return new Rectangle(Yard.getBLOCK_XIZE() * col, Yard.getBLOCK_XIZE() * row, w, h);
    }

    void draw(Graphics g) {// 画出蛋
        Color c = g.getColor();
        g.setColor(color);
        g.fillOval(Yard.getBLOCK_XIZE() * col, Yard.getBLOCK_XIZE() * row, w, h);
        g.setColor(c);
        if (color == Color.green) {
            color = color.red;
        } else {
            color = color.green;
        }
    }
}