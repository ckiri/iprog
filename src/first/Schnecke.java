package first;


public class Schnecke {

	
	public static void zweiD (String[][] matrix) {
		String namePerson = "Denis_Maric_";
		char arr[] = namePerson.toCharArray();
		for(int k=0;k<arr.length;k++){
		}
		
		int k = 0;

		int m = matrix.length;
		for (int i = 0; i < m; i++) {
			int n = matrix[i].length;
			for(int j = 0; j < n; j++) {
				if(k == arr.length) k = 0;
				matrix[i][j] = String.valueOf(arr[k]);
				k++;
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
		
	public static void main(String[] args) {
		
		int n;
		n = MyIO.readInt("Wählen Sie eine Zahl zwischen 0 und 45: ");
		String[][] matrix = new String[n][n];
		zweiD(matrix);
	}
}
	
	
