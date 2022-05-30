package com.expo.euphonic.invoice.test;

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
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.content.Intent;
import android.net.Uri;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import java.text.DecimalFormat;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class PrintviewActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String path = "";
	private String print = "";
	private double v1 = 0;
	private double v2 = 0;
	private double v3 = 0;
	private double v4 = 0;
	private double v5 = 0;
	private double v6 = 0;
	private double v7 = 0;
	private double v8 = 0;
	private double Ivno = 0;
	
	private HorizontalScrollView hscroll1;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear1;
	private LinearLayout main;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private LinearLayout linear3;
	private LinearLayout linear54;
	private LinearLayout linear45;
	private LinearLayout linear4;
	private LinearLayout linear7;
	private LinearLayout linear21;
	private LinearLayout linear22;
	private LinearLayout linear23;
	private LinearLayout linear29;
	private LinearLayout linear31;
	private LinearLayout linear40;
	private LinearLayout linear41;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private TextView textview2;
	private TextView textview3;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private TextView textview11;
	private TextView textview12;
	private TextView textview13;
	private TextView textview4;
	private LinearLayout linear9;
	private LinearLayout linear11;
	private LinearLayout linear12;
	private LinearLayout linear8;
	private LinearLayout linear10;
	private TextView textview5;
	private TextView textview6;
	private TextView textview7;
	private TextView textview8;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private TextView textview9;
	private TextView textview10;
	private TextView textview14;
	private TextView textview15;
	private TextView textview16;
	private TextView textview17;
	private TextView textview18;
	private TextView textview19;
	private LinearLayout linear17;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear20;
	private TextView textview20;
	private TextView textview21;
	private TextView textview22;
	private TextView textview23;
	private TextView textview24;
	private TextView textview25;
	private TextView textview26;
	private TextView textview27;
	private TextView textview28;
	private TextView textview29;
	private TextView textview30;
	private TextView textview31;
	private TextView textview32;
	private TextView textview33;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private TextView textview43;
	private TextView textview44;
	private TextView textview45;
	private TextView textview46;
	private TextView textview47;
	private TextView textview48;
	private TextView textview49;
	private TextView textview50;
	private TextView textview51;
	private TextView textview34;
	private TextView textview35;
	private TextView textview36;
	private TextView textview37;
	private TextView textview38;
	private TextView textview39;
	private TextView textview40;
	private TextView textview41;
	private TextView textview42;
	private TextView textview52;
	private TextView textview53;
	private TextView textview54;
	private TextView textview55;
	private TextView textview56;
	private TextView textview57;
	private TextView textview58;
	private TextView textview59;
	private TextView textview60;
	private TextView textview75;
	private TextView textview76;
	private TextView textview77;
	private TextView textview78;
	private TextView textview79;
	private TextView textview80;
	private TextView textview81;
	private TextView textview82;
	private TextView textview83;
	private TextView textview84;
	private TextView textview85;
	private TextView textview86;
	private TextView textview87;
	private TextView textview88;
	private TextView textview89;
	private TextView textview90;
	private TextView textview91;
	private TextView textview92;
	private TextView textview61;
	private TextView textview62;
	private TextView textview66;
	private TextView textview63;
	private LinearLayout linear32;
	private LinearLayout linear37;
	private LinearLayout linear38;
	private LinearLayout linear33;
	private LinearLayout linear46;
	private LinearLayout linear34;
	private LinearLayout linear35;
	private TextView textview74;
	private TextView textview64;
	private TextView textview65;
	private LinearLayout linear47;
	private LinearLayout linear48;
	private LinearLayout linear36;
	private LinearLayout linear49;
	private TextView textview69;
	private TextView textview96;
	private TextView textview70;
	private TextView textview71;
	private TextView textview72;
	private TextView textview73;
	private TextView textview99;
	private TextView textview100;
	private TextView textview101;
	private TextView textview102;
	private TextView textview103;
	private TextView textview104;
	private TextView textview97;
	private TextView textview98;
	private TextView textview67;
	private TextView textview68;
	private LinearLayout linear44;
	private LinearLayout linear50;
	private LinearLayout linear51;
	private WebView webview1;
	private TextView textview95;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private TextView textview105;
	private TextView textview106;
	private TextView textview107;
	private TextView textview108;
	private TextView textview109;
	private TextView textview110;
	private TextView textview111;
	private TextView textview112;
	private TextView textview113;
	private TextView textview114;
	private TextView textview93;
	private TextView textview94;
	
	private Intent i = new Intent();
	private Calendar c = Calendar.getInstance();
	private TimerTask t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.printview);
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
		
		hscroll1 = (HorizontalScrollView) findViewById(R.id.hscroll1);
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		main = (LinearLayout) findViewById(R.id.main);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear54 = (LinearLayout) findViewById(R.id.linear54);
		linear45 = (LinearLayout) findViewById(R.id.linear45);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		linear21 = (LinearLayout) findViewById(R.id.linear21);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		linear23 = (LinearLayout) findViewById(R.id.linear23);
		linear29 = (LinearLayout) findViewById(R.id.linear29);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		linear40 = (LinearLayout) findViewById(R.id.linear40);
		linear41 = (LinearLayout) findViewById(R.id.linear41);
		linear42 = (LinearLayout) findViewById(R.id.linear42);
		linear43 = (LinearLayout) findViewById(R.id.linear43);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview12 = (TextView) findViewById(R.id.textview12);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview4 = (TextView) findViewById(R.id.textview4);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview7 = (TextView) findViewById(R.id.textview7);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview14 = (TextView) findViewById(R.id.textview14);
		textview15 = (TextView) findViewById(R.id.textview15);
		textview16 = (TextView) findViewById(R.id.textview16);
		textview17 = (TextView) findViewById(R.id.textview17);
		textview18 = (TextView) findViewById(R.id.textview18);
		textview19 = (TextView) findViewById(R.id.textview19);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		textview20 = (TextView) findViewById(R.id.textview20);
		textview21 = (TextView) findViewById(R.id.textview21);
		textview22 = (TextView) findViewById(R.id.textview22);
		textview23 = (TextView) findViewById(R.id.textview23);
		textview24 = (TextView) findViewById(R.id.textview24);
		textview25 = (TextView) findViewById(R.id.textview25);
		textview26 = (TextView) findViewById(R.id.textview26);
		textview27 = (TextView) findViewById(R.id.textview27);
		textview28 = (TextView) findViewById(R.id.textview28);
		textview29 = (TextView) findViewById(R.id.textview29);
		textview30 = (TextView) findViewById(R.id.textview30);
		textview31 = (TextView) findViewById(R.id.textview31);
		textview32 = (TextView) findViewById(R.id.textview32);
		textview33 = (TextView) findViewById(R.id.textview33);
		linear24 = (LinearLayout) findViewById(R.id.linear24);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		textview43 = (TextView) findViewById(R.id.textview43);
		textview44 = (TextView) findViewById(R.id.textview44);
		textview45 = (TextView) findViewById(R.id.textview45);
		textview46 = (TextView) findViewById(R.id.textview46);
		textview47 = (TextView) findViewById(R.id.textview47);
		textview48 = (TextView) findViewById(R.id.textview48);
		textview49 = (TextView) findViewById(R.id.textview49);
		textview50 = (TextView) findViewById(R.id.textview50);
		textview51 = (TextView) findViewById(R.id.textview51);
		textview34 = (TextView) findViewById(R.id.textview34);
		textview35 = (TextView) findViewById(R.id.textview35);
		textview36 = (TextView) findViewById(R.id.textview36);
		textview37 = (TextView) findViewById(R.id.textview37);
		textview38 = (TextView) findViewById(R.id.textview38);
		textview39 = (TextView) findViewById(R.id.textview39);
		textview40 = (TextView) findViewById(R.id.textview40);
		textview41 = (TextView) findViewById(R.id.textview41);
		textview42 = (TextView) findViewById(R.id.textview42);
		textview52 = (TextView) findViewById(R.id.textview52);
		textview53 = (TextView) findViewById(R.id.textview53);
		textview54 = (TextView) findViewById(R.id.textview54);
		textview55 = (TextView) findViewById(R.id.textview55);
		textview56 = (TextView) findViewById(R.id.textview56);
		textview57 = (TextView) findViewById(R.id.textview57);
		textview58 = (TextView) findViewById(R.id.textview58);
		textview59 = (TextView) findViewById(R.id.textview59);
		textview60 = (TextView) findViewById(R.id.textview60);
		textview75 = (TextView) findViewById(R.id.textview75);
		textview76 = (TextView) findViewById(R.id.textview76);
		textview77 = (TextView) findViewById(R.id.textview77);
		textview78 = (TextView) findViewById(R.id.textview78);
		textview79 = (TextView) findViewById(R.id.textview79);
		textview80 = (TextView) findViewById(R.id.textview80);
		textview81 = (TextView) findViewById(R.id.textview81);
		textview82 = (TextView) findViewById(R.id.textview82);
		textview83 = (TextView) findViewById(R.id.textview83);
		textview84 = (TextView) findViewById(R.id.textview84);
		textview85 = (TextView) findViewById(R.id.textview85);
		textview86 = (TextView) findViewById(R.id.textview86);
		textview87 = (TextView) findViewById(R.id.textview87);
		textview88 = (TextView) findViewById(R.id.textview88);
		textview89 = (TextView) findViewById(R.id.textview89);
		textview90 = (TextView) findViewById(R.id.textview90);
		textview91 = (TextView) findViewById(R.id.textview91);
		textview92 = (TextView) findViewById(R.id.textview92);
		textview61 = (TextView) findViewById(R.id.textview61);
		textview62 = (TextView) findViewById(R.id.textview62);
		textview66 = (TextView) findViewById(R.id.textview66);
		textview63 = (TextView) findViewById(R.id.textview63);
		linear32 = (LinearLayout) findViewById(R.id.linear32);
		linear37 = (LinearLayout) findViewById(R.id.linear37);
		linear38 = (LinearLayout) findViewById(R.id.linear38);
		linear33 = (LinearLayout) findViewById(R.id.linear33);
		linear46 = (LinearLayout) findViewById(R.id.linear46);
		linear34 = (LinearLayout) findViewById(R.id.linear34);
		linear35 = (LinearLayout) findViewById(R.id.linear35);
		textview74 = (TextView) findViewById(R.id.textview74);
		textview64 = (TextView) findViewById(R.id.textview64);
		textview65 = (TextView) findViewById(R.id.textview65);
		linear47 = (LinearLayout) findViewById(R.id.linear47);
		linear48 = (LinearLayout) findViewById(R.id.linear48);
		linear36 = (LinearLayout) findViewById(R.id.linear36);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		textview69 = (TextView) findViewById(R.id.textview69);
		textview96 = (TextView) findViewById(R.id.textview96);
		textview70 = (TextView) findViewById(R.id.textview70);
		textview71 = (TextView) findViewById(R.id.textview71);
		textview72 = (TextView) findViewById(R.id.textview72);
		textview73 = (TextView) findViewById(R.id.textview73);
		textview99 = (TextView) findViewById(R.id.textview99);
		textview100 = (TextView) findViewById(R.id.textview100);
		textview101 = (TextView) findViewById(R.id.textview101);
		textview102 = (TextView) findViewById(R.id.textview102);
		textview103 = (TextView) findViewById(R.id.textview103);
		textview104 = (TextView) findViewById(R.id.textview104);
		textview97 = (TextView) findViewById(R.id.textview97);
		textview98 = (TextView) findViewById(R.id.textview98);
		textview67 = (TextView) findViewById(R.id.textview67);
		textview68 = (TextView) findViewById(R.id.textview68);
		linear44 = (LinearLayout) findViewById(R.id.linear44);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		linear51 = (LinearLayout) findViewById(R.id.linear51);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		textview95 = (TextView) findViewById(R.id.textview95);
		linear52 = (LinearLayout) findViewById(R.id.linear52);
		linear53 = (LinearLayout) findViewById(R.id.linear53);
		textview105 = (TextView) findViewById(R.id.textview105);
		textview106 = (TextView) findViewById(R.id.textview106);
		textview107 = (TextView) findViewById(R.id.textview107);
		textview108 = (TextView) findViewById(R.id.textview108);
		textview109 = (TextView) findViewById(R.id.textview109);
		textview110 = (TextView) findViewById(R.id.textview110);
		textview111 = (TextView) findViewById(R.id.textview111);
		textview112 = (TextView) findViewById(R.id.textview112);
		textview113 = (TextView) findViewById(R.id.textview113);
		textview114 = (TextView) findViewById(R.id.textview114);
		textview93 = (TextView) findViewById(R.id.textview93);
		textview94 = (TextView) findViewById(R.id.textview94);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MainActivity.class);
				startActivity(i);
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c = Calendar.getInstance();
				try{ android.graphics.pdf.PdfDocument document = new android.graphics.pdf.PdfDocument(); android.graphics.pdf.PdfDocument.PageInfo pageInfo = new android.graphics.pdf.PdfDocument.PageInfo.Builder(main.getWidth(), main.getHeight(), 1).create(); android.graphics.pdf.PdfDocument.Page page = document.startPage(pageInfo); Canvas canvas = page.getCanvas(); Paint paint = new Paint(); canvas.drawPaint(paint); main.draw(canvas); document.finishPage(page);
					
					path = FileUtil.getExternalStorageDir().concat("/").concat("expo-INV".concat("/".concat(new SimpleDateFormat("yyyy").format(c.getTime()).trim().concat("/".concat("Invoice no. ".concat(getIntent().getStringExtra("Ivno")).concat("/".concat("Invoice no. ".concat(getIntent().getStringExtra("Ivno")).concat(" - ".concat(getIntent().getStringExtra("print").trim())).concat(".pdf"))))))));
					FileUtil.writeFile(path, "");
					java.io.File myFile = new
					java.io.File(path); java.io.FileOutputStream fOut = new java.io.FileOutputStream(myFile); java.io.OutputStreamWriter myOutWriter = new java.io.OutputStreamWriter(fOut); document.writeTo(fOut); document.close(); myOutWriter.close(); fOut.close(); Toast.makeText(getBaseContext(), "File Saved", Toast.LENGTH_LONG).show(); } catch (Exception e) { Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_LONG).show();}
				
				SketchwareUtil.showMessage(getApplicationContext(), path);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
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
	}
	private void initializeLogic() {
		_border();
		_text();
		webview1.loadUrl("https://api.qrserver.com/v1/create-qr-code/?size=35x35&data=".concat(getIntent().getStringExtra("qr")));
		textview95.setText(getIntent().getStringExtra("qr"));
		textview1.setText(getIntent().getStringExtra("print").trim());
		textview3.setText(getIntent().getStringExtra("print"));
		textview65.setText(getIntent().getStringExtra("word"));
		Ivno = Double.parseDouble(getIntent().getStringExtra("Ivno"));
		if (Double.parseDouble(getIntent().getStringExtra("price")) < Double.parseDouble(getIntent().getStringExtra("net"))) {
			textview104.setText("+".concat(new DecimalFormat("0.0").format(Double.parseDouble(getIntent().getStringExtra("net")) - Double.parseDouble(getIntent().getStringExtra("price")))));
		}
		else {
			textview104.setText(new DecimalFormat("0.0").format(Double.parseDouble(getIntent().getStringExtra("net")) - Double.parseDouble(getIntent().getStringExtra("price"))));
		}
		textview5.setText(getIntent().getStringExtra("add").trim());
		textview6.setText(getIntent().getStringExtra("state").toUpperCase().concat(" : ".concat("STATE CODE : ".concat(getIntent().getStringExtra("code")))));
		textview10.setText(String.valueOf((long)(Ivno)).concat("                                ".concat(getIntent().getStringExtra("bookno"))));
		textview21.setText(getIntent().getStringExtra("dinv"));
		textview8.setText(getIntent().getStringExtra("through").toUpperCase());
		textview15.setText(getIntent().getStringExtra("odno").toUpperCase().trim());
		textview23.setText(getIntent().getStringExtra("dod"));
		textview17.setText(getIntent().getStringExtra("car").toUpperCase());
		textview19.setText(getIntent().getStringExtra("boxesno"));
		textview26.setText(getIntent().getStringExtra("mrs").toUpperCase());
		textview103.setText(new DecimalFormat("0.00").format(Double.parseDouble(getIntent().getStringExtra("transcharge"))));
		textview108.setText(getIntent().getStringExtra("loc").toUpperCase());
		textview109.setText(getIntent().getStringExtra("dii"));
		textview110.setText(getIntent().getStringExtra("tii"));
		textview111.setText(getIntent().getStringExtra("drg"));
		textview112.setText(getIntent().getStringExtra("trg"));
		textview100.setVisibility(View.INVISIBLE);
		textview101.setVisibility(View.INVISIBLE);
		textview102.setVisibility(View.INVISIBLE);
		textview96.setVisibility(View.INVISIBLE);
		textview70.setVisibility(View.INVISIBLE);
		textview71.setVisibility(View.INVISIBLE);
		if (getIntent().getStringExtra("code").equals("09")) {
			textview100.setText(getIntent().getStringExtra("gst1"));
			textview102.setText(getIntent().getStringExtra("gst2"));
			textview100.setVisibility(View.VISIBLE);
			textview102.setVisibility(View.VISIBLE);
			textview96.setVisibility(View.VISIBLE);
			textview71.setVisibility(View.VISIBLE);
		}
		else {
			textview101.setText(getIntent().getStringExtra("gst1"));
			textview101.setVisibility(View.VISIBLE);
			textview70.setVisibility(View.VISIBLE);
		}
		textview62.setText(getIntent().getStringExtra("tot_qty"));
		textview63.setText(getIntent().getStringExtra("tot_price"));
		textview99.setText(getIntent().getStringExtra("tot_price"));
		textview98.setText(new DecimalFormat("00.00").format(Double.parseDouble(getIntent().getStringExtra("net"))));
		_product();
		_invisible();
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
	
	
	private void _setTextview_size (final TextView _text, final double _number) {
		_text.setTextSize((int)_number);
	}
	
	
	private void _border () {
		_RoundAndBorder(linear21, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear45, "#FFFFFF", 2, "#000000", 0);
		_RoundAndBorder(linear1, "#FFFFFF", 3, "#000000", 110);
		_RoundAndBorder(linear8, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear6, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear10, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear13, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear14, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear15, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear16, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear17, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear18, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear19, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear20, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview29, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview30, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview31, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview32, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview33, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear23, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear24, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear25, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear26, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear27, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear28, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview61, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview62, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview63, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear34, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear35, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear37, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear38, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(textview66, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear29, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear23, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear22, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear42, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear46, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear48, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear50, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear51, "#FFFFFF", 1, "#000000", 0);
		_RoundAndBorder(linear54, "#FFFFFF", 1, "#000000", 0);
	}
	
	
	private void _text () {
		_setTextview_size(textview5, 7);
		_setTextview_size(textview6, 7);
		_setTextview_size(textview4, 7);
		_setTextview_size(textview8, 7);
		_setTextview_size(textview7, 7);
		_setTextview_size(textview9, 6);
		_setTextview_size(textview10, 6);
		_setTextview_size(textview12, 7);
		_setTextview_size(textview13, 7);
		_setTextview_size(textview14, 6);
		_setTextview_size(textview15, 6);
		_setTextview_size(textview16, 6);
		_setTextview_size(textview17, 6);
		_setTextview_size(textview18, 6);
		_setTextview_size(textview19, 6);
		_setTextview_size(textview20, 6);
		_setTextview_size(textview21, 6);
		_setTextview_size(textview22, 6);
		_setTextview_size(textview23, 6);
		_setTextview_size(textview24, 6);
		_setTextview_size(textview25, 6);
		_setTextview_size(textview26, 6);
		_setTextview_size(textview27, 7);
		_setTextview_size(textview28, 7);
		_setTextview_size(textview29, 5);
		_setTextview_size(textview30, 5);
		_setTextview_size(textview31, 5);
		_setTextview_size(textview32, 5);
		_setTextview_size(textview33, 5);
		_setTextview_size(textview34, 7);
		_setTextview_size(textview35, 7);
		_setTextview_size(textview36, 7);
		_setTextview_size(textview37, 7);
		_setTextview_size(textview38, 7);
		_setTextview_size(textview39, 7);
		_setTextview_size(textview40, 7);
		_setTextview_size(textview41, 7);
		_setTextview_size(textview42, 7);
		_setTextview_size(textview43, 7);
		_setTextview_size(textview44, 7);
		_setTextview_size(textview45, 7);
		_setTextview_size(textview46, 7);
		_setTextview_size(textview47, 7);
		_setTextview_size(textview48, 7);
		_setTextview_size(textview49, 7);
		_setTextview_size(textview50, 7);
		_setTextview_size(textview51, 7);
		_setTextview_size(textview52, 7);
		_setTextview_size(textview53, 7);
		_setTextview_size(textview54, 7);
		_setTextview_size(textview55, 7);
		_setTextview_size(textview56, 7);
		_setTextview_size(textview57, 7);
		_setTextview_size(textview58, 7);
		_setTextview_size(textview59, 7);
		_setTextview_size(textview60, 7);
		_setTextview_size(textview61, 7);
		_setTextview_size(textview62, 7);
		_setTextview_size(textview63, 7);
		_setTextview_size(textview64, 7);
		_setTextview_size(textview65, 7);
		_setTextview_size(textview67, 6);
		_setTextview_size(textview68, 6);
		_setTextview_size(textview69, 7);
		_setTextview_size(textview70, 7);
		_setTextview_size(textview71, 7);
		_setTextview_size(textview72, 7);
		_setTextview_size(textview73, 7);
		_setTextview_size(textview74, 7);
		_setTextview_size(textview93, 6);
		_setTextview_size(textview75, 7);
		_setTextview_size(textview76, 7);
		_setTextview_size(textview77, 7);
		_setTextview_size(textview78, 7);
		_setTextview_size(textview79, 7);
		_setTextview_size(textview80, 7);
		_setTextview_size(textview81, 7);
		_setTextview_size(textview82, 7);
		_setTextview_size(textview83, 7);
		_setTextview_size(textview84, 7);
		_setTextview_size(textview85, 7);
		_setTextview_size(textview86, 7);
		_setTextview_size(textview87, 7);
		_setTextview_size(textview88, 7);
		_setTextview_size(textview89, 7);
		_setTextview_size(textview90, 7);
		_setTextview_size(textview91, 7);
		_setTextview_size(textview92, 7);
		_setTextview_size(textview94, 7);
		_setTextview_size(textview93, 7);
		_setTextview_size(textview95, 6);
		_setTextview_size(textview97, 8);
		_setTextview_size(textview98, 8);
		_setTextview_size(textview105, 5);
		_setTextview_size(textview106, 5);
		_setTextview_size(textview107, 5);
		_setTextview_size(textview108, 5);
		_setTextview_size(textview109, 5);
		_setTextview_size(textview110, 5);
		_setTextview_size(textview111, 5);
		_setTextview_size(textview112, 5);
		_setTextview_size(textview113, 8);
		_setTextview_size(textview114, 6);
		_setTextview_size(textview96, 7);
		_setTextview_size(textview99, 7);
		_setTextview_size(textview100, 7);
		_setTextview_size(textview101, 7);
		_setTextview_size(textview102, 7);
		_setTextview_size(textview103, 7);
		_setTextview_size(textview104, 7);
	}
	
	
	private void _product () {
		textview84.setText(getIntent().getStringExtra("v1"));
		textview34.setText(getIntent().getStringExtra("p1"));
		textview52.setText(getIntent().getStringExtra("q1"));
		textview75.setText(getIntent().getStringExtra("r1"));
		textview85.setText(getIntent().getStringExtra("v2"));
		textview35.setText(getIntent().getStringExtra("p2"));
		textview53.setText(getIntent().getStringExtra("q2"));
		textview76.setText(getIntent().getStringExtra("r2"));
		textview86.setText(getIntent().getStringExtra("v3"));
		textview36.setText(getIntent().getStringExtra("p3"));
		textview54.setText(getIntent().getStringExtra("q3"));
		textview77.setText(getIntent().getStringExtra("r3"));
		textview87.setText(getIntent().getStringExtra("v4"));
		textview37.setText(getIntent().getStringExtra("p4"));
		textview55.setText(getIntent().getStringExtra("q4"));
		textview78.setText(getIntent().getStringExtra("r4"));
		textview88.setText(getIntent().getStringExtra("v5"));
		textview38.setText(getIntent().getStringExtra("p5"));
		textview56.setText(getIntent().getStringExtra("q5"));
		textview79.setText(getIntent().getStringExtra("r5"));
		textview39.setText(getIntent().getStringExtra("p6"));
		textview57.setText(getIntent().getStringExtra("q6"));
		textview80.setText(getIntent().getStringExtra("r6"));
		textview89.setText(getIntent().getStringExtra("v6"));
		textview40.setText(getIntent().getStringExtra("p7"));
		textview58.setText(getIntent().getStringExtra("q7"));
		textview81.setText(getIntent().getStringExtra("r7"));
		textview90.setText(getIntent().getStringExtra("v7"));
		textview41.setText(getIntent().getStringExtra("p8"));
		textview59.setText(getIntent().getStringExtra("q8"));
		textview82.setText(getIntent().getStringExtra("r8"));
		textview91.setText(getIntent().getStringExtra("v8"));
		textview42.setText(getIntent().getStringExtra("p9"));
		textview60.setText(getIntent().getStringExtra("q9"));
		textview83.setText(getIntent().getStringExtra("r9"));
		textview92.setText(getIntent().getStringExtra("v9"));
	}
	
	
	private void _invisible () {
		if (textview34.getText().toString().equals("")) {
			textview43.setVisibility(View.INVISIBLE);
			textview34.setVisibility(View.INVISIBLE);
		}
		else {
			textview34.setText("Speaker : ".concat(textview34.getText().toString()));
		}
		if (textview35.getText().toString().equals("")) {
			textview44.setVisibility(View.INVISIBLE);
			textview35.setVisibility(View.INVISIBLE);
		}
		else {
			textview35.setText("Speaker : ".concat(textview35.getText().toString()));
		}
		if (textview36.getText().toString().equals("")) {
			textview45.setVisibility(View.INVISIBLE);
			textview36.setVisibility(View.INVISIBLE);
		}
		else {
			textview36.setText("Speaker : ".concat(textview36.getText().toString()));
		}
		if (textview37.getText().toString().equals("")) {
			textview46.setVisibility(View.INVISIBLE);
			textview37.setVisibility(View.INVISIBLE);
		}
		else {
			textview37.setText("Speaker : ".concat(textview37.getText().toString()));
		}
		if (textview38.getText().toString().equals("")) {
			textview47.setVisibility(View.INVISIBLE);
			textview38.setVisibility(View.INVISIBLE);
		}
		else {
			textview38.setText("Speaker : ".concat(textview38.getText().toString()));
		}
		if (textview39.getText().toString().equals("")) {
			textview48.setVisibility(View.INVISIBLE);
			textview39.setVisibility(View.INVISIBLE);
		}
		else {
			textview39.setText("Speaker : ".concat(textview39.getText().toString()));
		}
		if (textview40.getText().toString().equals("")) {
			textview49.setVisibility(View.INVISIBLE);
			textview40.setVisibility(View.INVISIBLE);
		}
		else {
			textview40.setText("Speaker : ".concat(textview40.getText().toString()));
		}
		if (textview41.getText().toString().equals("")) {
			textview50.setVisibility(View.INVISIBLE);
			textview41.setVisibility(View.INVISIBLE);
		}
		else {
			textview41.setText("Speaker : ".concat(textview41.getText().toString()));
		}
		if (textview42.getText().toString().equals("")) {
			textview51.setVisibility(View.INVISIBLE);
			textview42.setVisibility(View.INVISIBLE);
		}
		else {
			textview42.setText("Speaker : ".concat(textview42.getText().toString()));
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
