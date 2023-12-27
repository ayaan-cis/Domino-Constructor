package dominoes;

public interface Domino {
	public static final int MINIMUM_PIP_COUNT = 0;
	public static final int MAXIMUM_PIP_COUNT = 0;
	// part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT
	// part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT
	public int getHighPipCount();
	// part of post: MINIMUM_PIP_COUNT <= rv <= MAXIMUM_PIP_COUNT
	// part of post: rv <= getHighPipCount()
	public int getLowPipCount();
}
