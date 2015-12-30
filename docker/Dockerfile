FROM phusion/baseimage:latest
MAINTAINER jake@apache.org

ENV JEPSEN_GIT_URL http://github.com/aphyr/jepsen
ENV LEIN_ROOT true

#
# Jepsen dependencies
#
RUN apt-get -y -q update && \
    apt-get -y -q install software-properties-common && \
    add-apt-repository ppa:openjdk-r/ppa && \
    apt-get -y -q update && \
    apt-get install -qqy \
        openjdk-8-jdk \
        libjna-java \
        git \
        gnuplot \
        wget

ADD authorized_keys /root/.ssh/
RUN chmod 600 /root/.ssh/authorized_keys
RUN rm -f /etc/service/sshd/down
RUN /etc/my_init.d/00_regen_ssh_host_keys.sh

RUN apt-get -y -q install curl faketime unzip iptables iputils-ping

CMD ["/sbin/my_init"]