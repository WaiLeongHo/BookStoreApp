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

    /**  a button to double the price and show it on editTextPrice   */
    public void doublePrice(View v) {
        // editText Price       (converting the Price into double)     (convert object into String representation)
        double Price = Double.parseDouble(editText_Price.getText().toString()) * 2;
        new_price = Double.toString(Price);
        editText_Price.setText(new_price);
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
    }


    /**  PART 2  */
    @Override
    protected void onStart() {
        super.onStart();

        editText_BookID = findViewById(R.id.editTextBookID);
        editText_Title = findViewById(R.id.editTextTitle);
        editText_ISBN = findViewById(R.id.editTextISBN);
        editText_Author = findViewById(R.id.editTextAuthor);
        editText_Description = findViewById(R.id.editTextDescription);
        editText_Price = findViewById(R.id.editTextPrice);                                          //Price

        /**  store and retrieve data after clicking exiting app and reentering again  */
        SharedPreferences Data_BookID = getSharedPreferences("BookID", 0);
        SharedPreferences Data_Title = getSharedPreferences("Title", 0);
        SharedPreferences Data_ISBN = getSharedPreferences("ISBN", 0);
        SharedPreferences Data_Author = getSharedPreferences("Author", 0);
        SharedPreferences Data_Description = getSharedPreferences("Description", 0);
        SharedPreferences Data_Price = getSharedPreferences("Price", 0);                //Price

        /** retrieving the String value from the SharePreference objects using keys */
        String msg_BookID = Data_BookID.getString("BookID_key"," " );
        String msg_Title = Data_Title.getString("Title_key", " ");
        String msg_ISBN = Data_ISBN.getString("ISBN_key", " ");
        String msg_Author = Data_Author.getString("Author_key", " ");
        String msg_Description = Data_Description.getString("Description_key", " ");
        long myDoubleAsLong = Data_Price.getLong("myDouble", 0L);                              //Price
        double myDouble = Double.longBitsToDouble(myDoubleAsLong);

        /**  Set the text accordingly  */
        editText_BookID.setText(msg_BookID);
        editText_Title.setText(msg_Title);
        editText_ISBN.setText(msg_ISBN);
        editText_Author.setText(msg_Author);
        editText_Description.setText(msg_Description);
        editText_Price.setText(String.valueOf(myDouble));                                           //Price
    }

    @Override
    protected void onStop() {
        super.onStop();

        editText_BookID = findViewById(R.id.editTextBookID);
        editText_Title = findViewById(R.id.editTextTitle);
        editText_ISBN = findViewById(R.id.editTextISBN);
        editText_Author = findViewById(R.id.editTextAuthor);
        editText_Description = findViewById(R.id.editTextDescription);
        editText_Price = findViewById(R.id.editTextPrice);                                          //Price

        /**  assigning values  */
        String saveBookID = editText_BookID.getText().toString();
        String saveTitle = editText_Title.getText().toString();
        String saveISBN = editText_ISBN.getText().toString();
        String saveAuthor = editText_Author.getText().toString();
        String saveDescription = editText_Description.getText().toString();

        /**  store and retrieve data  */
        SharedPreferences Data_BookID = getSharedPreferences("BookID", 0);
        SharedPreferences Data_Title = getSharedPreferences("Title", 0);
        SharedPreferences Data_ISBN = getSharedPreferences("ISBN", 0);
        SharedPreferences Data_Author = getSharedPreferences("Author", 0);
        SharedPreferences Data_Description = getSharedPreferences("Description", 0);
        SharedPreferences Data_Price = getSharedPreferences("Price", 0);                //Price

        /**  it modify the data stored in the SharedPreferences  */
        SharedPreferences.Editor BookID_Editor = Data_BookID.edit();
        SharedPreferences.Editor Title_Editor = Data_Title.edit();
        SharedPreferences.Editor ISBN_Editor = Data_ISBN.edit();
        SharedPreferences.Editor Author_Editor = Data_Author.edit();
        SharedPreferences.Editor Description_Editor = Data_Description.edit();
        SharedPreferences.Editor Price_Editor = Data_Price.edit();                                   //Price

        /**  Storing the String value into desired SharedPreferences objects  */
        BookID_Editor.putString("BookID_key", saveBookID);
        Title_Editor.putString("Title_key", saveTitle);
        ISBN_Editor.putString("ISBN_key", saveISBN);
        Author_Editor.putString("Author_key", saveAuthor);
        Description_Editor.putString("Description_key", saveDescription);
        double myDouble = Double.valueOf(editText_Price.getText().toString());
        long myDoubleAsLong = Double.doubleToRawLongBits(myDouble);                                   //Price
        Price_Editor.putLong("myDouble", myDoubleAsLong);


        /** it saves the changes that we modify to the SharedPreferences objects  */
        BookID_Editor.commit();
        Title_Editor.commit();
        ISBN_Editor.commit();
        Author_Editor.commit();
        Description_Editor.commit();
        Price_Editor.commit();                                                                      //Price
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        // clearing out the Text after each orientation (TASK 1)
        editText_BookID.setText("");
        editText_Author.setText("");
        editText_Description.setText("");
        editText_Price.setText("");
    }
}


