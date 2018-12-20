% This function trains a logistic regression network by first modifing the 
% training dataset images and then passing them through the oneVsAll function.
% It saves the weight calculated in a mat file.  

 
num_labels = 9;
lambda = 0.1;
X=zeros(81,64);
c=1;
for j=1:9
    for i=1:9

read=imread([ num2str(j), "." num2str(i) ,".png" ] );
read = uint8(255 * read);
disp(size(read));
disp([ num2str(j), "." num2str(i) ,".png" ] );

disp(size(ImageModifier(read)));

X(c,:)=ImageModifier(read);
  c=c+1;
    end
end


y=[ones(9,1); ones(9,1)*2; ones(9,1)*3; ones(9,1)*4; ones(9,1)*5; ones(9,1)*6 ;ones(9,1)*7;...
    ones(9,1)*8; ones(9,1)*9 ];




[all_theta] = oneVsAll(X, y, num_labels, lambda);
save('weights','all_theta');



