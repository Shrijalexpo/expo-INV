package com.expo.euphonic.invoice.beta;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.ClipData;
import android.widget.AdapterView;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;

public class HomeActivity extends AppCompatActivity {
	
	public final int REQ_CD_FILE = 101;
	
	private FloatingActionButton _fab;
	private String Folder = "";
	private String UpFolder = "";
	private double position = 0;
	private String subtitle = "";
	private String play = "";
	private String info = "";
	private double song = 0;
	private boolean b = false;
	private String path = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> liststring = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private ListView listview1;
	private TextView textview3;
	private TextView textview1;
	private TextView textview2;
	
	private Intent in = new Intent();
	private AlertDialog.Builder dialog;
	private Intent file = new Intent(Intent.ACTION_GET_CONTENT);
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, 1000);
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
		
		_fab = (FloatingActionButton) findViewById(R.id._fab);
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		dialog = new AlertDialog.Builder(this);
		file.setType("text/*");
		file.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
					Folder = liststring.get((int)(_position));
					_RefreshData();
					textview2.setText(Folder);
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".jpg")) {
						
						in.putExtra("title", Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
						in.putExtra("img", liststring.get((int)(_position)));
						startActivity(in);
					}
					if (liststring.get((int)(_position)).endsWith(".png")) {
						
						in.putExtra("title", Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
						in.putExtra("img", liststring.get((int)(_position)));
						startActivity(in);
					}
					if (liststring.get((int)(_position)).endsWith(".pdf")) {
						_any(liststring.get((int)(_position)));
					}
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (FileUtil.isFile(liststring.get((int)(_position)))) {
					dialog.setTitle(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
					dialog.setPositiveButton("Open", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_any(liststring.get((int)(_position)));
						}
					});
					dialog.setNegativeButton("Share", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							_watsapp_share(Uri.parse(liststring.get((int)(_position))).getLastPathSegment(), liststring.get((int)(_position)));
						}
					});
					dialog.setNeutralButton("info", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							in.putExtra("path", liststring.get((int)(_position)));
							in.setClass(getApplicationContext(), ViewerActivity.class);
							startActivity(in);
						}
					});
					dialog.create().show();
				}
				return true;
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), RecoverActivity.class);
				startActivity(in);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), AdderessActivity.class);
				startActivity(in);
			}
		});
	}
	private void initializeLogic() {
		_RoundAndBorder(linear3, "#FFFFFF", 3, "#000000", 110);
		_RoundAndBorder(textview3, "#FFFFFF", 3, "#000000", 110);
		song = -1;
		Folder = FileUtil.getExternalStorageDir().concat("/".concat("expo-INV"));
		textview2.setText(Folder);
		_RefreshData();
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
		if (Folder.equals(FileUtil.getExternalStorageDir().concat("/".concat("expo-INV")))) {
			finishAffinity();
		}
		else {
			UpFolder = Folder.substring((int)(0), (int)(Folder.lastIndexOf("/")));
			Folder = UpFolder;
			textview2.setText(Folder);
			_RefreshData();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_RefreshData();
	}
	private void _RefreshData () {
		listmap.clear();
		subtitle = Folder.replace(FileUtil.getExternalStorageDir().concat("/expo-INV"), "");
		FileUtil.listDir(Folder, liststring);
		Collections.sort(liststring, String.CASE_INSENSITIVE_ORDER);
		position = 0;
		for(int _repeat14 = 0; _repeat14 < (int)(liststring.size()); _repeat14++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("file", liststring.get((int)(position)));
				listmap.add(_item);
			}
			
			position++;
		}
		listview1.setAdapter(new Listview1Adapter(listmap));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	
	private void _watsapp_share (final String _text, final String _file) {
		Intent shareIntent = new Intent(Intent.ACTION_SEND); shareIntent.setType("text/plain");  shareIntent.putExtra(Intent.EXTRA_TEXT, _text);
		shareIntent.putExtra (Intent.EXTRA_STREAM, Uri.parse(_file));
		startActivity(Intent.createChooser( shareIntent, "Share"));
	}
	
	
	private void _RoundAndBorder (final View _view, final String _color1, final double _border, final String _color2, final double _round) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color1));
		gd.setCornerRadius((int) _round);
		gd.setStroke((int) _border, Color.parseColor(_color2));
		_view.setBackground(gd);
	}
	
	
	private void _Print (final String _text, final String _file) {
		
	}
	
	
	private void _OpenFile (final String _path, final String _package1, final String _type) {
		java.io.File file = new java.io.File(_path);
		Uri path = Uri.fromFile(file);
		Intent intent = new Intent();
		intent.setPackage(_package1); intent.setDataAndType(Uri.fromFile(file), _type);
		startActivity(intent);
	}
	
	
	private void _any (final String _path) {
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder().build());
		java.io.File item =new java.io.File(_path);
		
		Intent myIntent = new Intent(Intent.ACTION_VIEW);
		myIntent.setData(Uri.fromFile(item));
		Intent j = Intent.createChooser(myIntent, "Choose an application to open with:");
		startActivity(j);
		//code by Amitoj Singh
	}
	
	
	public class Listview1Adapter extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _view, ViewGroup _viewGroup) {
			LayoutInflater _inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View _v = _view;
			if (_v == null) {
				_v = _inflater.inflate(R.layout.cus, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			
			textview1.setText(Uri.parse(liststring.get((int)(_position))).getLastPathSegment());
			textview2.setVisibility(View.GONE);
			if (FileUtil.isDirectory(liststring.get((int)(_position)))) {
				imageview1.setImageResource(R.drawable.folder);
			}
			else {
				if (liststring.get((int)(_position)).endsWith(".png")) {
					imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
					info = liststring.get((int)(_position));
					final java.io.File file1 = new java.io.File(info);
					try{
						long length = file1.length();
						length = length/1024;
						textview2.setText("File size : " + length +" KB");
					}catch(Exception e){
						showMessage("File not found : " + e.getMessage() + e);
					}
					textview2.setVisibility(View.VISIBLE);
				}
				else {
					if (liststring.get((int)(_position)).endsWith(".pdf")) {
						imageview1.setImageResource(R.drawable.pdf);
						info = liststring.get((int)(_position));
						final java.io.File file1 = new java.io.File(info);
						try{
							long length = file1.length();
							length = length/1024;
							textview2.setText("File size : " + length +" KB");
						}catch(Exception e){
							showMessage("File not found : " + e.getMessage() + e);
						}
						textview2.setVisibility(View.VISIBLE);
					}
					else {
						if (liststring.get((int)(_position)).endsWith(".jpg")) {
							imageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(liststring.get((int)(_position)), 1024, 1024));
							info = liststring.get((int)(_position));
							final java.io.File file1 = new java.io.File(info);
							try{
								long length = file1.length();
								length = length/1024;
								textview2.setText("File size : " + length +" KB");
							}catch(Exception e){
								showMessage("File not found : " + e.getMessage() + e);
							}
							textview2.setVisibility(View.VISIBLE);
						}
						else {
							
						}
					}
				}
			}
			
			return _v;
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
