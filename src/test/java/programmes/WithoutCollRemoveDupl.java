package programmes;

public class WithoutCollRemoveDupl {

	public static void main(String[] args) {
		int[] arr={1,3,5,6,8,1,3,8,9};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]==arr[j]){
					arr[j]=0;
				}
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0){
				System.out.print(arr[i]);
			}
		}

	}

}
