package com.mine.kid.mayb2;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;




/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BlankFragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private PAintView paintView;

    private TextView textView;
    private TextView textView2;
    private Button by;
    private Button s;
    private DisplayMetrics metrics;
    private View inflate;
   LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;
//private PAintView paintView;


    private String text;

    private  int[] ki = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
    int[] please;


    private OnFragmentInteractionListener mListener;

    public BlankFragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment1 newInstance(String param1, String param2) {
        BlankFragment1 fragment = new BlankFragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) throws NullPointerException {
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
        inflate = inflater.inflate(R.layout.fragment_blank_fragment1, container, false);
        textView = (TextView) inflate.findViewById(R.id.dynamic);
        textView2 = (TextView) inflate.findViewById(R.id.dynamicGeez);
        textView.setText(mParam1);
        textView2.setText(mParam2);

        s=(Button) inflate.findViewById(R.id.sa);
        s.setOnClickListener(this);


        paintView = (PAintView) inflate.findViewById(R.id.paintview);
      DisplayMetrics  metrics = new DisplayMetrics();
       getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
        paintView.init(metrics);




        return inflate;

    }



    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {


            paintView.setDrawingCacheEnabled(true);
            MainActivity m=(MainActivity) getActivity();
           m.save1(paintView,mParam1);


//        Log.d("the typed text is", editText.getText().toString());
    }

    public void setText(String text) {
        Log.d("this","text");
        this.text = text;
        textView.setText(this.text);
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String uri);
    }
    public void clearr(){
        paintView.clear();


    }
    public void plea () {
        paintView.clear();


    }


}
