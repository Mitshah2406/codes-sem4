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
     int findFirstOccurrence(int[] pages, int st, int end, int target){

        for(int i=st; i<=end;i++){
            if(target==pages[i]){
                return i;
            }
        }
        return Integer.MAX_VALUE;
    }

    public void performOptimal(int noOfPg,int[] pages, int noOfFrames){

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
                int frameIdxToBeRemoved = 0;
                int optimal = findFirstOccurrence(pages, i+1, noOfPg-1, frames[0]);
                for(int j=1;j<noOfFrames;j++){
                    int optimalPg = findFirstOccurrence(pages, i+1,noOfPg-1,frames[j]);
                    if(optimalPg>optimal){
                        optimal = optimalPg;
                        frameIdxToBeRemoved=j;
                    }
                }
                frames[frameIdxToBeRemoved] = pages[i];
                 System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => FAULT");
                      
            }











        }
        // for(int i=noOfFrames;i<noOfPg;i++){
        //     if(doesPageExist(pages[i], frames, noOfFrames)){
    
            
        //         hitCount++;

        //       System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => HIT");
        //     }else{
        //         int optimal = findFirstOccurrence(pages, i, pages.length-1,frames[0]);
        //         System.out.println(optimal);
        //         int frameIdxToBeRemoved = 0;
        //         for(int k=1;k<noOfFrames;k++){
        //             int currentOptimal = findFirstOccurrence(pages, i, pages.length-1, frames[k]);
        //             System.out.println(currentOptimal);

        //             if(currentOptimal> optimal){
        //                 frameIdxToBeRemoved = k;
        //                 optimal= currentOptimal;
        //             }
        //         }
        //         frames[frameIdxToBeRemoved] = pages[i];
        //          System.out.println("Page No "+ pages[i]+ " --> Frame ["+ Arrays.toString(frames) +" ] => FAULT");
         
                
        //     }
        // }

        System.out.println("Hit Ratio: "+ (float) hitCount/noOfPg * 100.0);
        System.out.println("Fault Ratio: "+ (float) (pages.length-hitCount)/noOfPg * 100.0);
        System.out.println("Total Hits: "+ hitCount);
        System.out.println("Total Faults: "+ (noOfPg-hitCount));
        
    }
  
}

class optimal{
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
        
        m.performOptimal(noOfPg, pages, noOfFrames);
    }
}