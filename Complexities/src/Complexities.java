public class Complexities {

	private int N;
	private int opCount = 0;

	public Complexities(int N) {
		this.N = N;
	}

    public int getLastCount( )
    {
    	return opCount;
    }
	
	public void constantTime() {
		opCount = 0;  //reset the count
		
		//do something sequential, just junk for example
		int temp = 0;
		temp = temp * temp;
		opCount++;    //increment the count
	
	}

	public void logrithmicTime() {
		opCount = 0;  //reset the count		
		
		for (int i = N; i > 1; i = i / 2) {
			opCount++;			
		}
	}

	public void linearTime() {
		opCount = 0;  //reset the count
		
		for (int i = 0; i < N; i++) {
			opCount++;
		}
	}

	public void linearithmicTime() {
		opCount = 0;  //reset the count
		
		for (int i = 0; i < N; i++) { // N
			for (int j = N; j > 1; j = j / 2) { // log N
				opCount++;			
			}
		}
	}

	public void quadraticTime() {
		opCount = 0;  //reset the count		
	
		for (int i = N; i > 0; i--) {
			for (int j = N; j > 0; j--) {
				opCount++;				
			}
		}
	}
	
	public void exponentialTime( ) {
		opCount = 0;  //reset the count	
		
		expRecursive( N);
	}

	
	private void expRecursive( int N)
	{
		opCount++;
		
		if ( N > 1) {
			expRecursive( N - 1);
			expRecursive( N - 1);
		}
	}
	
	
	
	public static void main(String[] args) {
		Complexities ce = new Complexities(8);

		ce.constantTime();
		System.out.println("O(1), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );	
		
		ce.logrithmicTime();
		System.out.println("O(log N), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );
		
		ce.linearTime();
		System.out.println("O(N), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );
		
		ce.linearithmicTime();
		System.out.println("O(N log N), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );
		
		ce.quadraticTime();
		System.out.println("O(N^2), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );
		
		ce.exponentialTime();
		System.out.println("O(2^N), N: " + ce.N + " Operations count: " + ce.getLastCount( ) );
	}
}
