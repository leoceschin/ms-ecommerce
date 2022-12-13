FROM openjdk
WORKDIR /catalog
COPY target/catalog-0.0.1-SNAPSHOT.jar /catalog/catalog.jar
ENTRYPOINT ["java", "-jar", "catalog.jar"]