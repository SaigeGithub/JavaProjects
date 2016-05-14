// NAME: Calc.java
// PURPOSE:  evaluates expressions written using postfix
// AUTHOR:  Saige Liu V00812068
// DATE:  2014/3/14
// CREDITS: none 
public class Calc{
	public static void main(String[] args){
		
		Stack<Integer> one = new LLStack<Integer>();
		
		int num=0;
		
		for(int i=0;i<args.length;i++){
			num++;
		}
		input(num,one,args);
	}
	public static void input(int num,Stack<Integer> one,String[] args){
		try{
			int k=0;
			while(num>0){
				if(!args[k].equals("+")&&!args[k].equals("-")&&!args[k].equals("x")&&!args[k].equals("/")){
					//change string to integer
					int val=Integer.parseInt(args[k]);
					one.push(val);
				}
				if(args[k].equals("+")){
					int a =one.pop();
					int b =one.pop();
					int c = a+b;
					one.push(c);
				}
				if(args[k].equals("-")){
					int a =one.pop();
					int b =one.pop();
					int c = b-a;
					one.push(c);
				}
				if(args[k].equals("x")){
					int a =one.pop();
					int b =one.pop();
					int c = a*b;
					one.push(c);
				}
				if(args[k].equals("/")){
					int a =one.pop();
					int b =one.pop();
					int c = b/a;
					one.push(c);
				}
				k++;
				num--;
			}
			if(one.size()==1){
				int fal= one.pop();
				System.out.println(fal);
			}else{
				System.out.println("invalid expression");
			}
		//catch stackempty or numberformatexception 
		}catch(StackEmptyException e){
			System.out.println("invalid expression");	}
		
		catch(NumberFormatException ef){
			System.out.println("invalid expression");	
		}
	}

}