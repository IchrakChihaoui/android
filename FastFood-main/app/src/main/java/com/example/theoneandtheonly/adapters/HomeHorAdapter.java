package com.example.theoneandtheonly.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.theoneandtheonly.R;
import com.example.theoneandtheonly.models.HomeHorModel;
import com.example.theoneandtheonly.models.HomeVerModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeHorAdapter extends RecyclerView.Adapter<HomeHorAdapter.ViewHolder> {
    public DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
     FirebaseFirestore db;

    private static final String TAG = "DocSnippets";
    List<Map<String, Object>> questionsList=new ArrayList<java.util.Map<String, Object>>();
    List<String> keys = new ArrayList<>();
    Map<String, Object> data = new HashMap<>();





    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    List<HomeHorModel> list;

    boolean check=true;
    boolean select=true;
    int row_index=-1;

    public HomeHorAdapter(UpdateVerticalRec updateVerticalRec, Activity activity, List<HomeHorModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    public HomeHorAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.home_horizontal_item,parent,false));


    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
       // firebaseDatabase = FirebaseDatabase.getInstance();


        // below line is used to get
        // reference for our database.
        if(check) {
            ArrayList<HomeVerModel> homeVerModels = new ArrayList<>();
            homeVerModels.add(new HomeVerModel(R.drawable.pizza1, "pizza1", "10DT", "10:00-23:00", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza2, "pizza2", "10DT", "10:00-23:00", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza3, "pizza3", "10DT", "10:00-23:00", "4.9"));
            homeVerModels.add(new HomeVerModel(R.drawable.pizza4, "pizza4", "10DT", "10:00-23:00", "4.9"));








            updateVerticalRec.callBack(position, homeVerModels);
            check = false;
        }
            holder.cardView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    //this.getAllDocsPlat();
                    // [START get_multiple_all]

                    row_index=position;
                    notifyDataSetChanged();

                    db = FirebaseFirestore.getInstance();
                    db.collection("plat")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        /***find pizza***/
                                        if(position==0) {
                                            ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                                            for (QueryDocumentSnapshot document : task.getResult()) {

                                               if(document.getData().get("categorie").toString().equals("pizza"))
                                               {
                                                              System.out.println("aaaaaaaaaaaaaaaaaaa"+document.getData().get("categorie").toString());

                                                   homeVerModels.add(new HomeVerModel(R.drawable.pizza1,document.getData().get("Nom").toString(),document.getData().get("prix").toString(),"10:00-23:00","4.9"));
                                               }
                                               // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                            }
                                            updateVerticalRec.callBack(position,homeVerModels);
                                        }

                                        /****find sandwtch******/
                                        if(position==1) {
                                            ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                                            for (QueryDocumentSnapshot document : task.getResult()) {

                                                if(document.getData().get("categorie").toString().equals("sandwitch"))
                                                {
                                                    System.out.println("aaaaaaaaaaaaaaaaaaa"+document.getData().get("categorie").toString());

                                                    homeVerModels.add(new HomeVerModel(R.drawable.sandwich4,document.getData().get("Nom").toString(),document.getData().get("prix").toString(),"10:00-23:00","4.9"));
                                                }
                                                // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                            }
                                            updateVerticalRec.callBack(position,homeVerModels);
                                        }

                                        /****find Ice cream******/
                                        if(position==2) {
                                            ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                                            for (QueryDocumentSnapshot document : task.getResult()) {

                                                if(document.getData().get("categorie").toString().equals("ic"))
                                                {
                                                    System.out.println("aaaaaaaaaaaaaaaaaaa"+document.getData().get("categorie").toString());

                                                    homeVerModels.add(new HomeVerModel(R.drawable.icecream3,document.getData().get("Nom").toString(),document.getData().get("prix").toString(),"10:00-23:00","4.9"));
                                                }
                                                // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                            }
                                            updateVerticalRec.callBack(position,homeVerModels);
                                        }
                                        if(position==3) {
                                            ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                                            for (QueryDocumentSnapshot document : task.getResult()) {

                                                if(document.getData().get("categorie").toString().equals("humburguer"))
                                                {
                                                    System.out.println("aaaaaaaaaaaaaaaaaaa"+document.getData().get("categorie").toString());

                                                    homeVerModels.add(new HomeVerModel(R.drawable.burger1,document.getData().get("Nom").toString(),document.getData().get("prix").toString(),"10:00-23:00","4.9"));

                                                }
                                                // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                            }

                                            updateVerticalRec.callBack(position,homeVerModels);
                                        }
                                        if(position==4) {
                                            ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();

                                            for (QueryDocumentSnapshot document : task.getResult()) {

                                                if(document.getData().get("categorie").toString().equals("humburguer"))
                                                {
                                                    System.out.println("aaaaaaaaaaaaaaaaaaa"+document.getData().get("categorie").toString());

                                                    homeVerModels.add(new HomeVerModel(R.drawable.fries1,document.getData().get("Nom").toString(),document.getData().get("prix").toString(),"10:00-23:00","4.9"));
                                                }
                                                // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                            }

                                            updateVerticalRec.callBack(position,homeVerModels);
                                        }

                                    } else {
                                        Log.d(TAG, "Error getting documents: ", task.getException());
                                    }
                                }
                            });



                  /* if (position==0){

                       ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();
                       homeVerModels.add(new HomeVerModel(R.drawable.pizza1,"pizza1","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.pizza2,"pizza2","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.pizza3,"pizza3","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.pizza4,"pizza4","10DT","10:00-23:00","4.9"));

                       updateVerticalRec.callBack(position,homeVerModels);

                   }
                   else if (position==1){
                       ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();


                       homeVerModels.add(new HomeVerModel(R.drawable.sandwich1,"sandwich1","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.sandwich2,"sandwich2","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.sandwich3,"sandwich3","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.sandwich4,"sandwich4","10DT","10:00-23:00","4.9"));

                       updateVerticalRec.callBack(position,homeVerModels);
                   }
                   else if (position==2){
                       ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();


                       homeVerModels.add(new HomeVerModel(R.drawable.burger1,"sandwich1","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.burger4,"sandwich2","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.burger1,"sandwich3","10DT","10:00-23:00","4.9"));


                       updateVerticalRec.callBack(position,homeVerModels);
                   }
                   else if (position==3){
                       ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();


                       homeVerModels.add(new HomeVerModel(R.drawable.icecream1,"icecream1","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.icecream2,"icecream2","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.icecream3,"icecream3","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.icecream4,"icecream4","10DT","10:00-23:00","4.9"));

                       updateVerticalRec.callBack(position,homeVerModels);
                   }
                   else if (position==4){
                       ArrayList<HomeVerModel> homeVerModels=new ArrayList<>();


                       homeVerModels.add(new HomeVerModel(R.drawable.fries1,"fries1","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.fries2,"fries2","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.fries3,"fries3","10DT","10:00-23:00","4.9"));
                       homeVerModels.add(new HomeVerModel(R.drawable.fries4,"fries4","10DT","10:00-23:00","4.9"));

                       updateVerticalRec.callBack(position,homeVerModels);
                   }      */

                }

              /*  public void getAllDocsPlat() {
                    // [START get_multiple_all]
                    db = FirebaseFirestore.getInstance();
                    db.collection("plat")
                            .get()
                            .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                    if (task.isSuccessful()) {
                                        for (QueryDocumentSnapshot document : task.getResult()) {
                                          //  questionsList.add(document.getData());
                                            data.put(document.getId(),document.getData());
                                            String namePlat = document.getData().get("Nom").toString();
                                            String categoryPlat=document.getData().get("categorie").toString();
                                           String prixPlat=document.getData().get("categorie").toString();

                                            // Log.d(TAG, document.getId() + " => " + document.getData().get("Nom").toString());
                                        }
                                    } else {
                                        Log.d(TAG, "Error getting documents: ", task.getException());
                                    }
                                }
                            });
                    // [END get_multiple_all]
                }   */
            });
            if (select){
                if (position==0){
                    holder.cardView.setCardBackgroundColor(R.drawable.change_bg);
                    select= false;

                }
            }
            else{
                if(row_index==position){
                    holder.cardView.setCardBackgroundColor(R.drawable.change_bg);
                } else{
                    holder.cardView.setCardBackgroundColor(R.drawable.default_bg );
                }
            }

        }



    public int getImage() {
        return 0;
    }

    public   int getName() {
        return 0;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.hor_img);
            name=itemView.findViewById(R.id.hor_text);
            cardView=itemView.findViewById(R.id.cardView);

        }
    }


}
