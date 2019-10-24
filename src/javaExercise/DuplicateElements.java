package javaExercise;

public class DuplicateElements {

	public static void main(String[] args) {
		String names[] = {"Java", "JavaScript", "C", "Python", "C", "Java", "C"};
		dupElements(names);
	}
	
	public static void dupElements(String array[]) {
		for(int i=0; i<array.length; i++) {
			for(int j = i+1; j<array.length; j++) {
				
				if(array[i]==array[j]) {
					System.out.println("Duplicate :" + array[j]);
				}
			}
		}
	}
}
