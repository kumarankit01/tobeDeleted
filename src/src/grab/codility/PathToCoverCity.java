package grab.codility;

import java.util.Stack;

public class PathToCoverCity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0,1,2,3};
		int b[]=solution(a);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
	public static int[] solution(int[] T) {
		int pathCount[] =  new int[T.length-1];
		Stack<Integer> currentCity =  new Stack<>();
		Stack<Integer> nextCity =  new Stack<>();
		//start navigating from capital
		for (int i = 0; i < T.length; i++) {
			if(T[i] == i){
				currentCity.push(i);
				break;
			}
		}
		int currentLevel = 0;
		//check connectivity from all the city connected at current level
		//2 stack - 1 for current level and 1 for next level city
		//if both are empty that means we have covered all the city
		while(!(currentCity.empty() && nextCity.empty())){
			int count = 0;
			// we need to check only 1 stack which is full
			if(!currentCity.empty()){
				while(!currentCity.empty()){
					int city = currentCity.pop();
					for (int j = 0; j < T.length; j++) {
						if(T[j] == city && j!= city){
							count++;
							nextCity.push(j);
						}
					}
				}
			}else{
				while(!nextCity.isEmpty()){
					int city = nextCity.pop();
					for (int j = 0; j < T.length; j++) {
						if(T[j] == city && j!= city){
							count++;
							currentCity.push(j);
						}
					}

				}
			}
			pathCount[currentLevel] = count;
			currentLevel++;
			if(currentLevel == T.length-1)
				break;
		}


		return pathCount;
	}

}
