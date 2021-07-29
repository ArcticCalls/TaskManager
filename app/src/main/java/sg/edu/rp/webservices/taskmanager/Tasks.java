package sg.edu.rp.webservices.taskmanager;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Tasks implements Serializable {

    private int _id;
    private String desc;

    public Tasks(int id, String desc){
        this._id = id;
        this.desc = desc;
    }

    public int getId(){
        return _id;
    }

    public String getDesc(){
        return desc;
    }

    public  void setId(int id){
        this._id = id;
    }

    public void  setDesc(String desc){
        this.desc = desc;
    }


    @Override
    public String toString() {
        return _id + "\n" + desc;
    }
}
