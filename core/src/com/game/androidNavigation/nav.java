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
                System.err.println("Up");
                return true;
            }
        });

        downButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/down2.png")).getDrawable());
        downButton.setBounds(10, 90, 80, 100);
        downButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.err.println("Down");
                return true;
            }
        });

        rightButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/right2.png")).getDrawable());
        rightButton.setBounds(1180, 200, 80, 100);
        rightButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.err.println("Right");
                return true;
            }
        });

        leftButton = new ImageButton(new Image(new Texture("res/gui/ControllerImage/left2.png")).getDrawable());
        leftButton.setBounds(1090, 200, 80, 100);
        leftButton.addListener(new InputListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.err.println("Left");
                return true;
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
