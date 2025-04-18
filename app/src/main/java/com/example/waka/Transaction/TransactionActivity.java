package com.example.waka.Transaction;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waka.Model.Transaction;
import com.example.waka.R;

import java.util.ArrayList;
import java.util.List;

public class TransactionActivity extends AppCompatActivity {
    private RecyclerView rcvTransactions;
    private TransactionAdapter transactionAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_transaction);
        rcvTransactions = findViewById(R.id.rcvTransactions);
        rcvTransactions.setLayoutManager(new LinearLayoutManager(this));

        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("3550609", "Mở khóa Chương 149: Luân hồi không ngừng (đại kết cục) (4)", "2025-03-18 01:31", -510));
        transactions.add(new Transaction("3550608", "Mở khóa Chương 148: Luân hồi không ngừng (3)", "2025-03-18 01:31", -510));
        transactions.add(new Transaction("3550607", "Mở khóa Chương 147: Luân hồi không ngừng (2)", "2025-03-18 01:31", -510));
        transactions.add(new Transaction("3550606", "Mở khóa Chương 146: Luân hồi không ngừng (1)", "2025-03-18 01:31", -510));
        transactions.add(new Transaction("3550604", "Quy đổi từ Kẹo", "2025-03-18 01:31", 10200));

        transactionAdapter = new TransactionAdapter(transactions);
        rcvTransactions.setAdapter(transactionAdapter);
    }
}