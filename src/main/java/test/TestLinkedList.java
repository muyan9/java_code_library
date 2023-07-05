package test;

import java.util.LinkedList;

public class TestLinkedList {
    public static void main(String[] a){
        LinkedList<String> event = new LinkedList<String>();
        for(int i=0; i<10; i++){
            event.add("sss" + i);

        }
        System.out.println(event.size());
        while(event.size()+2>0) {
            System.out.println(event.poll());
            System.out.println(event.size());
        }

    }
}
