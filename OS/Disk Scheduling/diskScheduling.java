import java.util.*;

class DiskAlgos{
    public void fcfs(int[] disks, int n, int currentHead){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;


        for(int i=0;i<n;i++){
            currentTrack =disks[i];
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }

        System.out.println("The total number of seek operations are "+ seek);
        for(int i: disks){
            System.out.print(i+" => ");
        }
    }
    public void sstf(int[] disks, int n, int currentHead){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;

        Arrays.sort(disks);

        for(int i=0;i<n;i++){
            currentTrack =disks[i];
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }

        System.out.println("The total number of seek operations are "+ seek);
        for(int i: disks){
            System.out.print(i+" => ");
        }
    }
    public void scan(int[] disks, int n, int currentHead, int direction, int start, int end){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;

        Arrays.sort(disks);
        int max= currentHead;
        int max_idx=-1;
        for(int i=0;i<n;i++){
            if(max<disks[i]){
                max = disks[i];
                max_idx = i;
            } if(max>currentHead){
                break;
            }
        }
        int min_idx = max_idx-1;
        if(direction==1){


        for(int i=max_idx;i<n;i++){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }}else{
  for(int i=min_idx;i>=0;i--){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }
        }
        currentHead = direction==1? end: start;
        singleTrackDistance = direction==1?  Math.abs(disks[1]-currentHead): Math.abs(disks[n-2]-currentHead);
       
        seek+=singleTrackDistance;


        System.out.println("The total number of seek operations are "+ seek);
        if(direction==1){

            for(int i=max_idx;i<n;i++){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx-1;i>=1;i--){
                System.out.print(disks[i]+" => ");
            }
        }else{

            
            for(int i=min_idx;i>=0;i--){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx;i<n-1;i++){
                System.out.print(disks[i]+" => ");
            }
        }
    }
    public void cscan(int[] disks, int n, int currentHead, int direction, int start, int end){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;

        Arrays.sort(disks);
        int max= currentHead;
        int max_idx=-1;
        for(int i=0;i<n;i++){
            if(max<disks[i]){
                max = disks[i];
                max_idx = i;
            } if(max>currentHead){
                break;
            }
        }
        int min_idx = max_idx-1;
        if(direction==1){


        for(int i=max_idx;i<n;i++){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }
    }else{
        
  for(int i=min_idx;i>=0;i--){

            currentTrack =disks[i];

                singleTrackDistance = Math.abs(currentTrack-currentHead);

            seek += singleTrackDistance;
            currentHead = currentTrack;
        }
        }
        currentHead = direction==1? end: start;
        singleTrackDistance = direction==1?  Math.abs(disks[0]-currentHead): Math.abs(disks[n-1]-currentHead);
        seek+=singleTrackDistance;
        singleTrackDistance = direction==1? Math.abs(disks[0]-disks[min_idx]): Math.abs(disks[n-1]-disks[max_idx]);
        seek+=singleTrackDistance;


        System.out.println("The total number of seek operations are "+ seek);
        if(direction==1){

            for(int i=max_idx;i<n;i++){
                System.out.print(disks[i]+" => ");
            }
    
            for(int i=0;i<=min_idx;i++){
                System.out.print(disks[i]+" => ");
            }
        }else{

            
            for(int i=min_idx;i>=0;i--){
                System.out.print(disks[i]+" => ");
            }
                 
            for(int i=n-1;i>=max_idx;i--){
                System.out.print(disks[i]+" => ");
            }
        }
    }
    public void look(int[] disks, int n, int currentHead, int direction, int start, int end){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;

        Arrays.sort(disks);
        int max= currentHead;
        int max_idx=-1;
        for(int i=0;i<n;i++){
            if(max<disks[i]){
                max = disks[i];
                max_idx = i;
            } if(max>currentHead){
                break;
            }
        }
        int min_idx = max_idx-1;
        if(direction==1){


        for(int i=max_idx;i<n-1;i++){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }}else{
  for(int i=min_idx;i>=1;i--){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }
        }
        currentHead = direction==1? disks[n-2]: disks[1];
        singleTrackDistance = direction==1?  Math.abs(disks[1]-currentHead): Math.abs(disks[n-2]-currentHead);
       
        seek+=singleTrackDistance;


        System.out.println("The total number of seek operations are "+ seek);
        if(direction==1){

            for(int i=max_idx;i<n-1;i++){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx-1;i>=1;i--){
                System.out.print(disks[i]+" => ");
            }
        }else{

            
            for(int i=min_idx;i>=1;i--){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx;i<n-1;i++){
                System.out.print(disks[i]+" => ");
            }
        }
    }
    public void clook(int[] disks, int n, int currentHead, int direction, int start, int end){
        int seek = 0;
        int currentTrack = 0;
        int singleTrackDistance = 0;

        Arrays.sort(disks);
        int max= currentHead;
        int max_idx=-1;
        for(int i=0;i<n;i++){
            if(max<disks[i]){
                max = disks[i];
                max_idx = i;
            } if(max>currentHead){
                break;
            }
        }
        int min_idx = max_idx-1;
        if(direction==1){


        for(int i=max_idx;i<n-1;i++){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }}else{
  for(int i=min_idx;i>=1;i--){

            currentTrack =disks[i];
                System.out.println("Current track: "+ currentTrack);
            singleTrackDistance = Math.abs(currentTrack-currentHead);
            seek += singleTrackDistance;
            currentHead = currentTrack;
        }
        }
        currentHead = direction==1? disks[n-2]: disks[1];
                singleTrackDistance = direction==1?  Math.abs(disks[1]-currentHead): Math.abs(disks[n-2]-currentHead);
        seek+=singleTrackDistance;
        singleTrackDistance = direction==1? Math.abs(disks[1]-disks[min_idx]): Math.abs(disks[n-2]-disks[max_idx]);

       
        seek+=singleTrackDistance;


        System.out.println("The total number of seek operations are "+ seek);
        if(direction==1){

            for(int i=max_idx;i<n-1;i++){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx-1;i>=1;i--){
                System.out.print(disks[i]+" => ");
            }
        }else{

            
            for(int i=min_idx;i>=1;i--){
                System.out.print(disks[i]+" => ");
            }
            for(int i=max_idx;i<n-1;i++){
                System.out.print(disks[i]+" => ");
            }
        }
    }

    
}
class diskScheduling {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The number of disks: ");
        int n = sc.nextInt();
        System.out.println("Enter The range of cylinders: ");
        int start = sc.nextInt();
        int end = sc.nextInt();
        n+=2;
        
        int disks[] = new int[n];
        disks[0] = start;

        disks[1] = end;

        for(int i=2;i<n;i++){
            disks[i] = sc.nextInt();
        }
        System.out.println("Enter the current head position: ");
        int cH = sc.nextInt();
        System.out.println("Enter the direction (RIGHT-1, LEFT-0): ");
        int direction = sc.nextInt();

      DiskAlgos da = new DiskAlgos();
      da.clook(disks, n, cH, direction, start,end);  




    } 
}