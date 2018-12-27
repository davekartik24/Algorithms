

public class Activity implements Comparable<Activity>{

	int start;
	int end;
	int index;

	public Activity(int start, int end, int index) {

		this.start = start;
		this.end = end;
		this.index = index;
	}

	public int compareTo(Activity inputActivity) {

		if(inputActivity.end == end) return 0;

		if(end < inputActivity.end) return -1;

		return 1;
	}


}