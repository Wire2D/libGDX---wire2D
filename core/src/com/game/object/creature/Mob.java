package com.game.object.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.game.object.Base;
import com.game.object.klasy.Warrior;
import com.game.operations.Testy;
import com.game.resources.Resources;

/**
 * Created by scorpion43 on 25.03.2016.
 */
public class Mob extends Base {

    private TextureRegion currentFrame;
    private float stateTime;
    private int level;

    private final float MOVE_TIME = 0.02F;
    private float moveTime = MOVE_TIME;


   /**
    * kierunki do losowania dla moba
    */
    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private int countToStopMove_default = 100;
    private int countToStopMove = countToStopMove_default;
    private int direction = 0;

    public Mob(String name, int x, int y, int level) {
        super(new Warrior());

        mUpAnimation = new Animation(0.2f, Resources.getTextureRegion (name, true)[3]);
        mDownAnimation = new Animation(0.2f, Resources.getTextureRegion (name, true)[0]);
        mRightAnimation = new Animation(0.2f, Resources.getTextureRegion (name, true)[2]);
        mLeftAnimation = new Animation(0.2f, Resources.getTextureRegion (name, true)[1]);

        mUpImage = Resources.getTextureRegion (name, true)[3][0];
        mDownImage = Resources.getTextureRegion (name, true)[0][0];
        mRightImage = Resources.getTextureRegion (name, true)[2][0];
        mLeftImage = Resources.getTextureRegion (name, true)[1][0];

        mImage = mDownImage;
        mAnimation = mUpAnimation;
        this.setPosition(x * 32,y * 32);
    }

    public void render(SpriteBatch batch, TiledMapTileLayer collisionLayer){
        float time = Gdx.graphics.getDeltaTime();
        moveTime -= time;

        if (moveTime <= 0) {
            moveTime = MOVE_TIME;
            changeMobPosition(collisionLayer);
        }

        if(animate){
            stateTime += Gdx.graphics.getDeltaTime();           // #15
            currentFrame = mAnimation.getKeyFrame(stateTime, true);
            batch.draw (currentFrame,getX(),getY());
        } else {
            batch.draw (mImage, getX() - 16, getY() - 5);
        }
    }

    private void update(SpriteBatch batch, Vector2 pos){

    }

    /**
     * scorpion43
     * zmina pozycji moba na podstawie kierunku
     */
    private void changeMobPosition(TiledMapTileLayer collisionLayer) {
        boolean ifEnterBoundaries = checkBoundaries(collisionLayer);
        if (countToStopMove == 0 || ifEnterBoundaries || !animate ) {
            if (ifEnterBoundaries) {
                direction = findOppositeDirection(direction);
            }
            else {
                direction = randomDirection();
            }
            setAnimationForMob(direction);
            animate = true;
            countToStopMove = countToStopMove_default;
        }
        countToStopMove--;
        if (direction == Mob.UP) {
            System.out.println("Do góry");
            setY(getY() + 1);
        }
        else if (direction == Mob.RIGHT) {
            System.out.println("W prawo");
            setX(getX() + 1);
        }
        else if (direction == Mob.DOWN) {
            System.out.println("W dół");
            setY(getY() - 1);
        }
        else if (direction == Mob.LEFT) {
            System.out.println("W lewo");
            setX(getX() - 1);
        }
    }

    /**
     * scorpion 43
     * funkcja do znajdowania przeciwnego kierunku kiedy mob trafi na granicę
     * @param direction
     * @return
     */
    protected int findOppositeDirection(int direction) {
        switch (direction) {
            case Mob.UP:
                return Mob.DOWN;
            case Mob.RIGHT:
                return Mob.LEFT;
            case Mob.LEFT:
                return Mob.RIGHT;
            case Mob.DOWN:
                return Mob.UP;
        }

        return 0;
    }

    /**
     * scorpion43
     * wylosowanie kierunku w którym ma się poruszać mob
     */
    protected int randomDirection() {
        int direction = MathUtils.random(Mob.UP, Mob.DOWN + 1);
        return direction;
    }

    /**
     * funkcja która usstawia odpowiedni zestaw animacji dla moba
     * w zależności od kierunku
     * @param direction
     */
    protected void setAnimationForMob(int direction) {
        switch (direction) {
            case Mob.UP:
                mImage = mUpImage;
                mAnimation = mUpAnimation;
                break;
            case Mob.RIGHT:
                mImage = mRightImage;
                mAnimation = mRightAnimation;
                break;
            case Mob.DOWN:
                mImage = mDownImage;
                mAnimation = mDownAnimation;
                break;
            case Mob.LEFT:
                mImage = mLeftImage;
                mAnimation = mLeftAnimation;
                break;
            default:
                System.out.println("Nie ma takiego ruchu.");
                break;
        }
    }


    /**
     * sprawdzenie czy mob nie chce uciec z areny
     */
    protected boolean checkBoundaries(TiledMapTileLayer collisionLayer) {
        if (Testy.isBlock(this, collisionLayer)) {
            return true;
        }
        /*if (position.x <= 0 || position.x >= Gdx.graphics.getWidth()) {
            return true;
        }
        if ((position.y <= 0) || (position.y >= Gdx.graphics.getHeight())){
            return true;
        }*/

        return false;
    }

}
