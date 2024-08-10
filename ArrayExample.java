class ArrayExample {
      public static void main(String[] args) {
            // Feel free to change the array to better test your code
            String[] example = {"Sally", "George", "Dave", "Stuart", "Kia", "Irina", "Zhi", "", "", ""};
        
            System.out.println("Search Test");
            System.out.println(search(example, "George"));
            
            System.out.println("Remove Test");
            example = remove(example, "Stuart");
            for(String value : example) {
              System.out.print(value + " ");
            }
            System.out.println();
            
            System.out.println("AddToMiddle Test");
            example = addToMiddle(example, "Anna");
            for(String value : example) {
              System.out.print(value + " ");
            }
            System.out.println();
            
      }
    
      /**
      * Create a method that will iterate through the array
      * to determine if the word is in the set already 
      * @return true if the word exists in the set
      */
      public static boolean search(String[] set, String word) {
        for (int i = 0; i < set.length; i++) {
            if(set[i].equals(word)) {
              return true;
            }
        }
        return false;
      }
      
    
      /**
      * Create a method that remove ANY element that matches
      * the given word
      *
      * @return the set without any instances of the given 
      * word 
      */
      public static String[] remove(String[] set, String word) {
        // When deleting something, consider what you are 
        // going to do with the gap
    
        int deleteIndex = -1;
        for(int i = 0; i < set.length; i++) {
          if(set[i].equals(word)) {
            deleteIndex = i;
            break;
          }
        }
    
        if(deleteIndex >= 0) {
        for (int i = deleteIndex; i < set.length - 1; i++){
          set[i] = set[i+1];
        }
          set[set.length-1] = "";
        }
        return set;
      } 
    
      /**
      * Create a method will add the give word to the middle 
      * of the array.  It will move all other elements out of
      * the way. You can assume that the array is not full and
      * has some empty spots towards the end of the array.
      *
      * @return the set without any instances of the given 
      * word 
      */
      public static String[] addToMiddle(String[] set, String word) {
        for(int i = 0; i < set.length - 2; i++){
          if(set[i].equals("")){
            set[i] = word;
            String a = set[4];
            String b = set[i];
            set[4] = b;
            set[i] = a;
            
          }
        }
        return set;  
      }
}