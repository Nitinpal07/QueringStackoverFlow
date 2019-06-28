package nitin.luckyproject.queringstackoverflow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private List<Answer> data;

    public RecyclerViewAdapter(List<Answer> data) {
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView text;

        public ViewHolder(View v) {
            super(v);
            text = v.findViewById(android.R.id.text1);
        }
    }



    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_selectable_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Answer answer = data.get(position);
        holder.text.setText(answer.toString());
        holder.itemView.setTag(answer.answerId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
