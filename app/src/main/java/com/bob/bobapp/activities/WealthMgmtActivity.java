package com.bob.bobapp.activities;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;

import com.bob.bobapp.BOBApp;
import com.bob.bobapp.Home.BaseContainerFragment;
import com.bob.bobapp.R;
import com.bob.bobapp.adapters.AddressTypeAdapter;
import com.bob.bobapp.adapters.CityAdapter;
import com.bob.bobapp.adapters.CountryAdapter;
import com.bob.bobapp.adapters.GenderAdapter;
import com.bob.bobapp.adapters.GrossIncomeAdapter;
import com.bob.bobapp.adapters.MaritalStatusAdapter;
import com.bob.bobapp.adapters.NationalityAdapter;
import com.bob.bobapp.adapters.OccupationAdapter;
import com.bob.bobapp.adapters.PoliticalExposedAdapter;
import com.bob.bobapp.adapters.StateAdapter;
import com.bob.bobapp.adapters.WealthSourceAdapter;
import com.bob.bobapp.api.APIInterface;
import com.bob.bobapp.api.request_object.CallClientCreationActivationRequest;
import com.bob.bobapp.api.request_object.CallClientCreationActivationRequestBody;
import com.bob.bobapp.api.request_object.FinacleClientDetailsRequest;
import com.bob.bobapp.api.request_object.FinacleClientDetailsRequestBody;
import com.bob.bobapp.api.request_object.GetDropDownDatasForKYCRegisteredRequest;
import com.bob.bobapp.api.response_object.AddressType;
import com.bob.bobapp.api.response_object.AuthenticateResponse;
import com.bob.bobapp.api.response_object.CallClientCreationActivationResponse;
import com.bob.bobapp.api.response_object.City;
import com.bob.bobapp.api.response_object.Country;
import com.bob.bobapp.api.response_object.FinacleClientDetailsResponse;
import com.bob.bobapp.api.response_object.Gender;
import com.bob.bobapp.api.response_object.GetDropDownDatasForKYCRegisteredResponse;
import com.bob.bobapp.api.response_object.GrossAnnIncome;
import com.bob.bobapp.api.response_object.MaritalStatus;
import com.bob.bobapp.api.response_object.NationalitiesResponse;
import com.bob.bobapp.api.response_object.Occupation;
import com.bob.bobapp.api.response_object.PoliticalFigure;
import com.bob.bobapp.api.response_object.SourceOFWealth;
import com.bob.bobapp.api.response_object.State;
import com.bob.bobapp.fragments.BaseFragment;
import com.bob.bobapp.utility.Constants;
import com.bob.bobapp.utility.FontManager;
import com.bob.bobapp.utility.SettingPreferences;
import com.bob.bobapp.utility.Util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

import androidx.fragment.app.Fragment;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WealthMgmtActivity extends BaseFragment {
    private TextView txtCancel, txtNext;
    private AppCompatEditText edtPanNumber, edtName, edtDateOfBirth, edtFatherOrHusbandName, edtMotherMaidenName,
            edtEmail, edtMobile, edtAddress1, edtAddress2, edtAddress3, edtPin, edtBirthPalce, edtINR,
            edtNomineeName, edtNomineeDob, edtRelationship, edtNomineeShare, edtNomineeAddress, edtGurdianName;
    private String panNumber, name, dob, fatherOrHusbandName, motherName, email, mobileNumber, address1, address2,
            address3, pin, birthPlace, inr, nomineeName, nomineeDob, nomineRelationship, nomineeShare,
            nomineeAddress, guardianName;
    private String nationality = "", gender = "", maritalStatus = "", addressType = "", city = "", state = "",
            country = "", occupation = "", politicalExposed = "", grossAnnualIncome = "", wealthSource = "",
            birthCountry = "", isMinor = "true", isNominee = "true";
    private AppCompatSpinner spinnerGender, spinnerMaritalStatus, spineerCity, spineerState, spineerCountry,
            spineerAddressType, spineerOccuptaion, spineerPoliticalExposed, spineerGrossIncome,
            spineerWealthSource, spineerNationality, spineerBirthCountry;
    private RadioButton radioMinorYes, radioMinorNo, radioNimineeYes, radioNimineeNo;
    private APIInterface apiInterface;
    private Util util;
    private GenderAdapter genderAdapter;
    private MaritalStatusAdapter maritalStatusAdapter;
    private CityAdapter cityAdapter;
    private StateAdapter stateAdapter;
    private CountryAdapter countryAdapter;
    private AddressTypeAdapter addressTypeAdapter;
    private OccupationAdapter occupationAdapter;
    private PoliticalExposedAdapter politicalExposedAdapter;
    private GrossIncomeAdapter grossIncomeAdapter;
    private WealthSourceAdapter wealthSourceAdapter;
    private NationalityAdapter nationalityAdapter;
    private ArrayList<Gender> genderArrayList = new ArrayList<>();
    private ArrayList<MaritalStatus> maritalStatusArrayList = new ArrayList<>();
    private ArrayList<City> cityArrayList = new ArrayList<>();
    private ArrayList<State> stateArrayList = new ArrayList<>();
    private ArrayList<Country> countryArrayList = new ArrayList<>();
    private ArrayList<AddressType> addressTypeArrayList = new ArrayList<>();
    private ArrayList<Occupation> occupationArrayList = new ArrayList<>();
    private ArrayList<PoliticalFigure> politicalFigureArrayList = new ArrayList<>();
    private ArrayList<GrossAnnIncome> grossAnnIncomeArrayList = new ArrayList<>();
    private ArrayList<SourceOFWealth> sourceOFWealthArrayList = new ArrayList<>();
    private ArrayList<NationalitiesResponse> nationalitiesResponseArrayList = new ArrayList<>();
    private Calendar calendar;
    int year, month, dayOfMonth;
    private DatePickerDialog datePickerDialog;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        context = getActivity();

        util = new Util(context);

        return inflater.inflate(R.layout.activity_wealth_mgmt, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void getIds(View view) {
        txtCancel = view.findViewById(R.id.txtCancel);
        txtNext = view.findViewById(R.id.txtNext);
        edtPanNumber = view.findViewById(R.id.edtPanNumber);
        edtName = view.findViewById(R.id.edtName);
        edtDateOfBirth = view.findViewById(R.id.edtDateOfBirth);
        edtFatherOrHusbandName = view.findViewById(R.id.edtFatherOrHusbandName);
        edtMotherMaidenName = view.findViewById(R.id.edtMotherMaidenName);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtMobile = view.findViewById(R.id.edtMobile);
        edtAddress1 = view.findViewById(R.id.edtAddress1);
        edtAddress2 = view.findViewById(R.id.edtAddress2);
        edtAddress3 = view.findViewById(R.id.edtAddress3);
        edtPin = view.findViewById(R.id.edtPin);
        edtBirthPalce = view.findViewById(R.id.edtBirthPalce);
        edtINR = view.findViewById(R.id.edtINR);
        edtNomineeName = view.findViewById(R.id.edtNomineeName);
        edtNomineeDob = view.findViewById(R.id.edtNomineeDob);
        edtRelationship = view.findViewById(R.id.edtRelationship);
        edtNomineeShare = view.findViewById(R.id.edtNomineeShare);
        edtNomineeAddress = view.findViewById(R.id.edtNomineeAddress);
        edtGurdianName = view.findViewById(R.id.edtGurdianName);
        radioMinorYes = view.findViewById(R.id.radioMinorYes);
        radioMinorNo = view.findViewById(R.id.radioMinorNo);
        radioNimineeYes = view.findViewById(R.id.radioNimineeYes);
        radioNimineeNo = view.findViewById(R.id.radioNimineeNo);


        spinnerGender = view.findViewById(R.id.spinnerGender);
        spinnerMaritalStatus = view.findViewById(R.id.spinnerMaritalStatus);
        spineerCity = view.findViewById(R.id.spineerCity);
        spineerState = view.findViewById(R.id.spineerState);
        spineerCountry = view.findViewById(R.id.spineerCountry);
        spineerAddressType = view.findViewById(R.id.spineerAddressType);
        spineerOccuptaion = view.findViewById(R.id.spineerOccuptaion);
        spineerPoliticalExposed = view.findViewById(R.id.spineerPoliticalExposed);
        spineerGrossIncome = view.findViewById(R.id.spineerGrossIncome);
        spineerWealthSource = view.findViewById(R.id.spineerWealthSource);
        spineerNationality = view.findViewById(R.id.spineerNationality);
        spineerBirthCountry = view.findViewById(R.id.spineerBirthCountry);

        radioMinorYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isMinor = "true";
                    radioMinorYes.setChecked(true);
                    radioMinorNo.setChecked(false);
                }
            }
        });

        radioMinorNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isMinor = "false";
                    radioMinorYes.setChecked(false);
                    radioMinorNo.setChecked(true);
                }
            }
        });

        radioNimineeYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isNominee = "true";
                    radioNimineeYes.setChecked(true);
                    radioNimineeNo.setChecked(false);
                }
            }
        });
        radioNimineeNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isNominee = "false";
                    radioNimineeYes.setChecked(false);
                    radioNimineeNo.setChecked(true);
                }
            }
        });
    }

    // calendar
    private void onDateCalendar() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        edtDateOfBirth.setText((month + 1) + "/" + day + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }

    // calendar
    private void onDateCalendar1() {
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        datePickerDialog = new DatePickerDialog(context,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        edtNomineeDob.setText((month + 1) + "/" + day + "/" + year);
                    }
                }, year, month, dayOfMonth);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
        datePickerDialog.show();
    }


    @Override
    public void handleListener() {
        BOBActivity.imgBack.setOnClickListener(this);
        txtCancel.setOnClickListener(this);
        txtNext.setOnClickListener(this);
        edtDateOfBirth.setOnClickListener(this);
        edtNomineeDob.setOnClickListener(this);
    }

    @Override
    public void initializations() {
        util = new Util(context);
        BOBActivity.llMenu.setVisibility(View.GONE);
        BOBActivity.title.setText("Wealth Management");
        apiInterface = BOBApp.getApi(context, Constants.ACTION_GET_DROPDOWN);
        // getDropDownApiCall();

        GetFinacleClientDetailsApi();
    }

    @Override
    public void setIcon(Util util) {

    }

    // gender adapter
    private void setGenderAdapter() {
        genderAdapter = new GenderAdapter(context, genderArrayList);
        spinnerGender.setAdapter(genderAdapter);
        for (int i = 0; i < genderArrayList.size(); i++) {
            if (genderArrayList.get(i).getName().equalsIgnoreCase(gender)) {
                spinnerGender.setSelection(i);
            }
        }
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spinnerGender.getSelectedItemPosition();
                gender = genderArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // marital status adapter
    private void setMaritalStatusAdapter() {
        maritalStatusAdapter = new MaritalStatusAdapter(context, maritalStatusArrayList);
        spinnerMaritalStatus.setAdapter(maritalStatusAdapter);
        for (int i = 0; i < maritalStatusArrayList.size(); i++) {
            if (maritalStatusArrayList.get(i).getName().equalsIgnoreCase(maritalStatus)) {
                spinnerMaritalStatus.setSelection(i);
            }
        }

        spinnerMaritalStatus.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spinnerMaritalStatus.getSelectedItemPosition();
                maritalStatus = maritalStatusArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // city  adapter
    private void setCityAdapter() {
        cityAdapter = new CityAdapter(context, cityArrayList);
        spineerCity.setAdapter(cityAdapter);
        for (int i = 0; i < cityArrayList.size(); i++) {
            if (cityArrayList.get(i).getName().equalsIgnoreCase(city)) {
                spineerCity.setSelection(i);
            }
        }
        spineerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerCity.getSelectedItemPosition();
                //   city = cityArrayList.get(pos).getName();
                city = cityArrayList.get(pos).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // state  adapter
    private void setStateAdapter() {
        stateAdapter = new StateAdapter(context, stateArrayList);
        spineerState.setAdapter(stateAdapter);
        for (int i = 0; i < stateArrayList.size(); i++) {
            if (stateArrayList.get(i).getName().equalsIgnoreCase(state)) {
                spineerState.setSelection(i);
            }
        }
        spineerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerState.getSelectedItemPosition();
                // state = stateArrayList.get(pos).getName();
                state = stateArrayList.get(pos).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // country  adapter
    private void setCountryAdapter() {
        countryAdapter = new CountryAdapter(context, countryArrayList);
        spineerCountry.setAdapter(countryAdapter);
        for (int i = 0; i < countryArrayList.size(); i++) {
            if (countryArrayList.get(i).getName().equalsIgnoreCase(country)) {
                spineerCountry.setSelection(i);
            }
        }
        spineerCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerCountry.getSelectedItemPosition();
                // country = countryArrayList.get(pos).getName();
                country = countryArrayList.get(pos).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // birth country  adapter
    private void setBirthCountryAdapter() {
        countryAdapter = new CountryAdapter(context, countryArrayList);
        spineerBirthCountry.setAdapter(countryAdapter);
        for (int i = 0; i < countryArrayList.size(); i++) {
            if (countryArrayList.get(i).getName().equalsIgnoreCase(birthCountry)) {
                spineerBirthCountry.setSelection(i);
            }
        }
        spineerBirthCountry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerBirthCountry.getSelectedItemPosition();
                birthCountry = countryArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // address type  adapter
    private void seAddressTypeAdapter() {
        addressTypeAdapter = new AddressTypeAdapter(context, addressTypeArrayList);
        spineerAddressType.setAdapter(addressTypeAdapter);

        for (int i = 0; i < addressTypeArrayList.size(); i++) {
            if (addressTypeArrayList.get(i).getName().equalsIgnoreCase(addressType)) {
                spineerAddressType.setSelection(i);
            }
        }
        spineerAddressType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerAddressType.getSelectedItemPosition();
                //   addressType = addressTypeArrayList.get(pos).getName();
                addressType = addressTypeArrayList.get(pos).getValue();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // occupation  adapter
    private void setOccupationAdapter() {
        occupationAdapter = new OccupationAdapter(context, occupationArrayList);
        spineerOccuptaion.setAdapter(occupationAdapter);

        for (int i = 0; i < occupationArrayList.size(); i++) {
            if (occupationArrayList.get(i).getName().equalsIgnoreCase(occupation)) {
                spineerOccuptaion.setSelection(i);
            }
        }
        spineerOccuptaion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerOccuptaion.getSelectedItemPosition();
                occupation = occupationArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    // political exposed  adapter
    private void setPoliticalExposedAdapter() {
        politicalExposedAdapter = new PoliticalExposedAdapter(context, politicalFigureArrayList);
        spineerPoliticalExposed.setAdapter(politicalExposedAdapter);

        for (int i = 0; i < politicalFigureArrayList.size(); i++) {
            if (politicalFigureArrayList.get(i).getName().equalsIgnoreCase(politicalExposed)) {
                spineerPoliticalExposed.setSelection(i);
            }
        }
        spineerPoliticalExposed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerPoliticalExposed.getSelectedItemPosition();
                politicalExposed = politicalFigureArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // gross income  adapter
    private void setGrossIncomeAdapter() {
        grossIncomeAdapter = new GrossIncomeAdapter(context, grossAnnIncomeArrayList);
        spineerGrossIncome.setAdapter(grossIncomeAdapter);

        for (int i = 0; i < grossAnnIncomeArrayList.size(); i++) {
            if (grossAnnIncomeArrayList.get(i).getName().equalsIgnoreCase(grossAnnualIncome)) {
                spineerGrossIncome.setSelection(i);
            }
        }
        spineerGrossIncome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerGrossIncome.getSelectedItemPosition();
                grossAnnualIncome = grossAnnIncomeArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // wealth source adapter
    private void setWealthSourceAdapter() {
        wealthSourceAdapter = new WealthSourceAdapter(context, sourceOFWealthArrayList);
        spineerWealthSource.setAdapter(wealthSourceAdapter);

        for (int i = 0; i < sourceOFWealthArrayList.size(); i++) {
            if (sourceOFWealthArrayList.get(i).getName().equalsIgnoreCase(wealthSource)) {
                spineerWealthSource.setSelection(i);
            }
        }
        spineerWealthSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerWealthSource.getSelectedItemPosition();
                wealthSource = sourceOFWealthArrayList.get(pos).getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

    }

    // nationality adapter
    private void setNationalityAdapter() {
        nationalityAdapter = new NationalityAdapter(context, nationalitiesResponseArrayList);
        spineerNationality.setAdapter(nationalityAdapter);
        for (int i = 0; i < nationalitiesResponseArrayList.size(); i++) {
            if (nationalitiesResponseArrayList.get(i).getCountryName().equalsIgnoreCase(nationality)) {
                spineerNationality.setSelection(i);
            }
        }

        spineerNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                int pos = spineerNationality.getSelectedItemPosition();
                nationality = nationalitiesResponseArrayList.get(pos).getCountryName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.menu) {
            getActivity().onBackPressed();
        } else if (id == R.id.txtCancel) {
            getActivity().onBackPressed();
        } else if (id == R.id.txtNext) {
            String result = validationForm();
            if (result.equalsIgnoreCase("success")) {
                CallClientCreationActivationApi();
            } else {
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
            }
        } else if (id == R.id.edtDateOfBirth) {
            onDateCalendar();
        } else if (id == R.id.edtNomineeDob) {
            onDateCalendar1();
        }if (id == R.id.imgBack) {
            getActivity().onBackPressed();
        }
    }

    // apply validation here...
    private String validationForm() {
        String result = "";
        panNumber = edtPanNumber.getText().toString().trim();
        name = edtName.getText().toString().trim();
        dob = edtDateOfBirth.getText().toString().trim();
        fatherOrHusbandName = edtFatherOrHusbandName.getText().toString().trim();
        motherName = edtMotherMaidenName.getText().toString().trim();
        email = edtEmail.getText().toString().trim();
        mobileNumber = edtMobile.getText().toString().trim();
        address1 = edtAddress1.getText().toString().trim();
        address2 = edtAddress2.getText().toString().trim();
        address3 = edtAddress3.getText().toString().trim();
        pin = edtPin.getText().toString().trim();
        birthPlace = edtBirthPalce.getText().toString().trim();
        inr = edtINR.getText().toString().trim();
        nomineeName = edtNomineeName.getText().toString().trim();
        nomineeDob = edtNomineeDob.getText().toString().trim();
        nomineRelationship = edtRelationship.getText().toString().trim();
        nomineeShare = edtNomineeShare.getText().toString().trim();
        nomineeAddress = edtNomineeAddress.getText().toString().trim();
        guardianName = edtGurdianName.getText().toString().trim();
        if (TextUtils.isEmpty(panNumber)) {
            edtPanNumber.setFocusable(true);
            edtPanNumber.requestFocus();
            return getString(R.string.enter_pan_no);
        }
        if (TextUtils.isEmpty(name)) {
            edtName.setFocusable(true);
            edtName.requestFocus();
            return getString(R.string.enter_name);
        }
        if (TextUtils.isEmpty(dob)) {
            edtDateOfBirth.setFocusable(true);
            edtDateOfBirth.requestFocus();
            return getString(R.string.enter_dob);
        }
        if (TextUtils.isEmpty(fatherOrHusbandName)) {
            edtFatherOrHusbandName.setFocusable(true);
            edtFatherOrHusbandName.requestFocus();
            return getString(R.string.enter_husband);
        }

        if (TextUtils.isEmpty(motherName)) {
            edtMotherMaidenName.setFocusable(true);
            edtMotherMaidenName.requestFocus();
            return getString(R.string.enter_mother);
        }
        if (TextUtils.isEmpty(email)) {
            edtEmail.setFocusable(true);
            edtEmail.requestFocus();
            return getString(R.string.enter_email);
        }
        if (TextUtils.isEmpty(mobileNumber)) {
            edtMobile.setFocusable(true);
            edtMobile.requestFocus();
            return getString(R.string.enter_mobile);
        }
        if (TextUtils.isEmpty(address1)) {
            edtAddress1.setFocusable(true);
            edtAddress1.requestFocus();
            return getString(R.string.enter_address);
        }
        if (TextUtils.isEmpty(pin)) {
            edtPin.setFocusable(true);
            edtPin.requestFocus();
            return getString(R.string.enter_pin_code);
        }
        if (TextUtils.isEmpty(birthPlace)) {
            edtBirthPalce.setFocusable(true);
            edtBirthPalce.requestFocus();
            return getString(R.string.enter_birth_place);
        }
        if (TextUtils.isEmpty(inr)) {
            edtINR.setFocusable(true);
            edtINR.requestFocus();
            return getString(R.string.enter_inr);
        }

        return result = "success";
    }

    // api call
    private void GetFinacleClientDetailsApi() {

        util.showProgressDialog(context, true);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;


        FinacleClientDetailsRequestBody requestBody = new FinacleClientDetailsRequestBody();
        requestBody.setpInfinityID(authenticateResponse.getClientUCC());
       // requestBody.setpInfinityID("BJF002853");

        FinacleClientDetailsRequest model = new FinacleClientDetailsRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.GetFinacleClientDetails(model).enqueue(new Callback<FinacleClientDetailsResponse>() {
            @Override
            public void onResponse(Call<FinacleClientDetailsResponse> call, Response<FinacleClientDetailsResponse> response) {

                //    util.showProgressDialog(InvestmentCartActivity.this, false);

                if (response.isSuccessful()) {
                    edtPanNumber.setText(response.body().getPAN());
                    edtName.setText(response.body().getName());
                    edtDateOfBirth.setText(response.body().getBirthDt());
                    edtFatherOrHusbandName.setText(response.body().getFatherOrHusbandName());
                    edtMotherMaidenName.setText(response.body().getMotherName());
                    edtEmail.setText(response.body().getEmail());
                    edtMobile.setText(response.body().getMobNo());
                    edtAddress1.setText(response.body().getMAddrLine1());
                    edtAddress2.setText(response.body().getMAddrLine2());
                    edtAddress3.setText(response.body().getMAddrLine3());
                    edtPin.setText(response.body().getMPostalCode());
                    edtBirthPalce.setText(response.body().getBirthPlace());
                    edtINR.setText(response.body().getEstimatedFinancialGrowth());
                    nationality = response.body().getNationality();
                    gender = response.body().getGender();
                    maritalStatus = response.body().getMaritalStatus();
                    addressType = response.body().getAddressType();
                    city = response.body().getMCity();
                    state = response.body().getMState();
                    country = response.body().getMCountry();
                    occupation = response.body().getOccupationcode();
                    politicalExposed = response.body().getPoliticallyExposed();
                    grossAnnualIncome = response.body().getGrossannualincome();
                    wealthSource = response.body().getWealthSource();
                    birthCountry = response.body().getBirthCountry();
                    getDropDownApiCall();

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<FinacleClientDetailsResponse> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // api calling
    private void getDropDownApiCall() {
        //   util.showProgressDialog(this, true);

        GetDropDownDatasForKYCRegisteredRequest model = new GetDropDownDatasForKYCRegisteredRequest();
        //  model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.GetDropDownDatasForKYCRegistered(model).enqueue(new Callback<GetDropDownDatasForKYCRegisteredResponse>() {
            @Override
            public void onResponse(Call<GetDropDownDatasForKYCRegisteredResponse> call, Response<GetDropDownDatasForKYCRegisteredResponse> response) {

                //  util.showProgressDialog(WealthMgmtActivity.this, false);

                if (response.isSuccessful()) {
                    // gender
                    genderArrayList = response.body().getGender();
                    setGenderAdapter();

                    // marital status
                    maritalStatusArrayList = response.body().getMaritalStatus();
                    setMaritalStatusAdapter();

                    // city adapter;
                    cityArrayList = response.body().getCity();
                    setCityAdapter();

                    //state
                    stateArrayList = response.body().getState();
                    setStateAdapter();

                    // country
                    countryArrayList = response.body().getCountry();
                    setCountryAdapter();
                    setBirthCountryAdapter();

                    // address type
                    addressTypeArrayList = response.body().getAddressType();
                    seAddressTypeAdapter();

                    //occupation adapter
                    occupationArrayList = response.body().getOccupation();
                    setOccupationAdapter();

                    //political exposed
                    politicalFigureArrayList = response.body().getPoliticalFigure();
                    setPoliticalExposedAdapter();

                    // gross income
                    grossAnnIncomeArrayList = response.body().getGrossAnnIncome();
                    setGrossIncomeAdapter();

                    // wealth souce
                    sourceOFWealthArrayList = response.body().getSourceOFWealth();
                    setWealthSourceAdapter();

                    //api call
                    getNationalityDropDownApiCall();

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetDropDownDatasForKYCRegisteredResponse> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // api calling
    private void getNationalityDropDownApiCall() {

        GetDropDownDatasForKYCRegisteredRequest model = new GetDropDownDatasForKYCRegisteredRequest();
        //  model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.getNationalities(model).enqueue(new Callback<ArrayList<NationalitiesResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<NationalitiesResponse>> call, Response<ArrayList<NationalitiesResponse>> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {
                    nationalitiesResponseArrayList = response.body();
                    setNationalityAdapter();

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ArrayList<NationalitiesResponse>> call, Throwable t) {
                util.showProgressDialog(context, false);
//                       Toast.makeText(WealthMgmtActivity.this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }


    // CallClientCreationActivation api call
    private void CallClientCreationActivationApi() {

        util.showProgressDialog(context, true);
        UUID uuid = UUID.randomUUID();
        String uniqueIdentifier = String.valueOf(uuid);

        AuthenticateResponse authenticateResponse = BOBActivity.authResponse;


        CallClientCreationActivationRequestBody requestBody = new CallClientCreationActivationRequestBody();

        requestBody.setpInfinityID(authenticateResponse.getClientUCC());
     //   requestBody.setpInfinityID("BJF002853");
        requestBody.setConstitutionCode("");
        requestBody.setClientStatus("");
        requestBody.setCustStatus("");
        requestBody.setClientTaxId("");
        requestBody.setDateofIncorporation("");
        requestBody.setIsNRE("");
        requestBody.setPAN(panNumber);
        requestBody.setName(name);
        requestBody.setFirstName(name);
        requestBody.setMiddleName("");
        requestBody.setLastName("");
        requestBody.setBirthDt(dob);
        requestBody.setGender(gender);
        requestBody.setDefaultAddrType("");
        requestBody.setPassportNum("");
        requestBody.setMotherName(motherName);
        requestBody.setFatherOrHusbandName(fatherOrHusbandName);
        requestBody.setNationality(nationality);
        requestBody.setEmail(email);
        requestBody.setMobNo(mobileNumber);
        requestBody.setMAddrLine1(address1);
        requestBody.setMAddrLine2(address2);
        requestBody.setMAddrLine3(address3);
        requestBody.setMCity(city);
        requestBody.setMState(state);
        requestBody.setMCountry(country);
        requestBody.setMPostalCode(pin);
        requestBody.setUCC("");
        requestBody.setKYCVerified("");
        requestBody.setKYCVerified("false");
        requestBody.setKYCDescription("");
        requestBody.setTitle("MR.");
        requestBody.setMaritalStatus(maritalStatus);
        requestBody.setAddressType(addressType);
        requestBody.setErrorMessage("");
        requestBody.setBirthPlace(birthPlace);
        requestBody.setBirthCountry(birthCountry);
        requestBody.setPoliticallyExposed(politicalExposed);
        requestBody.setGrossannualincome(grossAnnualIncome);
        requestBody.setWealthSource(wealthSource);
        requestBody.setEstimatedFinancialGrowth(inr);
        requestBody.setOccupation("");
        requestBody.setOccupation_code("");
        requestBody.setPan_no1("");
        requestBody.setEmail1("");
        requestBody.setOccupation("2");
        requestBody.setPin(pin);
        requestBody.setIsofflineclient("0");
        requestBody.setClientIP("49.32.167.152");

        requestBody.setIsApplyNominee(isNominee);

        requestBody.setNomineeName1(nomineeName);
        requestBody.setDateOfBirth1(nomineeDob);
        requestBody.setNomineeRelationship1(nomineRelationship);
        requestBody.setNomineeShare1(nomineeShare);
        requestBody.setNomineeAddress1(nomineeAddress);
        requestBody.setNomineeIsMinor1(isMinor);

        requestBody.setDateOfBirth2("");
        requestBody.setNomineeShare2("0.0");
        requestBody.setNomineeIsMinor2("false");

        requestBody.setDateOfBirth3("");
        requestBody.setNomineeShare3("0.0");
        requestBody.setNomineeIsMinor3("false");


        CallClientCreationActivationRequest model = new CallClientCreationActivationRequest();
        model.setRequestBodyObject(requestBody);
        model.setSource(Constants.SOURCE);


        SettingPreferences.setRequestUniqueIdentifier(context, uniqueIdentifier);
        model.setUniqueIdentifier(uniqueIdentifier);


        apiInterface.CallClientCreationActivation(model).enqueue(new Callback<CallClientCreationActivationResponse>() {
            @Override
            public void onResponse(Call<CallClientCreationActivationResponse> call, Response<CallClientCreationActivationResponse> response) {

                util.showProgressDialog(context, false);

                if (response.isSuccessful()) {
                    replaceFragment(new TermsAndConditionActivity());
//                    if (response.body().getClientCode().equalsIgnoreCase("1")) {
//
//                    }

                } else {
                    Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CallClientCreationActivationResponse> call, Throwable t) {
                util.showProgressDialog(context, false);
                Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void replaceFragment(Fragment fragment) {

        ((BaseContainerFragment)getParentFragment()).replaceFragment(fragment, true);
    }


}
