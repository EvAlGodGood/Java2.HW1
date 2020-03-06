package circles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame { //класс наследник JFrame (окно)
    private static final int POS_X = 400; //начальные координаты и размер окна
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;
    //Color color = new Color (132,23,196); //мой цвет для фона canvas
    private Sprite[] sprites = new Sprite[40]; //массив из 10 спрайтов
    private int clickRL = sprites.length/2;//для изменеия количества отрисовываемых объектов (как ++ по клику по canvas -- по клику правой)

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles(); //создание объекта окна
            }
        });
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //умолчание завершение программы при закрытии окна
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT); //координаты и размер окна
        setTitle("Circles (-O﬩O-)"); //заголовок окна
        initApplication(); //создали массив шаров
        MainCanvas canvas = new MainCanvas(this); //создали объект по классу с управлением из MainCircles
        add(canvas); //добавили canvas
        //canvas.setBackground(color); //установка моего цвета для canvas (постоянный)

        setVisible(true); //видимость окна
    }


    private void initApplication() { //инициализатор массива спрайтов Ball
        sprites[0] = new BackGroundCanvas();
        for (int i = 1; i < sprites.length; i++) {//-clickRL
            sprites[i] = new Ball();
        }
    }

    public void onCanvasRepainted(MainCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(MainCanvas canvas, float deltaTime) { //обновитель положения )
//        if ((count % 150)==0 && clickRL<sprites.length) {
//            clickRL++;
//        }
        for (int i = 0; i < sprites.length-clickRL; i++) { //учесть чтобы не вышло за длину массива
            sprites[i].update(canvas, deltaTime);

        }
    }

    private void render(MainCanvas canvas, Graphics g) { //формировщик изображения и отрисовки на Canvas
        for (int i = 0; i < sprites.length-clickRL; i++) { //учесть чтобы не вышло за длину массива
            sprites[i].render(canvas, g);
        }
    }
}