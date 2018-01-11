package com.rabtman.common.base;

import android.app.Application;
import com.rabtman.common.di.component.AppComponent;


public abstract class BaseApplication extends Application implements App {

  private CommonApplicationLike mCommonApplicationLike;


  @Override
  public void onCreate() {
    super.onCreate();
    this.mCommonApplicationLike = new CommonApplicationLike(this);
    this.mCommonApplicationLike.onCreate();
  }

  /**
   * 程序终止的时候执行
   */
  @Override
  public void onTerminate() {
    super.onTerminate();
    this.mCommonApplicationLike.onTerminate();
  }


  /**
   * 将AppComponent返回出去,供其它地方使用, AppComponent接口中声明的方法返回的实例,在getAppComponent()拿到对象后都可以直接使用
   *
   * @return
   */
  @Override
  public AppComponent getAppComponent() {
    return mCommonApplicationLike.getAppComponent();
  }

}
