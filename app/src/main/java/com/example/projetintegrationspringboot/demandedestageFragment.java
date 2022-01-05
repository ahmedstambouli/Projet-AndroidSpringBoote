package com.example.projetintegrationspringboot;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
    ArrayList<Datamodel> dataholder;

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
         View view= inflater.inflate(R.layout.fragment_demandedestage, container, false);
         recyclerView=view.findViewById(R.id.recycle);
        recyclerView.setLayoutManager( new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();

        Datamodel ad1=new Datamodel(R.drawable.ren,"pfe","uptech");
        dataholder.add(ad1);
        Datamodel ad2=new Datamodel(R.drawable.ren,"pfe","TELECOM");
        dataholder.add(ad2);
        Datamodel ad3=new Datamodel(R.drawable.ren,"pfe","ourax");
        dataholder.add(ad3);
        Datamodel ad4=new Datamodel(R.drawable.ren,"pfe","iset");
        dataholder.add(ad4);
recyclerView.setAdapter(new MyAdapter(dataholder));
         return view;
    }
}