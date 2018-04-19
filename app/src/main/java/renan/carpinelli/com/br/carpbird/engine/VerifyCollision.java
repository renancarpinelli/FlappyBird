package renan.carpinelli.com.br.carpbird.engine;

import renan.carpinelli.com.br.carpbird.elements.Bird;
import renan.carpinelli.com.br.carpbird.elements.Tube;
import renan.carpinelli.com.br.carpbird.elements.Tubes;

/**
 * Created by rcarpinelli on 27/09/2017.
 */

class VerifyCollision {
    private Bird bird;
    private Tubes tubes;

    public VerifyCollision(Bird bird, Tubes tubes) {
        this.bird = bird;
        this.tubes = tubes;
    }

    public boolean haveCollision() {
        return tubes.haveCollision(bird);
    }
}
