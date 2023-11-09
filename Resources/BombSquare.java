import java.util.*;

public class BombSquare extends GameSquare
{
	private boolean thisSquareHasBomb = false;
	public static final int MINE_PROBABILITY = 10;

	public BombSquare(int x, int y, GameBoard board)
	{
		super(x, y, "images/blank.png", board);

		Random r = new Random();
		thisSquareHasBomb = (r.nextInt(MINE_PROBABILITY) == 0);
	}

	public int checkSurroundingBombs(){
 		
		int bombCount = 0;

		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				if(isSquareOutOfBounds(i,j)){
					GameSquare adjacenSquare = board.getSquareAt(xLocation + i, yLocation + j);
					if (adjacenSquare != null && ((BombSquare)adjacenSquare).thisSquareHasBomb){
						bombCount++;
					}
				}
			}
		}
		return bombCount;
	}

	private boolean isSquareOutOfBounds(int x, int y){
		return xLocation + x > 0 && xLocation + x < board.getWidth() &&
				yLocation + y > 0 && yLocation + y < board.getHeight(); 
	}

	public void clicked()
	{
		if(thisSquareHasBomb){
			setImage("images/bomb.png");
		}else{
			
			int numSurroundingBombs = checkSurroundingBombs();

			if(numSurroundingBombs > 0){
				setImage("images/" + numSurroundingBombs + ".png");
			}
		}
	}
}
