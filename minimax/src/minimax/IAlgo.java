package minimax;

import java.util.SortedSet;

public interface IAlgo {

	public SortedSet<Estimate> evaluate(IPosition position);
}
