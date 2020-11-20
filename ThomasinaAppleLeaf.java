import java.awt.Color;

public class ThomasinaAppleLeaf
{
    public static void main(String[] args)
    {
        final int WIDTH = 400;
        final int HEIGHT = 600;
        final int SCALE = 50;
        final int ITERATIONS = 10000;

        Picture canvas = new Picture(WIDTH, HEIGHT);
        double x = 0, y = 0;

            /*
             * Put this code snippet inside the loop.
             *      Get the pixel based on the current x and y values and set its color.
             *      Offset the x and y values such that the origin is near the bottom-center of 
             *      the picture. Also magnify the transformation in order to see more detail.
             */
            Pixel pixel = canvas.getPixel((int)(x * SCALE + WIDTH / 2),
                    (int)(-y * SCALE + HEIGHT - 50));
            pixel.setColor(Color.GREEN);

        

        canvas.explore();
    }
}
