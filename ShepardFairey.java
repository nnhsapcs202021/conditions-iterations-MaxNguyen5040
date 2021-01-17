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


    private static final Color color1 = new Color( 0, 161, 163);
    private static final Color color2 = new Color(30, 161, 173);
    private static final Color color3 = new Color( 60, 161, 183);
    private static final Color color4 = new Color( 90, 161, 205);


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

        manipulator.posterize(range1,range2,range3,range4,color1,color2,color3,color4);

    }

    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        //  (the selfie image must be in the Shepard Fairey folder)
        Picture selfie = new Picture( "Selfie.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey fairey = new ShepardFairey( selfie );

        // display the original selfie picture
        selfie.explore();

        // transform the selfie picture by applying a Shepard Fairey-inspired effect
        fairey.transform();

        // display the transformed selfie picture
        selfie.explore();

        // save the transformed selfie picture

        /* This code doesn't work for some students for unknown reasons.
         * You may need to specify an absolute path. For example:
         *  finalPic.write("C:\\Users\\gschmit\\GitHub\\decisions-loops-gcschmit\\Shepard Fairey\\MrSchmitPortrait.jpg");
         */

       //I wrote the final product to a seperate file so we can view the original as many times as we want. I don't know if this is the correct path.
       selfie.write( "Users\\MaxNguyen5040\\GitHub\\conditions-iterations-MaxNguyen5040\\WriteSelfie.jpg" );

    }
}
