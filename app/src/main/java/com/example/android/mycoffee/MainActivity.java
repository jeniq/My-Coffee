package com.example.android.mycoffee;

import android.app.SearchManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences settings;
    private int espressoCoffee;
    private int americanoCoffee;
    private int cappuccinoCoffee;
    private int flatWhiteCoffee;
    private int frappeCoffee;
    private int latteCoffee;
    private int latteMacchiattoCoffee;
    private int mochaCoffee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadText();

        EditText searchCoffeeInWeb = (EditText) findViewById(R.id.find_another_coffee);
        searchCoffeeInWeb.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchWeb();
                    return true;
                }
                return false;
            }
        });
    }

    /**
     * @param keyCode is the key of pressed button
     * @param event   action of pressed button
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                searchWeb();
                return true;
            case KeyEvent.KEYCODE_NUMPAD_ENTER:
                searchWeb();
                return true;
            case KeyEvent.KEYCODE_SEARCH:
                searchWeb();
                return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * return to previous layer if pressed 'back' button
     */
    @Override
    public void onBackPressed() {
        saveText();
        setContentView(R.layout.activity_main);
        loadText();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.reset_data) {
            espressoCoffee = 0;
            americanoCoffee = 0;
            flatWhiteCoffee = 0;
            cappuccinoCoffee = 0;
            frappeCoffee = 0;
            latteCoffee = 0;
            latteMacchiattoCoffee = 0;
            mochaCoffee = 0;
            setContentView(R.layout.activity_main);
            saveText();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Open layout with more information about Americano Coffee
     */
    public void openAmericano(View view) {
        setContentView(R.layout.americano_coffee);
    }

    /**
     * Open layout with more information about Americano Coffee
     */
    public void openEspresso(View view) {
        setContentView(R.layout.espresso_coffee);
    }

    /**
     * Open layout with more information about Latte Coffee
     */
    public void openLatte(View view) {
        setContentView(R.layout.latte_coffee);
    }

    /**
     * Open layout with more information about Cappuccino Coffee
     */
    public void openFlatWhite(View view) {
        setContentView(R.layout.flat_white_coffee);
    }

    /**
     * Open layout with more information about Cappuccino Coffee
     */
    public void openCappuccino(View view) {
        setContentView(R.layout.cappuccino_coffee);
    }

    /**
     * Open layout with more information about Cappuccino Coffee
     */
    public void openFrappe(View view) {
        setContentView(R.layout.frappe_coffee);
    }

    /**
     * Open layout with more information about Cappuccino Coffee
     */
    public void openLatteMacchiatto(View view) {
        setContentView(R.layout.latte_macchiatto_coffee);
    }

    /**
     * Open layout with more information about Cappuccino Coffee
     */
    public void openMocha(View view) {
        setContentView(R.layout.mocha_coffee);
    }


    /**
     * Open web page with query from search field
     */
    public void searchWeb() {
        EditText search = (EditText) findViewById(R.id.find_another_coffee);
        String query = search.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method is called when the heart in more information is clicked.
     */
    public void incrementCoffee(View view) {
        String coffeeId = view.getTag().toString();
        setContentView(R.layout.activity_main);
        switch (coffeeId) {
            case "espresso_coffee":
                espressoCoffee++;
                TextView espressoTextView = (TextView) findViewById(R.id.espresso_counter);
                espressoTextView.setText(Integer.toString(espressoCoffee));
                saveText();
                setContentView(R.layout.espresso_coffee);
                break;
            case "americano_coffee":
                americanoCoffee++;
                TextView americanoTextView = (TextView) findViewById(R.id.americano_counter);
                americanoTextView.setText(Integer.toString(americanoCoffee));
                saveText();
                setContentView(R.layout.americano_coffee);
                break;
            case "cappuccino_coffee":
                cappuccinoCoffee++;
                TextView cappuccinoTextView = (TextView) findViewById(R.id.cappuccino_counter);
                cappuccinoTextView.setText(Integer.toString(cappuccinoCoffee));
                saveText();
                setContentView(R.layout.cappuccino_coffee);
                break;
            case "flatWhite_coffee":
                flatWhiteCoffee++;
                TextView flatWhiteTextView = (TextView) findViewById(R.id.flat_white_counter);
                flatWhiteTextView.setText(Integer.toString(flatWhiteCoffee));
                saveText();
                setContentView(R.layout.flat_white_coffee);
                break;
            case "frappe_coffee":
                frappeCoffee++;
                TextView frappeTextView = (TextView) findViewById(R.id.frappe_counter);
                frappeTextView.setText(Integer.toString(frappeCoffee));
                saveText();
                setContentView(R.layout.frappe_coffee);
                break;
            case "latte_coffee":
                latteCoffee++;
                TextView latteTextView = (TextView) findViewById(R.id.latte_counter);
                latteTextView.setText(Integer.toString(latteCoffee));
                saveText();
                setContentView(R.layout.latte_coffee);
                break;
            case "latteMacchiatto_coffee":
                latteMacchiattoCoffee++;
                TextView latteMacchiattoTextView = (TextView) findViewById(R.id.latte_macchiato_counter);
                latteMacchiattoTextView.setText(Integer.toString(latteMacchiattoCoffee));
                saveText();
                setContentView(R.layout.latte_macchiatto_coffee);
                break;
            case "mocha_coffee":
                mochaCoffee++;
                TextView mochaTextView = (TextView) findViewById(R.id.mocha_counter);
                mochaTextView.setText(Integer.toString(mochaCoffee));
                saveText();
                setContentView(R.layout.mocha_coffee);
                break;
        }
        Toast.makeText(this, "Have a good day!", Toast.LENGTH_SHORT).show();
    }

    protected void OnDestroy() {
        saveText();
        super.onDestroy();
    }

    private void saveText() {
        settings = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = settings.edit();
        ed.putInt("SAVED_TEXT1", espressoCoffee);
        ed.putInt("SAVED_TEXT2", americanoCoffee);
        ed.putInt("SAVED_TEXT3", cappuccinoCoffee);
        ed.putInt("SAVED_TEXT4", flatWhiteCoffee);
        ed.putInt("SAVED_TEXT5", frappeCoffee);
        ed.putInt("SAVED_TEXT6", latteCoffee);
        ed.putInt("SAVED_TEXT7", latteMacchiattoCoffee);
        ed.putInt("SAVED_TEXT8", mochaCoffee);
        ed.commit();
    }

    private void loadText() {
        settings = getPreferences(MODE_PRIVATE);
        int savedValue = settings.getInt("SAVED_TEXT1", espressoCoffee);
        TextView coffeeCount = (TextView) findViewById(R.id.espresso_counter);
        espressoCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT2", americanoCoffee);
        coffeeCount = (TextView) findViewById(R.id.americano_counter);
        americanoCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT3", cappuccinoCoffee);
        coffeeCount = (TextView) findViewById(R.id.cappuccino_counter);
        cappuccinoCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT4", flatWhiteCoffee);
        coffeeCount = (TextView) findViewById(R.id.flat_white_counter);
        flatWhiteCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT5", frappeCoffee);
        coffeeCount = (TextView) findViewById(R.id.frappe_counter);
        frappeCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT6", latteCoffee);
        coffeeCount = (TextView) findViewById(R.id.latte_counter);
        latteCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT7", latteMacchiattoCoffee);
        coffeeCount = (TextView) findViewById(R.id.latte_macchiato_counter);
        latteMacchiattoCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

        savedValue = settings.getInt("SAVED_TEXT8", mochaCoffee);
        coffeeCount = (TextView) findViewById(R.id.mocha_counter);
        mochaCoffee = savedValue;
        coffeeCount.setText(Integer.toString(savedValue));

    }
}
