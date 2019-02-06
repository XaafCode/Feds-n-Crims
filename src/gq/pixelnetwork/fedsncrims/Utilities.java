package gq.pixelnetwork.fedsncrims;

public class Utilities {
    /**
     * Creates a random number in the range
     * @param min
     * @param max
     * @return
     */
    private int getRandomNumberRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("Integer 'max' must be greater than integer 'min'!");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}