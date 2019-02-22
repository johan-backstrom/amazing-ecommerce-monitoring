export JAVA_TOOL_OPTIONS="-Ddriver=remote"
./gradlew test
curl -i -XPOST "http://influxdb:8086/write?db=influxdb" --data-binary "tests myfield=$?"