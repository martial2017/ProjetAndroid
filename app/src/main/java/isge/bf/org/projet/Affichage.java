package isge.bf.org.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class Affichage extends AppCompatActivity {

    private Intent intent;
    private TextView nom;
    private TextView prenom;
    private TextView adresse;
    private TextView ageP;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);
            intent=getIntent();
        nom=(TextView)findViewById(R.id.nomRecup);
        prenom=(TextView)findViewById(R.id.prenomRecup);
            adresse=(TextView)findViewById(R.id.adresseRecup);
            ageP=(TextView)findViewById(R.id.ageRecup);



        //= new Intent()intentV=getIntent();
       nom.setText("NOM  : "+intent.getStringExtra("NomS"));
        prenom.setText("PRENOM  : "+intent.getStringExtra("PrenomS"));
        adresse.setText("ADRESSE  : "+intent.getStringExtra("AdresseS"));
            ageP.setText("AGE  : "+intent.getStringExtra("AgeS"));

    }
}
