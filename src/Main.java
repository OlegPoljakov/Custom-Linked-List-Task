public class Main {
    public static void main(String[] args) {

        CustomLinkedList list = new CustomLinkedList();

        list.addElementToRight(1000);
        list.addElementToRight(1567);
        list.addElementToRight(1345);
        list.addElementToRight(1);
        list.addElementToRight(10000);
        list.addElementToRight(10);
        list.addElementToRight(8);
        list.addElementToRight(6);
        list.addElementToRight(66);

        list.addElementToLeft(800);
        list.addElementToLeft(345);
        list.addElementToLeft(543);
        list.addElementToLeft(62);
        list.addElementToLeft(69);

        System.out.println("list is: " + list.printList());

        list.deleteElement(800);
        System.out.println("list is: " + list.printList());

        list.deleteElement(69);
        System.out.println("list is: " + list.printList());

        list.deleteElement(66);
        System.out.println("list is: " + list.printList());

        list.deleteElement(15);
        System.out.println("list is: " + list.printList());

        System.out.println(list.getNMaxElements(6));
    }
}
