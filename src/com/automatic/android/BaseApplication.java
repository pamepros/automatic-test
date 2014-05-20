package com.automatic.android;

import com.automatic.android.controller.ApiController;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;

public class BaseApplication extends Application {

	
	private static BaseApplication _instance;
	private static ApiController _apicontroller;
	private static ImageLoader _imageloader;

	public BaseApplication() {
		super();
		_instance = this;
	}

	public static BaseApplication getInstance() {
		return _instance;
	}
	
	public static ApiController getAPIController() {
		if(_apicontroller == null) {
			_apicontroller = new ApiController();
		}
		return _apicontroller;
	}
	
	public static ImageLoader getImageLoader() {

		if(_imageloader == null) {
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(_instance.getApplicationContext()).build();
			ImageLoader.getInstance().init(config);
            _imageloader = ImageLoader.getInstance();
		}

		return _imageloader;
	}
}
