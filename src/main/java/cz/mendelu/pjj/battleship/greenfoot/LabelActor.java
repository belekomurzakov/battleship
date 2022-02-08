package cz.mendelu.pjj.battleship.greenfoot;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.awt.*;
import java.util.Objects;

public class LabelActor extends Actor {
    private String name;
    private String text;

    public String getName() {
        return name;
    }

    public LabelActor(String text, String name) {
        this.setText(text);
        this.name = name;
    }

    public void setText(String text) {
        if (!Objects.equals(this.text, text)) {
            this.text = text;
            var image = new GreenfootImage(text, 18, Color.WHITE, new Color(255, 255, 255, 0));
            setImage(image);
        }
    }

    protected String updateText() {
        return null;
    }

    @Override
    public void act() {
        var newText = updateText();
        if (newText != null) {
            setText(newText);
        }
    }
}
