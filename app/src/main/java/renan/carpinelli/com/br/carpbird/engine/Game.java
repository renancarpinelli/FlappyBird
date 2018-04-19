package renan.carpinelli.com.br.carpbird.engine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import renan.carpinelli.com.br.carpbird.R;
import renan.carpinelli.com.br.carpbird.elements.Bird;
import renan.carpinelli.com.br.carpbird.elements.Score;
import renan.carpinelli.com.br.carpbird.elements.Tube;
import renan.carpinelli.com.br.carpbird.elements.Tubes;
import renan.carpinelli.com.br.carpbird.graphic.Screen;

/**
 * Created by rcarpinelli on 21/09/2017.
 */

public class Game extends SurfaceView implements Runnable, View.OnTouchListener {

    private boolean isRunning = true;
    private SurfaceHolder holder = getHolder();

    private Bird bird;
    private Tubes tubes;

    private Bitmap background;
    private Screen screen;

    private Score score;

    public Game(Context context) {
        super(context);
        screen = new Screen(context);
        initializeElements();
        setOnTouchListener(this);
    }

    private void initializeElements() {
        bird = new Bird(screen);
        score = new Score();
        tubes = new Tubes(screen, score);
        Bitmap back = BitmapFactory.decodeResource(getResources(), R.drawable.background);
        background = Bitmap.createScaledBitmap(back, screen.getWidth(), screen.getHeight(), false);
    }

    @Override
    public void run() {
        while (isRunning) {
            if (!holder.getSurface().isValid()) continue;
            Canvas canvas = holder.lockCanvas();
            // Desenha componentes do jogo
            canvas.drawBitmap(background, 0, 0, null);

            bird.drawCanvas(canvas);
            bird.fall();

            tubes.drawCanvas(canvas);
            tubes.move();

            score.drawCanvas(canvas);

            if(new VerifyCollision(bird, tubes).haveCollision()){
                isRunning = false;
            }

            holder.unlockCanvasAndPost(canvas);
        }
    }

    public void start() {
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        bird.jump();
        return false;
    }
}
