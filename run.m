% This function will test the a network with a new data from the user. 

load('weights');
while (true)
testinput=input('Please enter your trial image ');
imr=imread(testinput);

InputModified=ImageModifier(imr);

pred = predictMy(all_theta, InputModified);
disp(pred);
end
