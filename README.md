## 主要环境依赖
* Redis
* Mysql
* MongoDB

### follow
mkdir ~/volume

### Redis
docker pull  redis:3.2  
mkdir -p ~/volume/redis ~/volume/redis/data
cd ~/volume/redis
docker run -p 6379:6379 -v $PWD/data:/data  -d redis:3.2 redis-server --appendonly yes
