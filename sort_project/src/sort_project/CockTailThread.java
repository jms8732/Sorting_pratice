package sort_project;

import java.awt.Color;


/*
 * Ä¬Å×ÀÏ Á¤·Ä
 */
public class CockTailThread extends baseThread implements Runnable {

	public CockTailThread(int LEN, Point[] array, int x, int y) {
		super(LEN, array, "Cock Tail Sort", x, y);
	}

	public void run() {
		int left = 0, shift= -1 , right = array.length-1;

		while ((left=shift) < right) {
			for (int i = left+1; i < right; i++) {
				if (array[i].len < array[i+1].len) {
					Point temp = array[shift=i];
					array[i] = array[i+1];
					array[i+1] = temp;

					array[i+1].color = Color.white;
					array[i].color = Color.white;
					b.repaint();
					sleep();
					
				}
			}

			for (int i = (right=shift)-1; i > left; i--) {
				if (array[i].len < array[i+1].len) {
					Point temp = array[shift=i];
					array[i] = array[i+1];
					array[i+1] = temp;

					array[i+1].color = Color.red;
					array[i].color = Color.red;
				

					array[i+1].color = Color.white;
					array[i].color = Color.white;
					b.repaint();
					sleep();
					

				}
			}
		}
		finish();
	}

}
