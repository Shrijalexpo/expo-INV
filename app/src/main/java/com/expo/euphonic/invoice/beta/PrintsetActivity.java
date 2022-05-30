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
import android.widget.ScrollView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import android.view.View;
import java.text.DecimalFormat;

public class PrintsetActivity extends AppCompatActivity {
	
	
	private double net = 0;
	private double gst1 = 0;
	private double gst2 = 0;
	private double price = 0;
	private double ivno = 0;
	private String code = "";
	private String out = "";
	private String str = "";
	private String ten = "";
	private String one = "";
	private String qr = "";
	private String binary = "";
	
	private ScrollView vscroll1;
	private HorizontalScrollView hscroll1;
	private LinearLayout linear1;
	private LinearLayout linear3;
	private WebView webview1;
	private LinearLayout linear4;
	private TextView textview1;
	private LinearLayout linear2;
	private Button button1;
	private Button button2;
	private Button button3;
	private TextView textview5;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	
	private Intent i = new Intent();
	private Calendar cal = Calendar.getInstance();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.printset);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		textview1 = (TextView) findViewById(R.id.textview1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button3 = (Button) findViewById(R.id.button3);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("print", "                  Office Copy");
				i.putExtra("price", new DecimalFormat("00.00").format(price));
				i.putExtra("net", new DecimalFormat("00.00").format(net));
				i.putExtra("gst1", new DecimalFormat("00.00").format(gst1));
				i.putExtra("gst2", new DecimalFormat("00.00").format(gst2));
				i.putExtra("word", textview4.getText().toString());
				i.putExtra("Ivno", getIntent().getStringExtra("Ivno"));
				i.putExtra("code", code);
				i.putExtra("qr", "1".concat(qr));
				i.setClass(getApplicationContext(), PrintviewActivity.class);
				startActivity(i);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("print", "      Original for Buyer");
				i.putExtra("price", new DecimalFormat("00.00").format(price));
				i.putExtra("net", new DecimalFormat("00.00").format(net));
				i.putExtra("gst1", new DecimalFormat("00.00").format(gst1));
				i.putExtra("gst2", new DecimalFormat("00.00").format(gst2));
				i.putExtra("word", textview4.getText().toString());
				i.putExtra("Ivno", getIntent().getStringExtra("Ivno"));
				i.putExtra("code", code);
				i.putExtra("qr", "2".concat(qr));
				i.setClass(getApplicationContext(), PrintviewActivity.class);
				startActivity(i);
			}
		});
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("print", "Duplicate for Transporter");
				i.putExtra("price", new DecimalFormat("00.00").format(price));
				i.putExtra("net", new DecimalFormat("00.00").format(net));
				i.putExtra("gst1", new DecimalFormat("00.00").format(gst1));
				i.putExtra("gst2", new DecimalFormat("00.00").format(gst2));
				i.putExtra("word", textview4.getText().toString());
				i.putExtra("Ivno", getIntent().getStringExtra("Ivno"));
				i.putExtra("code", code);
				i.putExtra("qr", "3".concat(qr));
				i.setClass(getApplicationContext(), PrintviewActivity.class);
				startActivity(i);
			}
		});
	}
	private void initializeLogic() {
		i.putExtra("add", getIntent().getStringExtra("add"));
		i.putExtra("bookno", getIntent().getStringExtra("bookno"));
		i.putExtra("state", getIntent().getStringExtra("state"));
		i.putExtra("dinv", getIntent().getStringExtra("dinv"));
		i.putExtra("through", getIntent().getStringExtra("through"));
		i.putExtra("odno", getIntent().getStringExtra("odno"));
		i.putExtra("dod", getIntent().getStringExtra("dod"));
		i.putExtra("car", getIntent().getStringExtra("car"));
		i.putExtra("boxesno", getIntent().getStringExtra("boxesno"));
		i.putExtra("mrs", getIntent().getStringExtra("mrs"));
		i.putExtra("transcharge", getIntent().getStringExtra("transcharge"));
		i.putExtra("loc", getIntent().getStringExtra("loc"));
		i.putExtra("dii", getIntent().getStringExtra("dii"));
		i.putExtra("tii", getIntent().getStringExtra("tii"));
		i.putExtra("drg", getIntent().getStringExtra("drg"));
		i.putExtra("trg", getIntent().getStringExtra("trg"));
		i.putExtra("finyr", getIntent().getStringExtra("finyr"));
		i.putExtra("igst", getIntent().getStringExtra("igst"));
		i.putExtra("v1", getIntent().getStringExtra("v1"));
		i.putExtra("v2", getIntent().getStringExtra("v2"));
		i.putExtra("v3", getIntent().getStringExtra("v3"));
		i.putExtra("v4", getIntent().getStringExtra("v4"));
		i.putExtra("v5", getIntent().getStringExtra("v5"));
		i.putExtra("v6", getIntent().getStringExtra("v6"));
		i.putExtra("v7", getIntent().getStringExtra("v7"));
		i.putExtra("v8", getIntent().getStringExtra("v8"));
		i.putExtra("v9", getIntent().getStringExtra("v9"));
		i.putExtra("p1", getIntent().getStringExtra("p1"));
		i.putExtra("q1", getIntent().getStringExtra("q1"));
		i.putExtra("r1", getIntent().getStringExtra("r1"));
		i.putExtra("p2", getIntent().getStringExtra("p2"));
		i.putExtra("q2", getIntent().getStringExtra("q2"));
		i.putExtra("r2", getIntent().getStringExtra("r2"));
		i.putExtra("p3", getIntent().getStringExtra("p3"));
		i.putExtra("q3", getIntent().getStringExtra("q3"));
		i.putExtra("r3", getIntent().getStringExtra("r3"));
		i.putExtra("p4", getIntent().getStringExtra("p4"));
		i.putExtra("q4", getIntent().getStringExtra("q4"));
		i.putExtra("r4", getIntent().getStringExtra("r4"));
		i.putExtra("p5", getIntent().getStringExtra("p5"));
		i.putExtra("q5", getIntent().getStringExtra("q5"));
		i.putExtra("r5", getIntent().getStringExtra("r5"));
		i.putExtra("p6", getIntent().getStringExtra("p6"));
		i.putExtra("q6", getIntent().getStringExtra("q6"));
		i.putExtra("r6", getIntent().getStringExtra("r6"));
		i.putExtra("p7", getIntent().getStringExtra("p7"));
		i.putExtra("q7", getIntent().getStringExtra("q7"));
		i.putExtra("r7", getIntent().getStringExtra("r7"));
		i.putExtra("p8", getIntent().getStringExtra("p8"));
		i.putExtra("q8", getIntent().getStringExtra("q8"));
		i.putExtra("r8", getIntent().getStringExtra("r8"));
		i.putExtra("p9", getIntent().getStringExtra("p9"));
		i.putExtra("q9", getIntent().getStringExtra("q9"));
		i.putExtra("r9", getIntent().getStringExtra("r9"));
		i.putExtra("tot_qty", getIntent().getStringExtra("tot_qty"));
		i.putExtra("tot_price", getIntent().getStringExtra("tot_price"));
		cal = Calendar.getInstance();
		_RoundAndBorder(linear3, "#FFFFFF", 3, "#000000", 110);
		code = getIntent().getStringExtra("code");
		textview2.setText("Invoice no. ".concat(getIntent().getStringExtra("Ivno")));
		if (code.equals("09")) {
			gst1 = Double.parseDouble(getIntent().getStringExtra("gst1"));
			gst2 = Double.parseDouble(getIntent().getStringExtra("gst2"));
		}
		else {
			gst1 = Double.parseDouble(getIntent().getStringExtra("gst1"));
		}
		net = Math.round(gst1 + (gst2 + Double.parseDouble(getIntent().getStringExtra("price"))));
		price = gst1 + (gst2 + Double.parseDouble(getIntent().getStringExtra("price")));
		textview3.setText("Net amt. ".concat(String.valueOf(net)));
		if (!(net == 0)) {
			_func2(Double.parseDouble(String.valueOf((long)(net))));
			textview4.setText(out.concat("Rupees Only"));
		}
		qr = getIntent().getStringExtra("qr");
		textview5.setText(qr);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), MainActivity.class);
		startActivity(i);
	}
	private void _RoundAndBorder (final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	private void _num_main (final TextView _in, final TextView _out) {
		if (!_in.getText().toString().equals("")) {
			_func2(Double.parseDouble(String.valueOf((long)(Double.parseDouble(_in.getText().toString())))));
			_out.setText(out.concat("Only"));
		}
	}
	
	
	private void _func1 (final double _n, final String _s) {
		str = "";
		if (_n > 19) {
			_String_one(Double.parseDouble(String.valueOf((long)(_n % 10))));
			_String_ten(Double.parseDouble(String.valueOf((long)(_n / 10))));
			str = str.concat(ten.concat(one));
		}
		else {
			_String_one(_n);
			str = str.concat(one);
		}
		if (!(_n == 0)) {
			str = str.concat(_s);
		}
	}
	
	
	private void _func2 (final double _n) {
		out = "";
		_func1(Double.parseDouble(String.valueOf((long)(_n / 10000000))), "Crore ");
		out = out.concat(str);
		_func1(Double.parseDouble(String.valueOf((long)((_n / 100000) % 100))), "Lakh ");
		out = out.concat(str);
		_func1(Double.parseDouble(String.valueOf((long)((_n / 1000) % 100))), "Thousand ");
		out = out.concat(str);
		_func1(Double.parseDouble(String.valueOf((long)((_n / 100) % 10))), "Hundred ");
		out = out.concat(str);
		if ((_n > 100) && ((_n % 100) > 0)) {
			out = out.concat("and ");
		}
		_func1(Double.parseDouble(String.valueOf((long)(_n % 100))), "");
		out = out.concat(str);
	}
	
	
	private void _String_ten (final double _num) {
		if (_num == 0) {
			ten = "";
		}
		if (_num == 1) {
			ten = "";
		}
		if (_num == 2) {
			ten = "Twenty ";
		}
		if (_num == 3) {
			ten = "Thirty ";
		}
		if (_num == 4) {
			ten = "Fourty ";
		}
		if (_num == 5) {
			ten = "Fifty ";
		}
		if (_num == 6) {
			ten = "Sixty ";
		}
		if (_num == 7) {
			ten = "Seventy ";
		}
		if (_num == 8) {
			ten = "Eighty ";
		}
		if (_num == 9) {
			ten = "Ninety ";
		}
	}
	
	
	private void _String_one (final double _num) {
		if (_num == 0) {
			one = "";
		}
		if (_num == 1) {
			one = "One ";
		}
		if (_num == 2) {
			one = "Two ";
		}
		if (_num == 3) {
			one = "Three ";
		}
		if (_num == 4) {
			one = "Four ";
		}
		if (_num == 5) {
			one = "Five ";
		}
		if (_num == 6) {
			one = "Six ";
		}
		if (_num == 7) {
			one = "Seven ";
		}
		if (_num == 8) {
			one = "Eight ";
		}
		if (_num == 9) {
			one = "Nine ";
		}
		if (_num == 10) {
			one = "Ten ";
		}
		if (_num == 11) {
			one = "Eleven ";
		}
		if (_num == 12) {
			one = "Twelve ";
		}
		if (_num == 13) {
			one = "Thirteen ";
		}
		if (_num == 14) {
			one = "Fourteen ";
		}
		if (_num == 15) {
			one = "Fifteen ";
		}
		if (_num == 16) {
			one = "Sixteen ";
		}
		if (_num == 17) {
			one = "Seventeen ";
		}
		if (_num == 18) {
			one = "Eigthteen ";
		}
		if (_num == 19) {
			one = "Nineteen ";
		}
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
