import java.util.ArrayList;
import java.util.Collections;

public class KnightTour {
	private Board board;
	private int xDim, yDim;
	
	public KnightTour(int yDim, int xDim, int startY, int startX) {
		this.yDim = yDim; this.xDim = xDim;
		board = new Board(yDim, xDim, startY, startX);
	}
	public KnightTour() {
		this(8, 8, 0, 0);
	}
	public KnightTour(int dim) {
		this(dim, dim, 0, 0);
	}
	public boolean tour() {
		if(board.getMoveNum() == yDim * xDim + 1) {
			return true;
		}
		ArrayList<int[]> moves = board.getTourMoves();
		//Collections.shuffle(moves);
		for(int[] move : moves) {
			board.moveTo(move[0], move[1]);
			if(tour()) {
				return true;
			}
			board.revertOne();
		}
		return false;
	}
	public void printBoard() {
		board.printBoard();
	}
}
