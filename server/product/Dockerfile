FROM openjdk
WORKDIR /product
COPY target/product-0.0.1-SNAPSHOT.jar /product/product.jar
ENTRYPOINT ["java", "-jar", "product.jar"]