/**
 * @author kshitij
 *
 */

import java.util.ArrayList;

public class biker {
	private int x;
	private int y;
	private int directionFacing;

	/**
	 * 
	 */
	ArrayList<String> directions;

	biker() {
		directionFacing = -99;
		directions = new ArrayList<String>();
		directions.add("North");
		directions.add("East");
		directions.add("South");
		directions.add("West");
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}



	/**
	 * @return the directionFacing
	 */
	public int getDirectionFacing() {
		return directionFacing;
	}
	/**
	 * @param directionFacing the directionFacing to set
	 */
	public void setDirectionFacing(int directionFacing) {
		this.directionFacing = directionFacing;
	}

	/**
	 * method used to place biker on the grid and set the current direction in which biker is facing
	 * it takes x and y as location co-ordinates and direction in which currently biker is facing
	 * IllegalPlacingDirectionForBikerException is thrown when currentDirection for biker could not be set so biker could not be placed on grid.
	 * utOfGridException which is thrown when biker attempts to be placed out of grid
	 * returns true if successfully placed biker on grid
	 */
	public boolean placeBiker(int x, int y, String direction) throws IllegalPlacingDirectionForBikerException, OutOfGridException {
		if((x>=0 && x<7) && (y>=0 && y<7)) { // if placing them in 7by7 array. checking if out of grid 
			this.x = x;
			this.y = y;
			for(int i=0;i<4;i++) {
				if(directions.get(i).equalsIgnoreCase(direction)) {
					directionFacing = i;
					return true;
				}
			}
			throw new IllegalPlacingDirectionForBikerException("Please input correct placing direction for biker");// if cannot find matching direction

		}
		else
			throw new OutOfGridException("Biker cannot be placed out of Grid"); // if out of bounds of grid

	}

	/**
	 * method to move biker by one step in current facing direction
	 * @throws OutOfGridException which is thrown when biker attempts to go out of grid
	 */
	public void forward() throws OutOfGridException {
		if(directionFacing == 1)// Facing East
			if(x != 6)
				this.x++;
			else
				throw new OutOfGridException("Biker tried to go out of Grid : East facing Foward Opn Terminated");
		else if(directionFacing == 3)// facing west
			if(x != 0)
				this.x--;
			else
				throw new OutOfGridException("Biker tried to go out of Grid : West facing Foward Opn Terminated");
		else if(directionFacing == 2)//facing south
			if(y != 0)
				this.y--;
			else
				throw new OutOfGridException("Biker tried to go out of Grid : South facing Foward Opn Terminated");
		else if(directionFacing == 0)//facing north
			if(y!=6)
				this.y++;
			else
				throw new OutOfGridException("Biker tried to go out of Grid : North facing Foward Opn Terminated");
	}

	/**
	 * method used to turn biker left
	 */
	public void turnLeft() {
		if(directionFacing==0)
			directionFacing=3;
		else
			directionFacing--;
	}
	/**
	 * method used to turn biker right
	 */
	public void turnRight() {
		if(directionFacing == 3)
			directionFacing = 0;
		else
			directionFacing++;
	}

}
