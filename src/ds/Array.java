package ds;

import java.util.Arrays;

class ArrayImplementation{
	//1 create an array => time complexity = O(1) & space complexity = O(n) coz allocating n spaces in memory
	public int[] arr() {
		int[] arrayOne = new int[5];
		return arrayOne;
	}
	
	/* 1. */
	public void addOrCreateElement() {
		int[] arr = arr();
		System.out.println(Arrays.toString(arr)); // returns default values of [0, 0, 0, 0, 0]
	
		/* add/create an element */
	//2 insert element at the beginning - at index 0 => time complexity = O(1), space complexity = O(1) coz not creating a new space but replacing a default value
		arr[0] = 24;
	
	//3 insert element at the middle  - at index 2 => O(1) and O(1)
		arr[2] = 34;
	
	//4 insert element at the end - at index 4 => O(1) and O(1)
		arr[arr.length - 1] = 44;
		
		System.out.println(Arrays.toString(arr));
	}
	
		/* Remove an element is like replacing an element. This can be done in two ways- one way
		 * simple replace an element with a defualt value and second way is to shift towards left the 
		 * elements that are to the right of deleted element */
	public int[] removeElemAndReplaceWithDefaultValue(int[] arr) {
		//5. remove element from the beginning => time complexity = O(1) and space complexity = O(1)
		//6. remove element from the middle
		//7. remove element from the end
		arr[1] = 0;
		return arr;
	}
	
	/* 2. remove an element and shift all elements afterwards towards left 
	 * Time complexity = O(n)
	 * Space complexity = O(1)
	 * */
	public String[] removeElemAndShiftLeft(String[] arr, int indexOfElem) {
		for(int i = indexOfElem + 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		
		arr[arr.length - 1] = " ";
		
		return arr;
	}
	
	/* 3. access an element  based on the index */
	public void accessElement(Double[] arr, double targetValue) {
		
		//8. access an element at the front => time complexity = O(1) and space complexity = O(1)
		//9. access an element at the middle
		//10. access an element at the end of an array
		double elementAtFront = arr[0];
		System.out.println("Element at index o is " + elementAtFront);
		
		/* search for an element based on value, but not based on index 
		 * in this case time complexity = O(n) and space complexity = O(1)
		 * */
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == targetValue) {
				System.out.println("Found " + targetValue + " at index " + i);
			}
		}
	}

    /*4. Insert an element at  a given index */
    public int[] isertElementAtGivenIndex(int[] arr){
        // at index 2, insert 85 => means shift any elem after index 2 to right
        int index = 2;
        int element = 85;
        //shift one element to the right. To do so, i should start at last index value minus 2
        for(int i = arr.length - 2; i >= index; i--){
            arr[i + 1] = arr[i];
        }
        // insert an element
        arr[index] = element;
        return arr;
    }
    
    /* 5. delete an element, need to shift other elements to the left */
    public String[] deleteElement(String[] arr) {
    	int index = 2;
    	int currentArraySize = Integer.MIN_VALUE;
    	for(int i = index; i < arr.length - 1; i++) {
    			arr[i] = arr[i + 1];
        		currentArraySize = i;
    	}
    	//arr[arr.length - 1] = " ";
    	System.out.println("Current Array size = " + currentArraySize);
    	return arr;
    }
}


public class Array {
	public static void main(String[] args) {
		
		ArrayImplementation arrayImpl = new ArrayImplementation();
		arrayImpl.addOrCreateElement();
		
		//removeElemAndReplaceWithDefaultValue method
		int[] arrOne = {2, 3, 4, 5};
		int[] resultantArray = arrayImpl.removeElemAndReplaceWithDefaultValue(arrOne);
		System.out.println("Array after element at index 1 is removed is ...");
		System.out.println(Arrays.toString(resultantArray));
		
		//removeElemAndShiftLeft method
		String[] arrTwo = {"Java", "Spring", "ExpressJS", "ReactJS"};
		int targetIndex = 2;
		String[] resultantArray2 = arrayImpl.removeElemAndShiftLeft(arrTwo, targetIndex);
		System.out.println("After removing an element and shifting towards left...");
		System.out.println(Arrays.toString(resultantArray2));
		
		//accessElement method
		Double[] arrThree = {1.0, 2.0, 2.8, 3.6};
		double targetValue = 2.8;
		arrayImpl.accessElement(arrThree, targetValue);

        // insert element at given index
        int[] arrFour = new int[5];
        arrFour[0] = 2;
        arrFour[1] = 3;
        arrFour[2] = 5;
        arrFour[3] = 9;
       System.out.println(Arrays.toString(arrayImpl.isertElementAtGivenIndex(arrFour)));
       
       //delete element
       String[] arrayFive = {"Java", "C++", "Py", "JS", " "};
       System.out.println(Arrays.toString(arrayImpl.deleteElement(arrayFive)));
	}
}
