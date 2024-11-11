
/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: 1000-1140 Morning Class
 * Due: 11/11/2024
 * Platform/compiler: Ubuntu Linux / JDK 21
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   
 * any source. I have not given my code to any student.
 * Print your Name here: David Wery
*/

public class Plot {
	
	int x, y, width, depth;
	
	public Plot() {
		width = 1;
		depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot) {
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	public boolean encompasses(Plot plot) {
		// If top-left and bottom-right corners are in bounds then the whole plot is in bounds
		boolean x_test = (plot.x >= x && plot.x <= x+width && plot.x + plot.width >= x && plot.x + plot.width <= x + width);
		boolean y_test = (plot.y >= y && plot.y <= y+depth && plot.y + plot.depth >= y && plot.y + plot.depth <= y + depth);
		return x_test && y_test;
	}
	
	public boolean overlaps(Plot plot) {
		//test all 4 cases in which the plot DOES NOT collide with this plot, have to return opposite because asking for !(not overlapping)
		return !(x+width <= plot.x || x >= plot.x+plot.width || y+depth <= plot.y || y >= plot.y+plot.depth);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	@Override
	public String toString() {
		return x+","+y+","+width+","+depth;
	}
	
}
