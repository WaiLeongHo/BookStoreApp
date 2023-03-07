package com.example.bookstoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button clearButton = findViewById(R.id.button2);
        EditText editText_BookID = findViewById(R.id.editTextBookID);
        EditText editText_Title = findViewById(R.id.editTextTitle);
        EditText editText_ISBN = findViewById(R.id.editTextISBN);
        EditText editText_Author = findViewById(R.id.editTextAuthor);
        EditText editText_Description = findViewById(R.id.editTextDescription);
        EditText editText_Price = findViewById(R.id.editTextPrice);

        /** Clearing the Edit Text out using the (Clear Field) button */
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText_BookID.setText("");
                editText_ISBN.setText("");
                editText_Author.setText("");
                editText_Description.setText("");
                editText_Title.setText("");
                editText_Price.setText("");
            }
        });
    }

    /** a method to show a pop-up notification for a brief moment */
    public void showToast(View v){
        // Title
        EditText editText_Title = findViewById(R.id.editTextTitle);
        String Title = editText_Title.getText().toString();

        //Price
        EditText editText_Price = findViewById(R.id.editTextPrice);
        float Price = Integer.parseInt(editText_Price.getText().toString());

        // Toast method to show the pop up notification for a brief moment
        Toast myMessage = Toast.makeText(this, "Book (" + Title + ")" + " and the price (" + + Price + ")" , Toast.LENGTH_SHORT );
        myMessage.show();
    }
}


