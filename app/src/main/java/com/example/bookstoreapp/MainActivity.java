package com.example.bookstoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /** global variable */
    private String new_price;

    /** declaration */
    Button clearButton;
    Button loadButton;
    EditText editText_BookID;
    EditText editText_Title;
    EditText editText_ISBN;
    EditText editText_Author;
    EditText editText_Description;
    EditText editText_Price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** creating objects*/
        loadButton = findViewById(R.id.loadBook);
        clearButton = findViewById(R.id.clearFields);
        editText_BookID = findViewById(R.id.editTextBookID);
        editText_Title = findViewById(R.id.editTextTitle);
        editText_ISBN = findViewById(R.id.editTextISBN);
        editText_Author = findViewById(R.id.editTextAuthor);
        editText_Description = findViewById(R.id.editTextDescription);
        editText_Price = findViewById(R.id.editTextPrice);


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

    /**  a button to set value of ISBN into 00112233        (save function)   */
    public void valueISBN(View v) {
        /**  stores data  */
        SharedPreferences attributeID = getSharedPreferences("attributes", 0);

        /**  it modify the data stored in the SharedPreferences  */
        SharedPreferences.Editor attributesEditor = attributeID.edit();

        /**  Storing the String value into desired SharedPreferences objects  */
        attributesEditor.putString("ISBN_key", "00112233");

        /** it saves the changes that we modify to the SharedPreferences objects  */
        attributesEditor.apply();


    }

    /** a method to show a pop-up notification for a brief moment (TOAST Method) */
    public void showToast(View v){
        // Title
        String Title = editText_Title.getText().toString();

        // Price
        double Price = Double.parseDouble(editText_Price.getText().toString());
        new_price = Double.toString(Price);

        // Toast method to show the pop up notification for a brief moment
        Toast myMessage = Toast.makeText(this, "Book (" + Title + ")" + " and the price (" + new_price + ")" , Toast.LENGTH_SHORT );
        myMessage.show();

        /**  store and retrieve data  */
        SharedPreferences attributeID = getSharedPreferences("attributes", 0);

        /**  it modify the data stored in the SharedPreferences  */
        SharedPreferences.Editor attributesEditor = attributeID.edit();

        /**  Storing the String value into desired SharedPreferences objects  */
        attributesEditor.putString("Title_key", Title);

    }


    /**  PART 2  */
    /**  Load function  (set the values) */
    @Override
    protected void onStart() {
        super.onStart();

        /**  retrieve data after clicking exiting app and reentering again  */
        SharedPreferences attributeID = getSharedPreferences("attributes", 0);

        /** retrieving the String value from the SharePreference objects using keys */
        String msg_BookID = attributeID.getString("BookID_key"," " );
        String msg_Title = attributeID.getString("Title_key", " ");
        String msg_ISBN = attributeID.getString("ISBN_key", " ");
        String msg_Author = attributeID.getString("Author_key", " ");
        String msg_Description = attributeID.getString("Description_key", " ");

        /**  Set the text accordingly  */
        editText_BookID.setText(msg_BookID);
        editText_Title.setText(msg_Title);
        editText_ISBN.setText(msg_ISBN);
        editText_Author.setText(msg_Author);
        editText_Description.setText(msg_Description);
        editText_Price.setText(attributeID.getString("Price_key", " "));                      //price
    }

    /**  Save function  */
    @Override
    protected void onStop() {
        super.onStop();

        /**  assigning values (Retrieve data from user)  */
        String saveBookID = editText_BookID.getText().toString();
        String saveTitle = editText_Title.getText().toString();
        String saveISBN = editText_ISBN.getText().toString();
        String saveAuthor = editText_Author.getText().toString();
        String saveDescription = editText_Description.getText().toString();

        /**  stores data  */
        SharedPreferences attributeID = getSharedPreferences("attributes", 0);

        /**  it modify the data stored in the SharedPreferences  */
        SharedPreferences.Editor attributesEditor = attributeID.edit();

        /**  Storing the String value into desired SharedPreferences objects  */
        attributesEditor.putString("BookID_key", saveBookID);
        attributesEditor.putString("Title_key", saveTitle);
        attributesEditor.putString("ISBN_key", saveISBN);
        attributesEditor.putString("Author_key", saveAuthor);
        attributesEditor.putString("Description_key", saveDescription);
        attributesEditor.putString("Price_key", editText_Price.getText().toString());            //Price

        /** it saves the changes that we modify to the SharedPreferences objects  */
        attributesEditor.apply();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editText_BookID.setText("");
        editText_Author.setText("");
        editText_Description.setText("");
        editText_Price.setText("");
    }
    /** Load function */
    public void reload(View v){

        /**  retrieve data  */
        SharedPreferences attributeID = getSharedPreferences("attributes", 0);

        /** retrieving the String value from the SharePreference objects using keys */
        String msg_BookID = attributeID.getString("BookID_key"," " );
        String msg_Title = attributeID.getString("Title_key", " ");
        String msg_ISBN = attributeID.getString("ISBN_key", " ");
        String msg_Author = attributeID.getString("Author_key", " ");
        String msg_Description = attributeID.getString("Description_key", " ");

        // Set the text for the editTexts with the retrieved attributes
        editText_BookID.setText(msg_BookID);
        editText_Title.setText(msg_Title);
        editText_ISBN.setText(msg_ISBN);
        editText_Author.setText(msg_Author);
        editText_Description.setText(msg_Description);
        editText_Price.setText(attributeID.getString("Price_key", " "));                      //price
    }
}


