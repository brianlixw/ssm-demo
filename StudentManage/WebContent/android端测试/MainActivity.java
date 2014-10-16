package com.sisv.json2;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.json.JSONException;
import org.json.JSONObject;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

/**
 * android-async-http�����õ�1.4.5�汾����JsonHttpResponseHandler��ȡ���ص�json���ݣ�
 * ����1.4.4�и�bug��http://www.2cto.com/kf/201403/287457.html��������1.4.5
 * 
 * @author Administrator
 */
public class MainActivity extends Activity {

	public static final String HTTPCustomer = "http://10.255.92.152:8080/StudentManage/android/loginAction";
	private Button loginButton;
	private EditText tv_username;
	private EditText tv_password;
	private ListView lv_users;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv_users = (ListView) findViewById(R.id.lv_users);
		loginButton = (Button) findViewById(R.id.loginButton);

		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				tv_username = (EditText) findViewById(R.id.tv_username);
				String username = tv_username.getText().toString().trim();
				tv_password = (EditText) findViewById(R.id.tv_password);
				String password = tv_password.getText().toString().trim();

				if (!username.equals("") && !password.equals("")) {
					initData(username, password);
				}
			}
		});
	}

	private void initData(String name, String password) {
		// ���ʷ������� ��ȡjson����
		// �����ͻ��˶���
		AsyncHttpClient client = new AsyncHttpClient();
		Toast.makeText(this, "�������󵽷�����", Toast.LENGTH_LONG).show();
		RequestParams params = new RequestParams();
		params.put("student.username", name);
		params.put("student.password", password);
		client.post(HTTPCustomer, params, new JsonHttpResponseHandler() {
			/**
			 * ����������������json���󣬷��������ص���json�����������������������json���飬
			 * ���ȡ����ֵ���²���android-async-http�����ж�,����˷��ص�json���ݣ�
			 * {"loginResult":"successLogin"
			 * ,"student":{"birthday":null,"classGrade":
			 * {"name":"�ƿ�1��","pro":{"dep"
			 * :{"name":"���������Ϣ����ѧԺ"},"name":"�������ѧ�뼼��"}},
			 * "number":" 33","phone":"18255032152","sex":"��","username":"1"}}
			 */
			@Override
			public void onSuccess(int statusCode, Header[] headers,
					JSONObject response) {
				super.onSuccess(statusCode, headers, response);
				Toast.makeText(getApplicationContext(),
						"����ɹ�" + new String(response.toString()),
						Toast.LENGTH_LONG).show();
				List<String> objects = new ArrayList<String>();
				try {
					objects.add(response.getString("loginResult"));
					Log.i("TAG", response.getString("student"));
					// ��student�ַ���ת��Ϊjson��������õ���student�Ѿ���json��ʽ����
					JSONObject a = new JSONObject(response.getString("student"));
					objects.add(a.getString("username"));
					objects.add(a.getString("sex"));
				} catch (JSONException e) {
					e.printStackTrace();
				}
				ArrayAdapter<String> adapter = new ArrayAdapter<String>(
						MainActivity.this, android.R.layout.simple_list_item_1,
						objects);
				// ������ʾ������
				lv_users.setAdapter(adapter);
			}
		});
	}
}
