import java.util.*;
class Algo{
    int allocation[][]; 
    int maxNeed[][]; int available[][];
    int  remainingNeed[][];
    int  nR,  nP;
    void takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of res: ");
        nR = sc.nextInt();
        System.out.println("Enter no. of processes: ");
        nP = sc.nextInt();
        allocation = new int[nP][nR];
maxNeed = new int[nP][nR];
available = new int[1][nR]; // Assuming available resources matrix is of size 1xR
remainingNeed = new int[nP][nR];

        System.out.println("Enter allocation matrix: ");
        for(int i=0;i<nP;i++){
            for(int j =0;j<nR;j++){
                allocation[i][j] = sc.nextInt();
            }
        }
        
        System.out.println("Enter max need matrix: ");
        for(int i=0;i<nP;i++){
            for(int j =0;j<nR;j++){
                maxNeed[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter available resources matrix: ");

            for(int j =0;j<nR;j++){
                available[0][j] = sc.nextInt();
            }
        

    }
    int[][] generateRemainingNeed(){
            System.out.println("Remainign Need");
        
        for(int i=0;i<nP;i++){
            for(int j =0;j<nR;j++){
         

                remainingNeed[i][j] = maxNeed[i][j] - allocation[i][j];
                System.out.print(remainingNeed[i][j]+" ");
            }
            System.out.println();
        }

        return remainingNeed;

    }

    boolean check(int i, int currentAvailable[]){
        for(int j=0;j<nR;j++){
            if(remainingNeed[i][j] > currentAvailable[j]){
                 return false;
            }
        }
        return true;
    }
    void isSafe(){
        takeInput();
        int currentAvailable[] = new int[nR];
        boolean completed[] = new boolean[nP];
        for(int j=0;j<nR;j++){
            currentAvailable[j] = available[0][j];           
        }
        generateRemainingNeed();
        int j = 0;
        while(j<nP){
            boolean allocated = false;

            for(int i=0;i<nP;i++){
                if(!completed[i] && check(i,currentAvailable)){
                    System.out.println("In");
                    allocated = true;
                    for(int k=0;k<nR;k++){
                        currentAvailable[k] = currentAvailable[k]+ allocation[i][k];
                    }
                    completed[i] = true;
                    j++;
                    System.out.println("Completed Process: "+i);
                }
            }

            if(!allocated){
                break;
            }
        }
        if(j==nP){
            System.out.println("System is in Safe State");
        }else{
            System.out.println("System is in Unsafe State");
            
        }
    }
}
class banker{
    public static void main(String[] args){
        Algo a = new Algo();
        a.isSafe();
    }
}