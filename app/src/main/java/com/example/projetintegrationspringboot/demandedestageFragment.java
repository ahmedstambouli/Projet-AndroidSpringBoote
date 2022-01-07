package com.example.projetintegrationspringboot;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link demandedestageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class demandedestageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<Demandemodel> dataholder;
    private static final String URL_DATA = "http://192.168.1.4:8084/offers";
    private ProgressDialog progressDialog;
    private RequestQueue myvolley;

    public demandedestageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment demandedestageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static demandedestageFragment newInstance(String param1, String param2) {
        demandedestageFragment fragment = new demandedestageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demandedestage, container, false);
        recyclerView = view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder = new ArrayList<>();
        myvolley = Volley.newRequestQueue(getContext());

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Loading Data...");
        progressDialog.show();
        getdata();



        return view;
    }


    private void getdata() {


        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, URL_DATA, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        progressDialog.dismiss();
                        try {
                            System.out.println(response);
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject compteobj = response.getJSONObject(i);
                                String image = (String) compteobj.get("image");
                                String description = (String) compteobj.get("description");
                                String title = (String) compteobj.get("titre");


                                Demandemodel datamodel = new Demandemodel();
                                datamodel.setImage(image);
                                datamodel.setDescription(description);
                                datamodel.setTitle(title);
                                dataholder.add(datamodel);

                            }

                            recyclerView.setAdapter(new AdapterDemandeStage(dataholder, getContext()));


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(getContext(), error.getMessage() + " error Loading offers", Toast.LENGTH_LONG).show();
                    }
                });
        myvolley.add(request);
    }


}