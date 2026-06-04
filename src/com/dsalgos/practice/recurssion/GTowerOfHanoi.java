package com.dsalgos.practice.recurssion;

public class GTowerOfHanoi {


	public static void main(String[] args) {
		
		int n = 3;
		char t1;
		char sourceTower = t1 ='A';
		char t2;
		char destinationTower = t2 = 'B';
		char t3;
		char helperTower = t3 = 'C';
			
		towerOfHanoi(n, sourceTower, destinationTower, helperTower);
	}

	private static void towerOfHanoi(int n, char t1, char t2, char t3) {
		if(n==0) {
			return;
		}
		
		towerOfHanoi(n-1, t1, t3, t2); // will print instructions to move n-1 disks from t1 to t3 using t2 (*)
		System.out.println(n + " [ " + t1 + " -> " + t2 + " ]");
		towerOfHanoi(n-1, t3, t2, t1); // will print instructions to move n-1 disks from t3 to t2 using t1 (*)
		
	}
}
