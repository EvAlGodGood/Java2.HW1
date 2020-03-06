package circles;

import java.awt.*;

public abstract class Sprite { //абстрактный класс для наследования отрисовываемых объектов
    protected float x; //координаты спрайта
    protected float y;
    protected float halfWidth; // половина ширины и высоты для работы от центра спрайта
    protected float halfHeight;

    protected float getLeft() { //набор геттеров сеттеров для возврата и установки краев спрайта
        return x - halfWidth;
    }
    protected void setLeft(float left) {
        x = left + halfWidth;
    }
    protected float getRight() {
        return x + halfWidth;
    }
    protected void setRight(float right) {
        x = right - halfWidth;
    }
    protected float getTop() {
        return y - halfHeight;
    }
    protected void setTop(float top) {
        y = top + halfHeight;
    }
    protected float getBottom() {
        return y + halfHeight;
    }
    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }
    protected float getWidth() {
        return 2f * halfWidth;
    }
    protected float getHeight() {
        return 2f * halfHeight;
    }

    public void update(MainCanvas canvas, float deltaTime) {} //определение положения спрайта
    public void render(MainCanvas canvas, Graphics g) {} //подготовка к отрисовке на canvas

}