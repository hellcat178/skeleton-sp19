/*
* @Author: hexia
* @Date:   2020-01-17 17:23:30
* @Last Modified by:   hexia
* @Last Modified time: 2020-01-21 14:35:40
*/

public class NBody  {
	public static double readRadius(String filename){
		In in = new In(filename);
		int numberPlanets = in.readInt();
		double radius = in.readDouble();

		return radius;

	}

	public static Body[] readBodies(String filename){

		In in = new In(filename);
		int numberPlanets = in.readInt();
		double radius = in.readDouble();
	    Body[] bodies = new Body[numberPlanets];
		for(int i =0; i<numberPlanets ;i++){
			bodies[i] = new Body(in.readDouble(),in.readDouble(),
				in.readDouble(),in.readDouble(),in.readDouble(),"images/"+in.readString());

		}
		return bodies;

	}

		public static void main(String[] args){
			/* This main method need commond line arguments*/

			double t = Double.parseDouble(args[0]);
			double dt = Double.parseDouble(args[1]);
		    String filename = args[2];
		    double radius = readRadius(filename);
		    Body[] bodies = readBodies(filename);


		    
            
		    /** Sets up the universe so it matches the radius of the universe*/
		    StdDraw.setScale(-radius, radius);

		    /* Clears the drawing window. */
		    StdDraw.clear();

            /*Draw the background of the pic*/
            StdDraw.picture(0,0,"images/starfield.jpg");
		    /*Draw the initial positions of planets*/
		    for(Body b : bodies){
		    	b.draw();
		    }

		    //StdAudio.play("audio/2001.mid")

		    /*simulation*/
		    StdDraw.enableDoubleBuffering();
		    
		    for(double time = 0;time<=t;t+=dt){

		    	double[] xForces = new double[bodies.length];
		    	double[] yForces = new double[bodies.length];

		    	for(int i=0;i<bodies.length;i++){
		    		xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
		    		yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
		    		

		    	}

		    	for(int i=0;i<bodies.length;i++){
		    		bodies[i].update(dt,xForces[i],yForces[i]);
		    	}

		    	StdDraw.clear();
		    	StdDraw.picture(0,0,"images/starfield.jpg");
		    	for(Body b : bodies){
		    	b.draw();
		        }
		        StdDraw.show();
		        StdDraw.pause(10);  

		    	

		    }




		}

	
} 