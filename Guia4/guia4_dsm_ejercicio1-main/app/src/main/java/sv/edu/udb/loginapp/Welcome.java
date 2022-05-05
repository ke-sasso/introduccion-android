package sv.edu.udb.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.login.LoginManager;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Welcome extends AppCompatActivity {

    TextView name , email, logout;
//    Button logout;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        startUp();

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);

        GoogleSignInAccount singInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(singInAccount != null){
            name.setText(singInAccount.getDisplayName());
            email.setText(singInAccount.getEmail());
        }

//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//
//        GraphRequest request = GraphRequest.newMeRequest(
//                accessToken,
//                new GraphRequest.GraphJSONObjectCallback() {
//                    @Override
//                    public void onCompleted(
//                            JSONObject object,
//                            GraphResponse response) {
//
//                        try {
//                            String fullName = object.getString("name");
//                            name.setText(fullName);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                        // Application code
//                    }
//                });
//        Bundle parameters = new Bundle();
//        parameters.putString("fields", "id,name,link");
//        request.setParameters(parameters);
//        request.executeAsync();

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance().logOut();
//                Intent intent = new Intent(Welcome.this,MainActivity.class);
//                startActivity(intent);
                signOut();
            }
        });
    }

    void signOut(){
        gsc.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                finish();
                startActivity(new Intent(Welcome.this,MainActivity.class));
            }
        });
    }

    public void startUp(){
        name = findViewById(R.id.tvName);
        email = findViewById(R.id.tvEmail);
        logout = findViewById(R.id.logout);
    }
}