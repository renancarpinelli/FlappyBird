package renan.carpinelli.com.br.carpbird.elements;

import android.graphics.Canvas;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import renan.carpinelli.com.br.carpbird.graphic.Screen;

/**
 * Created by rcarpinelli on 21/09/2017.
 */

public class Tubes {

    private static final int DISTANCE_BETWEEN_TUBES = 300;
    private static final int AMOUNT_OF_TUBES = 5;
    private Screen screen;

    private final List<Tube> tubes = new ArrayList<>();
    private Score score;

    public Tubes(Screen screen, Score score) {
        this.score = score;
        this.screen = screen;
        int position = 500;

        for (int i = 0; i < AMOUNT_OF_TUBES; i++) {
            position += DISTANCE_BETWEEN_TUBES;
            tubes.add(new Tube(screen, position));
        }
    }

    public void drawCanvas(Canvas canvas) {
        for (Tube tube : tubes) {
            tube.drawCanvas(canvas);
        }
    }

    public void move() {
        ListIterator<Tube> iterator = tubes.listIterator();
        while (iterator.hasNext()) {
            Tube tube = (Tube) iterator.next();
            tube.move();

            if (tube.exitScreen()) {
                score.increaseScore();
                iterator.remove();
                Tube otherTube = new Tube(screen, getMax() + DISTANCE_BETWEEN_TUBES);
                iterator.add(otherTube);
            }
        }
    }

    private int getMax() {
        int max = 0;
        for (Tube tube : tubes) {
            max = Math.max(tube.getPosition(), max);
        }
        return max;
    }

    public boolean haveCollision(Bird bird) {
        for (Tube tube : tubes) {
            if (tube.haveCollisionHorizontal(bird) &&  tube.haveCollisionVertical(bird)) {
                return true;
            }
        }
        return false;
    }
}
