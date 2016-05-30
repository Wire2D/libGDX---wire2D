package com.game.object.creature;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.game.Settings.Constants;
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

    private boolean isChasingPlayer = false;

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

    public void render(SpriteBatch batch, TiledMapTileLayer collisionLayer, Player player){
        float time = Gdx.graphics.getDeltaTime();
        moveTime -= time;

        if (moveTime <= 0) {
            moveTime = MOVE_TIME;
            if (!isChasingPlayer) {
                changeMobPosition(collisionLayer);
            }
            else {
                chasePlayer(player, this);
                countToStopMove = 0;
            }

        }

        if(animate){
            stateTime += Gdx.graphics.getDeltaTime();           // #15
            currentFrame = mAnimation.getKeyFrame(stateTime, true);
            batch.draw (currentFrame,getX() - 16,getY());
        } else {
            batch.draw (mImage, getX() - 16, getY() - 5);
        }

        dst(player, batch);
    }

    private void update(SpriteBatch batch, Vector2 pos){

    }

    /**
     * scorpion43
     * ustawienie animacji w zależności od kierunku
     */
    private void setUpAnimation() {
        mImage = mUpImage;
        mAnimation = mUpAnimation;
    }

    private void setDownAnimation() {
        mImage = mDownImage;
        mAnimation = mDownAnimation;
    }

    private void setRightAnimation() {
        mImage = mRightImage;
        mAnimation = mRightAnimation;
    }

    private void setLeftAnimation() {
        mImage = mLeftImage;
        mAnimation = mLeftAnimation;
    }

    /**
     * scorpion43
     * Gonienienie playera
     */
    private void chasePlayer(Player player, Mob mob) {
        float playerX = player.getX();
        float playerY = player.getY();


        if (playerX > getX()) {
            setX(getX() + 1);
        }
        else if (playerX < getX()){
            setX(getX() - 1);
        }

        if (playerY > getY()) {
            setY(getY() + 1);
        }
        else if (playerY < getY()){
            setY(getY() - 1);
        }

        setAnimationForChasingMob(getX(), getY(), player.getX(), player.getY());
    }

    private void setAnimationForChasingMob(float mobX , float mobY, float playerX, float playerY) {
        /*mobX += 16;
        mobY += 16;*/

        if (mobX == playerX) {
            if (mobY < playerY) {
                setUpAnimation();
            }
            else {
                setDownAnimation();
            }
        }
        else if (mobY == playerY) {
            if (mobX < playerX) {
                setRightAnimation();
            }
            else {
                setLeftAnimation();
            }
        }
        else {
            if (mobY > playerY) {
                setDownAnimation();
            }
            else {
                if (mobX > playerX) {
                    setLeftAnimation();
                }
                else {
                    setRightAnimation();
                }
            }
        }
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
            setY(getY() + 1);
        }
        else if (direction == Mob.RIGHT) {
            setX(getX() + 1);
        }
        else if (direction == Mob.DOWN) {
            setY(getY() - 1);
        }
        else if (direction == Mob.LEFT) {
            setX(getX() - 1);
        }
    }

    /**
     * scorpion 43
     * funkcja do znajdowania przeciwnego kierunku kiedy mob trafi na granicę
     * @param direction aktualny kierunek moba
     * @return zwraca kierunek przeciwny
     */
    private int findOppositeDirection(int direction) {
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
    private int randomDirection() {
        return MathUtils.random(Mob.UP, Mob.DOWN + 1);
    }

    /**
     * funkcja która usstawia odpowiedni zestaw animacji dla moba
     * w zależności od kierunku
     * @param direction wylosowany kierunek
     */
    private void setAnimationForMob(int direction) {
        switch (direction) {
            case Mob.UP:
                setUpAnimation();
                break;
            case Mob.RIGHT:
                setRightAnimation();
                break;
            case Mob.DOWN:
                setDownAnimation();
                break;
            case Mob.LEFT:
                setLeftAnimation();
                break;
            default:
                System.out.println("Nie ma takiego ruchu.");
                break;
        }
    }


    /**
     * sprawdzenie czy mob nie chce uciec z areny
     */
    private boolean checkBoundaries(TiledMapTileLayer collisionLayer) {
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

    /**
     * Mazek27
     * Test odległości
     */
    private void dst(Player player, SpriteBatch batch){
        Vector2 posMonster = new Vector2(getX(),getY());
        Vector2 posPlayer = new Vector2(player.getX(),player.getY());


        if(posMonster.dst(posPlayer) < 200){
            isChasingPlayer = true;
            batch.end();
            ShapeRenderer shapeDebugger= new ShapeRenderer();
            if(Constants.camera != null){
                shapeDebugger.setProjectionMatrix(Constants.camera.combined);
            }
            shapeDebugger.begin(ShapeRenderer.ShapeType.Line);
            shapeDebugger.setColor(Color.WHITE);
            shapeDebugger.line(posMonster.x, posMonster.y + 16, posPlayer.x, posPlayer.y);
            shapeDebugger.rect(getX() - 16, getY(), 32, 32);
            shapeDebugger.rect(player.getX() - 16, player.getY(), 32, 40);
            shapeDebugger.end();
            batch.begin();
            //System.out.println(getWidth() + " = x, y = " + getHeight());
            bounds.set(getX() - 16, getY(), 32, 32);
            player.bounds.set(player.getX() - 16, player.getY(), 32, 40);
            if (bounds.overlaps(player.bounds)) {
                System.out.println("Mob wlazł na playera");
                player.setCountToDie(player.getCountToDie() - 1);
                System.out.println(player.getCountToDie());
                if (player.getCountToDie() <= 0) {
                    player.setCountToDie(COUNT_TO_DIE_DEFAULT_VALUE);
                    player.damage(player, 5);
                }
            }

        }
        else {
            isChasingPlayer = false;
        }
    }

}
