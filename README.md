1》project结构说明:
activity:存放activity组件的类  
adapter:存放adaper的类  
apiservice:包主要存放网络请求接口  
bean:包中存放实体类  
callback:存放定义的回调接口的类  
constants:存放接口常量类  
event:存放EventBus中的事件类  
http:包中存放网络请求工具类  
model:包中存放处理数据  
pesenter:包中存放主导器  
utils:存放工具类型的类
view:包中存放界面处理类  
2》安卓开发模式的简单说明，以往的是MVC模式，但是该项目使用的是MVP模式，MVP模式比MVC模式解耦性高，代码结构更简洁些(简洁不同于代码量少)
以下，进行简单描述说明：
  * MVC模式(M和V之间交互频繁，由C进行协调控制)：  
  * View：对应于布局文件  
  * Model：业务逻辑和实体模型  
  * Controllor：对应于Activity  
  
   * MVP模式(M和V的交互有P来完成，M和V不直接交互，p与V是通过接口交互)：  
   * View 对应于Activity，负责View的绘制以及与用户交互  
   * Model 依然是业务逻辑和实体模型  
   * Presenter 负责完成View于Model间的交互   

3》在该项目中的体现是:  
  M:VideoModel接口和其实现类VideoModelImpl(实现VideoModel接口获取数据(本地或者网络))  
  V:指的是VideoPlayerView接口,一般让Activity类实现,主要提供接口如下:  
      void showProgress();展示加载进度条  
      void hideProgress();隐藏加载进度条  
      void loadFailed(Throwable t);加载失败提示异常信息  
      void loadVideo(List<VideoInfo.ResultBean.VideoListByTimeBean> videos);主要数据通过接口回调进行处理结果  
  P:VideoPresenter接口和其实现类VideoPresenterImpl:  
     VideoPresenterImpl实现VideoPresenter接口中的方法,进行M和V的交互；  
4》其余内容介绍:  
  《1》.该案例中主要使用的网络请求是RxJava+Retrofit+Gson数据解析(api接口服务在HttpApiService中,真实过程在HttpUtils中),在ideoModelImpl中调用  
  《2》.bean实体类VideoInfo主要使用的GsonFormat(只针对标准格式json)  
  《3》.视频播放主要采用的是SurfaceView+MediaPlayer,由于列表要复用，容易错乱，使用标记解决问题  
  
  



 


