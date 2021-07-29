package sg.edu.rp.webservices.taskmanager;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Tasks implements Serializable {

    private int id;
    private String desc;

    public Tasks(int id, String desc){
        this.id = id;
        this.desc = desc;
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


    @Override
    public String toString() {
        return id + "\n" + desc;
    }
}
