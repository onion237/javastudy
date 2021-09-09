package com.douzone.text;

import com.douzone.i.Drawable;

public class GraphicText implements Drawable{
	private String text;
		
	public GraphicText(String text) {
		super();
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void draw() {
		System.out.println(text + "를 그렸습니다.");
	}

}
