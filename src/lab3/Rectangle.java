package lab3;

public class Rectangle
{
	
	private final double width;
	private final double height;
	
	public static void main(String[] args)
	{
		Rectangle r = new Rectangle(10, 5);
		System.out.println(r.getArea());  //50
		System.out.println(r.getPerimeter());  // 30


	}
	
	// constructor
	public Rectangle( double width, double height)
	{
		this.width = width;
		this.height = height;
	}

	// returns  width * height
	public double getArea()
	{
		return width*height;
	}
			
	// returns 2 * width + 2 * height
	public double getPerimeter()
	{
		return 2*(width+height);
	}


}
