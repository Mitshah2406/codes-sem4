import java.util.*;

class Algo{
    int allocation[][], maxNeed[][], remainingNeed[][];
    int nR, nP;
    int available[];

    void takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of processes: ");
        nP = sc.nextInt();
        
        System.out.println("Enter no of resources: ");
        nR = sc.nextInt();

                allocation = new int[nP][nR];
maxNeed = new int[nP][nR];
available = new int[nR]; // Assuming available resources matrix is of size 1xR
remainingNeed = new int[nP][nR];
        System.out.println("Enter allocation matrix: ");
        for(int i=0;i<nP;i++){
            for(int j=0;j<nR;j++){
                allocation[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter maxneed matrix: ");
        for(int i=0;i<nP;i++){
            for(int j=0;j<nR;j++){
                maxNeed[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter available res: ");
        for(int i=0;i<nR;i++){
            available[i] = sc.nextInt();
        }
    }
        int[][] generateRemainingNeed(){
            System.out.println("Remaining Need: ");
for(int i=0;i<nP;i++){
            for(int j=0;j<nR;j++){
                remainingNeed[i][j] = maxNeed[i][j] - allocation[i][j];
                System.out.print(remainingNeed[i][j] +" ");
            }
            System.out.println();
        }
        return remainingNeed;
    
        }

        boolean check(int[] currentlyAvailable, int i){

            for(int j=0;j<nR;j++){
                if(remainingNeed[i][j] > currentlyAvailable[j]){
                    return false;
                }
            }
            return true;

        }
        void isSafe(){
            takeInput();
            int currentlyAvailable[] = new int[nR];
            boolean completed[] = new boolean[nP];
            for(int i=0;i<nR;i++){
                currentlyAvailable[i] = available[i];
            }
            generateRemainingNeed();
            int j=0;
            while(j<nP){
                boolean allocated = false;
                for(int i=0;i<nP;i++){
                    if(!completed[i] && check(currentlyAvailable, i))
                    {
                                  System.out.println("In");
                        allocated = true;
                        for(int k=0;k<nR;k++){
                            currentlyAvailable[k] = currentlyAvailable[k] + allocation[i][k];
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
                System.out.println("System is in safe");
            }else{
                System.out.println("System is in unsafe");

            }
        }
    
}
class banker{
    public static void main(String args[]){
        Algo a = new Algo();
        a.isSafe();
    }
}
