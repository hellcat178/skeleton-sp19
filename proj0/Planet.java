/*
* @Author: hexia
* @Date:   2020-01-16 17:14:09
* @Last Modified by:   hexia
* @Last Modified time: 2020-03-10 00:24:23
*/
/* This is a class simulation a body
the utimate simulation is multibody motion in a plane*/
public class Planet {

	public double xxPos; //current x position
	public double yyPos; //current y postion
	public double xxVel; //current velocity in the x direction
	public double yyVel; //current velocity in the y direction
	public double mass;
	public String imgFileName; //name
	private static final double G = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b){
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;

	}

	/* take in a Body and calculate the distance between*/
	public double calcDistance (Planet b) {
		return Math.sqrt(Math.pow(xxPos-b.xxPos,2) + Math.pow(yyPos-b.yyPos,2));

	}
	
	public double calcForceExertedBy (Planet b) {
		double F = G*mass*b.mass/Math.pow(calcDistance(b),2);
        return F;
	}

	public double calcForceExertedByX (Planet b) {

		double r = calcDistance(b);
		double dx = b.xxPos - xxPos;
		return calcForceExertedBy(b) * dx/r;

	}

	public double calcForceExertedByY (Planet b) {
		
		double r = calcDistance(b);
		double dy = b.yyPos - yyPos;
		return calcForceExertedBy(b) * dy/r;
	}

	public double calcNetForceExertedByX (Planet [] bodies) {
        
        double netForce = 0;
		for(Planet b : bodies){

			if (b.equals(this)){
				continue;
			}

			netForce = netForce + calcForceExertedByX(b);

		}
		return netForce;

	}

	public double calcNetForceExertedByY (Planet [] bodies) {

		double netForce = 0;
		for(Planet b : bodies){
			if (b.equals(this)){
				continue;
			}

			netForce = netForce + calcForceExertedByY(b);

		}
		return netForce;
		
	}

	public void update(double dt, double fx, double fy){
		double ax = fx/this.mass;
		double ay = fy/this.mass;

		this.xxVel = this.xxVel + dt*ax;
		this.yyVel = this.yyVel + dt*ay;

		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;
	}

	public void draw(){
	
		StdDraw.picture(xxPos, yyPos,imgFileName);

	}

} 