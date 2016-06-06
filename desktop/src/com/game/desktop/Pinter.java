package com.game.desktop;


import com.badlogic.gdx.graphics.g2d.TextureAtlas;

/**
 * Created by Mazek on 2016-05-31.
 */
public class Pinter {

    public static void main (String[] arg) {
        TextureAtlas icons = new TextureAtlas("res/inventory/icons.atlas");
        for(int i = 0; i < icons.getRegions().size -1 ; i++){
            System.out.println(icons.getRegions().get(i).name);
        }

    }
//
//    private static void wypisz(int i, String nazwa){
//        for(int j = 1; j <= i; j++){
//            System.out.println("\tSWORD_"+j+"(\"" + nazwa +j);
//        }
//    }
//
//    private static void wypisz(HashMap<String, String> items){
//        for(String item: items.values()){
//            System.out.println(item);
//
//        }
//    }


}
