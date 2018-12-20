% A function which calculates the sigmoid of a number. 

function g = sigmoid(z)
g = 1.0 ./ (1.0 + exp(-z));
end
