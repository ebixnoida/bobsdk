package com.bob.bobapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bob.bobapp.R;
import com.bob.bobapp.api.response_object.AnswerCollection;
import com.bob.bobapp.api.response_object.RiskProfileQuestionCollection;
import com.bob.bobapp.listener.onAnswerItemListener;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private Context context;
    private AnswerAdapter answerAdapter;
    private ArrayList<RiskProfileQuestionCollection> riskProfileQuestionCollectionArrayList;
    private int count;
    private ArrayList<AnswerCollection> answerCollectionArrayList = new ArrayList<>();
    private onAnswerItemListener onAnswerItemListener;


    public QuestionAdapter(Context context, ArrayList<RiskProfileQuestionCollection> riskProfileQuestionCollectionArrayList,
                           int count,onAnswerItemListener onAnswerItemListener) {
        this.context = context;
        this.riskProfileQuestionCollectionArrayList = riskProfileQuestionCollectionArrayList;
        this.count = count;
        this.onAnswerItemListener = onAnswerItemListener;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new QuestionAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtQuestion.setText(riskProfileQuestionCollectionArrayList.get(count).getQuestionDescription());

        answerCollectionArrayList = riskProfileQuestionCollectionArrayList.get(count).getAnswerCollection();
        answerAdapter = new AnswerAdapter(context, answerCollectionArrayList,onAnswerItemListener);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recyclerAnswer.setLayoutManager(linearLayoutManager);
        holder.recyclerAnswer.setAdapter(answerAdapter);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView txtQuestion;
        private RecyclerView recyclerAnswer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerAnswer = itemView.findViewById(R.id.recyclerAnswer);
            txtQuestion = itemView.findViewById(R.id.txtQuestion);

        }
    }
}
