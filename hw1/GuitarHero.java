/** A client that uses the synthesizer package to replicate a plucked guitar string sound */
import synthesizer.GuitarString;
public class GuitarHero {


    public static void main(String[] args) {
        /* create two guitar strings, for concert q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' */
        GuitarString[] gs = new GuitarString[37];
        for (int i = 0; i < 37; i++) {
            gs[i] = new GuitarString(440.0 * Math.pow(2.0, (i - 24.0) / 12.0));
        }
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";


        while (true) {

            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                try {
                    gs[keyboard.indexOf(key)].pluck();
                } catch (ArrayIndexOutOfBoundsException e) {
                    //e.printStackTrace();
                }
            }

            /* compute the superposition of samples */
            double sample = 0.0;
            for (int i = 0; i < 37; i++) {
                sample += gs[i].sample();
            }


            /* play the sample on standard audio */
            StdAudio.play(sample);

            /* advance the simulation of each guitar string by one step */
            for (GuitarString g : gs) {
                g.tic();
            }
        }
    }
}

