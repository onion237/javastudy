package com.douzone.shape;

import com.douzone.i.Drawable;

public abstract class Shape implements Drawable{
	private int fillColor;
	private int lineColor;
	
	public int getFillColor() {
		return fillColor;
	}
	public void setFillColor(int fillColor) {
		this.fillColor = fillColor;
	}
	public int getLineColor() {
		return lineColor;
	}
	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}
	
	
}
