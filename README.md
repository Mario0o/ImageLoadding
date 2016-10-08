# ImageLoadding
#缓存原理
![这里写图片描述](http://img.blog.csdn.net/20161009030526446)
##Usage
###simple
1.将开源库导入项目即可使用
```
	BitMapUtils bitMapUtils = new BitMapUtils();
	bitMapUtils.disPlay();
```
###USE

```
       ImageLoadConfig config = new ImageLoadConfig();
            config.setLOCAL_PATH(getCacheDir().getPath()).
                    setMaxMemory(1024*1024*4).
                    setCONNECT_TIME(3000).
                    setDefault_image_Id(R.mipmap.ic_image).
                    setREAD_TIME(3000).
                    setUseDiskCache(true).
                    setInSampleSize(2);
                    
            BitMapUtils bitMapUtils = new BitMapUtils(config);
            bitMapUtils.disPlay(imageView,url);
```
