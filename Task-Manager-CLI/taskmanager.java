import java.io.*;
import java.nio.channels.Pipe.SourceChannel;
import java.util.*;

/*
 * Tasks to do will be:
 * 
 * help:                display all commands
 * add <string>:        add task <string> to the list of tasks
 * edit <string>:       edits that task <string>
 * complete <string>:   marks the task<string> as done
 * disp:                displays all tasks
 * disp incmp:          displays all incomplete tasks
 * disp cmp:            displays all complete tasks
 * rm <string>:        deletes a task
*/

class help{
    public static void helplist(){
        System.out.println(" > Commands are : ------------------------------------------- < ");
        System.out.println(" > add <task>       ----- adds a task to the list             < ");
        System.out.println(" > edit <task>      ----- edits specified task in the list    < ");
        System.out.println(" > complete <task>  ----- completes the specified task        < ");
        System.out.println(" > rm <task>        ----- removes the specified task          < ");
        System.out.println(" > dis incmp        ----- displays only the incomplete tasks  < ");
        System.out.println(" > dis cmp          ----- displays only the complete tasks    < ");
        System.out.println(" > dis              ----- displays the task List full         < ");
    }
}

class task{
    String name;
    String desc;
    boolean done=false;

    task(String s){
        name=s;
    }

    void complete(){
        done=true;
    }
    void setCompletion(boolean b){
        done=b; 
    }
    void setName(String s){
        name=s;
    }

    void setDesc(String s){
        desc=s;
    }

    String getName(){
        return name;
    }

    boolean getCompletion(){
        return done;
    }
}

class TaskList{
    ArrayList<task> tl= new ArrayList<task>();

    void addTask(String name, String description){
        task temp=new task(name);
        temp.desc= description;
        temp.done=false;
        tl.add(temp);
    }

    void completeTask(String tname){
        for(int i=0;i<tl.size();i++){
            if(tname.equalsIgnoreCase(tl.get(i).getName())){
                tl.get(i).complete();
                System.out.println(" >>> Task marked as complete");
                return;
            }
        }
        System.out.println(" >> Invalid Task Name");
    }

    void removeTask(String tname){
        for(int i=0;i<tl.size();i++){
            if(tname.equalsIgnoreCase(tl.get(i).getName())){
                tl.remove(i);
                System.out.println(" >>> Task successfully removed ");
                return;
            }
        }
        System.out.println(" >> Invalid Task Name");
    }

    void editTask(String tname){
        task temp= new task("");
        boolean got=false;
        for(int i=0;i<tl.size();i++){
            if(tname.equalsIgnoreCase(tl.get(i).getName())){
                temp=tl.get(i);
                tl.remove(i);
                got=true;
            }
        }
        if(!got){
            System.out.println(" >> Invalid Task Name");
            return;
        }
        


        System.out.println(" > Enter 1 to edit name");
        System.out.println(" > Enter 2 to edit Description");
        System.out.println(" > Enter 3 to edit status");

        Scanner in=new Scanner(System.in);
        int ch= in.nextInt();
        switch(ch){
            case 1:
            System.out.println(" > Enter new Name ");
            String s= in.nextLine();
            temp.setName(s);
            break;

            case 2:
            System.out.println(" >  Enter new Description");
            String ss =in.nextLine();
            temp.setDesc(ss);
            break;

            case 3:
            System.out.println(" >  Enter new Status (true for done, false for not done) ");
            boolean st=in.nextBoolean();
            temp.setCompletion(st);
            break;

            default:
            System.out.println(" >> Invalid choice");
        }
        tl.add(temp);
    }

    void display(){
        for(int i=0;i<tl.size();i++){
            System.out.println(" > Task "+i+" : ");
            System.out.println("   Name = "+tl.get(i).getName());
            System.out.println("   Description = "+tl.get(i).desc);
            System.out.println("   Status = "+(tl.get(i).getCompletion())?"Done":"Not Done");
            System.out.println();
        }
    }

    void disp(String param){
        if(param.equalsIgnoreCase("cmp")){
            
            for(int i=0;i<tl.size();i++){
                if(tl.get(i).getCompletion()==true){
                    System.out.println(" > Task "+i+" : ");
                    System.out.println("   Name = "+tl.get(i).getName());
                    System.out.println("   Description = "+tl.get(i).desc);
                    System.out.println("   Status = "+(tl.get(i).getCompletion())?"Done":"Not Done");
                    System.out.println();
                }
            }
        }

        else if(param.equalsIgnoreCase("incmp")){
            for(int i=0;i<tl.size();i++){
                if(tl.get(i).getCompletion()==false){
                    System.out.println(" > Task "+i+" : ");
                    System.out.println("   Name = "+tl.get(i).getName());
                    System.out.println("   Description = "+tl.get(i).desc);
                    System.out.println("   Status = "+(tl.get(i).getCompletion())?"Done":"Not Done");
                    System.out.println();
                }
            }
        }

        else{
            System.out.println(" >> Invalid choice ");
        }
    }
}

public class taskmanager {
    
    void reader(String command){
        String[] terms = split(command, ' '); //split into 2 parts ---- command name + task name

        //last term is always null
        switch(terms[0]){

        }
    }

    public static void main(String[] args) {
        taskmanager tsm= new taskmanager();
        // String [] app= s.split("Hello My Name is vdknm vkl ", ' ');
        // for(int i=0;i<app.length;i++){
        //     System.out.println(app[i]);
        // }



    }
}
