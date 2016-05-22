package com.game.object.Skills;

        import com.badlogic.gdx.Gdx;
        import com.badlogic.gdx.graphics.Color;
        import com.badlogic.gdx.graphics.Texture;
        import com.badlogic.gdx.graphics.g2d.BitmapFont;
        import com.badlogic.gdx.graphics.g2d.NinePatch;
        import com.badlogic.gdx.scenes.scene2d.Actor;
        import com.badlogic.gdx.scenes.scene2d.Stage;
        import com.badlogic.gdx.scenes.scene2d.ui.Image;
        import com.badlogic.gdx.scenes.scene2d.ui.Label;
        import com.badlogic.gdx.scenes.scene2d.ui.Skin;
        import com.game.GUI.GUI;
        import com.game.GUI.SkillBar;
        import com.game.object.klasy.Super_Class_Klasy;

        import java.util.ArrayList;

/**
 * Created by Mazek on 2016-05-21.
 */
public class SkillWindow {

    private static Stage skillWindow = GUI.getGUI_stage();
    private NinePatch background = new NinePatch(new Texture(Gdx.files.internal ("res/gui/SkillWindow/border.jpg")));
    private static ArrayList<Actor> cell_Skill = new ArrayList<Actor>();

    private static Skin skin = new Skin();

    public SkillWindow(Super_Class_Klasy klasa) {
        skin.add("default", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        skin.add("background", new Texture("res/gui/SkillWindow/border.jpg"));

        for(int i= 0; i < 8; i ++) {
            skin.add(String.valueOf(klasa.getSkillList().get(i).getId()), klasa.getSkillList().get(i).getPicture());
        }


        for(int i = 0; i < 8; i++){
                Image background = new Image(skin, "background");
                background.setBounds(100 + (i * 100) + 50, 100, 100, 200);
                background.setName(String.valueOf(klasa.getSkillList().get(i).getId()));
                cell_Skill.add(background);
            }
    }

    public static void addSource(){
        for(int i =0; i < cell_Skill.size(); i++){
            GUI.getGUI_stage().addActor(cell_Skill.get(i));
            SkillBar.dragAndDrop.addSource(
                    SkillBar.createSource(
                            cell_Skill.get(i),
                            skin
                    ));
        }
        System.out.println("Dodałem source");
    }

    public static void removeSource(){
        for(int i =0; i < cell_Skill.size(); i++){
            SkillBar.dragAndDrop.removeSource(
                    SkillBar.createSource(
                            cell_Skill.get(i),
                            skin
                    ));
            for(int j = 0; j < skillWindow.getActors().size; j++){
                if(skillWindow.getActors().get(j).getName() == cell_Skill.get(i).getName()){
                    System.out.println("Usunałem " + skillWindow.getActors().get(j).getName());
                    skillWindow.getActors().get(j).remove();
                    break;
                }
            }


        }
        System.out.println("Usunąłem source");
    }
}
