package sort_project;

import java.awt.Color;
import java.util.*;

public class PlaySort {
	private static Random rn;
	private static final int LEN = 1000;
	private static Thread[] bt;

	public static void main(String[] args) {
		rn = new Random();

		Point[] array = new Point[LEN];
		boolean[] check = new boolean[LEN];

		for (int i = 0; i < LEN; i++) {
			int h = get_len(check);
			array[i] = new Point(h, Color.white);
		}

		init(array);
		start();
	}

	private static void start() {
		for (Thread t : bt) {
			if (t != null)
				t.start();
		}
	}

	private static void init(Point[] array) {
		bt = new Thread[7];
		bt[0] = new Thread(new BubbleThread(LEN, array, 0, 0));
		bt[1] = new Thread(new SelectionThread(LEN, array, 700, 0));
		bt[2] = new Thread(new InsertionThread(LEN, array, 0, 500));
		bt[3] = new Thread(new MergeThread(LEN, array, 700, 500));
		bt[4] = new Thread(new CockTailThread(LEN, array, 1400, 500));
		bt[5] = new Thread(new QuickThread(LEN, array, 1400, 0));

		bt[6] = new Thread(new HeapThread(LEN, array, 1000, 500));
	}

	private static int get_len(boolean[] check) {
		while (true) {
			int len = rn.nextInt(LEN);

			if (!check[len]) {
				check[len] = true;
				return len;
			}
		}
	}

}
