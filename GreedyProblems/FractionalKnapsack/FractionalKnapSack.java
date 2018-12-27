
import java.util.*;

public class FractionalKnapSack{	

	public int maxValue(int[] wt, int[] val, int capacity) {

		Goods[] goodsArray = new Goods[wt.length];

		int totalValue = 0;

		for(int i = 0; i < wt.length; i++) {

			goodsArray[i] = new Goods(wt[i], val[i]);
		}

		Arrays.sort(goodsArray);

		int k = 0;

		while(k < goodsArray.length && capacity != 0) {

			if(capacity >= goodsArray[k].weight) {
				capacity = capacity - goodsArray[k].weight;
				totalValue = totalValue + goodsArray[k].value;
				k++;
			} else {
				totalValue = totalValue + (int)goodsArray[k].ratio * capacity;
				break;
			}
		}

		return totalValue;
	}




	public static void main(String[] args) {

		int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 40, 100, 120}; 
        int capacity = 50;

        FractionalKnapSack testInstance = new FractionalKnapSack();

        System.out.println("The maximum value for the knapsack will be : " + testInstance.maxValue(wt, val, capacity));


	}
}