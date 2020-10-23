package com.ualr.layoutassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    // TODO 02. Create a new method called "calculateTotal" for calculating the invoice's total amount of money

    // TODO 03. Bind the "calculateTotal" method to the button with the "CALCULATE TOTAL" label

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton btn = findViewById(R.id.btn_calc);
    }

    public void calculateTotal(View view) {
        MaterialCheckBox cb_1 = findViewById(R.id.materialCheckBox1);
        MaterialCheckBox cb_2 = findViewById(R.id.materialCheckBox3);
        MaterialCheckBox cb_3 = findViewById(R.id.materialCheckBox4);
        MaterialCheckBox cb_4 = findViewById(R.id.materialCheckBox6);

        TextInputLayout textInputLayout0 = findViewById(R.id.textInputLayout);
        TextInputLayout textInputLayout1 = findViewById(R.id.textInputLayout3);
        TextInputLayout textInputLayout2 = findViewById(R.id.textInputLayout4);
        TextInputLayout textInputLayout3 = findViewById(R.id.textInputLayout6);

        MaterialButton discount = findViewById(R.id.btn_noDiscount);

        TextView totalTV = findViewById(R.id.total_TV);

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        MaterialCheckBox[] checkBoxes = new MaterialCheckBox[]{cb_1,cb_2,cb_3,cb_4};
        TextInputLayout[] textInputLayouts = new TextInputLayout[]{textInputLayout0,textInputLayout1,textInputLayout2,textInputLayout3};

        double total = 0;
        for(int i = 0; i < checkBoxes.length; i++) {
            if(checkBoxes[i].isChecked()) {
                try {
                    total += Integer.parseInt(String.valueOf(textInputLayouts[i].getEditText().getText()));
                } catch (Exception e) {
                    total+=0;
                }
            }
        }

        if(!discount.isChecked()) total*=0.8;

        totalTV.setText("$ " + df.format(total));
    }
}