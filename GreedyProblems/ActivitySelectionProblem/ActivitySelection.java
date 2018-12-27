
import java.util.*;

public class ActivitySelection {

	public int maxActivities(int[] s, int[] f) {

		Activity task[] = new Activity[s.length];

		int totalTask = 0;

		for(int i = 0; i < task.length; i++) {

			task[i] = new Activity(s[i], f[i], i);
		}

		Arrays.sort(task);

		int start = -1;
		int end = -1;

		for(int i = 0; i < task.length; i++) {

			if(start == -1) {

				totalTask++;
				start = task[i].start;
				end = task[i].end;
				continue;
			}

			if(task[i].start < end) continue;

			totalTask++;
			start = task[i].start;
			end = task[i].end;
		}

		return totalTask;
		
	}

	public static void main(String[] args) {

		int s[] =  {5, 1, 3, 0, 5, 8}; 
    	int f[] =  {9, 2, 4, 6, 7, 9}; 

    	ActivitySelection testInstance = new ActivitySelection();

    	System.out.println("total number of activities will be : " + testInstance.maxActivities(s, f));
	}
}