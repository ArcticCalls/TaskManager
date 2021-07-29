package sg.edu.rp.webservices.taskmanager;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Tasks implements Serializable {

    private int id;
    private String name;
    private String desc;
    private int seconds;

    public Tasks(int id, String desc, String name, int seconds){
        this.id = id;
        this.desc = desc;
        this.name = name;
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }

    public String getDesc(){
        return desc;
    }

    public  void setId(int id){
        this.id = id;
    }

    public void  setDesc(String desc){
        this.desc = desc;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return id + "\n" + desc + "\n" + name + "\n" + seconds;
    }
}
