public class DoublyHashedOBHTTest {
    
    public static void main (String[] args) {
        DoublyHashedOBHT<ChemicalElementDH,Integer> table1 = new DoublyHashedOBHT<ChemicalElementDH,Integer>(23);
        table1.insert(new ChemicalElementDH("H"),  new Integer(1));
        table1.insert(new ChemicalElementDH("He"), new Integer(2));
        table1.insert(new ChemicalElementDH("Li"), new Integer(3));
        table1.insert(new ChemicalElementDH("Be"), new Integer(4));
        table1.insert(new ChemicalElementDH("Na"), new Integer(11));
        table1.insert(new ChemicalElementDH("Mg"), new Integer(12));
        table1.insert(new ChemicalElementDH("K"),  new Integer(19));
        table1.insert(new ChemicalElementDH("Ca"), new Integer(20));
        table1.insert(new ChemicalElementDH("Rb"), new Integer(37));
        table1.insert(new ChemicalElementDH("Sr"), new Integer(38));
        table1.insert(new ChemicalElementDH("Cs"), new Integer(55));
        table1.insert(new ChemicalElementDH("Ba"), new Integer(56));

        System.out.println ("Initial table.");
        System.out.println(table1);
        
        table1.insert(new ChemicalElementDH("Fr"), new Integer(87));
        table1.insert(new ChemicalElementDH("Ra"), new Integer(88));
        table1.insert(new ChemicalElementDH("B"),  new Integer(5));

        System.out.println ("Table after inserting Fr, Ra and B.");
        System.out.println(table1);

    }
}        