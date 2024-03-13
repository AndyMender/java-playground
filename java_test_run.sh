#!/bin/bash
set -xe

if [ $# -ne 1 ]; then
    echo "Usage: $0 <Java class>"
    exit 1
fi

# Set up environment
JAVA_TESTCASE="$1"
JAVA_CODE_DIR="$(pwd)/codecademy/intermediate_course"
export JUNIT4_CLASSPATH="/usr/share/java/junit-4.13.2.jar:/usr/share/java/hamcrest-core.jar"

# Run test cases
pushd $JAVA_CODE_DIR
javac -cp ./:${JUNIT4_CLASSPATH} \
    ${JAVA_TESTCASE}.java \
    Test${JAVA_TESTCASE}.java \
    ${JAVA_TESTCASE}TestSuite.java \
    ${JAVA_TESTCASE}TestRunner.java   
popd
java -cp ./:${JUNIT4_CLASSPATH} org.junit.runner.JUnitCore codecademy.intermediate_course.${JAVA_TESTCASE}TestSuite
