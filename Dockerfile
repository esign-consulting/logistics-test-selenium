FROM maven:3.8.6-openjdk-11-slim

WORKDIR /logistics-test-selenium

COPY src src
COPY pom.xml dependencies.tar.gz ./

ARG CHROME_VERSION="103.0.5060.134-1"
RUN apt-get update \
    && curl -s https://dl.google.com/linux/chrome/deb/pool/main/g/google-chrome-stable/google-chrome-stable_${CHROME_VERSION}_amd64.deb -o /tmp/chrome.deb \
    && apt-get install /tmp/chrome.deb -y \
    && rm -rf /tmp/chrome.deb /var/lib/apt/lists/* \
    && mkdir /root/.m2 \
    && tar xzf dependencies.tar.gz -C /root/.m2 \
    && rm dependencies.tar.gz

CMD ["sh", "-c", "mvn -o test -Dpage.url=$LOGISTICS_URL -Dheadless=true"]