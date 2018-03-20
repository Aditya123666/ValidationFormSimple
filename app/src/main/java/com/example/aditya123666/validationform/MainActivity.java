package com.example.aditya123666.validationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nama,email,no,lahir,usia;

    private Button buttonsubmit;

    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        nama = (EditText) findViewById(R.id.etnama);
        email = (EditText) findViewById(R.id.etemail);
        no = (EditText) findViewById(R.id.etno);
        lahir = (EditText) findViewById(R.id.etlahir);
        usia = (EditText) findViewById(R.id.etusia);

        buttonsubmit = (Button) findViewById(R.id.btnsubmit);

        awesomeValidation.addValidation(this, R.id.etnama, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.etemail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.etno, "^[2-9]{2}[0-9]{8}$", R.string.mobileerror);
        awesomeValidation.addValidation(this, R.id.etlahir, "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[1,3-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", R.string.dateerror);
        awesomeValidation.addValidation(this, R.id.etusia, Range.closed(13, 60), R.string.ageerror);

        buttonsubmit.setOnClickListener(this);
//        buttonsubmit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (awesomeValidation.validate()) {
//                    Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();
//
//                    //process the data further
//                }
//            }
//        });
    }

    private void submitForm() {
        //first validate the form then move ahead
        //if this becomes true that means validation is successfull
        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Validation Successfull", Toast.LENGTH_LONG).show();

            //process the data further
        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonsubmit) {
            submitForm();
        }
    }
}
