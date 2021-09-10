package com.douzone.main;

import com.douzone.i.Drawable;
import com.douzone.point.ColorPoint;
import com.douzone.point.Point;
import com.douzone.shape.Rectangle;
import com.douzone.shape.Shape;
import com.douzone.shape.Triangle;
import com.douzone.text.GraphicText;

import tv.TV;

public class Main {
	public static void main(String[] args) {
		Point point1 = new Point(10, 10);
//		point1.setX(10);
//		point1.setY(10);
		
		draw(point1);
		point1.show(false);
		
		
		String input = "color"; //"black"
		
		
		
		Point point2;
		if(input.equals("color")) {
			point2 = new ColorPoint(100, 200, "red");			
		}else {
			point2 = new Point(100,100);
		}
		
		
		((ColorPoint)point2).setColor("red"); //runtime exception 발생 가능성
		
		point2.draw();
		
		point2.setX(100);
		point2.setY(100);
		
		draw(point2);
		point2.show(false);
		point2.show(true);
		
		Drawable d = new Triangle();
		draw(d);
		d = new Rectangle();
		draw(d);
		d = new GraphicText("java");
		draw(d);
		
		Rectangle r = new Rectangle();
		System.out.println(r instanceof Object);
		System.out.println(r instanceof Shape);
//		System.out.println(r instanceof Point); 
		
		// instanceof의 r-value 혹은 l-value가 class Type인 경우 계층구조를 따짐
		System.out.println(d instanceof Drawable);
		System.out.println(r instanceof Runnable);
		System.out.println(d instanceof TV);
		System.out.println(d instanceof Runnable);
		
	}
	public static void draw(Drawable d) {
		d.draw();
	}
}
