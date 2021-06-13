package com.bob.bobapp.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AnswerCollection;
import com.bob.bobapp.listener.onAnswerItemListener;

import java.util.ArrayList;

public class AnswerAdapter extends RecyclerView.Adapter<AnswerAdapter.ViewHolder> {

    private Context context;

    private ArrayList<AnswerCollection> answerCollectionArrayList;

    private onAnswerItemListener onAnswerItemListener;

    public AnswerAdapter(Context context, ArrayList<AnswerCollection> answerCollectionArrayList, onAnswerItemListener onAnswerItemListener) {

        this.context = context;

        this.answerCollectionArrayList = answerCollectionArrayList;

        this.onAnswerItemListener = onAnswerItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.answer_item, parent, false);

        return new AnswerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.radioAnswer.setText(answerCollectionArrayList.get(position).getAnswerDescription());

        if(answerCollectionArrayList.get(position).getSelected().equalsIgnoreCase("true")){

            holder.radioAnswer.setChecked(true);

        }else{

            holder.radioAnswer.setChecked(false);
        }

        holder.radioAnswer.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                for(int i = 0; i < answerCollectionArrayList.size(); i++){

                    if(i == position){

                        answerCollectionArrayList.get(i).setSelected("true");

                    }else{

                        answerCollectionArrayList.get(i).setSelected("false");
                    }
                }

                onAnswerItemListener.onItemListener(answerCollectionArrayList.get(position).getSelected(), answerCollectionArrayList.get(position).getAnswerDescription(), position);

                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return answerCollectionArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RadioButton radioAnswer;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            radioAnswer = itemView.findViewById(R.id.radioAnswer);
        }
    }
}
