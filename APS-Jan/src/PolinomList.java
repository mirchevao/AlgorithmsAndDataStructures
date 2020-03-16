class Koeficient implements Comparable<Koeficient> {
	int koefecient;
	int exponent;

	public Koeficient(int koefecient, int exponent) {
		this.koefecient = koefecient;
		this.exponent = exponent;
	}

	@Override
	public String toString() {
		String ret = koefecient+"*x^"+exponent+" ";
		return ret;
	}

	public int getKoefecient() {
		return koefecient;
	}

	public void setKoefecient(int koefecient) {
		this.koefecient = koefecient;
	}

	public int getExponent() {
		return exponent;
	}

	public void setExponent(int exponent) {
		this.exponent = exponent;
	}

	public Koeficient soberi(Koeficient in){
		if(this.exponent!=in.exponent){
			System.out.println("Koeficientite ne moze da se soberat bidejki imaat razlicni eksponenti");
			return null;
		}
		Koeficient ret = new Koeficient(exponent, this.koefecient+in.koefecient);
		return ret;
	}
	@Override
	public int compareTo(Koeficient arg0) {
		if (this.exponent>arg0.exponent) return 1;
		if (this.exponent<arg0.exponent) return -1;
		return 0;
	}

}

public class PolinomList {

	@Override
	public String toString() {
		return listaKoeficienti.toString();
	}

	SLL<Koeficient> listaKoeficienti = new SLL<Koeficient>();
	
	public PolinomList(SLL<Koeficient> listaKoeficienti) {
		this.listaKoeficienti = listaKoeficienti;
	}

	public SLL<Koeficient> getListaKoeficienti() {
		return listaKoeficienti;
	}

	public void setListaKoeficienti(SLL<Koeficient> listaKoeficienti) {
		this.listaKoeficienti = listaKoeficienti;
	}

	public PolinomList soberi(PolinomList in){
		SLL<Koeficient> listaKoeficienti2 = in.getListaKoeficienti();
		
		SLLNode<Koeficient> jazol1 = listaKoeficienti.getFirst();
		SLLNode<Koeficient> jazol2 = listaKoeficienti2.getFirst();
		
		SLL<Koeficient> rezultat = new SLL<Koeficient>(); 
		
		while(jazol1 != null && jazol2 != null){
			if(jazol1.element.compareTo(jazol2.element)<0){ //exponent1<exponent2
				rezultat.insertLast(jazol2.element);
				jazol2 = jazol2.succ;
			}
			else if(jazol1.element.compareTo(jazol2.element)>0){ //exponent1>exponent2
				rezultat.insertLast(jazol1.element);
				jazol1 = jazol1.succ;
			}
			else{ //(jazol1.element.compareTo(jazol2.element)==0){ //exponent1=exponent2
				Koeficient zbir = jazol1.element.soberi(jazol2.element);
				rezultat.insertLast(zbir);
				jazol1 = jazol1.succ; jazol2 = jazol2.succ;
			}
		}
		
		while(jazol1 != null){
			rezultat.insertLast(jazol1.element);
			jazol1 = jazol1.succ;
		}
		while(jazol2 != null){
			rezultat.insertLast(jazol2.element);
			jazol2 = jazol2.succ;
		}
		
		PolinomList ret = new PolinomList(rezultat);
		
		return ret;
	}

	public static void main(String[] args) {
		SLL<Koeficient> k1 = new SLL<Koeficient>();
		k1.insertLast(new Koeficient(2,4));
		k1.insertLast(new Koeficient(3,0));
		System.out.println("Polinom1: "+k1.toString());
		PolinomList p1 = new PolinomList(k1);

		SLL<Koeficient> k2 = new SLL<Koeficient>();
		k2.insertLast(new Koeficient(1,3));
		k2.insertLast(new Koeficient(2,2));
		k2.insertLast(new Koeficient(8,0));
		System.out.println("Polinom2: "+k2.toString());
		PolinomList p2 = new PolinomList(k2);
		
		System.out.println("Rezultat od zbir: "+p1.soberi(p2));
	}

}
