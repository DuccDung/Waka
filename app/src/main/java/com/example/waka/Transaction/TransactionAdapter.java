package com.example.waka.Transaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Transaction;
import com.example.waka.R;

import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private List<Transaction> transactionList;

    public TransactionAdapter(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.tvTransactionId.setText(transaction.getId());
        holder.tvContent.setText(transaction.getContent());
        holder.tvDate.setText(transaction.getDate());

        int amount = transaction.getAmount();
        holder.tvAmount.setText(String.valueOf(amount));
        holder.tvAmount.setTextColor(amount < 0 ? 0xFFFF5555 : 0xFF00C853); // đỏ nếu âm, xanh nếu dương
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public static class TransactionViewHolder extends RecyclerView.ViewHolder {
        TextView tvTransactionId, tvContent, tvDate, tvAmount;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTransactionId = itemView.findViewById(R.id.tvTransactionIdInTransaction);
            tvContent = itemView.findViewById(R.id.tvContentInTransaction);
            tvDate = itemView.findViewById(R.id.tvDateInTransaction);
            tvAmount = itemView.findViewById(R.id.tvAmountInTransaction);
        }
    }
}

