FROM java:8

EXPOSE 9006

ADD target/dockubernetes.jar dockubernetes.jar

ENTRYPOINT ["java", "-jar", "dockubernetes.jar"]