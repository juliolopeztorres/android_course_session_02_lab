package oob.fruitworld.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

import oob.fruitworld.R;
import oob.fruitworld.adapters.FruitAdapter;
import oob.fruitworld.models.Fruit;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Fruit> fruits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {
        this.showIconInActionBard();

        this.setVariables();
        this.initArrayFruits();

        FruitAdapter fruitAdapter = new FruitAdapter(this, R.layout.list_item, this.getFruits());
        this.getListView().setAdapter(fruitAdapter);
    }

    private void showIconInActionBard() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void setVariables() {
        this.setListView((ListView) findViewById(R.id.listView));
        this.setFruits(new ArrayList<Fruit>(7));
    }

    private void initArrayFruits() {
        ArrayList<Fruit> arrayFruit = new ArrayList<>(7);

        Fruit fruit = new Fruit(
                getString(R.string.fruit_apple_name),
                getString(R.string.fruit_apple_origin),
                R.mipmap.ic_apple);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_banana_name),
                getString(R.string.fruit_banana_origin),
                R.mipmap.ic_banana);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_cherry_name),
                getString(R.string.fruit_cherry_origin),
                R.mipmap.ic_cherry);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_orange_name),
                getString(R.string.fruit_orange_origin),
                R.mipmap.ic_orange);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_pear_name),
                getString(R.string.fruit_pear_origin),
                R.mipmap.ic_pear);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_raspberry_name),
                getString(R.string.fruit_raspberry_origin),
                R.mipmap.ic_raspberry);
        arrayFruit.add(fruit);

        fruit = new Fruit(
                getString(R.string.fruit_strawberry_name),
                getString(R.string.fruit_strawberry_origin),
                R.mipmap.ic_strawberry);
        arrayFruit.add(fruit);

        this.addArrayFruitInArray(arrayFruit);
    }

    private void addArrayFruitInArray(ArrayList<Fruit> arrayFruits) {
        for(Fruit fruit : arrayFruits) {
            this.addFruitInArray(fruit);
        }
    }

    private void addFruitInArray(Fruit fruit) {
        this.getFruits().add(fruit);
    }

    // ------------------ Getter & Setters ------------------


    public ListView getListView() {
        return listView;
    }

    public void setListView(ListView listView) {
        this.listView = listView;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }
}
