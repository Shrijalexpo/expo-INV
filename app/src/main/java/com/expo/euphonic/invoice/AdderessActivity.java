package com.expo.euphonic.invoice;

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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.EditText;
import android.content.Intent;
import android.net.Uri;
import android.app.Activity;
import android.content.SharedPreferences;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import android.widget.AdapterView;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.ClipData;
import android.content.ClipboardManager;

public class AdderessActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> lvw_item = new HashMap<>();
	private String add1 = "";
	private double code = 0;
	private double position = 0;
	private String add = "";
	private String codee = "";
	
	private ArrayList<HashMap<String, Object>> lvw_items = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear5;
	private ListView listview1;
	private TextView textview2;
	private TextView textview3;
	private TextView textview1;
	private ImageView imageview4;
	private ImageView imageview2;
	private EditText edittext4;
	private ImageView imageview3;
	
	private Intent i = new Intent();
	private SharedPreferences data;
	private AlertDialog.Builder dialog;
	private DatabaseReference frd = _firebase.getReference("expo-inv/Addresses");
	private ChildEventListener _frd_child_listener;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.adderess);
		com.google.firebase.FirebaseApp.initializeApp(this);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		listview1 = (ListView) findViewById(R.id.listview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview1 = (TextView) findViewById(R.id.textview1);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		edittext4 = (EditText) findViewById(R.id.edittext4);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		dialog = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext4.setText("");
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.putExtra("add1", lvw_items.get((int)_position).get("add").toString());
				i.putExtra("add2", lvw_items.get((int)_position).get("code").toString());
				i.setClass(getApplicationContext(), CreateActivity.class);
				startActivity(i);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				dialog.setTitle("Address :");
				final EditText edittext1= new EditText(AdderessActivity.this);
				
				LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
				
				edittext1.setLayoutParams(lpar);
				
				dialog.setView(edittext1);
				
				
				dialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						textview2.setText(edittext1.getText());
						dialog.setTitle("State Code :");
						final EditText edittext2= new EditText(AdderessActivity.this);
						
						LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
						
						edittext2.setLayoutParams(lpar);
						
						dialog.setView(edittext2);
						
						
						dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								textview3.setText(edittext2.getText());
								if (!textview2.getText().toString().equals("") && !textview3.getText().toString().equals("")) {
									lvw_item = new HashMap<>();
									lvw_item.put("add", textview2.getText().toString().toUpperCase());
									lvw_item.put("code", textview3.getText().toString());
									frd.child("add ".concat(String.valueOf((long)(list.size() + 1)))).updateChildren(lvw_item);
									textview2.setText("");
									textview3.setText("");
									SketchwareUtil.showMessage(getApplicationContext(), "New address saved");
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Error!!!");
								}
							}
						});
						dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								textview2.setText("");
								textview3.setText("");
							}
						});
						dialog.create().show();
					}
				});
				dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						textview2.setText("");
						textview3.setText("");
					}
				});
				dialog.create().show();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear5.setVisibility(View.VISIBLE);
			}
		});
		
		edittext4.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				
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
				
			}
		});
		
		_frd_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				frd.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lvw_items = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lvw_items.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						list.add(_childKey);
						listview1.setAdapter(new Listview1Adapter(lvw_items));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				frd.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lvw_items = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lvw_items.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						list.add(_childKey);
						listview1.setAdapter(new Listview1Adapter(lvw_items));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
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
				frd.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						lvw_items = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								lvw_items.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						list.add(_childKey);
						listview1.setAdapter(new Listview1Adapter(lvw_items));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		frd.addChildEventListener(_frd_child_listener);
		
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
		_RoundAndBorder(linear2, "#FFFFFF", 3, "#000000", 110);
		_setTextview_size(textview2, 1);
		_setTextview_size(textview3, 1);
		linear5.setVisibility(View.INVISIBLE);
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
	
	
	private void _watsapp_share (final String _text, final String _file) {
		Intent shareIntent = new Intent(Intent.ACTION_SEND); shareIntent.setType("text/plain");  shareIntent.putExtra(Intent.EXTRA_TEXT, _text);
		 startActivity(Intent.createChooser( shareIntent, "Share"));
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
				_v = _inflater.inflate(R.layout.custom, null);
			}
			
			final LinearLayout linear1 = (LinearLayout) _v.findViewById(R.id.linear1);
			final LinearLayout linear2 = (LinearLayout) _v.findViewById(R.id.linear2);
			final LinearLayout linear4 = (LinearLayout) _v.findViewById(R.id.linear4);
			final TextView num = (TextView) _v.findViewById(R.id.num);
			final TextView textview1 = (TextView) _v.findViewById(R.id.textview1);
			final TextView textview3 = (TextView) _v.findViewById(R.id.textview3);
			final TextView textview2 = (TextView) _v.findViewById(R.id.textview2);
			final LinearLayout linear5 = (LinearLayout) _v.findViewById(R.id.linear5);
			final ImageView imageview4 = (ImageView) _v.findViewById(R.id.imageview4);
			final ImageView imageview3 = (ImageView) _v.findViewById(R.id.imageview3);
			final ImageView imageview2 = (ImageView) _v.findViewById(R.id.imageview2);
			final ImageView imageview1 = (ImageView) _v.findViewById(R.id.imageview1);
			
			textview1.setText(lvw_items.get((int)_position).get("add").toString());
			textview2.setText(lvw_items.get((int)_position).get("code").toString());
			num.setText(String.valueOf((long)(_position + 1)).concat(". "));
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					frd.child(list.get((int)(_position))).removeValue();
					SketchwareUtil.showMessage(getApplicationContext(), "Address deleted");
				}
			});
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", lvw_items.get((int)_position).get("add").toString().concat("\n".concat("State code: ".concat(lvw_items.get((int)_position).get("code").toString())))));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied to Clipboard");
				}
			});
			imageview3.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_watsapp_share(lvw_items.get((int)_position).get("add").toString().concat("\n".concat("State code: ".concat(lvw_items.get((int)_position).get("code").toString()))), "");
				}
			});
			imageview4.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					add = lvw_items.get((int)_position).get("add").toString();
					codee = lvw_items.get((int)_position).get("code").toString();
					dialog.setTitle("Address :");
					final EditText edittext3= new EditText(AdderessActivity.this);
					
					LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
					
					edittext3.setLayoutParams(lpar);
					
					dialog.setView(edittext3);
					
					
					edittext3.setText(add);
					dialog.setPositiveButton("Next", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							add = (edittext3.getText().toString());
							dialog.setTitle("State Code :");
							final EditText edittext4= new EditText(AdderessActivity.this);
							
							LinearLayout.LayoutParams lpar = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
							
							edittext4.setLayoutParams(lpar);
							
							dialog.setView(edittext4);
							
							
							edittext4.setText(codee);
							dialog.setPositiveButton("Save", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									codee = (edittext4.getText().toString());
									if (!add.equals("") && !codee.equals("")) {
										lvw_item.put("add", add.toUpperCase().trim());
										lvw_item.put("code", codee.trim());
										frd.child("add ".concat(String.valueOf((long)(_position + 1)))).updateChildren(lvw_item);
										SketchwareUtil.showMessage(getApplicationContext(), "Address updated");
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Error!!!");
									}
								}
							});
							dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							dialog.create().show();
						}
					});
					dialog.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface _dialog, int _which) {
							
						}
					});
					dialog.create().show();
				}
			});
			
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
