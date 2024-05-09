import java.util.*;

class MemoryAllocationAlgos{
    boolean doesPageExist(int page, int[] frames, int noOfFrames){
        boolean exist = false;
        for(int i=0;i<noOfFrames; i++){
            if(frames[i]==page){
                exist = true;
                break;
            }
        }
        return exist;
                       
    }
    public void performFCFS(int noOfPg,int[] pages, int noOfFrames){
        boolean isHit = false;
        int hitCount = 0;
        int faultCount = 0;
        int frames[] = new int[noOfFrames];
        int faultIndex = 0;

        for(int i=0;i<noOfFrames;i++){
            frames[i] = -1;
        }
 
        for(int i=0;i<noOfPg;i++){
            if(doesPageExist(pages[i], frames, noOfFrames)){
                isHit = true;
                hitCount++;
              System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => HIT");
            }else{
                frames[faultIndex] = pages[i];
                System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => FAULT");
                faultIndex = (faultIndex+1) % noOfFrames;
                faultCount++;
                
            }
        }

        System.out.println("Hit Ratio: "+ (float) hitCount/noOfPg * 100.0);
        System.out.println("Fault Ratio: "+ (float) faultCount/noOfPg * 100.0);
        System.out.println("Total Hits: "+ hitCount);
        System.out.println("Total Faults: "+ faultCount);
        
    }
}

class fcfsMemAlloc{
    public static void main(String args[]){
                Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number Of Pages: ");

        int noOfPg = sc.nextInt();
        System.out.println("Enter The Number Of Frames: ");

        int noOfFrames = sc.nextInt();
        
        
        int pages[] = new int[noOfPg];
                System.out.println("Enter The Pages: ");
        for(int i=0;i<noOfPg;i++){
            pages[i] = sc.nextInt();
        }
        
        MemoryAllocationAlgos m = new MemoryAllocationAlgos();
        
        m.performFCFS(noOfPg, pages, noOfFrames);
    }
}