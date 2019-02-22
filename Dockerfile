FROM openjdk:8
RUN apt-get update && apt-get -y install cron
ADD cronfile /
RUN chmod 0644 /cronfile
RUN crontab /cronfile
RUN touch /var/log/cron.log
ADD . /monitoring/
RUN cd /monitoring && ./gradlew compileTestJava
CMD cron && tail -f /var/log/cron.log