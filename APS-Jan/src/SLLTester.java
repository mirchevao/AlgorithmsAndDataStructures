import java.util.Iterator;


public class SLLTester {

	public static void main(String[] args) {
		SLL<Integer> lista = new SLL<Integer>();
		lista.insertLast(5);
		System.out.print("Listata po vmetnuvanje na 5 kako posleden element: ");
		System.out.println(lista.toString());
		
		lista.insertFirst(3);
		System.out.print("Listata po vmetnuvanje na 3 kako prv element: ");
		System.out.println(lista.toString());
		
		lista.insertLast(1);
		System.out.print("Listata po vmetnuvanje na 1 kako posleden element: ");
		System.out.println(lista.toString());
		
		lista.deleteFirst();
		System.out.print("Listata po brishenje na prviot element: ");
		System.out.println(lista.toString());
		
		SLLNode<Integer> pom = lista.find(5);
		lista.insertBefore(2, pom);
		System.out.print("Listata po vmetnuvanje na elementot 2 pred elementot 5: ");
		System.out.println(lista.toString());
		
		pom = lista.find(1);
		lista.insertAfter(3, pom);
		System.out.print("Listata po vmetnuvanje na elementot 3 posle elementot 1: ");
		System.out.println(lista.toString());
		
		Iterator<Integer> i = lista.iterator();
		System.out.print("Izminuvanje so iterator: ");
		while(i.hasNext())
			System.out.print(i.next()+" ");
		System.out.println();
		System.out.println("Momentalna dolzina na listata: "+lista.length());
		
		System.out.print("Listata po prevrtuvanje: ");
		lista.mirror();
		System.out.println(lista.toString());
		
		pom = lista.find(2);
		lista.delete(pom);
		System.out.print("Listata po brishenje na elementot 2: ");
		System.out.println(lista.toString());
		
		System.out.println("Momentalna dolzina na listata: "+lista.length());
		
		lista.deleteList();
		System.out.print("Pecatenje na listata po nejzino brishenje: ");
		System.out.println(lista.toString());
		System.out.println("Momentalna dolzina na listata: "+lista.length());
		
	}

}
