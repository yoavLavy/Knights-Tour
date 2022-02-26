import java.util.ArrayList;

public class Board {
	private int[][] boardArr;
	private int rows, cols;
	private int currY, currX;
	int moveNum = 1;
	
	public Board(int rows, int cols, int startY, int startX) {
		this.rows = rows; this.cols = cols;
		currY = startY; currX = startX;
		
		boardArr = new int[rows][cols];
		moveTo(currY, currX);
	}
	public Board() {
		this(8, 8, 0, 0);
	}
	public Board(int dim) {
		this(dim, dim, 0, 0);
	}
	
	public void printBoard() {
		for(int[] row : boardArr) {
			for(int square : row) {
				System.out.printf("%3d", square);
			}
			System.out.println();
		}
	}
	public void moveTo(int row, int col) {
		boardArr[row][col] = moveNum++;
		currY = row; currX = col;
		
	}
	public int getMoveNum() {
		return moveNum;
	}
	private boolean isWithinBoard(int row, int col) {
		return 0 <= row && row < rows &&
				0 <= col && col < cols;
	}
	public ArrayList<int[]> getKnightMoves(){
		ArrayList<int[]> outputList = new ArrayList<int[]>();
		int[] deltaY = {2, 2, 1, -1, -2, -2, -1, 1};
		int[] deltaX = {-1, 1, 2, 2, 1, -1, -2, -2};
		for(int i = 0; i < 8; i++) {
			int moveY = currY + deltaY[i];
			int moveX = currX + deltaX[i];
			if(isWithinBoard(moveY, moveX)) {
				outputList.add(new int[]{moveY, moveX});
			}
		}
		
		return outputList;
	}
	public ArrayList<int[]> getTourMoves() {
		ArrayList<int[]> outputList = new ArrayList<int[]>();
		for(int[] move : getKnightMoves()) {
			if(isEmpty(move[0], move[1])) {
				outputList.add(move);
			}
		}
		return outputList;
	}
	private boolean isEmpty(int y, int x) {
		return boardArr[y][x] == 0;
	}

	public void revertOne() {
		boardArr[currY][currX] = 0;
		ArrayList<int[]> squares = getKnightMoves();
		for(int[] square : squares) {
			if(boardArr[square[0]][square[1]] == moveNum - 2) {
				currY = square[0]; currX = square[1];
				moveNum--;
				break;
			}
		}
	}
}
