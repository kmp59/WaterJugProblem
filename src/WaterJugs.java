
/**
 *
 * You have three containers that can hold $c_1$, $c_2$, and
 * $c_3$ liters of water, respectively.
 * Initially, container 1 is full and the other two containers  are empty.
 * You can repeat the following procedure any number of times:
 * Choose two of the containers and pour the contents of one
 * into the other until either the first is empty or the second is full.
 * Your goal is to end up with exactly $d$ liters in one of the containers.
 *
 * The input is a single line containing four integers between
 * 1 and 100 (inclusive) representing
 * $c_1$, $c_2$, $c_3$, and $d$.
 * The output is the number 1 if it is possible to obtain $d$ liters, and
 * -1 otherwise.
 * Good test case: 76 45 32 15.
 * Another test case: 100 5 3 4 ; from movie "Die hard: with a vengeance";
 * do google search for video clip. 
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class WaterJugs {

	public static void main(String args[]) {

		Queue<State> q = new LinkedList<State>();
		Stack<State> st = new Stack<State>();
		ArrayList<State> visited = new ArrayList<State>();

		Scanner scan = new Scanner(System.in);
		int[] cap = new int[3];
		for (int i = 0; i < 3; ++i) {
			cap[i] = scan.nextInt();
		}
		int d = scan.nextInt();
		State.setCapacities(cap); // Setting capacities
		int[] ini = { cap[0], 0, 0 };
		State stateIntitial = new State(ini);
		stateIntitial.pred = null;

		q.add(stateIntitial);
		visited.add(stateIntitial);

		while (q.peek() != null) {
			State next = q.poll();
			if (next.reachedGoal(d)) {
				for (State x = next; x != null; x = x.pred)
					st.push(x);
				break;
			}
			for (int i = 0; i <= 2; i++)
				for (int j = 0; j <= 2; j++) {
					if (i == j)
						continue;
					State p = next.move(i, j);
					boolean isVisited = false;
					for (State v : visited) {
						if (v.contents[0] == p.contents[0] && v.contents[1] == p.contents[1]
								&& v.contents[2] == p.contents[2]) {
							isVisited = true;
						}

					}
					if (!isVisited) {
						q.add(p);
						visited.add(p);
					}

				}
		}

		while (!st.isEmpty())
			st.pop().display();

	}
}
