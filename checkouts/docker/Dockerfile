# Version 0.0.1
FROM java:8
#FROM frolvlad/alpine-oraclejdk8

MAINTAINER smiler zhang "364247556@qq.com"

# 环境变量
ENV BIN_PATH /opt/app
ENV DATA_PATH /opt/app/data
ENV CONFIG_PATH /opt/app/data/config
ENV APP_NAME checkouts-1.0-SNAPSHOT.jar
ENV APP_VERSION 1.0-SNAPSHOT

EXPOSE 8089

#USER
#USER user:group

#VOLUME
VOLUME ["/opt/app/data"]

#ADD

#COPY
COPY $APP_NAME $BIN_PATH/
#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $CONFIG_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-showversion"]

# CMD
CMD ["-jar", "../../checkouts-1.0-SNAPSHOT.jar"]
