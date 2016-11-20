package grab.codility;

public class ParkingPrice {

	public static void main(String[] args) {
		solution("00:00", "23:59");
	}
	public static int solution(String E, String L) {
		String regex = ":";
		String entry[] = E.split(regex);
		String exit[] = L.split(regex);
		int entryTimeInMin = Integer.parseInt(entry[0])*60 + Integer.parseInt(entry[1]);
		int exitTimeInMin = Integer.parseInt(exit[0])*60 + Integer.parseInt(exit[1]);
		int timeDifference = (int) Math.ceil((exitTimeInMin - entryTimeInMin)/60.0);
		int totalCost = 5;
		if(timeDifference > 0){
			totalCost = 5+((timeDifference-1)*4);
		}
		return totalCost;
	}

}
