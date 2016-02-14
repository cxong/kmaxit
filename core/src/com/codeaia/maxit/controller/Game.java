package com.codeaia.maxit.controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.codeaia.maxit.state.Menu;
import com.codeaia.maxit.state.State;
import com.codeaia.maxit.ui.Text;

public class Game extends ApplicationAdapter {	

	public static final float width = 1280;
	public static final float height = 720;
	public static int state;
	public static float mX, mY, delta;
	private Music music;
	
	public static State menu, singleplayer, options, credits;
	private Text fps;
	
	@Override
	public void create() {
		fps = new Text("Fps : " + Gdx.graphics.getDeltaTime(), 10, Gdx.graphics.getHeight() - 50) ;
		
		mX = 0;
		mY = 0;
		delta = 0;
		
		music = Gdx.audio.newMusic(Gdx.files.internal("sound/iloveyouso.ogg"));
		music.setVolume(0.4f);
		music.play();
		
		state = 1;
		menu = new Menu(1);
	}

	private void update() {
		mX = Gdx.input.getX();
		mY = Gdx.graphics.getHeight() - Gdx.input.getY();
		delta = Gdx.graphics.getRawDeltaTime();

		 if (state == 1) {
			if(!menu.equals(null)){
				menu.update(mX, mY, delta);
			}
		} else if (state == 2) {
			if(!singleplayer.equals(null)){
				singleplayer.update(mX, mY, delta);
			}
		} else if (state == 3) {
			if(!options.equals(null)){
				options.update(mX, mY, delta);
			}
		} else if (state == 4) {
			if(!credits.equals(null)){
				credits.update(mX, mY, delta);
			}
		}
		 
		 fps.setText("FPS : " + (int) (1 / Gdx.graphics.getRawDeltaTime()));
		 
	}

	@Override
	public void render() {
		update();

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if (state == 1) {
			if(!menu.equals(null)){
			menu.render(mX, mY);
			}
		} else if (state == 2) {
			if(!singleplayer.equals(null)){
			singleplayer.render(mX, mY);
			}
		} else if (state == 3) {
			if(!options.equals(null)){
			options.render(mX, mY);
			}
		} else if (state == 4) {
			if(!credits.equals(null)){
			credits.render(mX, mY);
			}
		}
		
		fps.render(Color.WHITE);
	}

	@Override
	public void dispose() {
		super.dispose();
	}
}
