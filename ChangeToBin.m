%This function does changes an image file to have only 2 numbers based on a threshold, in this case 100.
%The numbers will be 0 and the 'how' variable.
% It means if the person pass 255 on the 'how' parameter, the image will only have two numbers,0 and 255.  
% The function accepts the image matrix,X and the 'how' paramerer and returns the modified image.  


function re= ChangeToBin(X,how)

m=size(X,1);
n=size(X,2);
for j=1:m
    for i=1:n
        if(X(j,i)>=100)
            
           X(j,i)=how; 
        else
            X(j,i)=0;
            
       end
        
        
    end
    
end
re=X;