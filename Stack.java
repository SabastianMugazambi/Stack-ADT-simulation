//Aditya Subramanian and Sabastian Mugazambi

import java.util.*;
public class Stack<T> implements StackInterface<T>  {
        
        //initialising the stack
        private T[] stuff;
        private int numItems;
        public Stack(int num) {
            this.numItems = 0;
            this.stuff = (T[]) new Object[num];
        }

        //Checks if the stack is empty and returns a boolean. 
        public boolean isEmpty() {
            if (numItems == 0) {
            return true;
            }
        return false;
        }

        //method that adds the item to the top of the stack.
        public void push(T item) {  
           stuff[this.numItems] = item;
           this.numItems++;
        }

        //Returns the top of the stack
        public T peek() {
            if (this.isEmpty()){
                throw new EmptyStackException();
            }
            return stuff[numItems-1];
        }
        
        //Removes and returns the top of the stack
        public T pop() {
        
            if (this.isEmpty()){
                throw new EmptyStackException();
            }
            this.numItems--;
            return stuff[numItems];
        }
        

        
        //Checks if the stack is empty and returns a boolean. 
        public void clear() {
            numItems = 0;
        }
        

}
