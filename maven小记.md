##maven小记
 * mvn -v 查看版本
 * compile 编译
 * test 测试
 * package 打包
 * clean 删除target
 * install 安装jar包到本地仓库中
 
###maven生命周期
 * clean 清理项目
 	1. pre-clean 执行清理前的工作
 	2. clean清理上一次构建生成的所有文件
 	3. post-clean执行清理后的文件
 * default 构建项目（最核心）
     * compile test package install
 * site 生成项目站点
     * pre-site 在生成项目站点前要完成的工作
     * site 生成项目的站点文档
     * post-site 在生成项目站点后要完成的工作
     * site-deploy 发布生成的站点到服务器上
 