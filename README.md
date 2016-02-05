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
curl -O https://www.openssl.org/source/openssl-1.0.2e.tar.gz
tar zxvf openssl-1.0.2e.tar.gz
curl -O http://nginx.org/download/nginx-1.8.1.tar.gz
tar zxvf nginx-1.8.1.tar.gz
```
```
# Mac Open SSL adjust 
# in: ./auto/lib/openssl/make 
# replace: && ./config --prefix=$ngx_prefix no-shared $OPENSSL_OPT \\ 
# with: && ./Configure darwin64-x86_64-cc --prefix=$ngx_prefix no-shared $OPENSSL_OPT \\
```
```
./configure --prefix=$APP_HOME/nginx-1.8.1 --sbin-path=$APP_HOME/nginx-1.8.1/nginx --conf-path=$APP_HOME/nginx-1.8.1/nginx.conf --pid-path=APP_HOME/nginx-1.8.1/nginx.pid --with-http_ssl_module --with-pcre=../pcre-8.21 --with-zlib=../zlib-1.2.5 --with-openssl=../openssl-1.0.2e
make; make install

cd $APP_HOME
ln -s nginx-1.8.1 nginx
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


