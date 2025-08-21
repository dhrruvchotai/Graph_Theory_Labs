import java.util.ArrayList;
import java.util.List;

public class AssignTasksOnVirtualMachines {
    public static void main(String[] args) {
        int numberOfTasks = 3;
        int numberOfVirtualMachines = 3;
        Task[] tasks = {new Task(3,4), new Task(2,4), new Task(1,2)};
        VirtualMachine[] virtualMachines = {new VirtualMachine(4,10), new VirtualMachine(2,4), new VirtualMachine(8, 10)};
        int costs[][] = {{1,2,3},{3,1,5},{2,2,4}};
       
        for(int i = 0; i < tasks.length; i++){
            int minTime = Integer.MAX_VALUE;
            int minVmIndex = -1;
            for(int j = 0; j < virtualMachines.length; j++){
                if(virtualMachines[j].cpu >= tasks[i].cpu && virtualMachines[j].ram >= tasks[i].minRam){
                    if(costs[i][j] < minTime){
                        minVmIndex = j;
                        minTime = costs[i][j];
                    }
                }
            }
            virtualMachines[minVmIndex].cpu -= tasks[i].cpu;
            virtualMachines[minVmIndex].ram -= tasks[i].minRam; 
            virtualMachines[minVmIndex].assignedTasks.add(tasks[i]);
        }

        for(int i = 0; i < virtualMachines.length; i++){
            System.out.println("Number of tasks assigned to vm "+(i+1)+" : " + virtualMachines[i].assignedTasks.size());
        }
    }
}
class Task{
    int cpu;
    int minRam;

    Task(int cpu, int minRam){
        this.cpu = cpu;
        this.minRam = minRam;
    }
}

class VirtualMachine{
    int cpu;
    int ram;
    List<Task> assignedTasks = new ArrayList<>();

    VirtualMachine(int cpu, int ram){
        this.cpu = cpu;
        this.ram = ram;
    }
}
