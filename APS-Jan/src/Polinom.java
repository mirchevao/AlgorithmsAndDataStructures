
public class Polinom {

	Array<Integer> koeficienti;

	public Polinom(Array<Integer> koeficienti) {
		this.koeficienti = koeficienti;
	}
	
	public Array<Integer> getKoeficienti() {
		return koeficienti;
	}

	public void setKoeficienti(Array<Integer> koeficienti) {
		this.koeficienti = koeficienti;
	}

	public Polinom soberi(Polinom o){
		
		Polinom prezultat;
		
		Array<Integer> koeficineti2 = o.getKoeficienti();
		
		int n = koeficienti.get(0);  // n  broj na nenulti koef vo polinom 1
		int m = koeficineti2.get(0);  // m  broj na nenulti koef vo polinom 2
		Array<Integer> rezultat = new Array<Integer>(n*2+m*2+1);  //golemi spored najlosh slucaj
		
		int i=1,j=1;
		int k=1;
		
		while(i<=2*n && j<=2*m){
			if(koeficienti.get(i)==koeficineti2.get(j)){   // sporedba na eksponenti
				rezultat.set(k+1,koeficienti.get(i+1)+koeficineti2.get(j+1));    // sobiranje na    koeficientite
				if(rezultat.get(k+1)!=null){
					rezultat.set(k, koeficienti.get(i));
					k+=2;
				}
				i+=2; j+=2;
			}
			else{ //ako koeficientite ne se ednakvi
				if(koeficienti.get(i)<koeficineti2.get(j)){
					rezultat.set(k+1,koeficineti2.get(j+1));
					rezultat.set(k, koeficineti2.get(j));
					k+=2; j+=2;
				}
				else if(koeficienti.get(i)>koeficineti2.get(j)){
					rezultat.set(k+1,koeficienti.get(i+1));
					rezultat.set(k, koeficienti.get(i));
					k+=2; i+=2;
				}
			}	
		}
		
		while(i<=2*n){
			rezultat.set(k+1,koeficienti.get(i+1));
			rezultat.set(k, koeficienti.get(i));
			k+=2; i+=2;
		}
		while(j<=2*n){
			rezultat.set(k+1,koeficineti2.get(j+1));
			rezultat.set(k, koeficineti2.get(j));
			k+=2; j+=2;
		}
		
		rezultat.set(0,k/2);
		
		
		prezultat = new Polinom(rezultat);
		return prezultat;
	}

	@Override
	public String toString() {
		String ret = new String();
		for(int i=1;i<=koeficienti.get(0)*2;i+=2){
			ret+=koeficienti.get(i+1)+"*x^"+koeficienti.get(i)+" ";
		}
		return ret;
	}
	
	public static void main(String[] args){
		Array<Integer> n1 =new Array<Integer>(10);
		Array<Integer> n2 =new Array<Integer>(10);
		n1.set(0, 2); n1.set(1, 4); n1.set(2, 2); n1.set(3, 0); n1.set(4, 3); //2*x^4 + 3
		n2.set(0, 3); n2.set(1, 3); n2.set(2, 1); n2.set(3, 2); n2.set(4, 2); n2.set(5, 0); n2.set(6, 8); //x^3 + 2*x^2 + 8
		Polinom a= new Polinom(n1);
		Polinom b= new Polinom(n2);
		Polinom c = a.soberi(b);
		System.out.print(c.toString());		
	}
}
