import org.junit.Test;
import static org.junit.Assert.*;

public class ColorManipulatorTest {
    @Test
    public void testgrayScale(){
        //assert equals checks value, assertEquals(Expected,variable)
        Picture picture= new Picture( "Selfie 2.jpg" );

        Picture grayscalepicture= new Picture( "Selfie 2.jpg" );
        ColorManipulator manipulator = new ColorManipulator( grayscalepicture );
        manipulator.grayscale();

        Pixel normalpixel = picture.getPixel( 100, 100 );
        Pixel graypixel = grayscalepicture.getPixel(100,100);

        int total = normalpixel.getBlue();
        total += normalpixel.getRed();
        total += normalpixel.getGreen();
        total /= 3;

        assertEquals(total,graypixel.getBlue());



    }

}

