FROM ubuntu:focal

ENV DEBIAN_FRONTEND=noninteractive

RUN apt-get update && \
    apt-get install -y wget software-properties-common sudo

RUN wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | apt-key add - && \
    add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/ && \
    apt-get update && \
    apt-get install -y adoptopenjdk-16-hotspot gradle curl git
    
RUN wget https://www.apache.org/dist/maven/maven-3/3.8.1/binaries/apache-maven-3.8.1-bin.tar.gz -P /tmp && \
    tar xf /tmp/apache-maven-*.tar.gz -C /opt && \
    ln -s /opt/apache-maven-3.8.1 /opt/maven

RUN useradd -ms /bin/bash dev && \
    adduser dev sudo && \
    echo "dev ALL=(ALL) NOPASSWD:ALL" | tee /etc/sudoers

USER dev

ENV JAVA_HOME=/usr/lib/jvm/adoptopenjdk-16-hotspot-amd64
ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=$M2_HOME/bin:$PATH