import java.util.*;

public class bestFit {
    static void bestFit(int blockSize[], int m, int processSize[], int n) {
        int copyBlockSize[] = blockSize.clone();
        int allocation[] = new int[n];
        for (int i = 0; i < n; i++) {
            int bestIdx = -1;
            for (int j = 0; j < m; j++) {
                if (blockSize[j] >= processSize[i]) {
                    if (bestIdx == -1)
                        bestIdx = j;
                    else if (blockSize[bestIdx] > blockSize[j])
                        bestIdx = j;
                }
            }
            if (bestIdx != -1) {
                allocation[i] = bestIdx;
                blockSize[bestIdx] -= processSize[i];
            }else{
                allocation[i] = -1;
            
            }
        }
        System.out.println("\nProcess No.\tProcess Size\tBlock Size\tBlock Size Left\tAllocated Block no.");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + (i + 1) + "\t\t"  + processSize[i] +"\t\t"+(allocation[i]==-1?"-1":copyBlockSize[allocation[i]])+ "\t\t"+(allocation[i]==-1? "-1":blockSize[allocation[i]])+"\t\t");
            if (allocation[i] != -1)
                System.out.print(allocation[i] + 1);
            else
                System.out.print("Not Allocated");
            // System.out.print("\t\t"+ blockSize[allocation[i]]);    
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of blocks: ");
        int m  = sc.nextInt();
        System.out.println("Enter the number of processes: ");
        int n  = sc.nextInt();
        int blockSize[] = new int[m];
        int processSize[] = new int[n];
        System.out.println("Enter the sizes of blocks:");
        for(int i = 0; i < m; i++) {
            blockSize[i] = sc.nextInt();
        }
        System.out.println("\nEnter the sizes of processes:");
        for(int i = 0; i < n; i++) {
            processSize[i] = sc.nextInt();
        }
        // int blockSize[] = {100, 500, 200, 300, 600};
        // int processSize[] = {212, 417, 112, 426};
        // int m = blockSize.length;
        // int n = processSize.length;
        bestFit(blockSize, m, processSize, n);
    }
}