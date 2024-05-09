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
     int findLastOccurrenceInRange(int[] pages, int st, int end, int target){

        for(int i=end; i>=st;i--){
            if(target==pages[i]){
                return i;
            }
        }
        return -1;
    }

    public void performLRU(int noOfPg,int[] pages, int noOfFrames){

        int hitCount = 0;
        int frames[] = new int[noOfFrames];
        
        

        for(int i=0;i<noOfFrames;i++){
            frames[i] = pages[i];
                        System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => FAULT");
                      

        }
        for(int i=noOfFrames;i<noOfPg;i++){
            if(doesPageExist(pages[i], frames, noOfFrames)){
    
            
                hitCount++;

              System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => HIT");
            }else{
                int leastRecently = findLastOccurrenceInRange(pages, 0, i-1,frames[0]);
                int frameIdxToBeRemoved = 0;
                for(int k=1;k<noOfFrames;k++){
                    int currentLRU = findLastOccurrenceInRange(pages, 0, i-1, frames[k]);

                    if(currentLRU< leastRecently){
                        frameIdxToBeRemoved = k;
                        leastRecently= currentLRU;
                    }
                }
                frames[frameIdxToBeRemoved] = pages[i];
                 System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => FAULT");
         
                
            }
        }

        System.out.println("Hit Ratio: "+ (float) hitCount/noOfPg * 100.0);
        System.out.println("Fault Ratio: "+ (float) (pages.length-hitCount)/noOfPg * 100.0);
        System.out.println("Total Hits: "+ hitCount);
        System.out.println("Total Faults: "+ (noOfPg-hitCount));
        
    }
  
}

class lruMemAlloc{
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
        
        m.performLRU(noOfPg, pages, noOfFrames);
    }
}