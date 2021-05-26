
public class CustomLinkedList {

    private Element LeftElement; //Left element of the List
    private Element RightElement; //Right element of the List
    private int numOfElements; //number of list elements. 0 in the beginning

    //Add element to the left side
    public void addElementToLeft(int num){
        Element elem = new Element(num);
        //If list is empty - initial state, just add an element
        if(RightElement == null){
            LeftElement = elem;
            RightElement = elem;
            numOfElements++;
        }
        else {
            elem.next = LeftElement; //Element being added refers to the left element of the list
            LeftElement = elem; //Element being added became left
            numOfElements++;
        }
    }

    //Add element to the left side
    public void addElementToRight(int num){
        Element elem = new Element(num);
        //If list is empty - initial state, just add an element
        if(RightElement == null){
            LeftElement = elem;
            RightElement = elem;
            numOfElements++;
        }
        else {
            RightElement.next = elem; //Element being added is refered by the right element of the list
            RightElement = elem; //Element being added became right
            numOfElements++;
        }
    }


    //Delete element from the list
    public void deleteElement(int num){

        //Empty List - nothing to be deleted
        if (RightElement == null){
            return;
        }

        //If only one element in a list
        if (RightElement == LeftElement) {
            //If this is the element which has to be deleted
            if (RightElement.data == num) {
                RightElement = null;
                LeftElement = null;
                numOfElements--;
                return;
            }
            //Quit if this element is not which has to be deleted
            else {
                return;
            }
        }

        //If deleted element - is the last right one
        if(LeftElement.data == num){
            LeftElement = LeftElement.next;
            numOfElements--;
            return;
        }

        //All elements except the first one
        else {
            Element temp = LeftElement;
            while(temp.next != null){
                if(temp.next.data == num){
                    if(temp.next == RightElement) {
                        RightElement = temp;
                    }
                    temp.next = temp.next.next;   //Throw away the found element. If its the last one, than it holds reference to null
                    numOfElements--;
                    return;
                }
                temp = temp.next;
            }
        }
    }

    //Returns string with list elements separated by commas
    public String printList(){
        String output = "";
        if (RightElement == null){
            return "List is empty";
        }
        else {
            Element temp = LeftElement;
            while (temp != null) {
                if (temp.next == null){
                    output = output + String.valueOf(temp.data);
                }
                else {
                    output = output + String.valueOf(temp.data) + ", ";
                }
                temp = temp.next;
            }
            return output;
        }
    }

    /*
    Bubble sort, increase
    Bubble sort:
            for bypass in range (1,N)         -> for bypass in range (0,N-1)
        for k in range (0,N-bypass)   ->     for k in range (0,N-bypass-1)
    */
    public void sortIncrease() {
        Element temp;
        for (int i = 0; i < numOfElements-1; i++){
            temp = LeftElement;
            for(int k = 0; k < numOfElements - i - 1; k++){
                if(temp.next != null){
                    if (temp.data > temp.next.data){
                        int swapeddata = temp.data;
                        temp.data = temp.next.data;
                        temp.next.data = swapeddata;
                    }
                    temp = temp.next;
                }
            }
        }
    }

    //Returns string with N max elements from the list. Numbers are separated by commas
    public String getNMaxElements(int num){

        if(LeftElement == null) {
            return "Serching is impossible. List is empty";
        }

        if(num > numOfElements){
            return "Serching is impossible. Number of list items is less than number of items to be found";
        }

        else {
            Element temp = LeftElement;
            String outputString = "";
            int[] output = new int[num];
            int k = 0;

            sortIncrease();

            for(int i = 1; i <= numOfElements; i++){
                if (i > numOfElements - num){
                    output[k] = temp.data;
                    k++;
                }
                temp = temp.next;
            }

            for (int i = 0; i < num; i++){
                if(i != num - 1) {
                    outputString = outputString + output[i] + ", ";
                }
                else {
                    outputString = outputString + output[i];
                }
            }
            return outputString;
        }
    }
}


