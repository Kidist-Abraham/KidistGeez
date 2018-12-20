
 To try the trained network you should 

1. Install Matlab on Windows or Octave on Ubuntu. I tried it on Octave so one should be more comfortable running it on Octave.

For octave you can just type

sudo apt-get install octave

2. Install the 'image' package on your octave or matlab environment

For Octave you can do that by

sudo apt-get install octave-image

3. Untar the datasets.tar.gz tar file to the home directory of this repository. Those are datasets of digits which you can use to test.

4. Open Octave and load the image package.
 you can do this by typing pkg load image on the command line.

5. run run.m on your Matlab or Octave command line and a propt of "Please enter your trial image" will apear.
 You will have to enter the image cotted in a single or double coat.
   
  ex, "6.4.png".

The classifier will work best on images written/skecthed with black color in a white background. Remember to put your image in the same directory. 






