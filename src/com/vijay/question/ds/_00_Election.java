package com.vijay.question.ds;

import java.util.LinkedList;

/**
 * A group of students are sitting in a circle. The teacher is electing a new
 * class president. The teacher does this by singing a song while walking around
 * the circle. After the song is finished the student at which the teacher
 * stopped is removed from the circle.
 *
 * Starting at the student next to the one that was just removed, the teacher
 * resumes singing and walking around the circle. After the teacher is done
 * singing, the next student is removed. The teacher repeats this until only one
 * student is left.
 *
 * A song of length k will result in the teacher walking past k students on each
 * round. The students are numbered 1 to n. The teacher starts at student 1.
 *
 * For example, suppose the song length is two (k=2). And there are four
 * students to start with (1,2,3,4). The first student to go would be `2`, after
 * that `4`, and after that `3`. Student `1` would be the next president in this
 * example.
 *
 * 
 * Implement whoIsElected() correctly.
 */
public class _00_Election {

	// solution 1
	public static int whoIsElected(int n, int k) {
		if (n == 1)
			return 1;
		return (whoIsElected(n - 1, k) + k - 1) % n + 1;
	}

	// solution 2
	public static int whoIsElected2(int n, int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		// why -1 ? value needed before index
		int i = -1;
		// if size 1 then that will be president.
		while (list.size() > 1) {
			int v = (i + k) % list.size();
			list.remove(v);
			//move cursor 1 step back as you delete one.
			i = v - 1;
		}
		return list.getFirst();
	}

	public static boolean doTestsPass() {
		int[][] testCases = { { 1, 1, 1 }, { 2, 2, 1 }, { 4, 2, 1 }, { 100, 2, 73 }, { 5, 3, 4 }, { 6, 4, 5 },
				{ 1000, 5, 763 }, { 6, 2, 5 } };

		for (int[] testCase : testCases) {
			int answer = whoIsElected2(testCase[0], testCase[1]);
			if (answer != testCase[2]) {
				System.out.println("test failed!");
				System.out.printf("n:%d, k%d, answer got: %d, should be: %d\n", testCase[0], testCase[1], answer,
						testCase[2]);
				return false;
			}
		}
		System.out.println("All tested passed");
		return true;
	}

	/**
	 * Execution entry point.
	 */
	public static void main(String args[]) {
		doTestsPass();
	}
}
