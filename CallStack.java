//Aditya Subramanian and Sabastian Mugazambi



//Implementing the stack interface as a linked stack. 
public class CallStack implements StackInterface<Method> {

    //Initialising the variables that will keep track of the node and the simmulation.
    private Node first;
    private SimulationComponent simcomp;

    //Creating a private class that has all the capabilities of a node.     
    private class Node {
        private Method method;
        private Node next;
        
        //Constructing the node by adding the method and also the next reference for the next node.
        public Node(Method method1) {
            method = method1;
            next = null;
        }
        
        //This method changes the next node reference a a particular node. 
        public void changeNext(Node node1) {
            next = node1;
        }
        
        //This method returns the reference to the next node stored on the current node. 
        public Node nextNode() {
            return this.next;
        }
        
        //This method returns the method currently stored  at the current node. 
        public Method currentMethod() {
            return this.method;
        }
        
    }
    
    //Constructing the first node and also constructing an object for the given SimulationComponent class. 
    public CallStack(SimulationComponent thingy) {
        first = null;
        this.simcomp = thingy;
    }
    
    //adding a method to the stack and also keeping track of the node referencies so that the new node is added to the link. 
    public void push(Method method2){
        simcomp.addMethodToGraphicalStack(method2);
        Node node2 = new Node(method2);

        //Conditional statement to check if we are stating to add from the first or ading from the current list. 
        if(first == null){
            first = node2;

        } else {

            //This executes if there is already another method that has been added to the stack before it. 
            node2.changeNext(first);
            this.first = node2;
        }
    }

    //Checking if the stack is empty and removing the top item in the stack.
    public Method pop(){

        if(this.isEmpty()){
            return null;
        }


        //storing the removed method in an instance variable popped and then changing nodes to get rid of the removed one and returning the popped method. 
        Method popped = first.currentMethod();
        this.first = first.nextNode();
        simcomp.removeMethodFromGraphicalStack(popped);
        return popped;
    }
    
    //Returns the item that is at the top of the stack but does not do anything to it.
    public Method peek(){
        return first.currentMethod();
    }
    
    //Checks if the stack is empty then returns a boolean. 
    public boolean isEmpty() {
        if (first == null) {
            return true; 
        }

    return false;
    }

    //Clears the whole stack by nulling the first or reseting it to null. 
    public void clear() {
        this.first = null;
    }


}
