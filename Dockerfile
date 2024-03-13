FROM debian:trixie-slim

# Install extra Java packages
RUN apt-get update && apt-get install -y \
    openjdk-21-jdk-headless \
    openjdk-21-jre-headless

# Copy in selected sources
ARG JAVA_SOURCES
COPY ${JAVA_SOURCES} /opt/workdir/${JAVA_SOURCES}
WORKDIR /opt/workdir

# Build sources
RUN javac $(find ./* | grep .java)
