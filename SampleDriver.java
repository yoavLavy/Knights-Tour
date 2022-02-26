
public class SampleDriver {
	public static void main(String[] args) {
		KnightTour kt5 = new KnightTour(5);
		kt5.tour();
		kt5.printBoard();
		System.out.println();
		System.out.println();
		
		KnightTour kt6 = new KnightTour(6);
		kt6.tour();
		kt6.printBoard();
		System.out.println();
		
		KnightTour kt56 = new KnightTour(5, 6, 0, 0);
		kt56.tour();
		kt56.printBoard();
	}

}
