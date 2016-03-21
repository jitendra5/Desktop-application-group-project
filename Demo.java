import java.awt.*;
public class Demo extends Frame
{
String s;
public Demo()
{
s="Welcome to Java";
}
public void paint(Graphics g)
{
setBackground(Color.red);
setForeground(Color.yellow);
g.drawString(s,100,100);
}
public static void main(String args[])
{
Demo d= new Demo();
d.setVisible(true);
d.setSize(300,300);
d.setTitle("Hello World");
}
}