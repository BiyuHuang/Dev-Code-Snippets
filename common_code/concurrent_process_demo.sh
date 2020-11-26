#!/bin/bash
# Step1 创建有名管道
[ -e ./fd1 ] || mkfifo ./fd1

# 创建文件描述符，以可读（<）可写（>）的方式关联管道文件，这时候文件描述符3就有了有名管道文件的所有特性
exec 3<> ./fd1

# 关联后的文件描述符拥有管道文件的所有特性,所以这时候管道文件可以删除，我们留下文件描述符来用就可以了
rm -rf ./fd1

# Step2 创建令牌
for i in `seq 1 3`;
do
    # echo 每次输出一个换行符,也就是一个令牌
    echo >&3
done

# Step3 拿出令牌，进行并发操作
for line in `seq 1 10`;
do
    read -u3                    # read 命令每次读取一行，也就是拿到一个令牌
    {
        echo $(date +%Y-%m-%d:%T) $line
        sleep 10
        echo >&3                # 执行完一条命令会将令牌放回管道
    }&
done

wait

exec 3<&-                       # 关闭文件描述符的读
exec 3>&-                       # 关闭文件描述符的写
