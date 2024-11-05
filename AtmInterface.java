package com.atm.pragati;

import java.util.*;

class  BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=10000f;
	int transaction=0;
	String transactionhistory="";
	
	public void register() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your Name: ");
			this.name=sc.nextLine();
			System.out.println("\nEnter Your userName: ");
			this.userName=sc.nextLine();
			System.out.println("\nEnter Your Password: ");
			this.password=sc.nextLine();
			System.out.println("\nEnter Your AccountNo: ");
			this.accountNo=sc.nextLine();
			
			System.out.println("\nRegistration Successful. Please Log in Your Bank Account");
	}
	public boolean login() {
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin) {
			System.out.println("\nEnter Your User Name: ");
			String UserName=sc.nextLine();
			if(UserName.equals(userName)) {
				while(!isLogin) {
					System.out.println("\nEnter Your Password: ");
					String Password=sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("\nLogin Successfull: ");
						isLogin=true;
					}else {
						System.out.println("\nDoes not Match Password");
					}
				}
			}else {
				System.out.println("\nUsername Not Found");
			}
		}
		return isLogin;
	}
	public void withdraw() {
		System.out.println("\nEnter Amount to WithDraw");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(balance >=amount) {
				transaction++;
				balance =-amount;
				System.out.println("\nWithdraw is Successfull");
			  String str =amount +"Rs Withdraw\n";
			  transactionhistory=transactionhistory.concat(str);
			}else {
				System.out.println("\nInsufficiant Balance");
			}
		}catch(Exception e) {
			
		}
	}
	
	public  void deposit() {
		System.out.println("\nEnter Your Deposit Amount:");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(amount <=10000f) {
				transaction++;
				balance +=amount;
				System.out.println("\nDeposit Successful.");
				String str=amount +"Rs Deposited\n";
				transactionhistory =transactionhistory.concat(str);
			}else {
				System.out.println("\nLimit is 10000.");
			}
		}catch(Exception  e) {
			
		}
	}
	
	public  void transfer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter Your receipent Name's :");
		String receipent=sc.nextLine();
		System.out.println("\nEnter Amount to transfer");
		float amount=sc.nextFloat();
		try {
			
			if(balance>=amount) {
			if(amount <=50000f) {
				transaction++;
				balance -=amount;
				System.out.println("\n Successful Transferrd to."+receipent);
				String str=amount +"Rs transfer to"+receipent+"\n";
				transactionhistory =transactionhistory.concat(str);
			}else {
				System.out.println("\nLimit is 50000.");
			}
		}else{
		    System.out.println("Insufficient Balance");	
		}}catch(Exception  e) {
		}
			
		}
	
	public void  checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
	
	
	public void transectionHistory() {
		if(transaction == 0) {
			System.out.println("No Transection Happen");
		}else {
			System.out.println("\n"+ transactionhistory);
		}
	}
}

public class AtmInterface {

	public static int takenIntegerInput(int limit) {
		int  input=0;
		boolean flag=false;
		
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				if(flag && input>limit|| input<1) {
				System.out.println("Choose the number between 1 to  "+limit);
				flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only Number.");
				flag=false;
			}
			
		}
		return input;
	}
	public static void main(String[] args) {
	    System.out.println("\n***************WELCOME TO OUR ATM INTERFACE*********************");
	    System.out.println("\n1.Register \n2.Exit");
	    System.out.println("Choose one option");
	    int choose=takenIntegerInput(2);
	    if(choose==1) {
	    	BankAccount b=new BankAccount();
	    	b.register();
	    	while(true){
	    		System.out.println("\n1.Login \n2.Exit");
	    		System.out.println("Enter Your choice");
	    		int ch=takenIntegerInput(2);
	    		if(ch==1) {
	    			if(b.login()) {
	    				System.out.println("\n**********************WELCOME BACK TO OUR ATM INTERFACE"+b.name +"***************************");
	    				boolean isFinised=false;
	    				while(!isFinised) {
	    					System.out.println("\n1.withdraw \n2.Deposit \n3.trasfer \n4.checkbalance \n5.Transaction History \n6.Exit");
	    		    		System.out.println("Enter Your choice");
	    		    		int c=takenIntegerInput(2);
	    		    		switch(c) {
	    		    		case 1:
	    		    			b.withdraw();
	    		    		case 2:
	    		    			b.deposit();
	    		    		case 3:
	    		    			b.transfer();
	    		    		case 4:
	    		    			b.checkBalance();
	    		    		case 5:
	    		    			b.transectionHistory();
	    		    		case 6:
	    		    			isFinised=true;
	    		    			break;
	    		    		}
	    				}
	    			}	
	    		}else {
	    			System.exit(0);
	    		}
	    	}
	    }else {
	    	System.exit(0);
	    }
	}
}