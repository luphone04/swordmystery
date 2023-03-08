package com.myjavaproject.swordmystery;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.myjavaproject.swordmystery.logic.objects.Character;
import com.myjavaproject.swordmystery.logic.objects.CharacterRecord;
import java.util.HashMap;
public class Resources {
    public static final int ENEMY_VERTICAL = 0; // spider
    public static final int ENEMY_HORIZONTAL = 1; // ghost
    public static final int ENEMY_DIAGONAL = 2; // bat
    public static final int ENEMY_RANDOM = 3; // slime
    public static final int ENEMY_UNIVERSAL = 4; // skeleton
    TextureAtlas gameSprites;
    public BitmapFont gamefont;
    public TextureRegion ground;
    public TextureRegion wall;
    public Sprite player;
    public HashMap<Integer, Sprite> enemySprites;
    public HashMap<String, Sprite> playerSprites;
    public TextureRegion base;
    public TextureRegion warning;
    public Sprite attackBonus;
    public Sprite healthBonus;
    public Sprite coinBonus;
    public TextureRegionDrawable soundBtn[];
    public TextureRegionDrawable leftArrowBtn;
    public TextureRegionDrawable rightArrowBtn;
    public TextureRegionDrawable upArrowBtn;
    public TextureRegionDrawable downArrowBtn;
    public static final int TILE_SIZE = 16;
    public Resources()
    {
        gamefont = new BitmapFont(Gdx.files.internal("gamefont.fnt"), Gdx.files.internal("gamefont.png"), false);

        gameSprites = new TextureAtlas(Gdx.files.internal("packed/game.atlas"));
        ground = gameSprites.findRegion("ground");
        wall = gameSprites.findRegion("wall");

        player = new Sprite(gameSprites.findRegion("player"));

        enemySprites = new HashMap<Integer, Sprite>();
        enemySprites.put(ENEMY_VERTICAL, gameSprites.createSprite("spider"));
        enemySprites.put(ENEMY_HORIZONTAL, gameSprites.createSprite("ghost"));
        enemySprites.put(ENEMY_DIAGONAL, gameSprites.createSprite("bat"));
        enemySprites.put(ENEMY_RANDOM, gameSprites.createSprite("slime"));
        enemySprites.put(ENEMY_UNIVERSAL, gameSprites.createSprite("skeleton"));

        playerSprites = new HashMap<String, Sprite>();
        playerSprites.put(CharacterRecord.CHAR_NAME_HUMAN, gameSprites.createSprite("player"));
        playerSprites.put(CharacterRecord.CHAR_NAME_SPIDER, gameSprites.createSprite("spider"));
        playerSprites.put(CharacterRecord.CHAR_NAME_SKELETON, gameSprites.createSprite("skeleton"));
        playerSprites.put(CharacterRecord.CHAR_NAME_GHOST, gameSprites.createSprite("ghost"));
        playerSprites.put(CharacterRecord.CHAR_NAME_SLIME, gameSprites.createSprite("slime"));

        base = gameSprites.findRegion("base");
        warning = gameSprites.findRegion("warning");

        attackBonus = gameSprites.createSprite("attack");
        healthBonus = gameSprites.createSprite("health");
        coinBonus = gameSprites.createSprite("coin");

        soundBtn = new TextureRegionDrawable[4];
        for (int i = 0; i < 4; i++)
        {
            soundBtn[i] = new TextureRegionDrawable(gameSprites.findRegion("sound" + i));
        }

        leftArrowBtn = new TextureRegionDrawable(gameSprites.findRegion("larrow"));
        rightArrowBtn = new TextureRegionDrawable(gameSprites.findRegion("rarrow"));
        upArrowBtn = new TextureRegionDrawable(gameSprites.findRegion("uarrow"));
        downArrowBtn = new TextureRegionDrawable(gameSprites.findRegion("darrow"));
    }

    public void dispose()
    {
        gameSprites.dispose();
    }
}
