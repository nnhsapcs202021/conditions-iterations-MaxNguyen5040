Shepard Fairey Lab

# Introduction

A lot of colors combine to form an image, whereas the Shepard Fairey
	uses only four. Fairey's collage groups portrait contains only
	off-white, red and two shades of blue. Fairey's collage groups
	large regions with a single color. The trick is determining which
	pixels to group. The darkest sections of the portrait use the
	darkest hue of Fairey's four color palette. We really only need
	to measure a pixel's intensity rather than its actual color. A
	pixel colored (255,0,0) could be viewed as having the same
	intensity as a pixel visualizing (0,255,0).

So in hope of "Fairey-fication" let's convert the image to grayscale
	by computing the average of each pixel's red, green, and blue
	values. If pixel is colored (r, g, b), then we replace this with
	the single value (r + g + b)/ 3 = gray value. Grayscale contains
	only one color channel ranging from black (value of 0) to white
	(value of 255).

# Requirements

## ColorManipulator Class and Unit Test

1. familiarize yourself with the Picture, SimplePicture, Pixel, and
	Color classes by reading the documentation

2. review the maxBlue method in the ColorManipulator class

3. implement the maxRed and maxGreen methods in the ColorManipulator
	class (test these methods by modifying the main method of the
	ColorManipulator class to invoke these methods on the Picture
	object)

4. review the negate method in the ColorManipulator class

5. implement the shell of the grayscale method in the
	ColorManipulator class but **don’t implement it yet (i.e., don’t
	change the color of any pixels)**.

6. implement a JUnit test for the grayscale method (check several
	pixels in the image to verify that they were correctly converted
	with the assertEquals method; refer to the CarTest class from the
	Classes unit for an example). Run this test; **it must fail**
	since you haven’t implemented** **the grayscale method yet.
	**Commit your code in GitHub** to capture that you wrote the test
	before implementing the grayscale method.

7. Implement the grayscale method in the ColorManipulator class. Run
	the test again. **It should now pass**. It is important to make
	sure that your unit tests can actually fail.

## Shepard-fying Algorithm

1. create a Picture object from a selfie or other photo of yourself

2. add an instance variable to store a reference to the Picture
	object in the ShepardFairey class

3. in the transform method of the ShepardFairey class

    1. invoke the grayscale method on the ColorManipulator object to
    	convert the picture to grayscale (already implemented)

    2. find the smallest and largest grayscale values in the picture

    3. divide the range between the smallest and largest into four
    	equal subranges

    4. invoke the posterize method on the ColorManipulator object to
    	convert the color of each pixel in the picture to one of the
    	four colors (dark blue, red, light blue, off-white)
    	associated with each subrange (need to implement, carefully
    	consider which parameters this method will need)

4. save the final picture to a file with your full name

    5. for example:

        1. selfie.write( "GeoffSchmit.jpg" )

5. verify that the transformed image file was successfully saved,
	committed to GitHub, and pushed to GitHub.com

# Extensions:

* Choose your own 4 color palette and convert your picture. This
	[site](http://paletton.com/#uid=71T1p0kllll1FEsbvsfvberW17x) may
	help you choose a different 4 color pallet.

* Choose 2 different color palettes (one for each photo). How can you
	support this with the same posterize method?

* Do some additional filtering after the conversion to remove stray
	off-color pixels.

* Add more awesome.

# Submission:

* Submit a link to your GitHub repository with this assignment.

# Credit:

* This lab is adapted from Mr. Hayes’s lab at NCHS.

* He adapted it from Tim Chartier’s "Math Bytes"






https://docs.google.com/document/d/1YI88PIB4hJaGN4JobcRVGck0Jbo9-lNFWAD8GHpABvo/edit#