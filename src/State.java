
public class State {
	static int[] capacity;
	int[] contents;
	State pred; // predecessor state

	static void setCapacities(int[] c) {
		for (int i = 0; i<3; i++) {
		c[i] = capacity[i];}
	}


/*
 * Define states to be used in solving the water jugs problem.
 */

class State {
	static int[] capacity;
	int[] contents;
	State pred; // predecessor state

	static void setCapacities(int[] c) //set static capacity
	{
		capacity = new int[3];
		capacity[0] = c[0];
		capacity[1] = c[1];
		capacity[2] = c[2];
	}

	State(int[] c) // changeble contents 
	{
		contents = new int[3];
		contents[0] = c[0];
		contents[1] = 0;
		contents[2] = 0;
	}

	State(State s) //State contents
	{
		contents = new int[3];
		contents[0] = s.contents[0];
		contents[1] = s.contents[1];
		contents[2] = s.contents[2];
	}
	
	State move(int source, int destination) // move contents from one jug to another
	{
		State newState = new State(this);
		
		int i = source;
		int j = destination;
		int amountTransfer;
		
		if(newState.contents[i] <= State.capacity[j] - newState.contents[j])//if content is less than capacity then move everything
			{
			amountTransfer = newState.contents[i];
			newState.contents[i] -= amountTransfer;
			newState.contents[j] += amountTransfer;
			}
			
		if(newState.contents[i] > State.capacity[j] - newState.contents[j])//if more than move only util one gets full or one gets empty
		{
			amountTransfer = State.capacity[j] - newState.contents[j];
			newState.contents[i] -= amountTransfer;
			newState.contents[j] += amountTransfer;
		}
		newState.pred = this;
		return newState;
		
	}

	boolean reachedGoal(int d) //checks goal
	{
		boolean isTrue = false;
		for (int x = 0; x < contents.length; x++) {
			if (contents[x] == d)
				isTrue = true;
		}
			
		return isTrue;
	}

	void display() {
		System.out.println(contents[0] + " " + contents[1] + " " + contents[2]);
	}
}
	State(int[] c) {
		for(int i = 0; i<3; i++) {
		contents[i] = c[i];}
	}


	public State(State state) {
		for(int i = 0; i<3; i++) {
			contents[i] = state.contents[i];}
	}

	State move(int source, int destination) {
		State newState = new State(this);
		int i  = source;
		int j = destination;
		int amountToTransfer;
		if(newState.contents[i] <= (State.capacity[j] - newState.contents[j])) {
			amountToTransfer = newState.contents[i];
			newState.contents[i] += amountToTransfer;
			newState.contents[j] -= amountToTransfer;}
		
		else if(newState.contents[i] > (State.capacity[i] - newState.contents[j])) {
			amountToTransfer = (State.capacity[j] - newState.contents[j]);
			newState.contents[j] += amountToTransfer;
			newState.contents[i] -= amountToTransfer;
		}
		
		newState.pred = this;
		return newState;
	}

	boolean reachedGoal(int d) {
		if ( contents[0] == d || contents[1] == d || contents[2] == d ) {
			return true;
		}
		else {
			return false;
		}
	}

	void display() {
		System.out.println(contents[0] + " " + contents[1] + " " + contents[2]);
	}
}
