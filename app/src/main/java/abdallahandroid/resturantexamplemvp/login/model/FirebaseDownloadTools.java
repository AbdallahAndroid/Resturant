package abdallahandroid.resturantexamplemvp.login.model;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseDownloadTools {



    public void getData_thenSaveItTo_listName(final String key0, String key1,
                                              final int saveToArrayListWithIndex){
        System.out.println("realtime - start down: " + key0 + " " + key1  );
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child(key0).child(key1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                System.out.println("realtime - value is " + value );
                if ( value != null ){
                    DataDownloaded.nameEnglish_list.set(saveToArrayListWithIndex, value);
                }
                myRef.removeEventListener(this); /// remove listenner
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("realtime - Failed to read value." + error.toException());
            }
        });
    }


    public void getData_thenSaveItTo_listImageUrl(final String key0, String key1,
                                              final int saveToArrayListWithIndex){
        System.out.println("realtime - start down: " + key0 + " " + key1  );
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child(key0).child(key1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                System.out.println("realtime - value is " + value );
                if ( value != null ){
                    DataDownloaded.imageUrl_list.set(saveToArrayListWithIndex, value);
                }
                myRef.removeEventListener(this); /// remove listenner
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("realtime - Failed to read value." + error.toException());
            }
        });
    }


    public void getData_thenSaveItTo_listNameArabic(final String key0, String key1,
                                                  final int saveToArrayListWithIndex){
        System.out.println("realtime - start down: " + key0 + " " + key1  );
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child(key0).child(key1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                System.out.println("realtime - value is " + value );
                if ( value != null ){
                    DataDownloaded.nameArabic_list.set(saveToArrayListWithIndex, value);
                }
                myRef.removeEventListener(this); /// remove listenner
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("realtime - Failed to read value." + error.toException());
            }
        });
    }


    public void getData_thenSaveItTo_listDescriptionEnglish (final String key0, String key1,
                                                    final int saveToArrayListWithIndex){
        System.out.println("realtime - start down: " + key0 + " " + key1  );
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference();
        myRef.child(key0).child(key1).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                System.out.println("realtime - value is " + value );
                if ( value != null ){
                    DataDownloaded.description_list.set(saveToArrayListWithIndex, value);
                }
                myRef.removeEventListener(this); /// remove listenner
            }
            @Override
            public void onCancelled(DatabaseError error) {
                System.out.println("realtime - Failed to read value." + error.toException());
            }
        });
    }



}
