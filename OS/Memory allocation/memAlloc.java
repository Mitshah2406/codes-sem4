import java.util.*;

class MemoryAllocationAlgorithm{
    void bestFit(int[] blocks, int[] processes, int nB, int nP){
        int allocation[] = new int[nP];
  System.out.println("Process No.\t\tProcess Size\t\tAllocated Block No\t\tRemaining Block Size");
        for(int i=0;i<nP;i++){
            int bestBlockIdx = -1;
            for(int j=0;j<nB;j++){
                if(blocks[j]>=processes[i]){
                    if(bestBlockIdx==-1){
                        bestBlockIdx = j;
                    }else if(blocks[bestBlockIdx] > blocks[j]){
                        bestBlockIdx = j;
                    }
                }
            }
            if(bestBlockIdx!=-1){
                allocation[i] = bestBlockIdx;
                blocks[bestBlockIdx] = blocks[bestBlockIdx] - processes[i];
            }else{
                allocation[i] = -1;
            }
             System.out.println((i+1)+"\t\t\t"+processes[i]+"\t\t\t"+(allocation[i]+1)+"\t\t\t"+blocks[allocation[i]]);
        }


    }
  
    void firstFit(int[] blocks, int[] processes, int nB, int nP){
            int allocation[] = new int[nP];
  System.out.println("Process No.\t\tProcess Size\t\tAllocated Block No\t\tRemaining Block Size");
  for(int i=0;i<nP;i++){
    int firstIndex = -1;
    for(int j=0;j<nB;j++){
        if(blocks[j]>=processes[i]){
            firstIndex = j;
            break;
        }
    }
    if(firstIndex!=-1){
        allocation[i]= firstIndex;
        blocks[firstIndex] =  blocks[firstIndex] - processes[i];
    }else{
        allocation[i]=-1;
    }
     System.out.println((i+1)+"\t\t\t"+processes[i]+"\t\t\t"+(allocation[i]+1)+"\t\t\t"+(allocation[i]==-1? "-1" : blocks[allocation[i]]));
  }
    }
    void nextFit(){}
    void worstFit(int[] blocks, int[] processes, int nB, int nP){
        int[] allocation = new int[nP];
  System.out.println("Process No.\t\tProcess Size\t\tAllocated Block No\t\tRemaining Block Size");
        

  for(int i=0;i<nP;i++){
    int worstIdx = -1;
    int maxBlock = -1;
    for(int j=0;j<nB;j++){
        if(maxBlock<blocks[j]){
            if(processes[i]<=blocks[j]){

                maxBlock = blocks[j];
                worstIdx = j;
            }
        }
    }
    if(worstIdx!=-1){
        allocation[i] = worstIdx;
        blocks[worstIdx] = blocks[worstIdx] - processes[i];
    }else{
        allocation[i]  =-1;
    }
     System.out.println((i+1)+"\t\t\t"+processes[i]+"\t\t\t"+(allocation[i]+1)+"\t\t\t"+(allocation[i]==-1? "-1" : blocks[allocation[i]]));

  }
    
    }
}

class memAlloc{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter No of processes: ");
        int nP = sc.nextInt();

        System.out.println("Enter No of blocks: ");
        int nB = sc.nextInt();
        int processes[] = new int[nP];
        int blocks[] = new int[nB];
        System.out.println("Enter Sizes of processes: ");
        for(int i=0;i<nP; i++){
            processes[i] = sc.nextInt();
        }
        System.out.println("Enter Sizes of blocks: ");
        for(int i=0;i<nB; i++){
            blocks[i] = sc.nextInt();
        }

        MemoryAllocationAlgorithm m = new MemoryAllocationAlgorithm();
        m.worstFit(blocks, processes, nB, nP);
    }
}