function [J, grad] = lrCostFunction(theta, X, y, lambda)

J = 0;
grad = zeros(size(theta));
m=size(X,1);



       thetaN=theta;
       thetaN(1)=0;
       J=(-1/m)*sum(y.*log(sigmoid(X * theta) )+(1-y).*log((1-sigmoid(X*theta))))+(lambda/(2*m))*sum(thetaN.^2);
       grad=(1/m).*((sigmoid(X*theta)-y)'*X)'+(lambda/m).*thetaN;

grad = grad(:);

end
