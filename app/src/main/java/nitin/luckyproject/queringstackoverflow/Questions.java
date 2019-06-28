package nitin.luckyproject.queringstackoverflow;

import com.google.gson.annotations.SerializedName;

public class Questions {
    public String title;
    public String body;

    @SerializedName("question_id")
    public String questionId;

    @Override
    public String toString(){
        return(title);
    }
}
