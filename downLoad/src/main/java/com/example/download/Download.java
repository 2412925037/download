package com.example.download;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.utils.HttpDownloader;

public class Download extends Activity {

	private Button downloadtxt;
	private Button downloadmp3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		downloadtxt = (Button) findViewById(R.id.download_txt);
		downloadtxt.setOnClickListener(new DownLoadTxt());
		downloadmp3 = (Button) findViewById(R.id.download_mp3);
		downloadmp3.setOnClickListener(new DownLoadMp3());
	}

	/**
	 * 下载文本文件，主要是字符流
	 * @author Administrator
	 *
	 */
	class DownLoadTxt implements OnClickListener {

		@Override
		public void onClick(View v) {

			// TODO Auto-generated method stub
			HttpDownloader httpDownloader = new HttpDownloader();
			int result = httpDownloader.download(
					"http://192.168.0.152:8080/mp3/a1.lrc", "mp3Test/abc/",
					"a1.lrc");
			System.out.println("down load txt result = " + result);
			// String lrc =
			// httpDownloader.download("http://192.168.0.152:8080/mp3/a1.lrc");
			// System.out.println("down load txt = " + lrc);
		}

	}

	/**
	 * 下载字节流文件，也可以下载字符流文件
	 * @author Administrator
	 *
	 */
	class DownLoadMp3 implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			HttpDownloader httpDownloader = new HttpDownloader();
			int result = httpDownloader.downFile(
					"http://192.168.0.152:8080/mp3/a1.mp3", "mp3Test/",
					"a1.mp3");
			System.out.println("downfile load txt result = " + result);
		}
	}
}
