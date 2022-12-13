FROM openjdk
WORKDIR /inventory
COPY target/inventory-0.0.1-SNAPSHOT.jar /inventory/inventory.jar
ENTRYPOINT ["java", "-jar", "inventory.jar"]