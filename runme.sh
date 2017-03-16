mvn clean test
mvn tomcat7:run &
sleep 10
curl -GET -f -H 'Content-Type:application/json' -H 'Accept: application/json' http://localhost:8080/urls
echo 'response should be empty'
echo 'sending post request'
curl -f -XPOST -H 'Content-Type:application/json' -H 'Accept: application/json' --data-binary @sites.json http://localhost:8080/crawl
sleep 3
echo 'retrieving stored sites'
curl -GET -f -H 'Content-Type:application/json' -H 'Accept: application/json' http://localhost:8080/urls

