


public class Goods implements Comparable<Goods> {

	int weight;
	int value;
	double ratio;

	public Goods(int weight, int value) {

		this.weight = weight;
		this.value = value;
		this.ratio = value / weight;
	}


	public int compareTo(Goods toCompare) {

		if(ratio == toCompare.ratio) return 0;

		if(toCompare.ratio < ratio) return -1;

		return 1;
	}

	public boolean equals(Object input) {

		if(input instanceof Goods) {

			Goods inputCast = (Goods) input;

			if(inputCast.weight == this.weight && inputCast.value == this.value) return true;
		}

		return false;

	}

	public int hashCode() {

		return 31 * this.weight * this.value;
	}


}