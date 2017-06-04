package oob.fruitworld.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import oob.fruitworld.R;
import oob.fruitworld.models.Fruit;

public class FruitAdapter extends BaseAdapter{

    private Context context;
    private int layout;
    private ArrayList<Fruit> fruits;
    private View convertView;

    public FruitAdapter(Context context, int layout, ArrayList<Fruit> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    @Override
    public int getCount() {
        return this.getFruits().size();
    }

    @Override
    public Fruit getItem(int position) {
        return this.getFruits().get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FruitViewHolder fruitViewHolder;

        if (null == convertView) {
            convertView = this.createConvertView();
            fruitViewHolder = this.createHolder(convertView);
        } else {
            fruitViewHolder = (FruitViewHolder) convertView.getTag();
        }

        Fruit fruit = this.getItem(position);

        this.populateViewHolder(fruitViewHolder, fruit);

        return convertView;
    }

    private View createConvertView() {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());

        return layoutInflater.inflate(this.getLayout(), null);
    }

    private FruitViewHolder createHolder(View convertView) {
        FruitViewHolder fruitViewHolder = new FruitViewHolder(
                (TextView) convertView.findViewById(R.id.nameTextView),
                (TextView) convertView.findViewById(R.id.originTextView),
                (ImageView) convertView.findViewById(R.id.iconImageView));

        convertView.setTag(fruitViewHolder);

        return fruitViewHolder;
    }

    private FruitViewHolder populateViewHolder(FruitViewHolder fruitViewHolder, Fruit fruit) {
        fruitViewHolder.setName(fruit.getName());
        fruitViewHolder.setOrigin(fruit.getOrigin());
        fruitViewHolder.setIcon(fruit.getIcon());

        return fruitViewHolder;
    }

    // ------------------ Getter & Setters ------------------

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public int getLayout() {
        return layout;
    }

    public void setLayout(int layout) {
        this.layout = layout;
    }

    public ArrayList<Fruit> getFruits() {
        return fruits;
    }

    public void setFruits(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public View getConvertView() {
        return convertView;
    }

    public void setConvertView(View convertView) {
        this.convertView = convertView;
    }
}
