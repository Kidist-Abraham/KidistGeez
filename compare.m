%This function is intended in comparing to vector matrixs
% The function returns 1 if it finds 1 coresponding indexes which are equal.
% It returns 0 if none of the coresponding indexes are equal. 

function result= compare(X,Y)
m=length(X);
i=1;
R=zeros(1,m);
while (i<=m)
   
    R(1,i)=X(i)==Y(i);
    if (R(1,i)==0)
        result=0;
     break;   
    end
    i=i+1;
    
   result=1; 
end

