package com.example.waka.Payment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.example.waka.R;
import com.vnpay.authentication.VNP_AuthenticationActivity;

public class PaymentChooseActivity extends AppCompatActivity {

    private static final int VNPAY_PAYMENT_REQUEST = 1001;
    private Button btn50k;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_choose);

        makeStatusBarTransparent();
        applyTopPadding();

        btn50k = findViewById(R.id.btn50k);
        btn50k.setOnClickListener(v -> openSdk());
    }

    private void openSdk() {
        Intent intent = new Intent(this, VNP_AuthenticationActivity.class);
        intent.putExtra("url", "https://sandbox.vnpayment.vn/paymentv2/vpcpay.html?..."); // URL từ backend
        intent.putExtra("tmn_code", "2YH1X4JB"); // Mã TMNCode
        intent.putExtra("scheme", "waka"); // scheme trùng AndroidManifest.xml
        intent.putExtra("is_sandbox", true); // true nếu là môi trường test

        startActivityForResult(intent, VNPAY_PAYMENT_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VNPAY_PAYMENT_REQUEST && data != null) {
            String resultCodeVnp = data.getStringExtra("vnp_ResponseCode");
            Log.d("VNPAY_RESULT", "vnp_ResponseCode: " + resultCodeVnp);

            if ("00".equals(resultCodeVnp)) {
                // Thành công
                Intent successIntent = new Intent(PaymentChooseActivity.this, ResultPayment.class);
                successIntent.putExtra("payment_result", "success");
                startActivity(successIntent);
            } else {
                // Thất bại, bị huỷ hoặc lỗi
                Toast.makeText(this, "Thanh toán thất bại hoặc bị hủy", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void makeStatusBarTransparent() {
        Window window = getWindow();
        window.getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        );
        window.setStatusBarColor(Color.TRANSPARENT);
    }

    private void applyTopPadding() {
        View contentContainer = findViewById(R.id.choose_pay);
        if (contentContainer != null) {
            int statusBarHeight = getStatusBarHeight();
            contentContainer.setPadding(0, statusBarHeight, 0, 0);
        }
    }

    private int getStatusBarHeight() {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
