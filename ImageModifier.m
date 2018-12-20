% This image modifier function modifies the image in order to prepare it for
% the training and the testing input.
% This includes reeping out the part of the image which is not the part of the digit.


function imageUnroll= ImageModifier(im)            
im = uint8(255 * im);                               
imGray=rgb2gray((im));

imGray=imresize(imGray,[size(imGray,1),size(imGray,1)]);

imGray=ChangeToBin(imGray,255);

% The following set of code is responsible in cropping the image so that it fits the number only.
m=size(imGray,1);
in=ones(m,1)*255;
ins=ones(m,1)*255;
col22=zeros(m,1);
row22=zeros(m,1);
reference1=ones(1,m)*255;
reference2=ones(m,1)*255;




for c=1:m
     l=compare(imGray(c,:),reference1);
    if (l==0)
    [mm,in(c,1)]=min(imGray(c,:)); 
    
      a1=(imGray(c,:));
   a=(a1<1);
    col22(c,1)=find(a,1,'last');
    end
   
    l=compare(imGray(:,c),reference2);
    if (l==0)
    [mm,ins(c,1)]=min(imGray(:,c)); 
    
      b1=imGray(:,c)';
     b=(b1<1);
   row22(c,1)=find(b,1,'last');
    
    end
    
 end

col=min(in);
row=min(ins);

col2=max(col22);
row2=max(row22);

OnlyBlack=imGray(row:row2,col:col2);
imshow((OnlyBlack));

% The following will resize the image to fit the rest of the dataset 
% and concatenate the whole row of the image in one row.

OnlyBlackResize=imresize((OnlyBlack),[8,8]);

OnlyBlackbin=ChangeToBin(OnlyBlackResize,1);
imageUnroll=OnlyBlackbin'(:)';



