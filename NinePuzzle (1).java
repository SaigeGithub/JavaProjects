/*
Saige Liu   V00812068
*/
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.io.File;

 public class NinePuzzle{
    public static final int NUM_BOARDS = 362880;
    
	//sovle the puzzle.
	public static boolean SolveNinePuzzle(int[][] array){
        
        
        
        
        int[][] Map = new int [NUM_BOARDS][4]; 
        Map = adjencylist();
		int test = getIndexFromBoard(array); 
		return(sorting(Map,test,0)); 
        
	}
    
    public static int [] findEmpty(int[][]array){ 
        int []empty = new int [2]; 
        for(int i =0;i<3;i++){
            for(int k=0;k<3;k++){
                if(array[i][k]==0){
                    empty[0]=i; 
                    empty[1]=k; 
                }
            }
        }
        return empty;
    }
    //we build the ninepuzzle in this method
    public static int[][] adjencylist(){
        
        int [][] adlisit = new int[NUM_BOARDS][4]; 
        
        for(int x = 0;x<NUM_BOARDS;x++){ 
            for(int y = 0;y<4;y++){
                adlisit[x][y]=-1;
            }
        }
        
		for(int i = 0; i<NUM_BOARDS; i++){ 
			int[][] puzzle = getBoardFromIndex(i); 
            
            int [] empty = new int [2];
            empty = findEmpty(puzzle);
            
			int num1=empty[0];
			int num2=empty[1];
			int l=0;
            
            if(num2<2){
                int[][] puzzlee = getBoardFromIndex(i);     
                puzzlee[num1][num2] = puzzlee[num1][num2+1];
                puzzlee[num1][num2+1] = 0;
                int a = getIndexFromBoard(puzzlee);
                adlisit[i][l] = a;
                l++;
			}
            
			
            
            if(num1<2){
                int[][] puzzlee = getBoardFromIndex(i);   
                puzzlee[num1][num2] = puzzlee[num1+1][num2];
                puzzlee[num1+1][num2] = 0;
                int a = getIndexFromBoard(puzzlee);
                adlisit[i][l] = a;
                l++;
			}
            
			if(num2>0){
                int[][] puzzlee = getBoardFromIndex(i);     
                puzzlee[num1][num2] = puzzlee[num1][num2-1];
                puzzlee[num1][num2-1] = 0;
                int a = getIndexFromBoard(puzzlee);
                adlisit[i][l] = a;
                l++;
			}
			if(num1>0){
                int[][] puzzlee = getBoardFromIndex(i);  
                puzzlee[num1][num2] = puzzlee[num1-1][num2];
                puzzlee[num1-1][num2] = 0;
                int a = getIndexFromBoard(puzzlee);
                adlisit[i][l] = a;
                l++;
			}
            
        }
        return adlisit;
    }
    
    //the most important part is to sort the argorithm in BFS sorting
    public static boolean sorting(int[][] graph,int start, int goal){
		boolean[] covered = new boolean[NUM_BOARDS]; 
        
        ArrayDeque<Integer> et = new ArrayDeque<Integer>();       
		ArrayDeque<Integer[]> arrayet = new ArrayDeque<Integer[]>(); 
        
		for (int i = 0; i<covered.length;i++){ 
			covered[i] = false;
		}
        
		et.add(start); 
        
		Integer[] firstarrayet= new Integer[1];
        
		firstarrayet[0] = start; 
        
		arrayet.add(firstarrayet);
        
		covered[start] = true; 
        
		while(et.size()!=0){ 
			int b = et.remove(); 
            
			Integer[] dequeue = arrayet.remove(); 
            
			if(b==goal){ 
				for(int j=0;j<dequeue.length;j++){
					printBoard(getBoardFromIndex(dequeue[j]));
				}
				return true;
                
			}else{ 
                
                covered[b] = true;
                
				for(int x =0;x<4;x++){ 
                    int y = graph[b][x];
					if(y == -1){ 
						break; 
					}
                    
					if(covered[y] == false){ 
						et.add(y);
						Integer[] save = new Integer[dequeue.length+1]; 
						for(int j = 0;j<dequeue.length;j++){
							save[j] = dequeue[j];
						}
                        
						save[dequeue.length] = y;
						arrayet.add(save);
                        
					}
					
				}
			}
		}
		return false;
	}
    
	

	public static void printBoard(int[][] B){
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++)
				System.out.printf("%d ",B[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	
	
	public static int getIndexFromBoard(int[][] B){
		int i,j,tmp,s,n;
		int[] P = new int[9];
		int[] PI = new int[9];
		for (i = 0; i < 9; i++){
			P[i] = B[i/3][i%3];
			PI[P[i]] = i;
		}
		int id = 0;
		int multiplier = 1;
		for(n = 9; n > 1; n--){
			s = P[n-1];
			P[n-1] = P[PI[n-1]];
			P[PI[n-1]] = s;
			
			tmp = PI[s];
			PI[s] = PI[n-1];
			PI[n-1] = tmp;
			id += multiplier*s;
			multiplier *= n;
		}
		return id;
	}
    
	public static int[][] getBoardFromIndex(int id){
		int[] P = new int[9];
		int i,n,tmp;
		for (i = 0; i < 9; i++)
			P[i] = i;
		for (n = 9; n > 0; n--){
			tmp = P[n-1];
			P[n-1] = P[id%n];
			P[id%n] = tmp;
			id /= n;
		}
		int[][] B = new int[3][3];
		for(i = 0; i < 9; i++)
			B[i/3][i%3] = P[i];
		return B;
	}
	
    
    
	public static void main(String[] args){
	
        
		
		Scanner s;
        
		if (args.length > 0){
			
			try{
				s = new Scanner(new File(args[0]));
			} catch(java.io.FileNotFoundException e){
				System.out.printf("Unable to open %s\n",args[0]);
				return;
			}
			System.out.printf("Reading input values from %s.\n",args[0]);
		}else{
		
			s = new Scanner(System.in);
			System.out.printf("Reading input values from stdin.\n");
		}
		
		int graphNum = 0;
		double totalTimeSeconds = 0;
		
		
		while(true){
			graphNum++;
			if(graphNum != 1 && !s.hasNextInt())
				break;
			System.out.printf("Reading board %d\n",graphNum);
			int[][] B = new int[3][3];
			int valuesRead = 0;
			for (int i = 0; i < 3 && s.hasNextInt(); i++){
				for (int j = 0; j < 3 && s.hasNextInt(); j++){
					B[i][j] = s.nextInt();
					valuesRead++;
				}
			}
			if (valuesRead < 9){
				System.out.printf("Board %d contains too few values.\n",graphNum);
				break;
			}
			System.out.printf("Attempting to solve board %d...\n",graphNum);
			long startTime = System.currentTimeMillis();
			boolean isSolvable = SolveNinePuzzle(B);
			long endTime = System.currentTimeMillis();
			totalTimeSeconds += (endTime-startTime)/1000.0;
			
			if (isSolvable)
				System.out.printf("Board %d: Solvable.\n",graphNum);
			else
				System.out.printf("Board %d: Not solvable.\n",graphNum);
		}
		graphNum--;
		System.out.printf("Processed %d board%s.\n Average Time (seconds): %.2f\n",graphNum,(graphNum != 1)?"s":"",(graphNum>1)?totalTimeSeconds/graphNum:0);
	}

}
