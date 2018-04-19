package renan.carpinelli.com.br.carpbird.elements;

import android.graphics.Canvas;
import android.graphics.Paint;

import renan.carpinelli.com.br.carpbird.graphic.Cores;
import renan.carpinelli.com.br.carpbird.graphic.Screen;

/**
 * Created by rcarpinelli on 21/09/2017.
 */

public class Bird {

    private static final Paint VERMELHO = Cores.getBirdColor();

    public static final float X = 100;
    public static final float RAIO = 40;
    private float height;
    private Screen screen;

    public Bird(Screen screen) {
        this.height = 0;
        this.screen = screen;
    }

    public float getHeight() {
        return height;
    }

    public void drawCanvas(Canvas canvas) {
        canvas.drawCircle(X, height, RAIO, VERMELHO);
    }

    public void fall() {
        boolean onFloor = height + RAIO > screen.getHeight() - 120;
        if (!onFloor) {
            this.height += 8;
        }
    }

    public void jump() {
        if (height - RAIO > 0) {
            this.height -= 120;
        }
    }
}
