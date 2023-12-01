package com.yuyakaido.android.cardstackview.sample;


import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.auth.FirebaseAuth;
import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MyViewHolder> {
    private Context context;
    private List<MessageModel> messageModelList;

    public MessageAdapter(Context context){
        this.context=context;
        messageModelList=new ArrayList<>();
    }

    public void add(MessageModel messageModel){
        messageModelList.add(messageModel);
        notifyDataSetChanged();
    }

    public void clear(){
        messageModelList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.message_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MessageModel messageModel=messageModelList.get(position);
        holder.msg.setText(messageModel.getMessage());
        if(messageModel.getSenderId().equals(FirebaseAuth.getInstance().getUid())){
            holder.main.setGravity(Gravity.END);
            holder.msg.setBackgroundColor(context.getResources().getColor(R.color.green));
            holder.msg.setTextColor(context.getResources().getColor(R.color.black));
        }else{
            holder.main.setGravity(Gravity.START);
            holder.msg.setBackgroundColor(context.getResources().getColor(R.color.gray));
            holder.msg.setTextColor(context.getResources().getColor(R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView msg;
        private LinearLayout main;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            msg=itemView.findViewById(R.id.message);
            main=itemView.findViewById(R.id.mainMessageLayout);
        }
    }
}
