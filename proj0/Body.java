/*
* @Author: hexia
* @Date:   2020-01-16 17:14:09
* @Last Modified by:   hexia
* @Last Modified time: 2020-01-16 17:29:23
*/
/* This is a class simulation a body
the utimate simulation is multibody motion in a plane*/
public class Body {

	public double xxPos; //current x position
	public double yyPos; //current y postion
	public double xxVel; //current velocity in the x direction
	public double yyVel; //current velocity in the y direction
	public double mass;
	public String imgFileName; //name

	public Body(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Body(Body b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;

	}
	

} 