package minimax;

import java.util.SortedSet;
import java.util.TreeSet;

public class MinimaxAlgo {

	
	private MinimaxAlgoConfig config;
	private IAlgo heuristicalAlgo;

	public MinimaxAlgo(IAlgo heuristical, MinimaxAlgoConfig config) {
		this.heuristicalAlgo = heuristical;
		this.config = config;
	}
	
	public SortedSet<Estimate> evaluate(IPosition position) {
		return evaluate(position, 1);
	}
	
	public SortedSet<Estimate> evaluate(IPosition position, int depth) {
		
		if(depth == config.getMaxDepth()) {
			SortedSet<Estimate> estimates = this.heuristicalAlgo.evaluate(position);
			return estimates;
		}

		// in this set we keep N best moves for the current player
		// the set is ordered in ascending order by Estimate.getValue() 
		// the N is configurable using MaxEstimateCount setting
		TreeSet<Estimate> bestEstimateSet = new TreeSet<>();
		
		for(IMove move : position.getPossibleMoves()) {
			
			position.doMove(move);
			
			SortedSet<Estimate> estimates = evaluate(position, depth + 1);
			
			for(Estimate estimate : estimates) {
				updateBestEstimateSet(bestEstimateSet, position.isNextPlayerValuePositive(), estimate);
			}
			
			position.undoLastMove();
		}
		return bestEstimateSet;
	}

	private void updateBestEstimateSet(SortedSet<Estimate> bestEstimateSet, boolean maximizePositives, Estimate estimate) {
		if(bestEstimateSet.isEmpty()) {
			bestEstimateSet.add(estimate);
		} else {

			if(maximizePositives) {
				if(estimate.getValue() > bestEstimateSet.last().getValue()) {
					if(config.getMaxEstimateCount() == bestEstimateSet.size()) {
						bestEstimateSet.remove(bestEstimateSet.first());
					}
					bestEstimateSet.add(estimate);
				}
			} else {
				if(estimate.getValue() < bestEstimateSet.last().getValue()) {
					if(config.getMaxEstimateCount() == bestEstimateSet.size()) {
						bestEstimateSet.remove(bestEstimateSet.last());
					}
					bestEstimateSet.add(estimate);
				}
			}
		}
	}
}
