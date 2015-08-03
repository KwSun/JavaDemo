>Python3已经渐进成熟，最新版本已经出了3.4.3~众所周知，Python2和Python3是不兼容的，而Mac的资源库里自带的Python版本是2.7.5，在我更换版本及搭建相关环境的时候，踩了几个小坑，在此记录一下~

##更换版本
由于我安装了Homebrew，因此直接通过命令brew install python3下载了安装程序，安装完成后会发现，版本显示的是3.4.2~（可能跟我的系统版本有关，just maybe~）这时你在命令行模式或者在交互模式下编辑和运行代码都没问题。但是，当你想写一个小的web demo，需要搭建开发环境的时候，新的问题就出现了。比如，当安装第三方库（比如异步框架aiohttp），输入pip3 install aiohttp，会报错
      
         File "/usr/local/bin/pip3.4", line 7, in <module>
             from pip import main
            ImportError: No module named 'pip'
 意思是导入pip的时候可能出了错~但是当我修改文件内容，或者重新easy_install,都没用~最后实在没没辙了，一想到自己这个版本是3.4.2的，就想，换成最新的版本会怎么样呢？于是上官网下载了最新的，安装完成后，执行pip3 install XXX 命令的时候，没有再报上面的错，虽然理论上3.4.X都OK的，但是实践后发现，并不都OK~
##安装IPython
自带的命令行工具并不是很强大,比如不支持补齐操作，在交互式下调试并不是很方便。Ipython，增强的交互式命令行，可以用sudo pip install ipython安装它。安装好后，当你在终端下输入ipython的时候，可能会出现“未找到命令”的错误。别急，这是因为没有在path下配置的缘故。找到profile文件，输入export PATH=/Library/Frameworks/Python.framework/Versions/3.4/bin即可。（根据自己的安装路径写入）,在终端中输入ipython中，如下图所示，支持补齐操作。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](http://7xi5yl.com1.z0.glb.clouddn.com/ipython.png)
##在eclipse中安装Python插件
1. Help--Install New Software，Name填写PyDev,Location填写http://pydev.org/updates(如果没有的话可以让eclipse自行搜索)，接下来next、accept傻瓜式安装
2. 新建Python工程时，提示如下错误：Project interpreter not specified,这是没有导入Python的开发环境导致的
3. 从Eclipse的菜单，Eclipse --> Preferences 打开首选项配置；找到左边的PyDev项展开，点击Interpreters - Python Interpreter项(Interpreter是解释器的意思)
 
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](http://7xi5yl.com1.z0.glb.clouddn.com/python1.png)
4. 然后点击右侧的 New... 按钮，Interpreter Name 填写InterpreterPython，选择python程序的安装位置，然后等待导入完成，问题解决，如图

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](http://7xi5yl.com1.z0.glb.clouddn.com/python2.png)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](http://7xi5yl.com1.z0.glb.clouddn.com/python3.png)


##安装Django
*  方式1：sudo pip3 install Django(可能会因MD5校验错误而下载失败)
*  方式2：git clone http://github.com/django/django.git,然后sudo python setup.py install 安装成功后如图
* 安装后在终端中输入django-admin，如果出现"-bash: django-admin: 未找到命令",解决方案是将/Library/Frameworks/Python.framework/Versions/3.4/bin路径下的django-admin拷贝到/usr/local/bin路径下。此时在终端下输入django-admin，如果出现如图所示则表示OK了

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;![](http://7xi5yl.com1.z0.glb.clouddn.com/django2.png)


其他平台下出现上述的问题，解决方案类似，就不一一赘述了~^O(∩_∩)O