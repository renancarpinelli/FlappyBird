package renan.carpinelli.com.br.carpbird.elements;

import android.graphics.Canvas;

import renan.carpinelli.com.br.carpbird.graphic.Cores;
import renan.carpinelli.com.br.carpbird.graphic.Screen;

/**
 * Created by rcarpinelli on 21/09/2017.
 */

public class Tube {

    private Screen screen;
    private int heightTubeBottom;
    private int heightTubeTop;
    private static final int HEIGHT_TUBE = 250;

    public int getPosition() {
        return position;
    }

    private int position;
    private static final int WIDTH_TUBE = 100;

    public Tube(Screen screen, int position) {
        this.screen = screen;
        this.position = position;
        heightTubeTop = 0 + HEIGHT_TUBE + aleatoryValue();
        heightTubeBottom = screen.getHeight() - HEIGHT_TUBE - aleatoryValue();
    }

    private int aleatoryValue() {
        return (int) (Math.random() * 150);
    }

    public void drawCanvas(Canvas canvas) {
        drawBottomTube(canvas);
        drawTopTube(canvas);
    }

    public void move() {
        position -= 8;
    }

    private void drawTopTube(Canvas canvas) {
        canvas.drawRect(position, 0, position + WIDTH_TUBE, heightTubeTop, Cores.getTubeColor());
    }

    private void drawBottomTube(Canvas canvas) {
        canvas.drawRect(position, heightTubeBottom, position + WIDTH_TUBE, screen.getHeight() - 120, Cores.getTubeColor());
    }

    public boolean exitScreen() {
        return position + WIDTH_TUBE < 0;
    }

    public boolean haveCollisionHorizontal(Bird bird) {
        return this.position < bird.X + bird.RAIO;
    }

    public boolean haveCollisionVertical(Bird bird) {
        return bird.getHeight() - bird.RAIO < this.heightTubeTop || bird.getHeight() + bird.RAIO > this.heightTubeBottom;
    }
}
