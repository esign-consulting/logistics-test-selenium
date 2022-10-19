FROM maven:3.8.6-openjdk-11-slim

WORKDIR /logistics-test-selenium

COPY src src
COPY pom.xml dependencies.tar.gz ./

RUN apt-get update && apt-get upgrade -y && apt-get autoremove -y \
    && curl -s https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -O \
    && apt-get install ./google-chrome-stable_current_amd64.deb -y \
    && rm -rf google-chrome-stable_current_amd64.deb /var/lib/apt/lists/* \
    && mkdir /root/.m2 \
    && tar xzf dependencies.tar.gz -C /root/.m2 \
    && rm dependencies.tar.gz

CMD ["sh", "-c", "mvn -o test -Dpage.url=$LOGISTICS_URL -Dheadless=true"]