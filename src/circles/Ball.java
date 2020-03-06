package circles;

import java.awt.*;

public class Ball extends Sprite { //класс наследуется от абстрактного класса Sprite
    private final Color color = new Color( //задаем цвет
            (int) (Math.random() * 255),
            (int) (Math.random() * 255),
            (int) (Math.random() * 255)
    );
    private float vX = (float) (100f + (Math.random() * 200f)); // рандомно задали скорость по х и y
    private float vY = (float) (100f + (Math.random() * 200f));

    Ball() {
        halfHeight = 20 + (float) (Math.random() * 50f); //задаем размер Ball
        halfWidth = halfHeight;
    }

    @Override
    public void update(MainCanvas canvas, float deltaTime) { //определяем где на canvas отрисовать исходя из скорости и времени
        x += vX * deltaTime;
        y += vY * deltaTime;
        if (getLeft() < canvas.getLeft()) { //отскок от левого края окна
            setLeft(canvas.getLeft());
            vX = -vX;
        }
        if (getRight() > canvas.getRight()) { //отскок от правого края окна
            setRight(canvas.getRight());
            vX = -vX;
        }
        if (getTop() < canvas.getTop()) { //отскок от верха
            setTop(canvas.getTop());
            vY = -vY;
        }
        if (getBottom() > canvas.getBottom()) { //отскоок от низа
            setBottom(canvas.getBottom());
            vY = -vY;
        }

    }

    @Override
    public void render(MainCanvas canvas, Graphics g) { //готовим для отрисовке на canvas
        g.setColor(color);
        g.fillOval((int) getLeft(), (int) getTop(),
                (int) getWidth(), (int) getHeight());
    }
}