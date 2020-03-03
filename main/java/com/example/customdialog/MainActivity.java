package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_open_modal = findViewById(R.id.btn_open_modal);
        btn_open_modal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        showModal();
    }

    private void showModal() {

        final MyCustomDialog dialog = new MyCustomDialog();

        dialog.setTitle("What is Lorem Ipsum?");
        dialog.setMessage("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        dialog.setInfo("Administrator 03/03/2020 15:00");
        dialog.setTitleBtnNo("CANCEL");
        dialog.setTitleBtnYes("CONFIRM");
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        dialog.setYesListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.setNoListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show(transaction, "modal_info");
    }
}
