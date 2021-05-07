package com.bob.bobapp.utility;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.TextView;

import com.bob.bobapp.R;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static android.graphics.Typeface.BOLD;

public class Util {

    public static boolean isAlert = false;


    public static Typeface iconFont;

    private Context context;

    public Util(Context context){

        this.context = context;

        iconFont = FontManager.getTypeface(context, FontManager.FONTAWESOME);
    }

    public String callAPIUrlWithPost(String strUrl){

        strUrl = strUrl.replaceAll(" ", "%20");

        System.out.println("URLLLLLLLLLLLLLL :"+strUrl);

        String data = "";

        InputStream iStream = null;

        try{

            URL url = new URL(strUrl);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setReadTimeout(15000);

            urlConnection.setConnectTimeout(15000);

            urlConnection.setRequestMethod("POST");

            urlConnection.setDoInput(true);

            urlConnection.setDoOutput(true);

            urlConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            urlConnection.setRequestProperty("Accept", "application/json");

            urlConnection.connect();

            iStream = urlConnection.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));

            StringBuffer sb  = new StringBuffer();

            String line = "";

            while( ( line = br.readLine())  != null){

                sb.append(line);
            }

            data = sb.toString();

            br.close();

        }catch(Exception e){

            /*data = new Gson().toJson(createResponseOnConnectionFail());

            System.out.println("ON CONNECTION FAIL POST URL :" + data);*/

            e.printStackTrace();
        }

        return data;
    }

    public String httpPostJsonRequestForMATM(String strUrl, String jsonObject){


        InputStream inputStream = null;

        String result = "";

        try {

            URL url = new URL(strUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(15000);

            conn.setConnectTimeout(15000);

            conn.setRequestMethod("POST");

            conn.setDoInput(true);

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            conn.setRequestProperty("Accept", "application/json");

            conn.connect();

            OutputStream os = new BufferedOutputStream(conn.getOutputStream());

            os.write(jsonObject.getBytes());

            os.flush();

            inputStream = conn.getInputStream();

            if(inputStream != null){

                result = convertInputStreamToString(inputStream);
            }
            else{

                result = "Did not work!";
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    public String authorize(String userName, String userType)  {

        String authorization="";

        try {

            String passbuffer = userName + ":" + userType;

            byte[] data = passbuffer.getBytes("UTF-8");

            String base64 = Base64.encodeToString(data, Base64.NO_WRAP);

            authorization = "Basic " + base64;

        }catch (UnsupportedEncodingException ex){

            ex.printStackTrace();
        }

        return authorization;
    }

    public String httpPostJsonRequest(String strUrl, String jsonObject){

        String auth = authorize("Ebix", "Ebix@2019");

        InputStream inputStream = null;

        String result = "";

        try {

            URL url = new URL(strUrl);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setReadTimeout(60000);

            conn.setConnectTimeout(60000);

            conn.setRequestMethod("POST");

            conn.setDoInput(true);

            conn.setDoOutput(true);

            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

            conn.setRequestProperty("Accept", "application/json");

            conn.setRequestProperty("Authorization", auth);

            conn.connect();

            OutputStream os = new BufferedOutputStream(conn.getOutputStream());

            os.write(jsonObject.getBytes());

            os.flush();

            inputStream = conn.getInputStream();

            if(inputStream != null){

                result = convertInputStreamToString(inputStream);
            }
            else{

                result = "Did not work!";
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return result;
    }

    private String convertInputStreamToString(InputStream inputStream) throws IOException {

        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));

        String line = "";

        String result = "";

        while((line = bufferedReader.readLine()) != null) {

            result += line;
        }

        inputStream.close();

        return result;
    }

    public JSONObject createJsonObject(LinkedHashMap<String, String> map){

        JSONObject jsonObject = new JSONObject();

        try {

            for (Map.Entry<String, String> entry : map.entrySet()) {

                String key = entry.getKey();

                String value = entry.getValue();

                jsonObject.put(key, value);
            }

        }catch(Exception e){

            e.printStackTrace();
        }

        return jsonObject;
    }

    public void alertboxConnectivity(String title, String mymessage) {

        TextView textView = new TextView(context);

        textView.setText(title);

        textView.setPadding(70,20,10,10);

        textView.setTypeface(null,BOLD);

        textView.setTextSize(18);

        new AlertDialog.Builder(context)

                .setMessage(mymessage)

                .setCustomTitle(textView)

                .setCancelable(false)

                .setNeutralButton(android.R.string.ok,

                        new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {


                            }

                        }).show();
    }

    public String validateData(LinkedHashMap<String, String> linkedHashMap){

        String validateStr = "";

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()) {

            String key = entry.getKey();

            String value = entry.getValue();

            if(value.equals("")){

                if(key.equalsIgnoreCase("Terms and Conditions")){

                    validateStr += "Please accept " + key + ".\n";

                }else if(key.contains("select")){

                    validateStr += "Please " + key + ".\n";

                }else {

                    validateStr += "Please enter " + key + ".\n";
                }
            }
        }

        return validateStr;
    }

    public String getXMLRequest(String startNode, LinkedHashMap<String, String> linkedHashMap){

        String xml = "<" + startNode + ">";

        for (Map.Entry<String,String> entry : linkedHashMap.entrySet()) {

            String key = entry.getKey();

            String value = entry.getValue();

            xml += "<" + key + ">" + value + "</" + key + ">";
        }

        xml += "</" + startNode + ">";

        return xml;
    }

    public boolean checkInternetConnection() {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isAvailable() && cm.getActiveNetworkInfo().isConnected()) {

            return true;

        } else {

            return false;
        }
    }

    static ProgressDialog dialog = null;

    public static void showProgressDialog(Context context, boolean isShow) {

        try {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if (dialog == null && isShow) {

                dialog = ProgressDialog.show(context, null, null);

                dialog.setContentView(R.layout.small_progress_bar);

                dialog.setProgressStyle(android.R.style.Widget_ProgressBar);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();

                lp.dimAmount = 0.0f;

                dialog.getWindow().setAttributes(lp);

                dialog.getWindow().addFlags(WindowManager.LayoutParams.ALPHA_CHANGED);

                dialog.setCancelable(false);

                dialog.setCanceledOnTouchOutside(false);

                dialog.show();

            } else {

                if (dialog != null && dialog.isShowing()) {

                    dialog.dismiss();

                    dialog = null;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public String formatDate(String value){

        System.out.println("DATE VALUE: "+value);

        String formattedDate = "";

        String valueArray[] = value.split("T");

        String dateArray[] = valueArray[0].split("-");

        String date = dateArray[2];

        String month = dateArray[1];

        String year = dateArray[0];

        Calendar c = Calendar.getInstance();

        c.set(Integer.parseInt(year), Integer.parseInt(month) - 1, Integer.parseInt(date));

        DateFormat dateFormat=new SimpleDateFormat("dd MMM");

        formattedDate = dateFormat.format(c.getTime());

        return formattedDate;
    }

    public String getCurrentDate(boolean getIsBefore){
        //2020-01-07T00:00:00

        String formatedDate = "";

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Calendar cal = Calendar.getInstance();

        if(getIsBefore) {

            cal.add(Calendar.DATE, -7);
        }

        Date date = cal.getTime();

        formatedDate = dateFormat.format(date);

        return formatedDate;
    }

    public BigDecimal truncateDecimal(double x){

        if ( x > 0) {

            return new BigDecimal(String.valueOf(x)).setScale(2, BigDecimal.ROUND_FLOOR);

        } else {

            return new BigDecimal(String.valueOf(x)).setScale(2, BigDecimal.ROUND_CEILING);
        }
    }

    public String formatDateForFactsheet(String strDate) {

        String ddate = null;

        try {

            SimpleDateFormat dFormat = new SimpleDateFormat("yyyyMMdd");

            SimpleDateFormat dFormatFinal = new SimpleDateFormat("MMM dd, yyyy");

            Date date = dFormat.parse(strDate);

            ddate = dFormatFinal.format(date);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return ddate;
    }
}
