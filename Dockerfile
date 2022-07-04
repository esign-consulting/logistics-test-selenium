FROM maven:3.8.6-openjdk-11-slim

WORKDIR /logistics-test-selenium

COPY src src
COPY pom.xml dependencies.tar.gz ./

RUN apt update \
    && apt install firefox-esr wget -y \
    && rm -rf /var/lib/apt/lists/* \
    && wget -c https://github.com/mozilla/geckodriver/releases/download/v0.29.0/geckodriver-v0.29.0-linux64.tar.gz -O - | tar xz \
    && mkdir /root/.m2 \
    && tar xzf dependencies.tar.gz -C /root/.m2 \
    && rm dependencies.tar.gz

CMD ["sh", "-c", "mvn -o test -Dpage.url=$LOGISTICS_URL -Dheadless=true"]