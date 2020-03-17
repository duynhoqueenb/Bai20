package com.example.bai20;

import android.graphics.Typeface;
import android.os.Build;
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
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertPathBuilder;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import okhttp3.HttpUrl;
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
    private static String KEY_TOKEN_VALUE = "keyTokenValue";
    private static String KEY_TOKEN_VERSION = "keyTokenVersion";
    private static String KEY_TOKEN_VERSION_VALUE = "keyTokenVersionValue";
    private static String SOURCE_DEVICE = "";

    private EditText edtSearch;
    private TextView tv_tim;



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
        edtSearch = rootView.findViewById(R.id.edt_search);
        tv_tim = rootView.findViewById(R.id.tv_tim_search);


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


        tv_tim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtSearch.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Vui lòng nhập vào tên", Toast.LENGTH_SHORT).show();
                } else {
                    call = MainActivity.api.getEverything("17590", edtSearch.getText().toString(), "", "qbtest_NhapMaGt2333", "v1", "oppo", "28", "android", "167", "326eb6e645c9ef419bc5c7b24560f57c");
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

    //deAccent
    public static String deAccent(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

    public static String createTokenPostNewV3(JSONObject jsonObject) throws NoSuchAlgorithmException {
        String manufacturer = Build.MANUFACTURER;
        try {
            jsonObject.put(KEY_TOKEN,  KEY_TOKEN_VALUE);
            jsonObject.put(KEY_TOKEN_VERSION, KEY_TOKEN_VERSION_VALUE);
            jsonObject.put("MODEL", manufacturer.toLowerCase(Locale.ENGLISH));
            jsonObject.put("OS", Build.VERSION.SDK_INT);
            jsonObject.put("SRC", SOURCE_DEVICE);
            jsonObject.put("VERSION", BuildConfig.VERSION_CODE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        StringBuilder tmpString = new StringBuilder();

        String jsonData = sortJsonObjectV3(jsonObject,tmpString);
        Log.e("Duong dan jsonData: ", jsonData);
        return MD5Encoder(jsonData);
    }

    private static String sortJsonObjectV3(JSONObject jsonObject, StringBuilder tmpString) {
        JSONArray arrData = sortJsonArray(jsonObject.names());
        for (int i = 0; i < arrData.length(); i++) {
            try {
                if (jsonObject.get(arrData.getString(i)) instanceof JSONObject) {
                    tmpString.append(arrData.getString(i));
                    tmpString.append("=[");
                    tmpString.append(sortJsonObjectV3((JSONObject) jsonObject.get(arrData.getString(i)), new StringBuilder()));
                    tmpString.append("]");
                } else if (jsonObject.get(arrData.getString(i)) instanceof JSONArray) {
                    tmpString.append(arrData.getString(i));
                    tmpString.append("=[");
                    tmpString.append(sortJsonArrayV3((JSONArray) jsonObject.get(arrData.getString(i)), new StringBuilder()));
                    tmpString.append("]");
                } else {
                    tmpString.append(arrData.getString(i));
                    tmpString.append("=");
                    if (jsonObject.get(arrData.getString(i)) instanceof Number) {

                        tmpString.append(numberToString((Number) jsonObject.get(arrData.getString(i))).replaceAll("[^a-zA-Z0-9]", ""));
                    } else {
                        String txt = jsonObject.get(arrData.getString(i)).toString().replaceAll("[^a-zA-Z0-9]", "");
                        tmpString.append(txt);

                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (i + 1 < arrData.length()) {
                tmpString.append("&");
            }

            if (i + 1 == arrData.length()) {
                return tmpString.toString();
            }
        }
        return "";
    }

    private static JSONArray sortJsonArray(JSONArray array) {
        List<String> jsons = new ArrayList<String>();
        try {
            if (array != null) {
                for (int i = 0; i < array.length(); i++) {
                    jsons.add(array.getString(i));

                }
                Collections.sort(jsons);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONArray(jsons);

    }
    private static String sortJsonArrayV3(JSONArray jsonArray, StringBuilder tmpString) {
        for (int i = 0; i < jsonArray.length(); i++) {
            try {
                if (jsonArray.get(i) instanceof JSONObject) {
                    tmpString.append(i);
                    tmpString.append("=[");
                    tmpString.append(sortJsonObjectV3((JSONObject) jsonArray.get(i), new StringBuilder()));
                    tmpString.append("]");
                } else if (jsonArray.get(i) instanceof JSONArray) {
                    tmpString.append(i);
                    tmpString.append("=[");
                    tmpString.append(sortJsonArrayV3((JSONArray) jsonArray.get(i), new StringBuilder()));
                    tmpString.append("]");
                } else {
                    tmpString.append(i);
                    tmpString.append("=");
                    if (jsonArray.get(i) instanceof Number) {
                        tmpString.append(numberToString((Number) jsonArray.get(i)).replaceAll("[^a-zA-Z0-9]", ""));
                    } else {
                        String txt = jsonArray.get(i).toString().replaceAll("[^a-zA-Z0-9]", "");
                        tmpString.append(txt);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            if (i + 1 < jsonArray.length()) {
                tmpString.append("&");
            }

            if (i + 1 == jsonArray.length()) {
                return tmpString.toString();
            }
        }
        return "";
    }
    public static String numberToString(Number n) {
        String s = n.toString();
        if (s.indexOf('.') > 0) {
            if (s.indexOf('e') < 0 && s.indexOf('E') < 0) {
                while (s.endsWith("0")) {
                    s = s.substring(0, s.length() - 1);
                }
                if (s.endsWith(".")) {
                    s = s.substring(0, s.length() - 1);
                }
            } else {
                NumberFormat formatter = new DecimalFormat();
                formatter.setMaximumFractionDigits(25);
                return formatter.format(n);
            }
        }
        return s;
    }
}