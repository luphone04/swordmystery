package com.myjavaproject.swordmystery;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.myjavaproject.swordmystery.logic.GameProgress;
import com.myjavaproject.swordmystery.screens.CharacterSelectionScreen;
import com.myjavaproject.swordmystery.screens.GameScreen;

public class SwordMystery extends Game {
	public Resources res;

	@Override
	public void create () {
		res = new Resources();
		GameProgress.Load();
		SoundManager.LoadSounds();
		setScreen(new CharacterSelectionScreen(this));
	}

	@Override
	public void dispose () {
		GameProgress.Save();
		res.dispose();
		SoundManager.ReleaseSounds();
	}
}
