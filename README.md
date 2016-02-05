# SpringSkeleton

## Setting
 * env
```
#/etc/profile
export APP_HOME=ANYWHERE_YOU_WISH
```

 * Nginx
```
curl -OJL "http://sourceforge.net/projects/pcre/files/pcre/8.21/pcre-8.21.tar.gz/download"
tar zxvf pcre-8.21.tar.gz
curl -OJL "http://sourceforge.net/projects/libpng/files/zlib/1.2.5/zlib-1.2.5.tar.gz/download"
tar zxvf zlib-1.2.5.tar.gz
curl -OJL https://github.com/openssl/openssl/archive/OpenSSL_1_0_2e.tar.gz
tar zxvf openssl-OpenSSL_1_0_2e.tar.gz
curl -O http://nginx.org/download/nginx-1.8.1.tar.gz
tar zxvf nginx-1.8.1.tar.gz
```
```
# Mac Open SSL adjust 
# in: nginx-1.8.1/auto/lib/openssl/make 
# replace: && ./config --prefix=$ngx_prefix no-shared $OPENSSL_OPT \\ 
# with: && ./Configure darwin64-x86_64-cc --prefix=$ngx_prefix no-shared $OPENSSL_OPT \\
```
```
./configure --prefix=$APP_HOME/nginx-1.8.1 --sbin-path=$APP_HOME/nginx-1.8.1/nginx --conf-path=$APP_HOME/nginx-1.8.1/nginx.conf --pid-path=APP_HOME/nginx-1.8.1/nginx.pid --with-http_ssl_module --with-pcre=../pcre-8.21 --with-zlib=../zlib-1.2.5 --with-openssl=../openssl-OpenSSL-1_0_2e
make; make install

cd $APP_HOME
ln -s nginx-1.8.1 nginx
```
```
#/etc/profile
export NGINX_HOME=$APP_HOME/nginx
export PATH=$NGINX_HOME/bin:$PATH
```

* MySQL
	* For 10.10
		```curl -OL http://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.10-osx10.10-x86_64.dmg```
	* For 10.9
		```curl -OL http://dev.mysql.com/get/Downloads/MySQL-5.7/mysql-5.7.10-osx10.9-x86_64.dmg```
	* Workbench
	  ```curl -OL http://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community-6.3.6-osx-x86_64.dmg```

```
cp /usr/local/mysql/support-files/my-default.cnf /etc/my.cnf
```
```
#/etc/my.cnf
[mysqld]
character-set-server=utf8
collation-server=utf8_general_ci

init_connect=SET collation_connection=utf8_general_ci
init_connect=SET NAMES utf8

[client]
default-character-set=utf8

[mysql]
default-character-set=utf8
```
```
sudo /usr/local/mysql/support-files/mysql.server start
/usr/local/mysql/bin/mysql -u root -p
use mysql;
ALTER USER 'root'@'localhost' IDENTIFIED BY 'do_not_use';

create database testdb;
grant all privileges on testdb.* to dev@localhost identified by 'dev';
```

* Tomcat
```
curl -O http://apache.mirror.cdnetworks.com/tomcat/tomcat-8/v8.0.30/bin/apache-tomcat-8.0.30.tar.gz
tar zxvf apache-tomcat-8.0.30.tar.gz
cp -R apache-tomcat-8.0.30 $APP_HOME/
cd $APP_HOME
ln -s apache-tomcat-8.0.30 apache-tomcat
```
```
#/etc/profile
export CATALINA_HOME=$APP_HOME/apache-tomcat
export PATH=$CATALINA_HOME/bin:$PATH
```

 * Maven
```
curl -O http://apache.tt.co.kr/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.tar.gz
tar zxvf apache-maven-3.3.9-bin.tar.gz
cp -R apache-maven-3.3.9 $APP_HOME/
cd $APP_HOME
ln -s apache-maven-3.3.9 apache-maven
```
```
#/etc/profile
export M2_HOME=$APP_HOME/apache-maven
export M2=$M2_HOME/bin
export PATH=$M2:$PATH
```

 * STS : `http://dist.springsource.com/release/STS/3.7.2.RELEASE/dist/e4.5/spring-tool-suite-3.7.2.RELEASE-e4.5.1-macosx-cocoa-x86_64.tar.gz`
