package Nov;

/**
 * @author Gonghan
 * 
 */
public class ContainerWithMostWater {

	public static void main(String[] args) {

	}

}

/*
 * 1. set two poiners from both ends
 * 2. move shortest one to find if max area
 */
class ContainerWithMostWaterSolution {
	public int maxArea(int[] height) {
		// Area = |ai-aj|*Min(ai,aj)
		int length = height.length;
		int i = 0;
		int j = length - 1;
		int maxArea = 0;
		while (i < j) {
			maxArea = Math.max(maxArea,
					(j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j]) {
				i++;
			} else {
				j--;
			}
		}
		return maxArea;
	}
}
