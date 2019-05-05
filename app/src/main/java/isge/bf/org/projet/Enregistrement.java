package isge.bf.org.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Enregistrement extends AppCompatActivity implements View.OnClickListener{

    private EditText nom;
    private  EditText prenom;
    private EditText adresse;
    private Button enregistrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement);

        enregistrer = (Button) findViewById(R.id.recordf);
        enregistrer.setOnClickListener(this);
        nom=(EditText)findViewById(R.id.nomf);
        prenom=(EditText)findViewById(R.id.prenomf);
        adresse=(EditText)findViewById(R.id.adressef);
    }

    @Override
    public void onClick(View v) {


        Intent intentVf = new Intent();
        intentVf.setClass(this, Affichage.class);

        //startActivityForResult(intentV, GET_CODE);

        // Log.v("AccueilActivity",nom.getText().toString() + prenom.getText().toString());
        intentVf.putExtra("NomS", nom.getText().toString() );
        intentVf.putExtra("PrenomS", prenom.getText().toString() );
        intentVf.putExtra("AdresseS", adresse.getText().toString() );




        startActivity(intentVf);
    }
}
