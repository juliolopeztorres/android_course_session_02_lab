package oob.fruitworld.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;

import oob.fruitworld.R;
import oob.fruitworld.adapters.FruitAdapter;
import oob.fruitworld.models.Fruit;

public class MainActivity extends AppCompatActivity {

    private final int FRUIT_INIT_NUMBER = 1;
    private final int FRUIT_NUMBER = 7;

    private int counter;
    private ListView listView;
    private GridView gridView;
    private ArrayList<Fruit> fruits;
    private FruitAdapter fruitListAdapter;
    private FruitAdapter fruitGridAdapter;

    private MenuItem showListViewMenuItem;
    private MenuItem showGridViewMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.init();
    }

    private void init() {
        this.showIconInActionBard();

        this.setVariables();
    }

    private void showIconInActionBard() {
        ActionBar actionBar = getSupportActionBar();

        actionBar.setIcon(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void setVariables() {
        this.setCounter(this.FRUIT_INIT_NUMBER);
        this.setListView((ListView) findViewById(R.id.listView));
        this.setGridView((GridView) findViewById(R.id.gridView));
        this.setFruits(new ArrayList<Fruit>(this.FRUIT_NUMBER));
        this.initArrayFruits();

        this.setFruitListAdapter(new FruitAdapter(this, R.layout.list_item, this.getFruits()));
        this.setFruitGridAdapter(new FruitAdapter(this, R.layout.grid_item, this.getFruits()));

        this.getListView().setAdapter(this.getFruitListAdapter());
        this.getGridView().setAdapter(this.getFruitGridAdapter());
    }

    private void initArrayFruits() {
        ArrayList<Fruit> arrayFruit = this.getFruits();

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);

        this.setShowGridViewMenuItem(menu.findItem(R.id.showGridView));
        this.setShowListViewMenuItem(menu.findItem(R.id.showListView));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addFruit:
                this.addNewStandardFruit();
                break;
            case R.id.showGridView:
                this.updateViewType(R.id.gridView);
                break;
            case R.id.showListView:
                this.updateViewType(R.id.listView);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    private void addNewStandardFruit() {
        Fruit fruit = new Fruit(
                getString(R.string.fruit_standard_name) + " " + this.getCounter(),
                getString(R.string.fruit_standard_origin),
                R.mipmap.ic_launcher
        );

        this.getFruits().add(fruit);

        this.getFruitListAdapter().notifyDataSetChanged();
        this.getFruitGridAdapter().notifyDataSetChanged();
        this.updateCounter();
    }

    private void updateCounter() {
        this.setCounter(this.getCounter() + 1);
    }

    private void updateViewType(int layoutToShow) {
        if (!isLayoutVisible(layoutToShow)) {
            int listViewId = R.id.listView;
            int gridViewId = R.id.gridView;

            if (layoutToShow == listViewId) {
                this.getShowListViewMenuItem().setVisible(false);
                this.getShowGridViewMenuItem().setVisible(true);

                findViewById(listViewId).setVisibility(View.VISIBLE);
                findViewById(gridViewId).setVisibility(View.INVISIBLE);
            } else {
                this.getShowGridViewMenuItem().setVisible(false);
                this.getShowListViewMenuItem().setVisible(true);

                findViewById(gridViewId).setVisibility(View.VISIBLE);
                findViewById(listViewId).setVisibility(View.INVISIBLE);
            }
        }
    }

    private boolean isLayoutVisible(int layoutToShow) {
        return findViewById(layoutToShow).getVisibility() == View.VISIBLE;
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

    public FruitAdapter getFruitListAdapter() {
        return fruitListAdapter;
    }

    public void setFruitListAdapter(FruitAdapter fruitListAdapter) {
        this.fruitListAdapter = fruitListAdapter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public MenuItem getShowListViewMenuItem() {
        return showListViewMenuItem;
    }

    public void setShowListViewMenuItem(MenuItem showListViewMenuItem) {
        this.showListViewMenuItem = showListViewMenuItem;
    }

    public MenuItem getShowGridViewMenuItem() {
        return showGridViewMenuItem;
    }

    public void setShowGridViewMenuItem(MenuItem showGridViewMenuItem) {
        this.showGridViewMenuItem = showGridViewMenuItem;
    }

    public GridView getGridView() {
        return gridView;
    }

    public void setGridView(GridView gridView) {
        this.gridView = gridView;
    }

    public FruitAdapter getFruitGridAdapter() {
        return fruitGridAdapter;
    }

    public void setFruitGridAdapter(FruitAdapter fruitGridAdapter) {
        this.fruitGridAdapter = fruitGridAdapter;
    }
}
