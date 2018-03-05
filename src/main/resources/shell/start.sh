\#!/bin/bash

PROJECTNAME=spring_boot_mybatis_redis

pid=`ps -ef |grep $PROJECTNAME |grep -v "grep" |awk '{print $2}'`

if [ $pid ]; then
   echo "$PROJECTNAME  is  running  and pid=$pid"

else

   echo "Start success to start $PROJECTNAME ...."

   nohup java -jar spring_boot_mybatis_redis.jar  >> catalina.out  2>&1 &

fi
