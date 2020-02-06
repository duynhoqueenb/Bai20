package com.example.bai20;

import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SearchFragment extends Fragment {

    private View rootView;
    private TextView iconBack, iconSearch;
    private Call<DataResponse> call;

    private RecyclerView rvSearch;
    private SearchAdapter searchAdapter;
    private RecyclerView.LayoutManager rvLayoutManagerSearch;
    private List<UserModel> itemListSearch = new ArrayList<>();

    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_search, container, false);
        iconBack = rootView.findViewById(R.id.tv_search_iconBack);
        iconSearch = rootView.findViewById(R.id.icon_search);
        rvSearch = rootView.findViewById(R.id.rv_listketqua_search);

        MainActivity.callAnimationIn(rootView, getContext(), R.anim.slide_in_left, null);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Typeface myIconEdit = Typeface.createFromAsset(getContext().getAssets(), "fonts/TuoiTreTV.ttf");
        iconBack.setTypeface(myIconEdit);
        iconSearch.setTypeface(myIconEdit);

        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.callAnimationOut(rootView, getContext(), R.anim.slide_out_right, new AnimationInf() {
                    @Override
                    public void afterAnim() {
                        if (dataPasserSearch != null) {
                            dataPasserSearch.getSearch("BACKSEARCH");
                        }
                    }
                });
            }
        });


        searchAdapter = new SearchAdapter(itemListSearch);
        rvSearch.setAdapter(searchAdapter);
        rvLayoutManagerSearch = new LinearLayoutManager(getActivity());
        rvSearch.setLayoutManager(rvLayoutManagerSearch);


        call = MainActivity.api.getUsers();
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {
                DataResponse dataResponse = response.body();
                itemListSearch = dataResponse.getElements();

                searchAdapter.setDataList(itemListSearch);
                searchAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {

            }
        });


    }

    //interface
    TuyenDung dataPasserSearch;

    public void passDataSearch(TuyenDung data) {
        this.dataPasserSearch = data;
    }


}