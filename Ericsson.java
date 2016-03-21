class Ericsson
{
 int sum(int a,int b)
{
//int a=10,b=20;
int c;
c=a+b;
return c;
}

public static void main(String [] args)
{
Ericsson e=new Ericsson();
int x=e.sum(20,10);
System.out.println("Sum is:"+x);
}
}