package minimax;

public class Estimate implements Comparable<Estimate> {

	private IMove move;
	private float value;
	
	private Estimate(IMove move, float value) {
		this.move = move;
		this.value = value;
	}
	
	public IMove getMove() {
		return move;
	}
	
	public float getValue() {
		return value;
	}

	@Override
	public int compareTo(Estimate arg) {
		return Float.compare(this.getValue(), arg.getValue());
	}
}
