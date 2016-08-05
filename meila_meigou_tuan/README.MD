## 拼团项目

**开发**

打开cmd或者git bash执行命令`npm install`安装gulp依赖。完成修改后执行`gulp`压缩文件。然后再`git commit -am 'a new commit' && git push`即可


+   [doT模板引擎](http://olado.github.io/doT/)

**部署测试环境**

>host:172.18.5.65:22
>userName/password:dev/meila2013

连接后，输入：`/home/dev/ouer_code/build-test-tuan.sh <分支名>`，等待执行完毕，访问链接`http://dev.meilapp.com:8011/ptuan/group/group-zone.html`或者`http://dev.meilapp.com:10001/ptuan/group/group-zone.html`即可看到修改


#### gulp命令：

|任务|执行效果|
|----:|:----|
|gulp [default]|美化js并压缩js，压缩图片，压缩css|


基础任务

|基础任务|执行效果|
|----:|:----|
|gulp beautify_js|美化src目录下的所有js|
|gulp beautify_gulpfile|美化gulpfile.js|
|gulp beautify|同时执行上面的2条任务|
|gulp uglify|将src目录里的js文件同名压缩成.min.js|
|gulp minifycss|将src目录里的css文件同名压缩成.min.css|
|gulp imagemin|将src目录里的图片同名压缩|
|gulp clean|移除dest目录中的所有文件|


 

