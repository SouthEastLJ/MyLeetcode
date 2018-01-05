
//Input: 123
//Output:  321
//Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range.
// For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.




#define INT_MAX 2147483647
#define INT_MIN -2147483648

int reverse(int x) {
    int num=1;
    int a=x;
    int i=0;
    long out=0;
    while(1)
    {
        if(a>9 || a<-9)
        {
            a=a/10;
            num++;
        }
        else
        {
            break;
        }
    }
    for(i=0;i<num;i++)
    {
        out = out+ (x%10)*pow(10,(num-i-1));
        if(out > INT_MAX || out < INT_MIN)
            return 0;
        x=x/10;
    }
    
    
    return out;
    
}