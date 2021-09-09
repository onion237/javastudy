package com.douzone.point;

import com.douzone.i.Drawable;

public class Point implements Drawable{
	private int x;
	private int y;
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void show() {
		show(true);
	}
	public void show(boolean visible) {
		if(visible)
			System.out.println(toString() + "를 그렸습니다." );
		else
			System.out.println(toString() + "를 지웠습니다." );
	}
	@Override
	public String toString() {
		return "점 [x=" + x + ", y=" + y + "]";
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		show();
	}
}
