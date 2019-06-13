package examples.android.example.com.multiplerecyclerview;

import android.widget.Button;

public class My_items {



     int picURL;
             String picName, name,description, text;
    // Button btn;

   public  void setPicURL(int url){
       this.picURL=url;
   }

    public void setPicName(String picName1){
       this.picName=picName1;
    }

    public void setName(String name1){
       this.name=name1;
    }

    public void setDescription(String desc){
       this.description=desc;
    }

  public void setText(String txt){
       this.text=txt;

    }

    String getPicName(){
       return picName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // void setBtn(){}
}
