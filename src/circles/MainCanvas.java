package circles;

import javax.swing.*;
import java.awt.*;

public class MainCanvas extends JPanel {

    long lastFrameTime;
    private final MainCircles controller;

    MainCanvas(MainCircles controller) {
        lastFrameTime = System.nanoTime();
        this.controller = controller;
    }

    @Override
    protected void paintComponent(Graphics g) { //цикл отрисовки
        super.paintComponent(g);

        long currentTime = System.nanoTime(); //клок
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;//дельту привели к секундам
        controller.onCanvasRepainted(this, g, deltaTime); //проверка готовности для отрисовки

        try {
            Thread.sleep(16); //делим частоту отрисовки для уменьшения/нормализации FPS
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lastFrameTime = currentTime;
        repaint(); //повторить
    }

    public int getLeft() { return 0; }//определение краев canvas
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

}