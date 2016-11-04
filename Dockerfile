FROM java:8
ENV SCALA_VERSION 2.11.8
ENV SBT_VERSION 0.13.12
RUN apt-get update
RUN apt-get -y install wget && apt-get -y install git && apt-get -y install unzip
RUN curl -fsL http://downloads.typesafe.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz | tar xfz - -C /root/ && \
        echo >> /root/.bashrc && \
        echo 'export PATH=~/scala-$SCALA_VERSION/bin:$PATH' >> /root/.bashrc
RUN curl -L -o sbt-$SBT_VERSION.deb http://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
        dpkg -i sbt-$SBT_VERSION.deb && \
        rm sbt-$SBT_VERSION.deb && \
        apt-get update && \
        apt-get install sbt
RUN git clone https://github.com/previousdeveloper/open-versus.git; exit 0
RUN cd /open-versus && sbt compile && sbt packageBin
EXPOSE 8880
WORKDIR /open-versus
ENTRYPOINT sbt run