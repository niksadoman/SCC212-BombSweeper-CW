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

	// public int checkSurroundingBombs(){
	// 	int bombCount = 0; 

	// 	for(int x = xLocation - 1; x <= 3; x++){
	// 		for(int y = yLocation - 1; y <= 3; y++){
	// 			if(thisSquareHasBomb == true){
	// 				bombCount++;
	// 			}
	// 		}
	// 	}
	// 	return bombCount;
	// }

	public void clicked()
	{
		int bombCount;
		if(thisSquareHasBomb == true){
		setImage("images/bomb.png");
		}else{
			setIcon(getDisabledIcon());
		}

	}
}
