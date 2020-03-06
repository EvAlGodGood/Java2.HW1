package circles;

import java.awt.*;
//схитрим тк как не понял как менять конкретно цвет canvas
//сделаем бэкграунд наследником Sprite только он будет отрисовываться первым перед отрисовкой шаров
//и будет висеть на одном месте

public class BackGroundCanvas extends Sprite{
    protected int count = 0;
    private  Color colorBG = new Color(
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );

    BackGroundCanvas() {
        halfHeight = 120;
        halfWidth = 120;
    }

//    public static void setColorBG(int i, int i1, int i2) {
//        colorBG = (i, i1, i2);
//    }


    @Override
    public void update(MainCanvas canvas, float deltaTime) { //определяем где на canvas отрисовать "фон"
        count++;
        if ((count % 150)==0) {
            colorBG = new Color(
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255),
                    (int) (Math.random() * 255));

        }
        x = canvas.getLeft() / 2;
        y = canvas.getTop() / 2;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void render(MainCanvas canvas, Graphics g) { //готовим для отрисовке на canvas
        g.setColor(colorBG);
        g.fillRect((int) canvas.getLeft(), (int) canvas.getTop(),
                (int) canvas.getWidth(), (int) canvas.getHeight());
    }

}