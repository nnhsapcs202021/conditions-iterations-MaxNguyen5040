import java.awt.Color;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect.
 *
 * @author Max Nguyen
 * @version 1/6/2020
 */
public class ShepardFairey
{
    private ColorManipulator manipulator;
    private Picture picture;

    private static final Color OFF_WHITE = new Color( 248, 229, 175 );
    private static final Color LIGHT_BLUE = new Color( 121, 149, 159 );
    private static final Color RED = new Color( 198, 50, 45 );
    private static final Color DARK_BLUE = new Color( 16, 48, 77 );

    public ShepardFairey( Picture newPicture )
    {
        this.manipulator = new ColorManipulator( newPicture );
        this.picture = newPicture;
    }

    /**
     * Transforms the picture by applying a Shepard Fairey-inspired effect.
     *
     */
    public void transform() {
        manipulator.grayscale();

        ///find smallest and largest greyscale values
        int smallest;
        int biggest;
        int width = this.picture.getWidth();
        int height = this.picture.getHeight();
        Pixel pixel = this.picture.getPixel(0, 0);
        smallest = pixel.getBlue();
        biggest = pixel.getBlue();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel pixel1 = this.picture.getPixel(x, y);
                if(pixel1.getBlue() > biggest){
                    biggest = pixel1.getBlue();

                }
                else if(pixel1.getBlue() < smallest){
                    smallest = pixel1.getBlue();

                }
            }
        }

        //divide into 4 ranges
        int range = biggest-smallest;
        range /= 4; //how long each range is
        int range1 = range;
        int range2 = range*2;//ending value
        int range3 = range*3;
        int range4 = range*4;

        manipulator.posterize(range1,range2,range3,range4,Color.green,Color.blue,Color.white,Color.cyan);




    }

    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        //  (the selfie image must be in the Shepard Fairey folder)
        Picture selfie = new Picture( "Callaghan.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey fairey = new ShepardFairey( selfie );

        // display the original selfie picture
        selfie.explore();

        // transform the selfie picture by applying a Shepard Fairey-inspired effect
        fairey.transform();

        // display the transformed selfie picture
        selfie.explore();

//        // save the transformed selfie picture
//
//        /* This code doesn't work for some students for unknown reasons.
//         * You may need to specify an absolute path. For example:
//         *  finalPic.write("C:\\Users\\gschmit\\GitHub\\decisions-loops-gcschmit\\Shepard Fairey\\MrSchmitPortrait.jpg");
//         */
//        selfie.write( "MrSchmitPortrait.jpg" );
//
//        // display the transformed selfie picture
//        selfie.explore();
    }
}