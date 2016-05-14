package com.game.object.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.game.object.Base;
import com.game.operations.Testy;
import com.game.resources.Resources;

/**
 * Created by Khaffel on 25.03.2016.
 */
public class Mob extends Base {

    private TextureRegion currentFrame;
    private float stateTime;
    private int level;

    private final float MOVE_TIME = 0.02F;
    private float moveTime = MOVE_TIME;


   /* begin scorpion43
    kierunki do losowania dla moba*/
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    protected int countToStopMove_default = 100;
    protected int countToStopMove = countToStopMove_default;
    protected int direction = 0;

    /*end scorpion43*/

    public Mob(String name, int x, int y, int level) {
        super(49,49,45,65,65,45,100);

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
        position = new Vector2 (x * 32,y * 32);
    }

    public void render(SpriteBatch batch, TiledMapTileLayer collisionLayer){
        float time = Gdx.graphics.getDeltaTime();
        moveTime -= time;

        if (moveTime <= 0) {
            moveTime = MOVE_TIME;
            changeMobPosition();
        }

        //changeMobPosition();
        if(animate){
            stateTime += Gdx.graphics.getDeltaTime();           // #15
            currentFrame = mAnimation.getKeyFrame(stateTime, true);
            batch.draw (currentFrame,position.x,position.y);
        } else {
            batch.draw (mImage, position.x - 16, position.y- 5);
        }
        //update(batch, pos);
    }

    private void update(SpriteBatch batch, Vector2 pos){

    }

    /*scorpion43
    zmina pozycji moba na podstawie kierunku*/
    protected void changeMobPosition() {
        if (countToStopMove == 0 || checkBoundaries() || !animate ) {
            direction = randomDirection();
            animate = true;
            countToStopMove = countToStopMove_default;
        }
        countToStopMove--;
        if (direction == Mob.UP) {
            System.out.println("Do góry");
            position.y++;
        }
        else if (direction == Mob.RIGHT) {
            System.out.println("W prawo");
            position.x++;
        }
        else if (direction == Mob.DOWN) {
            System.out.println("W dół");
            position.y--;
        }
        else if (direction == Mob.LEFT) {
            System.out.println("W lewo");
            position.x--;
        }
    }

    /*scorpion43
    wylosowanie kierunku w którym ma się poruszać mob*/
    protected int randomDirection() {
        int direction = MathUtils.random(Mob.UP, Mob.DOWN + 1);
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

        return direction;
    }

    /*scorpion43
    sprawdzenie czy mob nie chce uciec z areny  */
    protected boolean checkBoundaries() {
//        if (Testy.isBlock(this, ))
        if (position.x <= 0 || position.x >= Gdx.graphics.getWidth()) {
            return true;
        }
        if ((position.y <= 0) || (position.y >= Gdx.graphics.getHeight())){
            return true;
        }

        return false;
    }

}
