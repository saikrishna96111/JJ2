package com.example.android.jj2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    int quantity=0,price;
    public void submitOrder(View view) {

        EditText txt = (EditText)findViewById(R.id.name_edit_text);
        String text_field = txt.getText().toString();

        CheckBox chk = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
        boolean hasWC = chk.isChecked();

        CheckBox chk1 = (CheckBox)findViewById(R.id.chocolate_checkbox);
        boolean hasC = chk1.isChecked();

        String priceMessage;

        price = calculatePrice(hasWC,hasC,quantity);

        priceMessage = createOrderSummary(text_field,hasWC,hasC,price);

        displayMessage(priceMessage);

    }

    public void increment(View view) {
        if(quantity>=0)
            quantity+=1;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if(quantity>0)
            quantity-=1;
        displayQuantity(quantity);
    }

    public void displayQuantity(int quantity) {
        TextView qnty = (TextView)findViewById(R.id.quantity_text_view);
        qnty.setText(" " +quantity);

    }

    public String createOrderSummary(String name,boolean hasWC,boolean hasC,int price) {
        String msg = "Name : " + name + "\n";
        msg = msg + "Has whipped cream?" + hasWC + "\n";
        msg = msg + "Has Chocolate?" + hasC + "\n";
        msg = msg + "Price : $" + price + "\n";
        msg = msg + "Thank you";

        return msg;
    }

    public void displayMessage(String priceMessage) {

        TextView message = (TextView)findViewById(R.id.order_summary_text_view);
        message.setText(priceMessage);
    }

    public int calculatePrice(boolean chk,boolean chk1,int quantity) {

        int pricet=0;
        if(chk == true)
            pricet += 1;
        if(chk1 == true)
            pricet += 2;
        pricet=pricet+5;
        pricet=pricet*quantity;
        return pricet;
    }
}
