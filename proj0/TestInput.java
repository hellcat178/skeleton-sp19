public class TestInput{

	public static Planet[] read(String filename){

		In in = new In(filename);
		int numberPlanets = in.readInt();
		double radius = in.readDouble();
	    Planet[] bodies = new Planet[numberPlanets];
		for(int i = 0; i < numberPlanets; i++){
			bodies[i] = new Planet(in.readDouble(),in.readDouble(),
				in.readDouble(),in.readDouble(),in.readDouble(),"./images/"+in.readString());

		}
		return bodies;

	}

		public static void main(String[] args){

			System.out.println(read("./data/planets.txt")[0].imgFileName);
		}
}