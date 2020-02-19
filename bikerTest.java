import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author kshitij
 *
 */
class bikerTest {
	static biker testBiker;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testBiker = new biker();

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testBiker.placeBiker(0, 4, "North");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPlace() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		assertEquals(0, testBiker.getX());
		assertEquals(4, testBiker.getY());
		assertEquals("North", testBiker.directions.get(testBiker.getDirectionFacing()));
	}
	@Test
	void testPlaceOutOfGrid() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.placeBiker(-20, 3, "North");
		}catch (OutOfGridException e) {

			assertEquals("Biker cannot be placed out of Grid",e.getMessage());
		}
	}
	@Test
	void testIllegalPlacingDirectionForBiker() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.placeBiker(0, 5, "Nth");
		}catch (IllegalPlacingDirectionForBikerException e) {

			assertEquals("Please input correct placing direction for biker",e.getMessage());
		}

	}
	@Test
	void testTurnLeft() {
		testBiker.turnLeft();
		assertEquals("West", testBiker.directions.get(testBiker.getDirectionFacing()));
	}
	@Test
	void testTurnRight() {
		testBiker.turnRight();
		assertEquals("East", testBiker.directions.get(testBiker.getDirectionFacing()));
	}
	@Test
	void testTurnForward() throws OutOfGridException {
		testBiker.forward();
		assertEquals(0, testBiker.getX());
		assertEquals(5, testBiker.getY());
	}
	
	@Test
	void testForwardOutOfGridFromNorth() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.forward();
			testBiker.forward();
			testBiker.forward();
		}catch (OutOfGridException e) {

			assertEquals("Biker tried to go out of Grid : North facing Foward Opn Terminated",e.getMessage());
		}
	}
	@Test
	void testForwardOutOfGridFromSouth() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.placeBiker(0, 2, "South");
			testBiker.forward();
			testBiker.forward();
			testBiker.forward();
		}catch (OutOfGridException e) {

			assertEquals("Biker tried to go out of Grid : South facing Foward Opn Terminated",e.getMessage());
		}
	}

	@Test
	void testForwardOutOfGridFromEast() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.placeBiker(4, 0, "East");
			testBiker.forward();
			testBiker.forward();
			testBiker.forward();
		}catch (OutOfGridException e) {

			assertEquals("Biker tried to go out of Grid : East facing Foward Opn Terminated",e.getMessage());
		}
	}
	
	@Test
	void testForwardOutOfGridFromWest() throws IllegalPlacingDirectionForBikerException, OutOfGridException{
		try {
			testBiker.placeBiker(2, 0, "West");
			testBiker.forward();
			testBiker.forward();
			testBiker.forward();
		}catch (OutOfGridException e) {

			assertEquals("Biker tried to go out of Grid : West facing Foward Opn Terminated",e.getMessage());
		}
	}
	
	@Test
	void testGpsReport() {
	
		assertEquals("(0,4), North", "("+testBiker.getX()+","+testBiker.getY()+"), "+ testBiker.directions.get(testBiker.getDirectionFacing()));
	}


}
