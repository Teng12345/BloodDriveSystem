package com.example.blooddrivesystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

public class FormPage extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    private EditText mEditText;
    private String gender;
    private String bloodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_page);

        // ... Rest of onCreate code ...
        // Create the spinner.
        Spinner spinner = findViewById(R.id.formoccupation_spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        // Create ArrayAdapter using the string array and default spinner layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner.
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void display(View view) {
        mEditText = findViewById(R.id.formname_text);
        String name = mEditText.getText().toString();

        mEditText = findViewById(R.id.formemail_text);
        String email = mEditText.getText().toString();

        mEditText = findViewById(R.id.formphone_text);
        int phone = Integer.parseInt(mEditText.getText().toString());

        mEditText = findViewById(R.id.formic_text);
        int ic = Integer.parseInt(mEditText.getText().toString());

        mEditText = findViewById(R.id.formaddress_text);
        String address = mEditText.getText().toString();

        Intent intent = new Intent(this, BloodDonorProfile.class);
        intent.putExtra("NameField", name);
        intent.putExtra("GenderField", gender);
        intent.putExtra("EmailField", email);
        intent.putExtra("PhoneField", phone);
        intent.putExtra("ICField", ic);
        intent.putExtra("AddressField", address);
        intent.putExtra("BloodTypeField", gender);
        startActivity(intent);
    }

    public void genderClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.formrbMale:
                if (checked)
                    gender = "Male";
                break;
            case R.id.formrbFemale:
                if (checked)
                    gender = "Female";
                break;
            default:
                break;
        }
    }

    public void bloodTypeClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.formrbA:
                if (checked)
                    bloodType = "A";
                break;
            case R.id.formrbB:
                if (checked)
                    bloodType = "B";
                break;
            case R.id.formrbAB:
                if (checked)
                    bloodType = "AB";
                break;
            case R.id.formrbO:
                if (checked)
                    bloodType = "O";
                break;
            default:
                break;
        }
    }
}