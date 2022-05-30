package com.expo.euphonic.invoice.beta;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import java.util.HashMap;
import java.util.ArrayList;
import android.widget.ScrollView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.view.View;
import android.widget.AdapterView;
import android.text.Editable;
import android.text.TextWatcher;
import java.text.DecimalFormat;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class CreateActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private double v1 = 0;
	private double v2 = 0;
	private double v3 = 0;
	private double v4 = 0;
	private double v5 = 0;
	private double v6 = 0;
	private double v7 = 0;
	private double v8 = 0;
	private double price = 0;
	private double tot_price = 0;
	private double tot_qty = 0;
	private double v9 = 0;
	private String invno_pos = "";
	private String loc_pos = "";
	private String finyr_pos = "";
	private double test = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private double run = 0;
	private double year = 0;
	private double day = 0;
	private double month = 0;
	
	private ArrayList<String> spin1 = new ArrayList<>();
	private ArrayList<String> spin2 = new ArrayList<>();
	private ArrayList<String> spin3 = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> maplist = new ArrayList<>();
	private ArrayList<String> invoice = new ArrayList<>();
	
	private ScrollView vscroll1;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear32;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview8;
	private EditText add;
	private LinearLayout linear13;
	private LinearLayout linear4;
	private LinearLayout linear10;
	private LinearLayout linear29;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private LinearLayout linear8;
	private LinearLayout linear11;
	private LinearLayout linear26;
	private LinearLayout linear30;
	private LinearLayout linear23;
	private TextView textview29;
	private LinearLayout linear24;
	private TextView textview30;
	private LinearLayout linear25;
	private LinearLayout linear14;
	private Button button3;
	private TextView logic;
	private TextView textview1;
	private TextView textview2;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview32;
	private EditText code;
	private TextView textview33;
	private EditText state;
	private TextView textview9;
	private EditText lnvno;
	private TextView textview10;
	private EditText bookno;
	private TextView textview15;
	private EditText dinv_a;
	private TextView textview37;
	private EditText dinv_b;
	private TextView textview38;
	private EditText dinv_c;
	private ImageView imageview5;
	private TextView textview35;
	private EditText finyr;
	private TextView textview11;
	private EditText through;
	private ImageView imageview1;
	private TextView textview12;
	private EditText odno;
	private Spinner spinner1;
	private TextView textview16;
	private EditText dod_a;
	private TextView textview39;
	private EditText dod_b;
	private TextView textview40;
	private EditText dod_c;
	private ImageView imageview4;
	private TextView textview13;
	private EditText car;
	private Spinner spinner2;
	private TextView textview14;
	private LinearLayout linear27;
	private EditText boxesno;
	private ImageView imageview3;
	private ImageView imageview2;
	private TextView textview17;
	private EditText mrs;
	private Spinner spinner3;
	private TextView textview31;
	private EditText transcharg;
	private TextView textview36;
	private EditText edittext1;
	private TextView textview20;
	private EditText loc;
	private EditText dii;
	private EditText tii;
	private EditText drg;
	private EditText trg;
	private TextView textview19;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private LinearLayout linear28;
	private TextView textview21;
	private EditText p1;
	private EditText q1;
	private EditText r1;
	private TextView textview22;
	private EditText p2;
	private EditText q2;
	private EditText r2;
	private TextView textview23;
	private EditText p3;
	private EditText q3;
	private EditText r3;
	private TextView textview24;
	private EditText p4;
	private EditText q4;
	private EditText r4;
	private TextView textview25;
	private EditText p5;
	private EditText q5;
	private EditText r5;
	private TextView textview26;
	private EditText p6;
	private EditText q6;
	private EditText r6;
	private TextView textview27;
	private EditText p7;
	private EditText q7;
	private EditText r7;
	private TextView textview28;
	private EditText p8;
	private EditText q8;
	private EditText r8;
	private TextView textview34;
	private EditText p9;
	private EditText q9;
	private EditText r9;
	
	private Intent i = new Intent();
	private RequestNetwork net;
	private RequestNetwork.RequestListener _net_request_listener;
	private SharedPreferences data;
	private Calendar cal = Calendar.getInstance();
	private AlertDialog.Builder dia;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private AlertDialog.Builder dialog;
	private DatabaseReference db = _firebase.getReference("expo-inv/General_Info");
	private ChildEventListener _db_child_listener;
	private DatabaseReference inv = _firebase.getReference("expo-inv/Invoices");
	private ChildEventListener _inv_child_listener;
	private AlertDialog.Builder check;
	private AlertDialog.Builder d;
	private Calendar c = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.create);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		textview8 = (TextView) findViewById(R.id.textview8);
		add = (EditText) findViewById(R.id.add);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		textview29 = (TextView) findViewById(R.id.textview29);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		textview30 = (TextView) findViewById(R.id.textview30);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		button3 = (Button) findViewById(R.id.button3);
		logic = (TextView) findViewById(R.id.logic);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview32 = (TextView) findViewById(R.id.textview32);
		code = (EditText) findViewById(R.id.code);
		textview33 = (TextView) findViewById(R.id.textview33);
		state = (EditText) findViewById(R.id.state);
		textview9 = (TextView) findViewById(R.id.textview9);
		lnvno = (EditText) findViewById(R.id.lnvno);
		textview10 = (TextView) findViewById(R.id.textview10);
		bookno = (EditText) findViewById(R.id.bookno);
		textview15 = (TextView) findViewById(R.id.textview15);
		dinv_a = (EditText) findViewById(R.id.dinv_a);
		textview37 = (TextView) findViewById(R.id.textview37);
		dinv_b = (EditText) findViewById(R.id.dinv_b);
		textview38 = (TextView) findViewById(R.id.textview38);
		dinv_c = (EditText) findViewById(R.id.dinv_c);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview35 = (TextView) findViewById(R.id.textview35);
		finyr = (EditText) findViewById(R.id.finyr);
		textview11 = (TextView) findViewById(R.id.textview11);
		through = (EditText) findViewById(R.id.through);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview12 = (TextView) findViewById(R.id.textview12);
		odno = (EditText) findViewById(R.id.odno);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		textview16 = (TextView) findViewById(R.id.textview16);
		dod_a = (EditText) findViewById(R.id.dod_a);
		textview39 = (TextView) findViewById(R.id.textview39);
		dod_b = (EditText) findViewById(R.id.dod_b);
		textview40 = (TextView) findViewById(R.id.textview40);
		dod_c = (EditText) findViewById(R.id.dod_c);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview13 = (TextView) findViewById(R.id.textview13);
		car = (EditText) findViewById(R.id.car);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		textview14 = (TextView) findViewById(R.id.textview14);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		boxesno = (EditText) findViewById(R.id.boxesno);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview17 = (TextView) findViewById(R.id.textview17);
		mrs = (EditText) findViewById(R.id.mrs);
		spinner3 = (Spinner) findViewById(R.id.spinner3);
		textview31 = (TextView) findViewById(R.id.textview31);
		transcharg = (EditText) findViewById(R.id.transcharg);
		textview36 = (TextView) findViewById(R.id.textview36);
		edittext1 = (EditText) findViewById(R.id.edittext1);
		textview20 = (TextView) findViewById(R.id.textview20);
		loc = (EditText) findViewById(R.id.loc);
		dii = (EditText) findViewById(R.id.dii);
		tii = (EditText) findViewById(R.id.tii);
		drg = (EditText) findViewById(R.id.drg);
		trg = (EditText) findViewById(R.id.trg);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		textview21 = (TextView) findViewById(R.id.textview21);
		p1 = (EditText) findViewById(R.id.p1);
		q1 = (EditText) findViewById(R.id.q1);
		r1 = (EditText) findViewById(R.id.r1);
		textview22 = (TextView) findViewById(R.id.textview22);
		p2 = (EditText) findViewById(R.id.p2);
		q2 = (EditText) findViewById(R.id.q2);
		r2 = (EditText) findViewById(R.id.r2);
		textview23 = (TextView) findViewById(R.id.textview23);
		p3 = (EditText) findViewById(R.id.p3);
		q3 = (EditText) findViewById(R.id.q3);
		r3 = (EditText) findViewById(R.id.r3);
		textview24 = (TextView) findViewById(R.id.textview24);
		p4 = (EditText) findViewById(R.id.p4);
		q4 = (EditText) findViewById(R.id.q4);
		r4 = (EditText) findViewById(R.id.r4);
		textview25 = (TextView) findViewById(R.id.textview25);
		p5 = (EditText) findViewById(R.id.p5);
		q5 = (EditText) findViewById(R.id.q5);
		r5 = (EditText) findViewById(R.id.r5);
		textview26 = (TextView) findViewById(R.id.textview26);
		p6 = (EditText) findViewById(R.id.p6);
		q6 = (EditText) findViewById(R.id.q6);
		r6 = (EditText) findViewById(R.id.r6);
		textview27 = (TextView) findViewById(R.id.textview27);
		p7 = (EditText) findViewById(R.id.p7);
		q7 = (EditText) findViewById(R.id.q7);
		r7 = (EditText) findViewById(R.id.r7);
		textview28 = (TextView) findViewById(R.id.textview28);
		p8 = (EditText) findViewById(R.id.p8);
		q8 = (EditText) findViewById(R.id.q8);
		r8 = (EditText) findViewById(R.id.r8);
		textview34 = (TextView) findViewById(R.id.textview34);
		p9 = (EditText) findViewById(R.id.p9);
		q9 = (EditText) findViewById(R.id.q9);
		r9 = (EditText) findViewById(R.id.r9);
		net = new RequestNetwork(this);
		data = getSharedPreferences("expo | INV", Activity.MODE_PRIVATE);
		dia = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		dialog = new AlertDialog.Builder(this);
		check = new AlertDialog.Builder(this);
		d = new AlertDialog.Builder(this);
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!p1.getText().toString().equals("") && (!q1.getText().toString().equals("") && (!r1.getText().toString().equals("") && !lnvno.getText().toString().equals("")))) {
					
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Error!!!");
				}
				if (invoice.contains("1".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))) {
					check.setTitle("Warning!!!");
					check.setMessage("Do You Want To Overwrite Invoice No. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString()))));
					check.setPositiveButton("Overwrite", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							if (FileUtil.isFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("1".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))))) {
								FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("1".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))));
							}
							if (FileUtil.isFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("2".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))))) {
								FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("2".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))));
							}
							if (FileUtil.isFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("3".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))))) {
								FileUtil.deleteFile(FileUtil.getExternalStorageDir().concat("/expo-INV/Fy ".concat(finyr.getText().toString().concat(" ~ ".concat(String.valueOf((long)(Double.parseDouble(finyr.getText().toString()) + 1)).concat("/Invoice no. ".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat("/".concat("3".concat(new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4)))))))))))))));
							}
							_cloud();
							_details();
							_product();
							_calculate();
						}
					});
					check.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							lnvno.setText(String.valueOf((long)(Double.parseDouble(maplist.get((int)0).get("Invno").toString()) + 1)));
						}
					});
					check.create().show();
				}
				else {
					_cloud();
					_details();
					_product();
					_calculate();
				}
			}
		});
		
		code.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (code.getText().toString().trim().equals("09")) {
					linear30.setVisibility(View.GONE);
				}
				else {
					linear30.setVisibility(View.VISIBLE);
				}
				if (!lnvno.getText().toString().equals("")) {
					lnvno.setText("");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		lnvno.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!lnvno.getText().toString().equals("")) {
					if ((Double.parseDouble(lnvno.getText().toString()) < 51) && (Double.parseDouble(lnvno.getText().toString()) > 0)) {
						bookno.setText("1");
					}
					else {
						if ((Double.parseDouble(lnvno.getText().toString()) < 101) && (Double.parseDouble(lnvno.getText().toString()) > 49)) {
							bookno.setText("2");
						}
						else {
							if ((Double.parseDouble(lnvno.getText().toString()) < 151) && (Double.parseDouble(lnvno.getText().toString()) > 99)) {
								bookno.setText("3");
							}
							else {
								if ((Double.parseDouble(lnvno.getText().toString()) < 201) && (Double.parseDouble(lnvno.getText().toString()) > 149)) {
									bookno.setText("3");
								}
								else {
									if ((Double.parseDouble(lnvno.getText().toString()) < 251) && (Double.parseDouble(lnvno.getText().toString()) > 199)) {
										bookno.setText("4");
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Invalid invoice no.");
									}
								}
							}
						}
					}
					if (code.getText().toString().equals("01")) {
						state.setText("Jammu & Kashmir");
					}
					if (code.getText().toString().equals("02")) {
						state.setText("Himachal Pradesh");
					}
					if (code.getText().toString().equals("03")) {
						state.setText("Punjab");
					}
					if (code.getText().toString().equals("04")) {
						state.setText("Chandigarh");
					}
					if (code.getText().toString().equals("05")) {
						state.setText("Uttarakhand");
					}
					if (code.getText().toString().equals("06")) {
						state.setText("Haryana");
					}
					if (code.getText().toString().equals("07")) {
						state.setText("DELHI");
					}
					if (code.getText().toString().equals("08")) {
						state.setText("Rajasthan");
					}
					if (code.getText().toString().equals("09")) {
						state.setText("Uttar Pradesh");
					}
					if (code.getText().toString().equals("10")) {
						state.setText("Bihar");
					}
					if (code.getText().toString().equals("11")) {
						state.setText("Sikkim");
					}
					if (code.getText().toString().equals("12")) {
						state.setText("Arunachal Pradesh");
					}
					if (code.getText().toString().equals("13")) {
						state.setText("Nagaland");
					}
					if (code.getText().toString().equals("14")) {
						state.setText("Manipur");
					}
					if (code.getText().toString().equals("15")) {
						state.setText("Mizoram");
					}
					if (code.getText().toString().equals("16")) {
						state.setText("Tripura");
					}
					if (code.getText().toString().equals("17")) {
						state.setText("Meghalaya");
					}
					if (code.getText().toString().equals("18")) {
						state.setText("Assam");
					}
					if (code.getText().toString().equals("19")) {
						state.setText("West Bengal");
					}
					if (code.getText().toString().equals("20")) {
						state.setText("Jharkhand");
					}
					if (code.getText().toString().equals("21")) {
						state.setText("Orissa");
					}
					if (code.getText().toString().equals("22")) {
						state.setText("Chhattisgarh");
					}
					if (code.getText().toString().equals("23")) {
						state.setText("Madhya Pradesh");
					}
					if (code.getText().toString().equals("24")) {
						state.setText("Gujarat");
					}
					if (code.getText().toString().equals("25")) {
						state.setText("Daman & Diu");
					}
					if (code.getText().toString().equals("26")) {
						state.setText("Dadra & Nagar Haveli");
					}
					if (code.getText().toString().equals("27")) {
						state.setText("Maharashtra");
					}
					if (code.getText().toString().equals("28")) {
						state.setText("Andhra Pradesh");
					}
					if (code.getText().toString().equals("29")) {
						state.setText("Karnataka");
					}
					if (code.getText().toString().equals("30")) {
						state.setText("Goa");
					}
					if (code.getText().toString().equals("31")) {
						state.setText("Lakshadweep");
					}
					if (code.getText().toString().equals("32")) {
						state.setText("Kerala");
					}
					if (code.getText().toString().equals("33")) {
						state.setText("Tamil Nadu");
					}
					if (code.getText().toString().equals("34")) {
						state.setText("Puducherry");
					}
					if (code.getText().toString().equals("35")) {
						state.setText("Andaman & Nicobar Islands");
					}
					if (code.getText().toString().equals("36")) {
						state.setText("Telengana");
					}
					if (code.getText().toString().equals("37")) {
						state.setText("Andhra Pradesh");
					}
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_dialog_calendar();
				d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						dinv_a.setText(new SimpleDateFormat("dd").format(c.getTime()));
						dinv_b.setText(new SimpleDateFormat("MM").format(c.getTime()));
						dinv_c.setText(new SimpleDateFormat("yyyy").format(c.getTime()));
					}
				});
				d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				through.setText("");
			}
		});
		
		spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					odno.setText("");
				}
				if (_position == 1) {
					odno.setText("WhatsApp");
				}
				if (_position == 2) {
					odno.setText("Verbal");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_dialog_calendar();
				d.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						dod_a.setText(new SimpleDateFormat("dd").format(c.getTime()));
						dod_b.setText(new SimpleDateFormat("MM").format(c.getTime()));
						dod_c.setText(new SimpleDateFormat("yyyy").format(c.getTime()));
					}
				});
				d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					car.setText("");
				}
				if (_position == 1) {
					car.setText("Trackon Courier");
				}
				if (_position == 2) {
					car.setText("Safexpress");
				}
				if (_position == 3) {
					car.setText("Swiftline Cargo");
				}
				if (_position == 4) {
					car.setText("POB");
				}
				if (_position == 5) {
					car.setText("New Mahaveer Trans.");
				}
				if (_position == 6) {
					car.setText("Shukla Transport");
				}
				if (_position == 7) {
					car.setText("Saran Road Corp.");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		boxesno.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				if (!dinv_a.getText().toString().equals("") && !dod_c.getText().toString().equals("")) {
					dinv_a.setText(new DecimalFormat("00").format(Double.parseDouble(dinv_a.getText().toString())));
					dinv_b.setText(new DecimalFormat("00").format(Double.parseDouble(dinv_b.getText().toString())));
					dinv_c.setText(new DecimalFormat("0000").format(Double.parseDouble(dinv_c.getText().toString())));
					dod_a.setText(new DecimalFormat("00").format(Double.parseDouble(dod_a.getText().toString())));
					dod_b.setText(new DecimalFormat("00").format(Double.parseDouble(dod_b.getText().toString())));
					dod_c.setText(new DecimalFormat("0000").format(Double.parseDouble(dod_c.getText().toString())));
					dii.setText(dinv_a.getText().toString().concat("-".concat(dinv_b.getText().toString().concat("-".concat(dinv_c.getText().toString())))));
					drg.setText(dinv_a.getText().toString().concat("-".concat(dinv_b.getText().toString().concat("-".concat(dinv_c.getText().toString())))));
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Error!!!");
				}
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (boxesno.getText().toString().equals("") && (boxesno.getText().toString().equals("1") && boxesno.getText().toString().equals("0"))) {
					SketchwareUtil.showMessage(getApplicationContext(), "Error!!!");
				}
				else {
					boxesno.setText(new DecimalFormat("000").format(Double.parseDouble(boxesno.getText().toString()) - 1));
				}
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (boxesno.getText().toString().equals("")) {
					boxesno.setText("001");
				}
				else {
					boxesno.setText(new DecimalFormat("000").format(Double.parseDouble(boxesno.getText().toString()) + 1));
				}
			}
		});
		
		spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (_position == 0) {
					mrs.setText("");
				}
				if (_position == 1) {
					mrs.setText("Cash");
				}
				if (_position == 2) {
					mrs.setText("30 Days Credit");
				}
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> _param1) {
				
			}
		});
		
		_net_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				i.setClass(getApplicationContext(), PrintsetActivity.class);
				startActivity(i);
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				dia.setTitle("OOPS!!! NO INTERNET");
				dia.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						net.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "A", _net_request_listener);
					}
				});
				dia.create().show();
			}
		};
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maplist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maplist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						lnvno.setText(new DecimalFormat("000").format(Double.parseDouble(maplist.get((int)0).get("Invno").toString()) + 1));
						finyr.setText(maplist.get((int)1).get("finyr").toString());
						loc.setText(maplist.get((int)2).get("loc").toString());
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				db.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						maplist = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								maplist.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						lnvno.setText(maplist.get((int)0).get("Invno").toString());
						finyr.setText(maplist.get((int)1).get("finyr").toString());
						loc.setText(maplist.get((int)2).get("loc").toString());
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_inv_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				invoice.add(_childKey);
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		inv.addChildEventListener(_inv_child_listener);
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	private void initializeLogic() {
		if (data.getString("test", "").equals("")) {
			dialog.setTitle("Are You New User?");
			dialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			dialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					test = 1;
					data.edit().putString("test", String.valueOf((long)(test))).commit();
				}
			});
			dialog.create().show();
		}
		_RoundAndBorder(button3, "#FFFFFF", 0, "#000000", 110);
		through.setText("Direct to the party");
		spin1.add("");
		spin1.add("WhatsApp");
		spin1.add("Verbal");
		spinner1.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, spin1));
		((ArrayAdapter)spinner1.getAdapter()).notifyDataSetChanged();
		spin2.add("");
		spin2.add("Trackon Courier");
		spin2.add("Safexpress");
		spin2.add("Swiftline Cargo");
		spin2.add("POB");
		spin2.add("New Mahaveer Transport");
		spin2.add("Shukla Transport");
		spin2.add("Saran Road Corporation");
		spinner2.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, spin2));
		((ArrayAdapter)spinner2.getAdapter()).notifyDataSetChanged();
		spin3.add("");
		spin3.add("Cash");
		spin3.add("30 Days Credit");
		spinner3.setAdapter(new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_spinner_dropdown_item, spin3));
		((ArrayAdapter)spinner3.getAdapter()).notifyDataSetChanged();
		transcharg.setText("0.00");
		cal = Calendar.getInstance();
		dinv_a.setText(new SimpleDateFormat("dd").format(cal.getTime()));
		dinv_b.setText(new SimpleDateFormat("MM").format(cal.getTime()));
		dinv_c.setText(new SimpleDateFormat("yyyy").format(cal.getTime()));
		linear30.setVisibility(View.INVISIBLE);
		add.setText("M/s ".concat(getIntent().getStringExtra("add1")));
		code.setText(getIntent().getStringExtra("add2"));
		_limit();
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _RoundAndBorder (final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	private void _calculate () {
		logic.setText("Calculating amount....................");
		tot_qty = Double.parseDouble(q1.getText().toString()) + (Double.parseDouble(q2.getText().toString()) + (Double.parseDouble(q3.getText().toString()) + (Double.parseDouble(q4.getText().toString()) + (Double.parseDouble(q5.getText().toString()) + (Double.parseDouble(q6.getText().toString()) + (Double.parseDouble(q7.getText().toString()) + (Double.parseDouble(q8.getText().toString()) + Double.parseDouble(q9.getText().toString()))))))));
		i.putExtra("tot_qty", String.valueOf((long)(tot_qty)).concat(" nos."));
		tot_price = v1 + (v2 + (v3 + (v4 + (v5 + (v6 + (v7 + (v8 + v9)))))));
		price = v1 + (v2 + (v3 + (v4 + (v5 + (v6 + (v7 + (v8 + (v9 + Double.parseDouble(transcharg.getText().toString())))))))));
		i.putExtra("price", new DecimalFormat("00.00").format(price));
		i.putExtra("tot_price", new DecimalFormat("00.00").format(tot_price));
		if (code.getText().toString().trim().equals("09")) {
			i.putExtra("gst1", new DecimalFormat("00.00").format(0.09d * price));
			i.putExtra("igst", "");
			i.putExtra("gst2", new DecimalFormat("00.00").format(0.09d * price));
		}
		else {
			i.putExtra("gst1", new DecimalFormat("00.00").format(Double.parseDouble(edittext1.getText().toString()) * price));
			i.putExtra("igst", edittext1.getText().toString());
			i.putExtra("gst2", "");
		}
		logic.setText("Checking connection....................");
		net.startRequestNetwork(RequestNetworkController.GET, "https://google.com", "A", _net_request_listener);
	}
	
	
	private void _product () {
		logic.setText("Saving product details.....................");
		if (!p1.getText().toString().equals("")) {
			i.putExtra("p1", p1.getText().toString());
			i.putExtra("q1", q1.getText().toString());
			i.putExtra("r1", new DecimalFormat("0.00").format(Double.parseDouble(r1.getText().toString())));
			v1 = Double.parseDouble(q1.getText().toString()) * Double.parseDouble(r1.getText().toString());
			i.putExtra("v1", new DecimalFormat("00.00").format(v1));
		}
		else {
			v1 = 0.0d;
			q1.setText("0");
		}
		if (!p2.getText().toString().equals("")) {
			i.putExtra("p2", p2.getText().toString());
			i.putExtra("q2", q2.getText().toString());
			i.putExtra("r2", new DecimalFormat("0.00").format(Double.parseDouble(r2.getText().toString())));
			v2 = Double.parseDouble(q2.getText().toString()) * Double.parseDouble(r2.getText().toString());
			i.putExtra("v2", new DecimalFormat("00.00").format(v2));
		}
		else {
			v2 = 0.0d;
			q2.setText("0");
		}
		if (!p3.getText().toString().equals("")) {
			i.putExtra("p3", p3.getText().toString());
			i.putExtra("q3", q3.getText().toString());
			i.putExtra("r3", new DecimalFormat("0.00").format(Double.parseDouble(r3.getText().toString())));
			v3 = Double.parseDouble(q3.getText().toString()) * Double.parseDouble(r3.getText().toString());
			i.putExtra("v3", new DecimalFormat("00.00").format(v3));
		}
		else {
			v3 = 0.0d;
			q3.setText("0");
		}
		if (!p4.getText().toString().equals("")) {
			i.putExtra("p4", p4.getText().toString());
			i.putExtra("q4", q4.getText().toString());
			i.putExtra("r4", new DecimalFormat("0.00").format(Double.parseDouble(r4.getText().toString())));
			v4 = Double.parseDouble(q4.getText().toString()) * Double.parseDouble(r4.getText().toString());
			i.putExtra("v4", new DecimalFormat("00.00").format(v4));
		}
		else {
			v4 = 0.0d;
			q4.setText("0");
		}
		if (!p5.getText().toString().equals("")) {
			i.putExtra("p5", p5.getText().toString());
			i.putExtra("q5", q5.getText().toString());
			i.putExtra("r5", new DecimalFormat("0.00").format(Double.parseDouble(r5.getText().toString())));
			v5 = Double.parseDouble(q5.getText().toString()) * Double.parseDouble(r5.getText().toString());
			i.putExtra("v5", new DecimalFormat("00.00").format(v5));
		}
		else {
			v5 = 0.0d;
			q5.setText("0");
		}
		if (!p6.getText().toString().equals("")) {
			i.putExtra("p6", p6.getText().toString());
			i.putExtra("q6", q6.getText().toString());
			i.putExtra("r6", new DecimalFormat("0.00").format(Double.parseDouble(r6.getText().toString())));
			v6 = Double.parseDouble(q6.getText().toString()) * Double.parseDouble(r6.getText().toString());
			i.putExtra("v6", new DecimalFormat("00.00").format(v6));
		}
		else {
			v6 = 0.0d;
			q6.setText("0");
		}
		if (!p7.getText().toString().equals("")) {
			i.putExtra("p7", p7.getText().toString());
			i.putExtra("q7", q7.getText().toString());
			i.putExtra("r7", new DecimalFormat("0.00").format(Double.parseDouble(r7.getText().toString())));
			v7 = Double.parseDouble(q7.getText().toString()) * Double.parseDouble(r7.getText().toString());
			i.putExtra("v7", new DecimalFormat("00.00").format(v7));
		}
		else {
			v7 = 0.0d;
			q7.setText("0");
		}
		if (!p8.getText().toString().equals("")) {
			i.putExtra("p8", p8.getText().toString());
			i.putExtra("q8", q8.getText().toString());
			i.putExtra("r8", new DecimalFormat("0.00").format(Double.parseDouble(r8.getText().toString())));
			v8 = Double.parseDouble(q8.getText().toString()) * Double.parseDouble(r8.getText().toString());
			i.putExtra("v8", new DecimalFormat("00.00").format(v8));
		}
		else {
			v8 = 0.0d;
			q8.setText("0");
		}
		if (!p9.getText().toString().equals("")) {
			i.putExtra("p9", p9.getText().toString());
			i.putExtra("q9", q9.getText().toString());
			i.putExtra("r9", new DecimalFormat("0.00").format(Double.parseDouble(r9.getText().toString())));
			v9 = Double.parseDouble(q9.getText().toString()) * Double.parseDouble(r9.getText().toString());
			i.putExtra("v9", new DecimalFormat("00.00").format(v9));
		}
		else {
			v9 = 0.0d;
			q9.setText("0");
		}
	}
	
	
	private void _details () {
		logic.setText("Saving details.................");
		i.putExtra("add", add.getText().toString());
		i.putExtra("code", code.getText().toString());
		i.putExtra("Ivno", new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())));
		i.putExtra("bookno", bookno.getText().toString());
		i.putExtra("state", state.getText().toString());
		i.putExtra("dinv", dinv_a.getText().toString().concat("-".concat(dinv_b.getText().toString().concat("-".concat(dinv_c.getText().toString())))));
		i.putExtra("through", through.getText().toString());
		i.putExtra("odno", odno.getText().toString());
		i.putExtra("dod", dod_a.getText().toString().concat("-".concat(dod_b.getText().toString().concat("-".concat(dod_c.getText().toString())))));
		i.putExtra("car", car.getText().toString());
		i.putExtra("boxesno", boxesno.getText().toString());
		i.putExtra("mrs", mrs.getText().toString());
		i.putExtra("transcharge", transcharg.getText().toString());
		i.putExtra("loc", loc.getText().toString());
		i.putExtra("dii", dii.getText().toString());
		i.putExtra("tii", tii.getText().toString());
		i.putExtra("drg", drg.getText().toString());
		i.putExtra("trg", trg.getText().toString());
		i.putExtra("finyr", finyr.getText().toString());
		i.putExtra("qr", new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())).concat(dinv_a.getText().toString().concat(dinv_b.getText().toString().concat(dinv_c.getText().toString().substring((int)(2), (int)(4))))));
	}
	
	
	private void _cloud () {
		if (data.getString("test", "").equals("")) {
			map = new HashMap<>();
			map.put("Invno", new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())));
			db.child("Invno").updateChildren(map);
			map.clear();
			map.put("finyr", finyr.getText().toString());
			db.child("finyr").updateChildren(map);
			map.clear();
			map.put("loc", loc.getText().toString());
			db.child("loc").updateChildren(map);
			map.clear();
			test = 1;
			data.edit().putString("test", String.valueOf((long)(test))).commit();
		}
		else {
			if ((Double.parseDouble(maplist.get((int)0).get("Invno").toString()) + 1) > Double.parseDouble(lnvno.getText().toString())) {
				map.put("finyr", finyr.getText().toString());
				db.child("finyr").updateChildren(map);
				map.clear();
				map.put("loc", loc.getText().toString());
				db.child("loc").updateChildren(map);
				map.clear();
			}
			else {
				map.put("Invno", new DecimalFormat("000").format(Double.parseDouble(lnvno.getText().toString())));
				db.child("Invno").updateChildren(map);
				map.clear();
				map.put("finyr", finyr.getText().toString());
				db.child("finyr").updateChildren(map);
				map.clear();
				map.put("loc", loc.getText().toString());
				db.child("loc").updateChildren(map);
				map.clear();
			}
		}
	}
	
	
	private void _EditTextLimit (final TextView _edittext, final double _limit, final TextView _output_tv) {
		_output_tv.setText(String.valueOf((long)(_edittext.getText().toString().length())).concat(" / ".concat(String.valueOf((long)(_limit)))));
		_edittext.addTextChangedListener(new TextWatcher() {
						@Override
						public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
								final String _charSeq = _param1.toString();
				_output_tv.setText(String.valueOf((long)(_edittext.getText().toString().length())).concat(" / ".concat(String.valueOf((long)(_limit)))));
			}
						
						@Override
						public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
								
						}
						
						@Override
						public void afterTextChanged(Editable _param1) {
								
						}
				});
		_edittext.setFilters( new InputFilter[] { new InputFilter.LengthFilter((int)_limit) } );
		/****---- NOTE ----****//*
Put this block in onCreate.
Made by Amitoj Singh
Source: https://stackoverflow.com/a/2462218/9300428
Download Sketchub for sharing Sketchware Projects. http://www.sketchub.in/
/****----NOTE ENDS----****/
	}
	
	
	private void _limit () {
		_EditTextLimit(dinv_a, 2, logic);
		_EditTextLimit(dod_a, 2, logic);
		_EditTextLimit(dinv_b, 2, logic);
		_EditTextLimit(dod_b, 2, logic);
		_EditTextLimit(dod_c, 4, logic);
		_EditTextLimit(dinv_c, 4, logic);
	}
	
	
	private void _dialog_calendar () {
		final LinearLayout _mainlayout = new LinearLayout(CreateActivity.this);
		_mainlayout.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.MATCH_PARENT));
		_mainlayout.setOrientation(LinearLayout.VERTICAL);
		
		final LinearLayout _viewlayout = new LinearLayout(CreateActivity.this);
		_viewlayout.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		
		android.util.TypedValue typedValue = new android.util.TypedValue();
		android.content.res.TypedArray a = CreateActivity.this.obtainStyledAttributes(typedValue.data, new int[] { android.R.attr.colorAccent });
		int color = a.getColor(0, 0);
		
		_viewlayout.setBackgroundColor(color);
		
		_viewlayout.setOrientation(LinearLayout.VERTICAL);
		_viewlayout.setPadding(36, 25, 36, 25);
		
		final TextView _year = new TextView(CreateActivity.this);
		_year.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		_year.setTextSize((int)getDip((int)12));
		
		_year.setTextColor(Color.parseColor("#E0E0E0"));
		
		_year.setText("2020");
		
		_year.setTypeface(null, 1);
		
		_viewlayout.addView(_year);
		
		final TextView _date = new TextView(CreateActivity.this);
		_date.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		_date.setTextSize((int)getDip((int)25));
		_date.setTextColor(Color.parseColor("#FFFFFF"));
		
		_date.setText("Sun, Mar 22");
		
		_date.setTypeface(null, 1);
		
		_viewlayout.addView(_date);
		
		
		final CalendarView _c = new CalendarView(CreateActivity.this);
		_c.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT));
		d.setView(_mainlayout);
		
		_mainlayout.addView(_viewlayout);
		_mainlayout.addView(_c);
		c = Calendar.getInstance();
		_date.setText(new SimpleDateFormat("EEE, MMM dd").format(c.getTime()));
		_year.setText(new SimpleDateFormat("yyyy").format(c.getTime()));
		_c.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
			@Override
			public void onSelectedDayChange(CalendarView _param1, int _param2, int _param3, int _param4) {
				year = (int)_param2;
				month = (int)_param3;
				day = (int)_param4;
				c.set(Calendar.YEAR, (int)(year));
				c.set(Calendar.MONTH, (int)(month));
				c.set(Calendar.DAY_OF_MONTH, (int)(day));
				_date.setText(new SimpleDateFormat("EEE, MMM dd").format(c.getTime()));
				_year.setText(new SimpleDateFormat("yyyy").format(c.getTime()));
			}
		});
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
