package isge.bf.org.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RecordPerson extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    private EditText nom;
    private  EditText prenom;
    private EditText adresse;
    private String agePers="10";
    private Button enregistrer;
    private  Spinner spinner;
   // TextView text;
   // private  Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_person);

        //spinner = (Spinner) findViewById(R.id.ageSpinner);
        //spinner.setOnItemSelectedListener(this);
        /*
        Binding to
         */
        enregistrer = (Button) findViewById(R.id.record);
        enregistrer.setOnClickListener(this);
        nom=(EditText)findViewById(R.id.nom);
        prenom=(EditText)findViewById(R.id.prenom);
        adresse=(EditText)findViewById(R.id.adresse);



        //set spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(
                this,
                R.array.ageArray,
                android.R.layout.simple_spinner_item);
        //link the adapter to the spinner
         spinner = (Spinner) findViewById(R.id.ageSpinner);
        spinner.setAdapter(adapter);



        //agePers= "10";



    }



    @Override
    public void onClick(View v) {


        Intent intentV = new Intent();
        intentV.setClass(this, Affichage.class);

        //startActivityForResult(intentV, GET_CODE);

       // Log.v("AccueilActivity",nom.getText().toString() + prenom.getText().toString());
        intentV.putExtra("NomS", nom.getText().toString() );
        intentV.putExtra("PrenomS", prenom.getText().toString() );
        intentV.putExtra("AdresseS", adresse.getText().toString() );
        intentV.putExtra("AgeS",agePers);

        Toast.makeText(
                RecordPerson.this,        // Qualify 'this" with Activity class
                " Les données ont été enregistrées!",        // Get string resource to display
                Toast.LENGTH_LONG).show();

        startActivity(intentV);

    
        //finish();
        //startActivityForResult(intentV, GET_CODE);
        //startActivity(intentV);
        // Log.v("AccueilActivity",nom.getText().toString() + prenom.getText().toString());
        //intentV.putExtra("datatosend", nom.getText().toString() );startActivity(intentV)
        //finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
      this.agePers=spinner.getSelectedItem().toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
       //text.setText(spinner.getSelectedItem().toString());
        //Log.v("Spinner4", "spincombox");
    }

}
