package com.game.androidNavigation;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;

/**
 * Created by Dariusz on 2016-04-01.
 */
public class Nav {
    public static boolean upNavPress = false;
    public static boolean downNavPress = false;
    public static boolean leftNavPress = false;
    public static boolean rightNavPress = false;

    private ImageButton upButton;
    private ImageButton downButton;
    private ImageButton leftButton;
    private ImageButton rightButton;
    private SpriteBatch batch;
    private Stage stage;

    public Nav() {
        batch = new SpriteBatch();
        stage = new Stage();

        upButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/up2.png")).getDrawable());
        upButton.setBounds(10, 200, 80, 100);
        upButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                upNavPress = true;
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                upNavPress = false;
            }
        });

        downButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/down2.png")).getDrawable());
        downButton.setBounds(10, 90, 80, 100);
        downButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                downNavPress = true;
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                downNavPress = false;
            }
        });

        rightButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/right2.png")).getDrawable());
        rightButton.setBounds(1180, 200, 80, 100);
        rightButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                rightNavPress = true;
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                rightNavPress = false;
            }
        });

        leftButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/left2.png")).getDrawable());
        leftButton.setBounds(1090, 200, 80, 100);
        leftButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                leftNavPress = true;
                return true;
            }

            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                leftNavPress = false;
            }
        });

        stage.addActor(upButton);
        stage.addActor(downButton);
        stage.addActor(rightButton);
        stage.addActor(leftButton);

        Gdx.input.setInputProcessor(stage);
    }

    public void render() {
        //stage.act(Gdx.graphics.getDeltaTime());
        batch.begin();
        upButton.draw(batch, 50);
        downButton.draw(batch, 50);
        rightButton.draw(batch, 50);
        leftButton.draw(batch, 50);
        batch.end();
    }

}
