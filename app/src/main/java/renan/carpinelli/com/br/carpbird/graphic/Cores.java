package renan.carpinelli.com.br.carpbird.graphic;

import android.graphics.Paint;
import android.graphics.Typeface;

/**
 * Created by rcarpinelli on 21/09/2017.
 */

public class Cores {

    public static Paint getBirdColor() {
        Paint red = new Paint();
        red.setColor(0xFFFF0000);
        return red;
    }

    public static Paint getTubeColor() {
        Paint green = new Paint();
        green.setColor(0xFF00FF00);
        return green;
    }

    public static Paint getScoreColor() {
        Paint white = new Paint();
        white.setColor(0xFFFFFFFF);
        white.setTextSize(80);
        white.setTypeface(Typeface.DEFAULT_BOLD);
        white.setShadowLayer(3, 5, 5 , 0xFF000000);
        return white;
    }
}
