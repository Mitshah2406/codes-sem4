import java.util.*;
class Process{
    int id, at, wt,bt,tat;

    public Process(int id, int at, int wt, int bt, int tat){
        this.id = id;
        this.at = at;
        this.wt = wt;
        this.bt = bt;
        this.tat = tat;
    }
}

class fcfs{
    public static void algo(ArrayList<Process> processes,int n){

  Collections.sort(processes, new Comparator<Process>(){
            public int compare(Process a, Process b){
                    return Integer.compare(a.at, b.at);
            }
        });
      int currentTime = 0;
      System.out.print(currentTime);
      for(Process p : processes){
          if(currentTime<p.at){
              currentTime = p.at;
            }
            
            p.wt = currentTime - p.at;
            p.tat = p.wt+ p.bt;
            currentTime+=p.bt;
            System.out.print("-> P"+p.id + "->"+currentTime);
      }

      System.out.println("\nId\t\t\tBT\t\t\tAT\t\t\tWT\t\t\tTAT");
      for(Process p: processes){
          System.out.println(p.id+"\t\t\t"+p.bt+"\t\t\t"+p.at+"\t\t\t"+p.wt+"\t\t\t"+p.tat);
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
            System.out.println("enter process 1's at, bt: ");
            int arrivalTime = sc.nextInt();
            int burstTime = sc.nextInt();

            processes.add(new Process(i+1, arrivalTime, 0, burstTime, 0));
        }
        algo(processes, n);
    }


}
