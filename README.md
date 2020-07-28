# VRHotel_pro

The VR Hotel Android application.

实现了一个Android app这个app可以搜索自己喜欢的酒店。

<img width="200" src="https://github.com/Skandinaviske/VRHotel_pro/blob/master/IMG/1.png"/>
登录界面，可以在界面搜索关键字找到自己理想的酒店信息或主题。

利用fragment实现点击按钮切换fragment(包括以下三个fragment显示酒店基本信息)：

Summary: 酒店具体描述（酒店内容均保存在本地，因为是个demo）
Location: 调用Google map显示酒店的位置
Gallery: 并且通过grid view查看酒店的图片（Unity 3D生成的VR图片，因为是个Demo，所以所有图片存在assets里，因为图片过多太占地方，每个room我只留了一张图片,本来是九宫格）
展示如下：会按不同的房间进行分类：
<img width="200" src="https://github.com/Skandinaviske/VRHotel_pro/blob/master/IMG/3.jpg"/>
点击图片进去后可以查看多有关于这个酒店的图片信息：
<img width="200" src="https://github.com/Skandinaviske/VRHotel_pro/blob/master/IMG/2.jpg"/>

通过点击图片，可链接启动VR app(Unity 3D搭建的):
<img width="200" src="https://github.com/Skandinaviske/VRHotel_pro/blob/master/IMG/4.jpg"/>

可使用Google Cardboard进行查看VR模式：
<img width="200" src="https://github.com/Skandinaviske/VRHotel_pro/blob/master/IMG/5.jpg"/>
（通过向下移动Google Cardboard可以实现向前走）
我暂时没有将Unity生成的app上传 因为太大了 Github有点放不下。


# Author
Ailwyn和他的Teammate
