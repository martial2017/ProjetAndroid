package isge.bf.org.projet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText nom;
    private EditText password;
    private Button connecter;
    private DatabaseManager gestionBaseDonnee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      gestionBaseDonnee = new DatabaseManager(this);
        nom = (EditText) findViewById(R.id.Name);
        password=(EditText)findViewById(R.id.Passwd);
        connecter=(Button)findViewById(R.id.button);
        connecter.setOnClickListener(this);
        //gestionBaseDonnee = new DatabaseManager(this);

       // gestionBaseDonnee.insertUser("admin", "admin2019");
       gestionBaseDonnee.close();
    }

    @Override
    public void onClick(View v) {

      //  if (gestionBaseDonnee.authentification(nom.toString(),password.toString())) {
        if(nom.getText().toString().equals("admin")&&password.getText().toString().equals("admin2019")) {
            Intent intentV = new Intent();
            intentV.setClass(this, RecordPerson.class);
            //intentV.setClass(this, Enregistrement.class);

            //startActivityForResult(intentV, GET_CODE);
            startActivity(intentV);
            // Log.v("AccueilActivity",nom.getText().toString() + prenom.getText().toString());
            //intentV.putExtra("datatosend", nom.getText().toString() );startActivity(intentV)
            //Log.v("ma",nom.getText());
            finish();
        }
      // }
        else{
            Toast.makeText(
                    MainActivity.this,        // Qualify 'this" with Activity class
                    " nom ou Mot de passe incorrect veuillez recommencer",        // Get string resource to display
                    Toast.LENGTH_LONG).show();
        }
    }


}