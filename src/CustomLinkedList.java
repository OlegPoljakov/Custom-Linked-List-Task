
public class CustomLinkedList {

    private Element LeftElement; //левый элимент списка
    private Element RightElement; //правый элимент списка
    private int numOfElements; //Изначально null элементов - пустой список

    //Добавление элемента слева
    public void addElementToLeft(int num){
        Element elem = new Element(num);
        //Если список пуст - начальное состояние, просто добавляем элемент
        if(RightElement == null){
            LeftElement = elem;
            RightElement = elem;
            numOfElements++;
        }
        else {
            elem.next = LeftElement; //ДобавлЯЕМЫЙ элемент ссылается на элемент слева
            LeftElement = elem; //ДобавлЯЕМЫЙ элмент стал левым
            numOfElements++;
        }
    }

    //Добавление элемента справа
    public void addElementToRight(int num){
        Element elem = new Element(num);
        //Если список пуст - начальное состояние, просто добавляем элемент
        if(RightElement == null){
            LeftElement = elem;
            RightElement = elem;
            numOfElements++;
        }
        else {
            RightElement.next = elem; //ДобавлЯЕМЫЙ элемент ссылается на элемент справа
            RightElement = elem; //ДобавлЯЕМЫЙ элмент стал правым
            numOfElements++;
        }
    }


    //Удаление элемента из списка
    public void deleteElement(int num){
        //Пустой список - удалять нечего
        if (RightElement == null){
            return;
        }
        //Если в списке один элемент
        if (RightElement == LeftElement) {
            //и он тот, который надо удалить
            if (RightElement.data == num) {
                RightElement = null;
                LeftElement = null;
                return;
            }
            //Если не тот, который надо удалить
            else {
                return;
            }
        }
        //Если в списке много элементов, ищем те, которые надо удалить
        else {
            Element temp = LeftElement;
            while (temp != null) {
                if (temp.next.data == num) {
                    temp.next = temp.next.next; //перескакиваем удаляемый элемент
                }
                temp = temp.next;
            }
        }
    }

    //Возврат строки с элементами списка. Числа разделены запятыми.
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
    Сортировка пузырьком по возрастанию. 
    Bubble sort:
            for bypass in range (1,N)         -> for bypass in range (0,N-1)
        for k in range (0,N-bypass)   ->     for k in range (0,N-bypass-1)
    */
    public void sortIncrease() {
        Element temp;
        for (int i = 0; i < numOfElements-1; i++){
            temp = LeftElement;
            for(int k = 0; k < numOfElements - i - 1; k++){
                if (temp.data > temp.next.data){
                    int swapeddata = temp.data;
                    temp.data = temp.next.data;
                    temp.next.data = swapeddata;
                }
                temp = temp.next;
            }
        }
    }

    //Возврат строки с N максимальных элементов списка. Числа разделены запятыми.
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


