
import images.APImage;
import images.Pixel;
import java.awt.Dimension;

public class TestDraw2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APImage image = new APImage ("C:\\GeorgeWork\\Boat\\J\\Img0031\\dscn0501.jpg");
		image.setSize(300, 400);
		image.setBounds(0, 0, 400, 600);
		
		
		Dimension imageDims = new Dimension();
		imageDims.setSize (300, 400);
		image.setSize (imageDims);
		
		int width = image.getWidth();
		int height = image.getHeight();
		
		int factor = 3; 
		
		APImage resizedImage = new APImage (width/3, height/3);
		int horIndex = 0;
		int vertIndex = 0;
		for (horIndex = 0; horIndex < width; horIndex += factor)
		{
			for (vertIndex = 0; vertIndex < height; vertIndex += factor)
			{
				// get pixel and copy it to resizedImage
				Pixel pixel = image.getPixel(0,  0);
				if (horIndex < width && vertIndex < height)
				{
					pixel = image.getPixel(horIndex,  vertIndex);
				}
				else
					System.out.print("ërror");
				
				// the bounds of the resized image must be checked.  Must stay less than width
				// and height of resized image.
				if (horIndex/factor < width/factor && vertIndex/factor < height/factor)
				{
					try
					{
						resizedImage.setPixel(horIndex/factor, vertIndex/factor, pixel);
					}
					catch (Exception exc)
					{
						String errorStr = exc.toString();
					}
					
				}
				else
				{
					System.out.print ("error");
				}
				
				
			}
		}
		int x = vertIndex;
		int y = horIndex;
		resizedImage.draw();
			
			
		
		/*
		image.draw();
		
		for (Pixel p : image)
		{
			int red = p.getRed();
			int green = p.getGreen();
			int blue = p.getBlue();
			int average = (red + green + blue) / 3;
			p.setRed(average);
			p.setGreen(average);
			p.setBlue(average);
		}
		
		image.draw();
		*/
	}

}
