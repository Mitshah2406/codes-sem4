import java.util.*;
class Process{
    int id, at, wt,bt,tat ,priority, remainingTime, completionTime;
    boolean ready;

    public Process(int id, int at, int wt, int bt, int tat, int priority, boolean ready, int completionTime){
        this.id = id;
        this.at = at;
        this.wt = wt;
        this.bt = bt;
        this.ready = ready;
        this.tat = tat;
        this.priority = priority;
        this.remainingTime = bt;
        this.completionTime = completionTime;
    }
}

class priority{
    public static void algo(ArrayList<Process> processes,int n){

        Collections.sort(processes, new Comparator<Process>(){
            public int compare(Process a, Process b ){
                return a.at-b.at;
            }
        });

        ArrayList<Process> readyQueue = new ArrayList();
        int currentTime = processes.get(0).at;

        for(Process p : processes){
            if(p.at<=currentTime){
                readyQueue.add(p);
                p.ready = true;
            }
        }
        System.out.print(currentTime);
        while(!readyQueue.isEmpty()){
            Collections.sort(readyQueue,  Comparator.comparingInt(p -> p.priority));

            Process currentProcess = readyQueue.get(0);

            currentTime++;
            currentProcess.remainingTime--;
            System.out.print(" -> P"+currentProcess.id+"-> "+currentTime);
            for(Process p : processes){
                if(!p.ready && p.at<= currentTime && p.id!=currentProcess.id){
                     readyQueue.add(p);
                p.ready = true;
                }
            }
            Collections.sort(readyQueue,  Comparator.comparingInt(p -> p.priority));
            if(!readyQueue.isEmpty() && currentProcess.id == readyQueue.get(0).id){
                if(currentProcess.remainingTime<=0){

                    readyQueue.remove(currentProcess);
                    currentProcess.completionTime = currentTime;
                }
            }
        }

        for(Process p : processes){
            p.tat = p.completionTime - p.at;
            p.wt = p.tat - p.bt;
        }

        System.out.println("\nId\t\t\tBT\t\t\tAT\t\t\tPriority\t\t\tWT\t\t\tTAT");
      for(Process p: processes){
          System.out.println(p.id+"\t\t\t"+p.bt+"\t\t\t"+p.at+"\t\t\t"+p.priority+"\t\t\t"+p.wt+"\t\t\t"+p.tat);
        }
        
        System.out.println();

        float avgWt = 0;
        float avgTat = 0;

        for(Process p: processes){
            avgWt+=p.wt;
            avgTat+=p.tat;
        }

        System.out.println("Average waiting time: "+avgWt/n);
        System.out.println("Average turnaround time: "+avgTat/n);


    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes: ");
        int n = sc.nextInt();

        ArrayList<Process> processes = new ArrayList();

        for(int i=0;i<n;i++){
            System.out.println("enter process 1's at, bt, priority: ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();
            int priority = sc.nextInt();
            processes.add(new Process(i+1, arrivalTime, 0, burstTime, 0,priority,false,0));
        }
        algo(processes, n);
    }


}
