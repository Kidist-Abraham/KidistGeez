% This function will predict the outcome of an imput image based on the 
% weights(all_theta) calculated int the oneVsAll function.

function p = predictMy(all_theta, X)
num_labels = size(all_theta, 1);

p = 0;
poss=zeros(num_labels,1);

X = [1 X];

for i=1:num_labels
 poss(i)=sigmoid(sum(X.*(all_theta(i,:))));

end 
[pos,in]=max(poss);
p=in;






