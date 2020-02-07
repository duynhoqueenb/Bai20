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

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
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

    private static String KEY_TOKEN = "keyToken";

    private static String KEY_TOKEN_VALUE = "Piepme2017";

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


        call = MainActivity.api.getEverything("17590", "duy", "", "qbtest_NhapMaGt2333", "v1", "oppo", "28", "android", "167", "326eb6e645c9ef419bc5c7b24560f57c");
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

    //create TokenNew
    public static String createTokenNew(ArrayList<String> lst) throws NoSuchAlgorithmException {
        try {
            lst.add(KEY_TOKEN + "=" + KEY_TOKEN_VALUE);
            String[] lstData = lst.toArray(new String[lst.size()]);
            Arrays.sort(lstData);
            String str = "";
            for (int i = 0; i < lstData.length; i++) {
                if (i > 0) {
                    str += "&";
                }
                str += lstData[i];
            }
            Log.e("gettoken", str);
            return MD5Encoder(str);
        } catch (Exception e) {
            return "";
        }
    }

    //MD5
    public static String MD5Encoder(String keyEncode) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(keyEncode.getBytes());


        byte byteData[] = md.digest();


        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }


        //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            String hex = Integer.toHexString(0xff & byteData[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}