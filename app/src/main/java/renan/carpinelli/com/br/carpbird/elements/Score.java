package renan.carpinelli.com.br.carpbird.elements;

import android.graphics.Canvas;
import android.graphics.Color;

import renan.carpinelli.com.br.carpbird.graphic.Cores;

/**
 * Created by rcarpinelli on 27/09/2017.
 */

public class Score {

    private int scores = 0;

    public void drawCanvas(Canvas canvas) {
        canvas.drawText(String.valueOf(scores), 100, 100, Cores.getScoreColor());
    }

    public void increaseScore() {
        scores++;
    }

}
