package minimax;

import java.util.Collection;

public interface IPosition {

	Collection<IMove> getPossibleMoves();

	void doMove(IMove move);

	void undoLastMove();

	/** True if next move's player is interested in maximal positive estimate values */
	boolean isNextPlayerValuePositive();
}
