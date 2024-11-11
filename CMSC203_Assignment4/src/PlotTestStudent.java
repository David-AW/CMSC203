import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlotTestStudent {

	private Plot plot1, plot2, plot3, plot4, plot5, plot6, plot7, plot8, plot9;
	
	@BeforeEach
	void setUp() throws Exception {
		plot1 = new Plot(5,5,5,5);
		plot2 = new Plot(6,6,3,3); // encompassed by plot1
		plot3 = new Plot(10,5,3,2); // not overlapping but touching right edge of plot1
		plot4 = new Plot(4,4,2,2); // overlapping top left
		plot5 = new Plot(9,4,2,2); // overlapping top right of plot1 and overlapping plot3
		plot6 = new Plot(4,8,3,3); // overlapping bottom left of plot1 and overlapping plot2
		plot7 = new Plot(9,9,2,2); // overlapping bottom right
		plot8 = new Plot(3,6,10,4); // overlapping no vertices encompassed
		plot9 = new Plot(0,0,1,1); // not overlapping anything
	}

	@AfterEach
	void tearDown() throws Exception {
		plot1 = plot2 = plot3 = plot4 = plot5 = plot6 = plot7 = plot8 = plot9 = null;
	}

	@Test
	void testToString() {
		assertEquals("5,5,5,5", plot1.toString());
		assertEquals("10,5,3,2", plot3.toString());
	}

	@Test
	void testEncompasses() {
		assertTrue(plot1.encompasses(plot2));
		assertFalse(plot1.encompasses(plot3));
		assertFalse(plot5.encompasses(plot3));
	}
	
	@Test
	void testOverlaps() {
		assertFalse(plot3.overlaps(plot1));
		assertTrue(plot4.overlaps(plot1));
		assertTrue(plot5.overlaps(plot1));
		assertTrue(plot5.overlaps(plot3));
		assertTrue(plot6.overlaps(plot1));
		assertTrue(plot6.overlaps(plot2));
		assertTrue(plot7.overlaps(plot1));
		assertTrue(plot8.overlaps(plot1));
		assertFalse(plot4.overlaps(plot6));
		assertFalse(plot9.overlaps(plot1));
	}
	
}
