package oob.fruitworld.adapters;

import android.widget.ImageView;
import android.widget.TextView;

public class FruitViewHolder {
    private TextView name;
    private TextView origin;
    private ImageView icon;

    public FruitViewHolder(TextView name, TextView origin, ImageView icon) {
        this.name = name;
        this.origin = origin;
        this.icon = icon;
    }

    // ------------------ Getter & Setters ------------------

    public ImageView getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon.setImageResource(icon);
    }

    public TextView getName() {
        return name;
    }

    public void setName(String name) {
        this.name.setText(name);
    }

    public TextView getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin.setText(origin);
    }
}
