package com.paypal.first.contactsadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by thanhtnguyen on 4/2/15.
 */
public class NewListAdapter extends ArrayAdapter<Person> {

    private final int layoutResource;
    List<Person> people = null;
    Context context;

    public NewListAdapter(Context context, int resource, List<Person> objects) {
        super(context, resource, objects);
        this.people = objects;
        this.layoutResource = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layoutResource, null);
        }
        Person person = people.get(position);
        TextView firstNameView = (TextView) view.findViewById(R.id.first_name);
        TextView lastNameView = (TextView) view.findViewById(R.id.last_name);
        TextView ageView = (TextView) view.findViewById(R.id.age);

        firstNameView.setText(person.getFirstName());
        lastNameView.setText(person.getLastName());
        ageView.setText(person.getAge() + "");
        return view;
    }
}
