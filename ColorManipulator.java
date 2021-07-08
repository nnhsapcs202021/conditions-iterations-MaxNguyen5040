

import java.awt.Color;

/**
 * Class that manipulates the colors in a specified picture
 *
 * @author gcschmit
 * @version 5 June 2017
 */
public class ColorManipulator
{
    private Picture picture;

    /**
     * Constructs a new ColorManipulator object with the specified picture
     *
     * @param  newPicture  the picture to manipulate
     */
    public ColorManipulator( Picture newPicture )
    {
        this.picture = newPicture;
    }

    /**
     * Returns the Picture associated with this ColorManipulator object. Intended to
     *      be used by the test class.
     *
     * @returns the Picture associated with this ColorManipulator object
     */
    public Picture getPicture()
    {
        return this.picture;
    }

    /**
     * Sets the blue component of the color of every pixel in the picture to the maximum value
     *
     *      An example of manipulating one component of the color of a pixel.
     */
    public void maxBlue()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                pixel.setBlue( 255 );
            }
        }
    }

    /**
     * Sets the red component of the color of every pixel in the picture to the maximum value
     *
     */
    public void maxGreen()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                pixel.setGreen( 255 );
            }
        }
    }

    /**
     * Sets the red component of the color of every pixel in the picture to the maximum value
     *
     */
    public void maxRed()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                pixel.setRed( 255 );
            }
        }
    }
    //Write maxGreen and maxRed methods

    /**
     * Negates the color of every pixel in the picture
     *
     *      An example of manipulating the color of a pixel using a Color object
     */
    public void negate()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                Color color = pixel.getColor();

                int negatedRed = 255 - color.getRed();
                int negatedBlue = 255 - color.getBlue();
                int negatedGreen = 255 - color.getGreen();

                Color negated = new Color( negatedRed, negatedBlue, negatedGreen );
                pixel.setColor( negated );
            }
        }
    }

    /**
     * Turns every pixel to grayscale by computing the average Red Blue and Green values with a gray value
     *
     */
    public void grayscale()
    {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );

                int total = pixel.getBlue();
                total += pixel.getRed();
                total += pixel.getGreen();
                total /= 3;

                pixel.setRed(total);
                pixel.setGreen(total);
                pixel.setBlue(total);
            }
        }
    }

    /**
     * Method for changing every pixel into a set color
     */
    public void posterize(int range1, int range2, int range3, int range4, Color color1, Color color2, Color color3, Color color4) {
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        //interate through the pixels, changing colors

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel = this.picture.getPixel(x, y);
                if(pixel.getBlue() <= range1){
                    pixel.setBlue(color1.getBlue());
                    pixel.setRed(color1.getRed());
                    pixel.setGreen(color1.getGreen());
                }
                else if(pixel.getBlue() <= range2){
                    pixel.setBlue(color2.getBlue());
                    pixel.setRed(color2.getRed());
                    pixel.setGreen(color2.getGreen());
                }
                else if(pixel.getBlue() <= range3){
                    pixel.setBlue(color3.getBlue());
                    pixel.setRed(color3.getRed());
                    pixel.setGreen(color3.getGreen());
                }
                else{
                    pixel.setBlue(color4.getBlue());
                    pixel.setRed(color4.getRed());
                    pixel.setGreen(color4.getGreen());
                    }
                }


            }
    }


    public static void main(String args[])
    {
        // the selfie image must be in the Shepard Fairey folder
        Picture picture= new Picture( "Callaghan.jpg" );
        ColorManipulator manipulator = new ColorManipulator( picture );

    }



}



